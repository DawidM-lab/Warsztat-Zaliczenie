import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String homeDirectory = System.getProperty("user.home");
            String filePath = homeDirectory + "/warsztat.dat";

            Warsztat warsztat = new Warsztat();

            Osobowy osobowy1 = new Osobowy("Jan Kowalski", "Toyota", "Corolla", "XYZ123", 1.8, "Benzyna");
            osobowy1.dodajNaprawe(1000, "Wymiana oleju");
            warsztat.dodajPojazd(osobowy1);

            Ciezarowy ciezarowy1 = new Ciezarowy("Andrzej Kowalczyk", "Scania", "R500", "STU678", 25000, "Ciągnik siodłowy");
            ciezarowy1.dodajNaprawe(3000, "Naprawa silnika");
            warsztat.dodajPojazd(ciezarowy1);

            Osobowy osobowy2 = new Osobowy("Anna Nowak", "Volkswagen", "Golf", "ABC456", 1.6, "Diesel");
            osobowy2.dodajNaprawe(1500, "Wymiana filtrów");
            warsztat.dodajPojazd(osobowy2);

            Ciezarowy ciezarowy2 = new Ciezarowy("Tomasz Lis", "MAN", "TGS", "DEF789", 18000, "Naczepa");
            ciezarowy2.dodajNaprawe(4000, "Wymiana opon");
            warsztat.dodajPojazd(ciezarowy2);

            Osobowy osobowy3 = new Osobowy("Ewa Malinowska", "Ford", "Focus", "GHI012", 2.0, "Benzyna");
            osobowy3.dodajNaprawe(1200, "Naprawa elektryki");
            warsztat.dodajPojazd(osobowy3);

            Ciezarowy ciezarowy3 = new Ciezarowy("Piotr Nowakowski", "Volvo", "FH16", "JKL345", 28000, "Naczepa chłodnia");
            ciezarowy3.dodajNaprawe(3500, "Wymiana chłodnicy");
            warsztat.dodajPojazd(ciezarowy3);

            warsztat.zapiszDoPliku(filePath);
            System.out.println("Dane zapisane do pliku: " + filePath);

            warsztat.odczytajZPliku(filePath);
            System.out.println("Dane odczytane z pliku: " + filePath);

            for (Pojazd pojazd : warsztat.getPojazdy()) {
                System.out.println(pojazd);
            }

            warsztat.dodajNaprawePoNrRejestracyjnym("XYZ123", 500, "Wymiana klocków hamulcowych");
            System.out.println("Naprawy dla pojazdu XYZ123: " + warsztat.getNaprawyPoNrRejestracyjnym("XYZ123"));
            System.out.println("Łączny koszt napraw dla pojazdu XYZ123: " + warsztat.getLacznyKosztNaprawPoNrRejestracyjnym("XYZ123"));

            List<Pojazd> najlepsiKlienci = warsztat.getNajlepsiKlienci(5);
            for (Pojazd klient : najlepsiKlienci) {
                System.out.println("Najlepszy klient: " + klient);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Błąd podczas odczytu/zapisu pliku: " + e.getMessage());
        }
    }
}
