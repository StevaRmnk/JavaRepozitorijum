import java.io.*;
import java.util.*;

public class Metode {

    public static int izbrojOdredjenoSlovo(String pp, String slovo){
        int n = pp.length() - pp.replace(slovo,"").length();
        return n;
    }

    public static int PronadjiRec(){


        String s = "";
        String b = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite rec: ");

        String t = scanner.nextLine();
        System.out.println(t);
        if(t.equals("")){
            t = null;
        }

        upisivanjeReciZaPoredjenje(t);
        List<String> ucitaniRezultati = ucitavanjeUnesenihPodataka();

        for(String s1 : ucitaniRezultati){
            if(t.equals(s1)){
                s = s1;
            }
            else {
                System.out.println("Nije pronadjena takva rec!");
            }
        }


        System.out.println("Unesite rec koju hocete da proverite da li se nalazi u prvom nizu: ");

            b = scanner.nextLine();

            char[] nizOdB = b.toCharArray();


        scanner.close();

        Integer maksimum = Integer.MAX_VALUE;

        HashMap<String,Integer> mapa = new HashMap<>();

        for (char a : nizOdB){
            String l = "" + a;

            if(mapa.containsKey(l)){
                mapa.put(l,mapa.get(l)+1);
            }else {
                mapa.put(l,1);
            }
        }

        for(Map.Entry<String,Integer> jednaStavkaMape : mapa.entrySet()){
         maksimum = (izbrojOdredjenoSlovo(s, jednaStavkaMape.getKey())/jednaStavkaMape.getValue()) < maksimum ? izbrojOdredjenoSlovo(s, jednaStavkaMape.getKey()) : maksimum;
        }

        return maksimum;

    }

    public static void upisivanjeRezultata(int max){
        try{
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("src/rezultati.txt")));
            upis.write(""+max);
            upis.close();
        }
        catch (IOException e){
            System.out.println("Doslo je do greske prilikom upisivanja!");
        }
    }

    public static List<String> ucitavanjeUnesenihPodataka(){
        List<String>pronadjeniStringovi = new ArrayList<>();
        try {
            File fajl = new File("src/upisivanjeVrednosti.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                pronadjeniStringovi.add(linijaKoda);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        return pronadjeniStringovi;
    }

    public static void upisivanjeReciZaPoredjenje(String rec){
        try {
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("src/upisivanjeVrednosti.txt")));
            if(rec == null){
                throw new NullPointerException();
            }else {
                upis.write(rec);
                upis.close();
            }
        }

        catch (IOException error){
            System.out.println("Doslo je do greske tokom upisivanja vrednosti");
        }
        catch (NullPointerException error){
            System.out.println("Nije upisana vrednost jer je null");
        }

    }


}
