package com.exemplu.jdbc;

public class Masina {
    private String numar_inmatriculare;
    private String marca;
    private int anul;
    private String culoarea;
    private int nr_km;

    public Masina(String numar_inmatriculare, String marca, int anul, String culoarea, int nr_km) {
        this.numar_inmatriculare = numar_inmatriculare;
        this.marca = marca;
        this.anul = anul;
        this.culoarea = culoarea;
        this.nr_km = nr_km;
    }

    public Masina() {
    }

    public String getNumar_inmatriculare() {
        return numar_inmatriculare;
    }

    public void setNumar_inmatriculare(String numar_inmatriculare) {
        this.numar_inmatriculare = numar_inmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public String getCuloarea() {
        return culoarea;
    }

    public void setCuloarea(String culoarea) {
        this.culoarea = culoarea;
    }

    public int getNr_km() {
        return nr_km;
    }

    public void setNr_km(int nr_km) {
        this.nr_km = nr_km;
    }

    @Override
    public String toString() {
        return "Masina:[" +
                "numar_inmatriculare='" + numar_inmatriculare + '\'' +
                ", marca='" + marca + '\'' +
                ", anul=" + anul +
                ", culoarea='" + culoarea + '\'' +
                ", nr_km=" + nr_km +
                ']';
    }
}


