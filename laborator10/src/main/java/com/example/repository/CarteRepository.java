package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Carte;

public interface CarteRepository  extends JpaRepository<Carte, String> {

	
}
