package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cantec {
    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator2\\src\\ex2\\in.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\laborator2\\src\\ex2\\out.txt"));

            List<vers> versuri = new ArrayList<>();
            String linie;

            while ((linie = reader.readLine()) != null) {
                versuri.add(new vers(linie.trim()));
            }
            reader.close();

            String grupareLitere = "la";

            Random random = new Random();


            for (vers vers : versuri) {
                int numarCuvinte = vers.numarCuvinte();
                int numarVocale = vers.numarVocale();


                boolean terminaCuGrupare = vers.seTerminaCu(grupareLitere);
                String linieFinala = vers.getContinut();


                if (random.nextDouble() < 0.1) {
                    vers.scrieCuMajuscule();
                    linieFinala = vers.getContinut();
                }


                linieFinala += " | Cuvinte: " + numarCuvinte + ", Vocale: " + numarVocale;
                if (terminaCuGrupare) {
                    linieFinala += " *";
                }

                writer.write(linieFinala);
                writer.newLine();
            }
            writer.close();
            System.out.println("Procesarea fișierului a fost finalizată cu succes!");

        } catch (FileNotFoundException e) {
            System.out.println("Fișierul cantec_in.txt nu a fost găsit.");
        } catch (IOException e) {
            System.out.println("A apărut o eroare la citirea sau scrierea fișierelor.");
        }
    }
}