package exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import exercitiul1.Carte;

import java.io.File;
import java.io.IOException;
import java.util.*;



public class MainApp {

    public static void scriere(Set<InstrumentMuzical>instrumente) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File fisier = new File("src/main/resources/instrumente.json");
        mapper.writeValue(fisier, instrumente);
    }

    public static Set<InstrumentMuzical> citire() throws IOException {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            //mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            Set<InstrumentMuzical> instrumente = mapper.readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return instrumente;
    }

    public static void verificare_duplicate(Set<InstrumentMuzical> set_instrumente) {
        var it = set_instrumente.iterator();
        InstrumentMuzical instrument = it.next();
        Set<InstrumentMuzical> set_instrumente_aux = new HashSet<>(set_instrumente);

        set_instrumente.add(instrument);

        if(set_instrumente_aux.size() == set_instrumente.size()) {
            System.out.println("Colectia set NU permite duplicate");
        }
        else {
            System.out.println("Colectia set PERMITE duplicate");
        }

    }


    public static void main(String[] args) throws IOException {
        //3
        Scanner scanner = new Scanner(System.in);
        Set<InstrumentMuzical> instrumente = citire();
//        instrumente.add(new Chitara("Flanco", 450.99f,TipChitara.ELECTRICA,6 ));
//        instrumente.add(new SetTobe("Yamaha", 1325f, TipTobe.ACUSTICE,5,2));
//        instrumente.add(new SetTobe("Startone", 879.50f, TipTobe.ELECTRONICE,7,2));
//        instrumente.add(new Chitara("Harley", 651.87f,TipChitara.ACUSTICA,6 ));
        //System.out.println(instrumente);
//        scriere(instrumente);

        //4
        for (InstrumentMuzical i : instrumente)
        {
            System.out.println(i);
        }

        InstrumentMuzical c1 = new Chitara("Flanco", 450.99f, TipChitara.ELECTRICA, 6);

        //5
        System.out.println("Doriti sa adaugati un nou instrument");
        String answer = scanner.next();
        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("da")) {
           // instrumente.add(c1);
            verificare_duplicate(instrumente);

        }
        else {
            System.out.println("Programul s-a terminat");
        }
        //6
        instrumente.removeIf((a)->a.getPret()>=3000);
       // instrumente.forEach(System.out::println);

        //7
        instrumente.stream().filter(instrumentMuzical ->instrumentMuzical instanceof Chitara)
                .forEach(System.out::println);
        //8
        instrumente.stream().filter(instrumentMuzical -> instrumentMuzical.getClass()
                        .equals(SetTobe.class))
                .forEach(System.out::println);

        //9
        Optional<InstrumentMuzical> chitara_cu_multe_corzi = instrumente.stream().filter(a->a instanceof Chitara)
                .max(Comparator.comparing((a)->((Chitara) a).getNr_corzi()));
        System.out.println("Chitara cu cel mai mare numar de corzi este: " + chitara_cu_multe_corzi);

        //10
        instrumente.stream().filter(a->a instanceof SetTobe)
                .sorted(Comparator.comparingInt(a -> ((SetTobe) a).getNr_tobe()).reversed())
                .forEach(System.out::println);

    }
}
