package com.example.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Carte;
import com.example.repository.CarteRepository;
@Controller
public class CarteWebController {
	@Autowired
	CarteRepository repository;
	@GetMapping("/lista-carti")
	public String getListaCarti(Model model) {
	String s="Lista cartilor preluate prin repository";
	model.addAttribute("str",s);
	model.addAttribute("lista",repository.findAll());
	return "carti";
	}
	 @PostMapping("/operatii")
	    public String handleOperatii(@RequestParam Optional<String> adauga,
	                                  @RequestParam Optional<String> modifica,
	                                  @RequestParam Optional<String> sterge,
	                                  @RequestParam Optional<String> filtreaza,
	                                  @RequestParam Optional<String> isbn,
	                                  @RequestParam Optional<String> titlu,
	                                  @RequestParam Optional<String> autor,
	                                  Model model) {
	        if (adauga.isPresent()) {
	            Carte carteNoua = new Carte();
	            carteNoua.setIsbn(isbn.orElse("").trim());
	            carteNoua.setTitlul(titlu.orElse("").trim());
	            carteNoua.setAutorul(autor.orElse("").trim());
	            repository.save(carteNoua);
	            model.addAttribute("message", "Cartea a fost adaugata cu succes!");
	        } else if (modifica.isPresent()) {
	            repository.findById(isbn.orElse("").trim()).ifPresent(carte -> {
	                carte.setTitlul(titlu.orElse("").trim());
	                carte.setAutorul(autor.orElse("").trim());
	                repository.save(carte);
	            });
	            model.addAttribute("message", "Cartea a fost modificata cu succes!");
	        } else if (sterge.isPresent()) {
	            repository.deleteById(isbn.orElse("").trim());
	            model.addAttribute("message", "Cartea a fost stearsa cu succes!");
	        } else if (filtreaza.isPresent()) {
	            String autorFiltru = autor.orElse("").trim();
	            model.addAttribute("lista", repository.findByAutorContaining(autorFiltru));
	            model.addAttribute("message", "Cartile filtrate dupa autor: " + autorFiltru);
	            return "carti";
	        }
	 }
}
