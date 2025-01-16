enum SistemOperare { WINDOWS, LINUX }
class sisCalcul extends echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd;
    private SistemOperare sistemOperare;

    public sisCalcul(String denumire, int nrInv, double pret, String zonaMag, Stare stare,
                        String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + ", SistemCalcul: tipMon=" + tipMon + ", vitProc=" + vitProc +
                ", cHdd=" + cHdd + ", sistemOperare=" + sistemOperare;
    }
}
