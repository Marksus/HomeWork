package a07inheritanceForms;

public class Generalization {
	class EnglishTranslator {
		public void translate(String word) {
			System.out.println("--The word in english--");
		}
	}

	class Polyglot extends EnglishTranslator {
		@Override
		public void translate(String word) {
			super.translate(word);
			System.out.println("--The word in spanish");
			System.out.println("--The word in deutsch");
		}
	}
}
