package com.example.lab11;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EvenimentController {
	@Autowired
	EvenimentRepository repository;
	@GetMapping("jpa/evenimente")
	public List<Eveniment> findAll() {
		return repository.findAll();
		}
	@GetMapping("jpa/evenimente/{locatia}")
	public Eveniment findByLocatie(@PathVariable String locatia) {
	Optional<Eveniment> optionalEveniment = repository.findById(locatia);
	if(optionalEveniment.isPresent())
	return optionalEveniment.get();
	else
	throw new EvenimentNotFoundException("Evenimentul cu locatia " + locatia + " nu a fost gasit");
	}
	@GetMapping("jpa/evenimente/{dataa}")
	public Eveniment findByData(@PathVariable String dataa) {
	Optional<Eveniment> optionalEveniment = repository.findById(dataa);
	if(optionalEveniment.isPresent())
	return optionalEveniment.get();
	else
	throw new EvenimentNotFoundException("Evenimentul cu data " + dataa + " nu a fost gasit");
	}
	

    @PostMapping("jpa/evenimente")
    public void saveEveniment(@RequestBody Eveniment eveniment) {
    repository.save(eveniment);
    }
    @DeleteMapping("jpa/persoane/{id}")
    public void deleteById(@PathVariable String id) {
     repository.deleteById(id);
    }
}
