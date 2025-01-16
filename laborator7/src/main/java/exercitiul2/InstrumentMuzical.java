package exercitiul2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)



public abstract class InstrumentMuzical {
    private String producator;
    private float pret;

    public InstrumentMuzical(String producator, float pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public InstrumentMuzical() {
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "Producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentMuzical instrumente = (InstrumentMuzical) o;
        return producator.equals(instrumente.producator) && pret == instrumente.pret;
    }

    public int hashCode() {
        return Objects.hash(producator, pret);
    }

}
