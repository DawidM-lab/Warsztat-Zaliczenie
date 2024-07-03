import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

    abstract class Pojazd implements Serializable {
    private String wlasciciel;
    private String marka;
    private String model;
    private String nrTablicRejestracyjnych;
    private double kosztNaprawy;
    private String rodzajPojazdu;
    private List<Naprawa> naprawy;

    public Pojazd(String wlasciciel, String marka, String model, String nrTablicRejestracyjnych, String rodzajPojazdu) {
        this.wlasciciel = wlasciciel;
        this.marka = marka;
        this.model = model;
        this.nrTablicRejestracyjnych = nrTablicRejestracyjnych;
        this.rodzajPojazdu = rodzajPojazdu;
        this.naprawy = new ArrayList<>();
    }

    public void dodajNaprawe(double koszt, String opis) {
        Naprawa naprawa = new Naprawa(koszt, opis);
        naprawy.add(naprawa);
        this.kosztNaprawy += koszt;
    }

    public List<Naprawa> getListaNapraw() {
        return naprawy;
    }

    public double getLacznyKosztNapraw() {
        return kosztNaprawy;
    }

    public String getNrTablicRejestracyjnych() {
        return nrTablicRejestracyjnych;
    }

    public String getRodzajPojazdu() {
        return rodzajPojazdu;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "wlasciciel='" + wlasciciel + '\'' +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", nrTablicRejestracyjnych='" + nrTablicRejestracyjnych + '\'' +
                ", kosztNaprawy=" + kosztNaprawy +
                ", rodzajPojazdu='" + rodzajPojazdu + '\'' +
                ", naprawy=" + naprawy +
                '}';
    }
}
