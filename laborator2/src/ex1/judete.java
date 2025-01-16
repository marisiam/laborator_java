package ex1;

import java.io.*;
import java.util.*;

public class judete {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator2\\src\\ex1\\in.txt"));
            List<String> listaJudete = new ArrayList<>();
            String linie;

            while ((linie = reader.readLine()) != null) {
                listaJudete.add(linie.trim());
            }
            reader.close();


            String[] judete = listaJudete.toArray(new String[0]);


            Arrays.sort(judete);


            System.out.println("Județele sortate:");
            for (String judet : judete) {
                System.out.println(judet);
            }


            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIntroduceți numele unui județ: ");
            String judetCautat = scanner.nextLine().trim();


            int pozitie = Arrays.binarySearch(judete, judetCautat);

            if (pozitie >= 0) {
                System.out.println("Județul " + judetCautat + " se află pe poziția " + pozitie + " în vectorul ordonat.");
            } else {
                System.out.println("Județul " + judetCautat + " nu a fost găsit în lista.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul judete_in.txt nu a fost găsit.");
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea fișierului.");
        }
    }
}
