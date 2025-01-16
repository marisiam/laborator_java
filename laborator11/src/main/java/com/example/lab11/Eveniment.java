package com.example.lab11;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
@Table(name="evenimente")
public class Eveniment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String denumire;
	private String locatia;
	private String dataa;
	private String timpul;
	private int pret;
	
	public Eveniment(int id, String denumire, String locatia, String dataa, String timpul, int pret) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.locatia = locatia;
		this.dataa = dataa;
		this.timpul = timpul;
		this.pret = pret;
	}
	public Eveniment() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getLocatia() {
		return locatia;
	}

	public void setLocatia(String locatia) {
		this.locatia = locatia;
	}

	public String getDataa() {
		return dataa;
	}

	public void setDataa(String dataa) {
		this.dataa = dataa;
	}

	public String getTimpul() {
		return timpul;
	}

	public void setTimpul(String timpul) {
		this.timpul = timpul;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	@Override
	public String toString() {
		return "Eveniment [id=" + id + ", denumire=" + denumire + ", locatia=" + locatia + ", dataa=" + dataa
				+ ", timpul=" + timpul + ", pret=" + pret + "]";
	}
	
}
