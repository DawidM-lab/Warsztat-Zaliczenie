     class Osobowy extends Pojazd {
    private double pojemnoscSilnika;
    private String rodzajPaliwa;

    public Osobowy(String wlasciciel, String marka, String model, String nrTablicRejestracyjnych, double pojemnoscSilnika, String rodzajPaliwa) {
        super(wlasciciel, marka, model, nrTablicRejestracyjnych, "Osobowy");
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    @Override
    public String toString() {
        return super.toString() + ", Osobowy{" +
                "pojemnoscSilnika=" + pojemnoscSilnika +
                ", rodzajPaliwa='" + rodzajPaliwa + '\'' +
                '}';
    }
}
