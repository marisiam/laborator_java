package ex4;

import java.time.LocalDate;

class persoana {
    private String nume;
    private String cnp;


    public persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    // Setter pentru CNP (opțional, dacă dorim să actualizăm CNP-ul)
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    // Metoda pentru calcularea vârstei
    public int getVarsta() {
        // Extragem data nașterii din CNP
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));

        // Determinarea secolului în funcție de prima cifră a CNP-ului
        int secol;
        switch (cnp.charAt(0)) {
            case '1':
            case '2':
                secol = 1900;
                break;
            case '5':
            case '6':
                secol = 2000;
                break;
            default:
                secol = 0; // Nu ar trebui să ajungem aici, deoarece validarea CNP-ului este anterioră
        }

        an += secol;

        // Data nașterii
        LocalDate dataNasterii = LocalDate.of(an, luna, zi);

        // Data curentă
        LocalDate dataCurenta = LocalDate.now();

        // Calcularea vârstei
        return dataCurenta.getYear() - dataNasterii.getYear() -
                (dataCurenta.getDayOfYear() < dataNasterii.getDayOfYear() ? 1 : 0);
    }
}