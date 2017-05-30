package automat;

import java.util.Scanner;

public class KaffeeAutomat {

	interface KaffeeAutomatInterface {
		
		/**
		 * Methode nimmt den Geldbetrag vom Kunden entgegen.
		 */
		public void bezahleBetrag(int betrag);

		/**
		 * Methode setzt das Produkt, welches der Kunde gewählt hat.
		 */
		public void waehleProdukt(String produkt);

		/**
		 * Methode setzt die Optionen für das jeweilige Produkt.
		 */
		public void waehleOption(String option);

		/**
		 * Keine Ahnung warum der Automat selbst Wechselgeld fordern soll.
		 */
		public int fordereWechselgeld();

		/**
		 * Die Methodennamen sind ja mal echt zum Schießen. Ich gehe mal
		 * davon aus das hier das Produkt zubereitet und ausgegeben
		 * wird.
		 */
		public int zapfeProdukt();

		/**
		 * Methode, um den kompletten Bestellvorgang zu stornieren und
		 * diesen auf den Anfangszustand setzen.
		 */
		public int abbruch();
	}

	class Produkt {
		
		private String bezeichnung;
		
		private int preis;
		
		private String[] optionen;

		/**
		 * Methode legt die Bezeichnung des Produktes fest.
		 */
		protected void setBezeichnung(String bezeichnung) {
			this.bezeichnung = bezeichnung;
		}

		/**
		 * Methode legt den entgültigen Preis fest.
		 */
		protected void setPreis(int preis) {
			this.preis = preis;
		}

		/**
		 * Methode speichert die gewählten Methoden für die 
		 * Statistik.
		 */
		protected void setOptionen(String[] optionen) {
			this.optionen = optionen;
		}
	}

	class Kaffee extends Produkt {

		public Kaffee() {
			setBezeichnung("Kaffee");
			setPreis(120);
			setOptionen();
		}

		/**
		 * Methode frägt den Kunden via Konsoleausgabe ob er Zusatzoptionen für seinen Kaffee
		 * wählt, welche er per Konsoleneingabe äußert.
		 */
		public void setOptionen() {
			
			String optionen;
			
			//Optionen: Extra Milch, Zucker oder Schockostreusel
			System.out.println("Durch einfaches drücken der Eingabetaste wird der Kaffee"
					+ " zubereitet. Sie können aber auch extra Milch, Zucker"
					+ " oder Schockostreusel eingeben und sie bekommen es jeweils"
					+ " für 10ct extra oben drauf. Um eine Option rückgängig zu machen,"
					+ " wählen Sie diese ein zweites Mal an.");
			
			private void inputOptionen() {
			    
				/**
				 * Liste legt fest, welche Optionen gewählt wurden.
				 * Die Erste Option in der Liste ist die Milch, 
				 * die Zweite ist Zucker und die Dritte sind
				 * Schockostreusel.
				 */
				private String[] optionsListe = {null, null, null};
				
				try {
			        optionen = in.nextLine();
			        if(!optionen.equalsIgnoreCase("Milch" || "Zucker" || "Schockostreusel" || "Abbruch")) {
				        throw new Exception();	
			        }
			    }
			
			    catch(Exception e) {
				    System.out.println("Regen Sie mich bitte nicht auf und konzentrieren Sie"
						+ " sich bei der Eingabe. Probieren Sie es nochmal.");
				    inputOptionen();
			    }
			    
			    if(optionen.equalsIgnoreCase("Abbruch")) {
			    	KaffeeAutomatInterface.abbruch();
			    }
			    
			    else if(optionen.equals("")) {
			    	setOptionen(optionsListe);
			    	//TODO: Kehre zur main() zurück und fahre dort fort.
			    }
			    
			    else if(optionen.equalsIgnoreCase("Milch")) {
			    	(optionsListe[0].equals("Milch") ? String[0] = null : String[0] = "Milch";
			    }
			    
			    else if(optionen.equalsIgnoreCase("Zucker")) {
			    	(optionsListe[1].equals("Zucker") ? String[1] = null : String[1] = "Zucker";
			    }
			    
			    else if(optionen.equalsIgnoreCase("Schockostreusel")) {
			    	(optionsListe[2].equals("Schockostreusel") ? String[2] = null : String[2] = "Schockostreusel";
			    }
			}
		}
	}

	class Tee extends Produkt {

		public Tee() {
			setBezeichnung("Tee");
			setPreis(100);
		}

		public void setOptionen() {
			// TODO: Setze irgendwie die Optionen
			// TODO: Rufe setOptionen(String[]) auf und setze beim Produkt die
			// Optionen
		}
	}

	class Kakao extends Produkt {

		public Kakao() {
			setBezeichnung("Kakao");
			setPreis(9999);
		}

		public void setOptionen() {
			// TODO: Setze irgendwie die Optionen
			// TODO: Rufe setOptionen(String[]) auf und setze beim Produkt die
			// Optionen
		}
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

			try {
				if (produkt.equals("Abbruch")) {
					KaffeeAutomatInterface.abbruch();
				}

				else if (produkt.equalsIgnoreCase("tee")) {
					Tee tee = new Tee();
				}

				else if (produkt.equalsIgnoreCase("kaffee")) {
					Kaffee kaffee = new Kaffee();
				}

				else if (produkt.equalsIgnoreCase("kakao")) {
					Kakao kakao = new Kakao();
				}

				else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Sollten Sie irgendwie hier landen, bekommen Sie"
						+ "von mir eine Juniortüte bei McDonalds spendiert!");
			}
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

	public static void main(String[] args) {
		
		begrueßeKunde();
		
		
		//Diese Methode begrueßt den Kunden per Konsolenausgabe und fordert zur 
		//Auswahl und Eingabe von Produkten auf.
		private static void begrueßeKunde() {
		System.out.println("Guten Tag bei McDonalds, Ihre Bestellung bitte!");
		System.out.println("OH, Sie fragen was wir überhaupt anbieten? Das kann"
				+ " ich Ihnen gerne sagen. Wir bieten Kaffee zu 1,20€,"
				+ " Kakao zu 99,99€, Tee zu 1€ und meine Handynummer zu 1€ an. =)");
		System.out.println("Anmerkung der Redaktion, gebe jetzt 'Kaffee', 'Tee' oder 'Kakao' ein."
				+ " Mit 'Abbruch' kannst du bis zur Bezahlung jederzeit abbrechen.");
		
		setProdukt();
		}
		
		//Diese Methode Filtert die Eingabe.
		private static void setProdukt() {
			
			Scanner in = new Scanner();
			
			String produkt;
			
			try {
			String produkt = in.nextLine();
				if(!produkt.equalsIgnoreCase("Kakao" || "Tee" || "Kaffee" || "Abbruch")) {
					throw new Exception;
				}
			}
			catch(Exception e) {
				System.out.println("Wie schwer ist es Kakao oder Tee oder Kaffee einzutippen?");
				setProdukt();
			}
			
			waehleProdukt(produkt);
		}
	}
}
