package ex5;

import java.util.Random;

public class fibonacci {
    public static void main(String[] args) {
        Random random = new Random();

        int numar = random.nextInt(21); // [0, 20]
        System.out.println("Numarul generat este: " + numar);

        if (esteFibonacci(numar)) {
            System.out.println("Numarul " + numar + " apartine sirului lui Fibonacci.");
        } else {
            System.out.println("Numarul " + numar + " nu apartine sirului lui Fibonacci.");
        }
    }

    public static boolean esteFibonacci(int numar) {
        if (numar < 0) return false;


        int test1 = 5 * numar * numar + 4;
        int test2 = 5 * numar * numar - 4;

        return estePatratPerfect(test1) || estePatratPerfect(test2);
    }

    public static boolean estePatratPerfect(int numar) {
        int radacina = (int) Math.sqrt(numar);
        return radacina * radacina == numar;
    }
}

