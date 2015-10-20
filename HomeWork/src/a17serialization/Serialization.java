package a17serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static class Serializator<T> {
		@SuppressWarnings("unchecked")
		public static <T> T deepCopy(T obj) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			try (ObjectOutputStream oos = new ObjectOutputStream(baos);) {
				oos.writeObject(obj);
			} catch (IOException e) {
				// e.printStackTrace();
				return null;
			}

			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

			try (ObjectInputStream ois = new ObjectInputStream(bais)) {
				return (T) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// e.printStackTrace();
				return null;
			}
		}
	}

}
