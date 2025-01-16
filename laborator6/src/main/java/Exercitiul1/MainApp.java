package Exercitiul1;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainApp {



    static void afisare_filtrata(List<Angajat> angajati, Predicate<Angajat> ang)
    {
        for(Angajat a : angajati)
        {
            if(ang.test(a))
                System.out.println(a.getNume());
        }
    }

    static void filtrate_post(List<Angajat> angajati)
    {
        List<Angajat>lista_angajati = angajati.stream()
                .filter((a)->a.getData_angajarii().getMonthValue() == 4 && a.getPostul()
                        .equalsIgnoreCase("director"))
                .collect(Collectors.toList());

        lista_angajati.forEach(System.out::println);
    }

    static void filtrare_salar_descrescator(List<Angajat> angajati)
    {
        List<Angajat>lista_angajati = angajati.stream()
                .filter((a)->a.getSalariul() != 0 && !a.getPostul()
                        .equalsIgnoreCase("director"))
                .collect(Collectors.toList());

        lista_angajati.sort(Comparator.comparingDouble(Angajat::getSalariul).reversed());
        for(Angajat a : lista_angajati)
        {
            System.out.println("Nume: " + a.getNume() + ", Salar: " + a.getSalariul());
        }
    }

    static void filtrare_nume(List<Angajat> angajati)
    {
        List<String>nume = angajati.stream().map(Angajat::getNume).collect(Collectors.toList());
        for (String name : nume)
        {
            System.out.println(name.toUpperCase());
        }
    }

    static void filtrare_salar_nume(List<Angajat> angajati)
    {
        List<Float>lista_angajati = angajati.
                stream().filter((a)->a.getSalariul() < 3000)
                .map(Angajat::getSalariul)
                .collect(Collectors.toList());
        lista_angajati.reversed().forEach(System.out::println);
    }

    static void primul_angajat(List<Angajat> angajati)
    {
        angajati.stream()
                .min((a1,a2)->a1.getData_angajarii().compareTo(a2.getData_angajarii()))
                .ifPresentOrElse(System.out::println, ()-> System.out.println("Nu exista primul angajat"));

    }

    static void statistici(List<Angajat> angajati)
    {
        DoubleSummaryStatistics statistics = angajati.stream()
                .collect(Collectors.summarizingDouble(Angajat::getSalariul));
        System.out.println("Salar maxim: " + statistics.getMax());
        System.out.println("Salar mediu: " + statistics.getAverage());
        System.out.println("Salariu minim: " + statistics.getMin());
    }

    static void mesaje(List<Angajat> angajati)
    {
        angajati.stream().filter((a1)->a1.getNume().equalsIgnoreCase("Ion"))
                .findAny()
                .ifPresentOrElse(a1-> System.out.println("Firma are cel putin un angajat Ion"),
                        ()-> System.out.println("Nu exista niciun Ion"));
    }

    static void angajare_vara(List<Angajat> angajati)
    {
        System.out.println("S-au angajat: " + angajati.stream().filter(a1->a1.getData_angajarii().getMonthValue() == 6 ||
                a1.getData_angajarii().getMonthValue() == 7 || a1.getData_angajarii().getMonthValue() == 8)
                .count() + " persoane");

    }

    public static void scriere(List<Angajat>lista) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        File fisier = new File("src/main/resources/angajati.json");
        mapper.writeValue(fisier, lista);
    }

    public static List<Angajat>citire() throws IOException {
        File fisier = new File("src/main/resources/angajati.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Angajat> angajati = mapper.readValue(fisier, new TypeReference<List<Angajat>>() {});
        return angajati;
    }


    public static void main(String[] args) throws IOException {
//        LocalDate d = LocalDate.parse("2017-11-20");
//        LocalDate d1 = LocalDate.parse("2019-06-29");
//        LocalDate d2 = LocalDate.parse("2015-03-07");
//        LocalDate d3 = LocalDate.parse("2010-01-01");
//        LocalDate d4 = LocalDate.parse("2016-04-11");
       // Angajat a = new Angajat("Andrei", "director", d4, 3000F);
        List<Angajat>angajatList = citire();
       // angajatList.add(a);
        //scriere(angajatList);
        //angajatList.forEach(System.out::println);



        //System.out.println("Angajatii cu un salariu mai mic decat 2500 RON: ");;
       afisare_filtrata(angajatList, angajat1 ->angajat1.getSalariul()<2500);
       filtrate_post(angajatList);
       filtrare_salar_descrescator(angajatList);
        filtrare_nume(angajatList);
        filtrare_salar_nume(angajatList);
        primul_angajat(angajatList);
        statistici(angajatList);
        mesaje(angajatList);
        angajare_vara(angajatList);
    }

}
