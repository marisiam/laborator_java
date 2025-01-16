package ex2;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class procesare {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\Lab1\\laborator1\\src\\ex2\\in.txt";
        String outputFile = "C:\\Users\\Marisia\\IdeaProjects\\Teme lab Java\\Lab1\\laborator1\\src\\ex2\\out.txt";


        List<Integer> numere = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String linie;
            while ((linie = reader.readLine()) != null) {
                numere.add(Integer.parseInt(linie.trim()));
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Eroare la citirea fisierului. Verificati formatul si existenta acestuia.");
            return;
        }


        int suma = 0;
        int minim = Integer.MAX_VALUE;
        int maxim = Integer.MIN_VALUE;
        for (int numar : numere) {
            suma += numar;
            if (numar < minim) minim = numar;
            if (numar > maxim) maxim = numar;
        }
        double media = (double) suma / numere.size();


        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
        System.out.println("Valoarea minima: " + minim);
        System.out.println("Valoarea maxima: " + maxim);


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write("Suma: " + suma + "\n");
            writer.write("Media: " + media + "\n");
            writer.write("Valoarea minima: " + minim + "\n");
            writer.write("Valoarea maxima: " + maxim + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println("Eroare la scrierea fisierului.");
        }
    }
}

