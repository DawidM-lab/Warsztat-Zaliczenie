import java.io.Serializable;

    class Naprawa implements Serializable {
    private double koszt;
    private String opis;

    public Naprawa(double koszt, String opis) {
        this.koszt = koszt;
        this.opis = opis;
    }

    public double getKoszt() {
        return koszt;
    }

    public String getOpis() {
        return opis;
    }

    @Override
    public String toString() {
        return "Naprawa{" +
                "koszt=" + koszt +
                ", opis='" + opis + '\'' +
                '}';
    }
}
