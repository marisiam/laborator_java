package ex4;

import java.util.Scanner;

public class gestionare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Citirea numărului de persoane
        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumăm newline-ul rămas

        // Vector pentru stocarea persoanelor
        persoana[] persoane = new persoana[n];

        // Citirea datelor pentru fiecare persoană
        for (int i = 0; i < n; i++) {
            System.out.print("Introduceți numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.print("Introduceți CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();
                if (esteCnpValid(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid! Reîncercați.");
                }
            }

            // Creăm un obiect de tip Persoana și îl adăugăm în vector
            persoane[i] = new persoana(nume, cnp);
        }

        // Afișarea datelor despre persoane
        System.out.println("\nInformații despre persoane:");
        for (persoana persoana : persoane) {
            System.out.println(persoana.getNume() + ", " + persoana.getCnp() + ", Vârsta: " + persoana.getVarsta());
        }

        scanner.close();
    }

    // Funcție pentru validarea unui CNP
    public static boolean esteCnpValid(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        // Verificăm dacă toate caracterele sunt cifre
        if (!cnp.matches("\\d+")) {
            return false;
        }

        // Verificăm dacă prima cifră este validă
        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }

        // Calcularea cifrei de control
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }

        // Verificăm dacă cifra de control este corectă
        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
}