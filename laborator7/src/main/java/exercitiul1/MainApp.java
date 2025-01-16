package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {

    public static void scriere(Map<Integer, Carte> carti) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fisier = new File("src/main/resources/carti.json");
        mapper.writeValue(fisier, carti);
    }



    public static void Afisare(Map<Integer, Carte> map) {
        map.forEach((key, value) -> {
            System.out.println("ID: " + key);
            System.out.println("Carte: " + value);
        });
    }

    public static Map<Integer, Carte> citire() throws IOException {
        File fisier = new File("src/main/resources/carti.json");
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fisier, new TypeReference<Map<Integer, Carte>>() {});
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> map = citire();
      //  System.out.println("Initial Map:");
       // Afisare(map);
      //  map.remove(1);
      //  System.out.println("\nAfter Removing Entry with ID 1:");
        //Afisare(map);

        Carte carte = new Carte("Ra", "Razvan", 2024);
        map.putIfAbsent(7, carte);

        scriere(map);

       // System.out.println("\nAfter Adding New Entry with ID 7:");
        //Afisare(map);

        Set<Carte> yualNoahHarari = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(carte1 -> carte1.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .collect(Collectors.toSet());

      //  yualNoahHarari.forEach(System.out::println);

        List<Carte> elemente = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(c -> !c.titlul().isBlank())
                .sorted((c1, c2) -> c1.titlul().compareToIgnoreCase(c2.titlul()))
                .collect(Collectors.toList());

        elemente.forEach(System.out::println);

        Optional<Carte> oldestBook = map.values().stream()
                .min((c1, c2) -> Integer.compare(c1.anul(), c2.anul()));
        oldestBook.ifPresent(book -> System.out.println("Cea mai veche carte: " + book));
    }
}
