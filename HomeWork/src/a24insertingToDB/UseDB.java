package a24insertingToDB;

public class UseDB {
	public static void main(String[] args) {
		int id = 1;
		Student t = DBManager.get(Student.class, id);

		if (t == null)
			System.out.println("no such student with id" + id);
		else {
			System.out.println(t.name);
		}
		Student t2 = new Student();
		t2.setId("3");
		t2.setName("Mary");
		t2.setStip("1500");
		DBManager.save(t2);
	}

}
