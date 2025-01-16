enum FormatCopiere { A3, A4 }
class copiator extends echipament {
    private int pTon;
    private FormatCopiere formatCopiere;

    public copiator(String denumire, int nrInv, double pret, String zonaMag, Stare stare,
                    int pTon, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + ", Copiator: pTon=" + pTon + ", formatCopiere=" + formatCopiere;
    }
}