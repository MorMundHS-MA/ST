import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Protokoll {
    private int Umsatz;
    private List<VerkaufsEreignis> log = new ArrayList<VerkaufsEreignis>();

    public void verkaufeProdukt(Produkt produkt, String[] optionen, int verkaufspreis) {
        log.add(new VerkaufsEreignis(
                produkt.getBezeichnung(),
                optionen,
                new Date(),
                verkaufspreis
        ));

        this.Umsatz += verkaufspreis;
    }

    class VerkaufsEreignis {
        private String Produktbezeichnung;
        private String[] Optionen;
        private Date Datum;
        private int VerkaufsPreis;

        public VerkaufsEreignis(String produktbezeichnung, String[] optionen, Date datum, int verkaufsPreis) {
            this.Produktbezeichnung = produktbezeichnung;
            this.Optionen = optionen;
            this.Datum = datum;
            this.VerkaufsPreis = verkaufsPreis;
        }
    }
}
