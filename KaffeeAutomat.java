package automat;

public class KaffeeAutomat {

	interface KaffeeAutomatInterface {

		public void bezahleBetrag(int betrag);

		public void waehleProdukt(String produkt);

		public void waehleOption(String option);

		public int fordereWechselgeld();

		public int zapfeProdukt();

		public int abbruch();
	}

	class Produkt {

		private String bezeichnung;
		private int preis;
		private String[] optionen;
	}

	class Kaffee extends Produkt {

	}

	class Tee extends Produkt {

	}

	class Kakao extends Produkt {

	}

	class AutomatenSteuerung implements KaffeeAutomatInterface {
		
		private Produkt[] produkte;
		private Protokoll protokoll;
		
		public AutomatenSteuerung() {
			this.protokoll = new Protokoll();
		}

		public int GetUmsatz() {
			// TODO: Mach was
			return 0;
		}

		public String[] ListeVerkaeufe() {
			// TODO: auch hier
			return null;
		}

		@Override
		public void bezahleBetrag(int betrag) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void waehleProdukt(String produkt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void waehleOption(String option) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int fordereWechselgeld() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int zapfeProdukt() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int abbruch() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	class Protokoll {
		private int Umsatz;

		class VerkaufsEreignis {
			private String Produktbezeichnung;
			private String[] Optionen;
			private DateTime Datum;
			private int VerkaufsPreis;
		}
	}
}
