package paket;

public class StringKlasa {
	
	 private int idStringa;
	    private String pocetnaRec;
	    private String trazenaRec;


	    public StringKlasa(){

	    }

	    public StringKlasa(int idStringa,String pocetnaRec, String trazenaRec) {
	        this.idStringa = idStringa;
	        this.pocetnaRec = pocetnaRec;
	        this.trazenaRec = trazenaRec;
	    }

	    public int getIdStringa() {
	        return idStringa;
	    }

	    public void setIdStringa(int id) {
	        this.idStringa = id;
	    }

	    public String getPocetnaRec() {
	        return pocetnaRec;
	    }

	    public void setPocetnaRec(String pocetnaRec) {
	        this.pocetnaRec = pocetnaRec;
	    }

	    public String getTrazenaRec() {
	        return trazenaRec;
	    }

	    public void setTrazenaRec(String trazenaRec) {
	        this.trazenaRec = trazenaRec;
	    }

	    public void zaPravljenjeKlase(String primljenPodatak){
	        String[] podeljeno = primljenPodatak.split("\\|");
	        setIdStringa(Integer.parseInt(podeljeno[0]));
	        setPocetnaRec(podeljeno[1]);
	        setTrazenaRec(podeljeno[2]);

	    }


	    public String zaUpisivanje(){
	        return String.join("|",idStringa + "",pocetnaRec,trazenaRec + "\n");
	    };

}
