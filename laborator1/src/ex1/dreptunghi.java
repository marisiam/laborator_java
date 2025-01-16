package ex1;

import java.util.Scanner;

public class dreptunghi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti lungimea dreptunghiului: ");
        double lungime = scanner.nextDouble(); // Break point aici

        System.out.print("Introduceti latimea dreptunghiului: ");
        double latime = scanner.nextDouble();

        double perimetru = 2 * (lungime + latime);

        double aria = lungime * latime;

        System.out.println("Perimetrul dreptunghiului este: " + perimetru);
        System.out.println("Aria dreptunghiului este: " + aria);

        scanner.close();
    }
}


