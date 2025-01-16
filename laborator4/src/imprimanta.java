enum ModTiparire { COLOR, ALB_NEGRU }
class imprimanta extends echipament {
    private int ppm;
    private int dpi;
    private int pCar;
    private ModTiparire modTiparire;

    public imprimanta(String denumire, int nrInv, double pret, String zonaMag, Stare stare,
                      int ppm, int dpi, int pCar, ModTiparire modTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pCar = pCar;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString() {
        return super.toString() + ", Imprimanta: ppm=" + ppm + ", dpi=" + dpi +
                ", pCar=" + pCar + ", modTiparire=" + modTiparire;
    }
}