package com.exemplu;

import com.exemplu.jdbc.Masina;
import com.exemplu.jdbc.MasinaJdbcDao;
import com.exemplu.jdbc.MasinaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Laborator9Application implements CommandLineRunner {

	@Autowired
	MasinaJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(Laborator9Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		//a
		//System.out.println("Adaugare masina");
		//int check = dao.insert(new Masina("AR57OPO", "Mercedes", 2019, "Albastru",
		//		30000));
		//if(check == 1)
		//{
		//	System.out.println("Succes");
		//}
		//else {
		//	System.out.println("Nu s-a facut inserare");
		//}

		//b
		System.out.println("Dati numarul matricol:");
		String nr_mat = scanner.next();
		dao.deleteByNrMat(nr_mat);
		if(dao.deleteByNrMat(nr_mat)==0)
		{
			System.out.println("Nu s-a efectuat stergerea.");
		}

		//c
		System.out.println("Dati numarul matricol:");
		String nr_matricol = scanner.next();
		System.out.println(dao.findByNrMat(nr_matricol));

		//d
		System.out.println("\nToate masinile: ");
		dao.findAll().forEach(System.out::println);

		//e
		System.out.println(dao.count("Dacia"));

		//f
		System.out.println("Masini care au sub 100.000 km: " + dao.countByKm());

		//g
		System.out.println("Masinile mai noi de 5 ani: " + dao.findNewerCars());
	}
}
