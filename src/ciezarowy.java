   class Ciezarowy extends Pojazd {
    private double ladownosc;
    private String typ;

    public Ciezarowy(String wlasciciel, String marka, String model, String nrTablicRejestracyjnych, double ladownosc, String typ) {
        super(wlasciciel, marka, model, nrTablicRejestracyjnych, "Ciezarowy");
        this.ladownosc = ladownosc;
        this.typ = typ;
    }

    public double getLadownosc() {
        return ladownosc;
    }

    public String getTyp() {
        return typ;
    }

    @Override
    public String toString() {
        return super.toString() + ", Ciezarowy{" +
                "ladownosc=" + ladownosc +
                ", typ='" + typ + '\'' +
                '}';
    }
}
