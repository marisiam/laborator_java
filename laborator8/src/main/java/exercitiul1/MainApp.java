package exercitiul1;

import java.sql.*;
import java.util.Scanner;
import static exercitiul1.functii.*;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        boolean quit = false;
        int optiune;
        while(!quit)
        {
            System.out.println("1.Adăugarea unei persoane în tabela persoane");
            System.out.println("2.Adăugarea unei excursii în tabela excursii");
            System.out.println("3.Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost");
            System.out.println("4.Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură ");
            System.out.println("5.Afișarea tuturor persoanelor care au vizitat o anumita destinație.");
            System.out.println("6.Afișarea persoanelor care au făcut excursii într-un an introdus");
            System.out.println("7.Ștergerea unei excursii");
            System.out.println("8.Ștergerea unei persoane (împreună cu excursiile în care a fost)");
            System.out.println("9.Iesire");
            optiune = scanner.nextInt();
            switch (optiune)
            {
                case 1:
                    System.out.println("Dati numele:");
                    String nume = scanner.next();
                    System.out.println("Dati varsta:");
                    int varsta = scanner.nextInt();
                    adaugare_persoane(connection, nume, varsta);
                    break;
                case 2:
                    System.out.println("Dati id-ul persoanei:");
                    int id = scanner.nextInt();
                    System.out.println("Dati destinatia:");
                    String destinatie = scanner.next();
                    System.out.println("Dati anul:");
                    int anul = scanner.nextInt();
                    adaugare_excursii(connection,id,destinatie,anul);
                    break;
                case 3: afisare_persoane_excursii(connection);
                    break;
                case 4:
                    System.out.println("Introduceti numele: ");
                    String nume_cautat = scanner.next();
                    afisare_excursii_dupa_nume(connection,nume_cautat);
                    break;
                case 5:
                    System.out.println("Dati destinatia:");
                    String destinatie_cautata = scanner.next();
                    afisare_persoane_dupa_destinatie(connection,destinatie_cautata);
                    break;
                case 6:
                    System.out.println("Introduceti anul: ");
                    int an_cautat = scanner.nextInt();
                    afisare_persoane_dupa_an(connection,an_cautat);
                    break;
                case 7:
                    System.out.println("Dati id-ul excursiei pe care doriti sa o stergeti:");
                    int idexcursie = scanner.nextInt();
                    stergere_excursie(connection,idexcursie);
                    break;
                case 8:
                    System.out.println("Dati id-ul persoanei: ");
                    int idPers = scanner.nextInt();
                    stergere_persoana_si_excursie(connection, idPers);
                case 9:
                    quit = true;
                    break;
                default:
                    System.out.println("Nu ati introdus nicio optiune corecta!");
                    break;
            }
        }


        connection.close();
    }
}
