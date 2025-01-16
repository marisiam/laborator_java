package ex3;

import java.util.Scanner;

public class divizori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti un numar natural: ");
        int n = scanner.nextInt();

        boolean estePrim = true;
        System.out.println("Divizorii numarului " + n + " sunt:");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != 1 && i != n) {
                    estePrim = false;
                }
            }
        }
        System.out.println();

        if (estePrim && n > 1) {
            System.out.println("Numarul " + n + " este prim.");
        } else if (n > 1) {
            System.out.println("Numarul " + n + " nu este prim.");
        } else {
            System.out.println("Numarul " + n + " nu este prim (numerele mai mici decat 2 nu sunt prime).");
        }

        scanner.close();
    }
}

