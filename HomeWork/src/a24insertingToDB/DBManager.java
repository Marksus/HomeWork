package a24insertingToDB;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBManager {

	private static Connection connection;

	static {
		System.out.println("Initializing DB connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() {

			@Override
			public void run() {
				try {
					connection.close();
					System.out.println("DB connection close");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public static <T> T get(Class<T> clazz, int id) {

		String tableName = clazz.getSimpleName().toLowerCase();

		try {
			PreparedStatement st = connection.prepareStatement("select * from " + tableName + " where id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			T t = load(rs, clazz);

			return t;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static <T> T load(ResultSet rs, Class<T> clazz) throws SQLException {
		rs.next();
		try {
			T t = clazz.newInstance();

			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i < metaData.getColumnCount(); i++) {
				String name = metaData.getColumnName(i);
				char[] charArray = name.toCharArray();
				charArray[0] = name.toUpperCase().charAt(0);
				String setterName = "set" + new String(charArray);
				Method setter = clazz.getMethod(setterName, String.class);
				setter.invoke(t, rs.getString(i));

			}

			return t;

		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Student get(int id) {
		System.out.println("get");

		try {
			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery("select * from student where id =" + id);

			Student student = getStudent(rs);

			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Student getStudent(ResultSet rs) throws SQLException {
		Student st = new Student();
		if (rs.next()) {
			st.id = rs.getString(1);
			st.name = rs.getString(2);
			st.stip = rs.getString(3);
			return st;
		}
		return null;
	}

	public static <T> void save(T t) {
		System.out.println("save");
		Map<String, String> data = new HashMap<>();
		for (Method method : t.getClass().getMethods()) {
			String methodName = method.getName();
			if (methodName.substring(0, 3).equals("get") && !methodName.equals("getClass")
					&& !methodName.equals("getId")) {
				try {
					String parameterName = methodName.substring(3);
					String parameterValue = (String) method.invoke(t);
					data.put(parameterName, parameterValue);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}

		saveOnBase(data, t.getClass().getSimpleName().toLowerCase());
	}

	private static void saveOnBase(Map<String, String> data, String database) {
		StringBuilder queryHalf1 = new StringBuilder("insert into " + database + " (");
		StringBuilder queryHalf2 = new StringBuilder(") values (");
		for (Map.Entry<String, String> pair : data.entrySet()) {
			queryHalf1.append(pair.getKey().toLowerCase()).append(",");
			queryHalf2.append("\'").append(pair.getValue()).append("\',");
		}
		queryHalf1.deleteCharAt(queryHalf1.length() - 1); // deleting ","
		queryHalf2.deleteCharAt(queryHalf2.length() - 1);
		queryHalf1.append(queryHalf2).append(")");
		System.out.println(queryHalf1);

		try {
			Statement st = connection.createStatement();
			st.execute(queryHalf1.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("saved");

	}

}
