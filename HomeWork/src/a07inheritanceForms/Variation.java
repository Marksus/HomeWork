package a07inheritanceForms;

public class Variation {
	class TableLamp {
		public void lampOn() {
		}

		public void lampOff() {
		}
	}

	class SearchLight extends TableLamp {
		@Override
		public void lampOn() {
			warmingUp();
			super.lampOn();
		}

		private void warmingUp() {
		}
	}
}
