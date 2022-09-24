package paket;

public class RezultatKlasa {
	

    private int idRezultata;
    private int rezultat;


    public RezultatKlasa(){

    }

    public RezultatKlasa(int idRezultata, int rezultat) {
        this.idRezultata = idRezultata;
        this.rezultat = rezultat;
    }

    public int getIdRezultata() {
        return idRezultata;
    }

    public void setIdRezultata(int idRezultata) {
        this.idRezultata = idRezultata;
    }

    public int getRezultat() {
        return rezultat;
    }

    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }


    public void zaPravljenjeKlase(String primljenPodatak){
        String[] podeljeno = primljenPodatak.split("\\|");
        setIdRezultata(Integer.parseInt(podeljeno[0]));
        setRezultat(Integer.parseInt(podeljeno[1]));
    }

    public String zaUpisivanje(){
        return String.join("|",idRezultata + "",rezultat + "\n");
    };

}
