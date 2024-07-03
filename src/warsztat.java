import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Warsztat implements Serializable {
    private List<Pojazd> pojazdy;

    public Warsztat() {
        this.pojazdy = new ArrayList<>();
    }

    public void dodajPojazd(Pojazd pojazd) {
        pojazdy.add(pojazd);
    }

    public void zapiszDoPliku(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this.pojazdy);
        }
    }

    public void odczytajZPliku(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            this.pojazdy = (List<Pojazd>) ois.readObject();
        }
    }

    public List<Naprawa> getNaprawyPoNrRejestracyjnym(String nrRejestracyjny) {
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.getNrTablicRejestracyjnych().equals(nrRejestracyjny)) {
                return pojazd.getListaNapraw();
            }
        }
        return new ArrayList<>();
    }

    public double getLacznyKosztNaprawPoNrRejestracyjnym(String nrRejestracyjny) {
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.getNrTablicRejestracyjnych().equals(nrRejestracyjny)) {
                return pojazd.getLacznyKosztNapraw();
            }
        }
        return 0.0;
    }

    public void dodajNaprawePoNrRejestracyjnym(String nrRejestracyjny, double koszt, String opis) {
        for (Pojazd pojazd : pojazdy) {
            if (pojazd.getNrTablicRejestracyjnych().equals(nrRejestracyjny)) {
                pojazd.dodajNaprawe(koszt, opis);
                return;
            }
        }
    }

    public List<Pojazd> getPojazdy() {
        return pojazdy;
    }

    public List<Pojazd> getNajlepsiKlienci(int liczbaKlientow) {
        return pojazdy.stream()
                .sorted((p1, p2) -> Double.compare(p2.getLacznyKosztNapraw(), p1.getLacznyKosztNapraw()))
                .limit(liczbaKlientow)
                .collect(Collectors.toList());
    }
}
