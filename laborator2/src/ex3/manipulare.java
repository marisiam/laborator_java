package ex3;

import java.util.Scanner;

public class manipulare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți șirul inițial: ");
        StringBuilder sir = new StringBuilder(scanner.nextLine());

        System.out.print("Introduceți șirul care trebuie inserat: ");
        String sirDeInserat = scanner.nextLine();

        System.out.print("Introduceți poziția la care se inserează șirul: ");
        int pozitieInserare = scanner.nextInt();


        if (pozitieInserare >= 0 && pozitieInserare <= sir.length()) {
            sir.insert(pozitieInserare, sirDeInserat);
            System.out.println("Șirul după inserare: " + sir);
        } else {
            System.out.println("Poziția de inserare este invalidă!");
        }


        System.out.print("Introduceți poziția de început pentru ștergere: ");
        int pozitieStergere = scanner.nextInt();
        System.out.print("Introduceți numărul de caractere de șters: ");
        int numarCaractere = scanner.nextInt();

        if (pozitieStergere >= 0 && pozitieStergere < sir.length() &&
                pozitieStergere + numarCaractere <= sir.length()) {
            sir.delete(pozitieStergere, pozitieStergere + numarCaractere);
            System.out.println("Șirul după ștergere: " + sir);
        } else {
            System.out.println("Parametrii pentru ștergere sunt invalizi!");
        }

        scanner.close();
    }
}

