import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static List<echipament> echipamente = new ArrayList<>();

    // Serializare
    public static void serializeaza(String fisier) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fisier))) {
            out.writeObject(echipamente);
        }
    }

    // Deserializare
    public static void deserializare(String fisier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fisier))) {
            echipamente = (List<echipament>) in.readObject();
        }
    }

    // Meniu
    public static void meniu() {
        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișarea tuturor echipamentelor");
            System.out.println("2. Afișarea imprimantelor");
            System.out.println("3. Afișarea copiatoarelor");
            System.out.println("4. Afișarea sistemelor de calcul");
            System.out.println("5. Modificarea stării unui echipament");
            System.out.println("6. Setarea modului de tipărire pentru imprimante");
            System.out.println("7. Setarea formatului de copiere pentru copiatoare");
            System.out.println("8. Instalarea sistemului de operare pe sisteme de calcul");
            System.out.println("9. Afișarea echipamentelor vândute");
            System.out.println("0. Ieșire");

            System.out.print("Alegeți o opțiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline-ul

            switch (optiune) {
                case 1 -> afiseazaToate();
                case 2 -> afiseazaImprimante();
                case 3 -> afiseazaCopiatoare();
                case 4 -> afiseazaSistemeCalcul();
                case 5 -> modificaStare(scanner);
                case 6 -> seteazaModTiparire(scanner);
                case 7 -> seteazaFormatCopiere(scanner);
                case 8 -> instaleazaSistemOperare(scanner);
                case 9 -> afiseazaVandute();
                case 0 -> System.out.println("Ieșire...");
                default -> System.out.println("Opțiune invalidă!");
            }
        } while (optiune != 0);

        scanner.close();
    }

    // Implementarea funcțiilor din meniu
    private static void afiseazaToate() {
        echipamente.forEach(System.out::println);
    }

    private static void afiseazaImprimante() {
        echipamente.stream()
                .filter(e -> e instanceof imprimanta)
                .forEach(System.out::println);
    }

    private static void afiseazaCopiatoare() {
        echipamente.stream()
                .filter(e -> e instanceof copiator)
                .forEach(System.out::println);
    }

    private static void afiseazaSistemeCalcul() {
        echipamente.stream()
                .filter(e -> e instanceof sisCalcul)
                .forEach(System.out::println);
    }

    private static void modificaStare(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al echipamentului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
        String stareNoua = scanner.nextLine();

        echipamente.stream()
                .filter(e -> e.getNrInv() == nrInv)
                .findFirst()
                .ifPresent(e -> e.setStare(Stare.valueOf(stareNoua)));
    }

    private static void seteazaModTiparire(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți modul de tipărire (COLOR, ALB_NEGRU): ");
        String modNou = scanner.nextLine();

        echipamente.stream()
                .filter(e -> e instanceof imprimanta && e.getNrInv() == nrInv)
                .map(e -> (imprimanta) e)
                .findFirst()
                .ifPresent(i -> i.setModTiparire(ModTiparire.valueOf(modNou)));
    }

    private static void seteazaFormatCopiere(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți formatul de copiere (A3, A4): ");
        String formatNou = scanner.nextLine();

        echipamente.stream()
                .filter(e -> e instanceof copiator && e.getNrInv() == nrInv)
                .map(e -> (copiator) e)
                .findFirst()
                .ifPresent(c -> c.setFormatCopiere(FormatCopiere.valueOf(formatNou)));
    }

    private static void instaleazaSistemOperare(Scanner scanner) {
        System.out.print("Introduceți numărul de inventar al sistemului de calcul: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți sistemul de operare (WINDOWS, LINUX): ");
        String sistemNou = scanner.nextLine();

        echipamente.stream()
                .filter(e -> e instanceof sisCalcul && e.getNrInv() == nrInv)
                .map(e -> (sisCalcul) e)
                .findFirst()
                .ifPresent(s -> s.setSistemOperare(SistemOperare.valueOf(sistemNou)));
    }

    private static void afiseazaVandute() {
        echipamente.stream()
                .filter(e -> e.getStare() == Stare.VANDUT)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // Popularea listei cu echipamente conform cerințelor
        echipamente.add(new imprimanta(
                "HP Deskjet 1000", 1234, 170, "A", Stare.ACHIZITIONAT,
                12, 600, 1000, ModTiparire.COLOR));
        echipamente.add(new imprimanta(
                "HP Officejet 7000 Wide", 1235, 1200, "B", Stare.VANDUT,
                33, 4800, 2000, ModTiparire.COLOR));
        echipamente.add(new copiator(
                "Konica Minolta bizhub C200", 1236, 17000, "B", Stare.EXPUS,
                2000, FormatCopiere.A3));
        echipamente.add(new copiator(
                "Konica Minolta bizhub 163", 1237, 500, "C", Stare.VANDUT,
                1500, FormatCopiere.A4));
        echipamente.add(new sisCalcul(
                "HUSK Office tech Celeron Dual Core E3400", 1238, 950, "A", Stare.EXPUS,
                "belinea", 2.4, 500, SistemOperare.WINDOWS));
        echipamente.add(new sisCalcul(
                "HUSK Office tech Celeron Dual Core G530", 1239, 1000, "B", Stare.VANDUT,
                "dell", 2.6, 700, SistemOperare.LINUX));

        // Rularea meniului
        meniu();
    }

}