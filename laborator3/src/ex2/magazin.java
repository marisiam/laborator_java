package ex2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class magazin {
    private static List<produs> produse = new ArrayList<>();

    public static void main(String[] args) {
        try {
            citireProduseDinFisier("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator3\\src\\ex2\\produse.csv");
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int optiune;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afisare produse");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Vanzare produs");
            System.out.println("4. Afisare produse cu pretul minim");
            System.out.println("5. Salvare produse cu cantitate mica");
            System.out.println("0. Iesire");
            System.out.print("Alegeti o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    afisareProduse();
                    break;
                case 2:
                    afisareProduseExpirate();
                    break;
                case 3:
                    vanzareProdus(scanner);
                    break;
                case 4:
                    afisareProdusePretMinim();
                    break;
                case 5:
                    salvareProduseCantitateMica(scanner);
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);
    }


    public static void citireProduseDinFisier(String numeFisier) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] valori = linie.split(",");
                String denumire = valori[0].trim();
                double pret = Double.parseDouble(valori[1].trim());
                int cantitate = Integer.parseInt(valori[2].trim());
                LocalDate dataExpirarii = LocalDate.parse(valori[3].trim());
                produse.add(new produs(denumire, pret, cantitate, dataExpirarii));
            }
        }
    }


    public static void afisareProduse() {
        if (produse.isEmpty()) {
            System.out.println("Nu exista produse in magazin.");
        } else {
            produse.forEach(System.out::println);
        }
    }


    public static void afisareProduseExpirate() {
        LocalDate azi = LocalDate.now();
        List<produs> produseExpirate = produse.stream()
                .filter(p -> p.getDataExpirarii().isBefore(azi))
                .collect(Collectors.toList());

        if (produseExpirate.isEmpty()) {
            System.out.println("Nu exista produse expirate.");
        } else {
            produseExpirate.forEach(System.out::println);
        }
    }


    public static void vanzareProdus(Scanner scanner) {
        System.out.print("Introduceti denumirea produsului: ");
        String denumire = scanner.nextLine();
        System.out.print("Introduceti cantitatea dorita: ");
        int cantitate = scanner.nextInt();

        produs produs = produse.stream()
                .filter(p -> p.getDenumire().equalsIgnoreCase(denumire))
                .findFirst()
                .orElse(null);

        if (produs == null) {
            System.out.println("Produsul nu exista.");
        } else if (produs.getCantitate() < cantitate) {
            System.out.println("Cantitate insuficienta pe stoc.");
        } else {
            produs.setCantitate(produs.getCantitate() - cantitate);
            produs.incasari += cantitate * produs.getPret();
            System.out.println("Produs vandut cu succes.");

            if (produs.getCantitate() == 0) {
                produse.remove(produs);
                System.out.println("Produsul a fost eliminat din stoc.");
            }
        }
    }


    public static void afisareProdusePretMinim() {
        OptionalDouble pretMinim = produse.stream()
                .mapToDouble(produs::getPret)
                .min();

        if (pretMinim.isPresent()) {
            double minim = pretMinim.getAsDouble();
            produse.stream()
                    .filter(p -> p.getPret() == minim)
                    .forEach(System.out::println);
        } else {
            System.out.println("Nu exista produse in magazin.");
        }
    }


    public static void salvareProduseCantitateMica(Scanner scanner) {
        System.out.print("Introduceti cantitatea maxima: ");
        int cantitateMaxima = scanner.nextInt();

        List<produs> produseCantitateMica = produse.stream()
                .filter(p -> p.getCantitate() < cantitateMaxima)
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator3\\src\\ex2\\produse_mici.csv"))) {
            for (produs produs : produseCantitateMica) {
                writer.write(produs.toString());
                writer.newLine();
            }
            System.out.println("Produsele au fost salvate in fisierul produse_mici.csv.");
        } catch (IOException e) {
            System.out.println("Eroare la scrierea fisierului: " + e.getMessage());
        }
    }
}
