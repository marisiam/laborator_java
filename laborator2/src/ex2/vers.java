package ex2;

class vers {
    private String continut;


    public vers(String continut) {
        this.continut = continut;
    }


    public int numarCuvinte() {
        if (continut.isEmpty()) {
            return 0;
        }
        return continut.split("\\s+").length; // Split pe spații
    }


    public int numarVocale() {
        int count = 0;
        String vocale = "aeiouAEIOU";
        for (char c : continut.toCharArray()) {
            if (vocale.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }


    public boolean seTerminaCu(String grupare) {
        return continut.endsWith(grupare);
    }


    public String getContinut() {
        return continut;
    }


    public void scrieCuMajuscule() {
        this.continut = continut.toUpperCase();
    }
}