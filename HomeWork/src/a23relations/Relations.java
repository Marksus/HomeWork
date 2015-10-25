package a23relations;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Relations {
	public static void main(String[] args) {
		Connection connection = null;
		Scanner scanner = null;
		String[] query = new String[4];

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/relations", "root", "");

			scanner = new Scanner(new InputStreamReader(System.in));
			PreparedStatement ps = connection
					.prepareStatement("insert into myRelations (name, age, height, weight) values(?, ?, ?, ?)");

			insert(ps, scanner);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void insert(PreparedStatement ps, Scanner sc) {
		while (sc.hasNextLine()) {
			try {
				String[] query = new String[4];
				query = sc.nextLine().split(" ");
				ps.setString(1, query[0]);
				ps.setInt(2, Integer.parseInt(query[1]));
				ps.setInt(3, Integer.parseInt(query[2]));
				ps.setInt(4, Integer.parseInt(query[3]));
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
