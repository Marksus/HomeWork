package a17serialization;

public class UseSerializator {

	public static void main(String[] args) {

		A a = new A();

		A a1 = a17serialization.Serialization.Serializator.deepCopy(a);

		if (null != a1)
			System.out.println(a1.x);
		else
			System.out.println(a1);
	}

}
