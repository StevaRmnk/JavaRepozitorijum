package paket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Metode {

	//URADJENA
    public static int izbrojOdredjenoSlovo(String pp, String slovo){
        int n = pp.length() - pp.replace(slovo,"").length();
        return n;
    }

    //URADJENA
    public static List<String> sacuvajReciIDajRezultat(String prvaRec,String drugaRec){

    	List<String> konacno = new ArrayList<>();
        String s = "";
        Integer maksimum = Integer.MAX_VALUE;

        if(prvaRec.equals("")){
            prvaRec = null;
        }
        if(drugaRec.equals("")){
            drugaRec = null;
        }
        List<StringKlasa> ucitanirez = ucitajSveReciZaPoredjenje();
        Random random = new Random();
        int gornja = 200;
        int nasumicni = random.nextInt(gornja);
        upisivanjeReciZaPoredjenje(nasumicni,prvaRec,drugaRec,ucitanirez);
        List<StringKlasa> ucitaniRezultati = ucitajSveReciZaPoredjenje();

        List<String> prveReci = new ArrayList<>();
        for(StringKlasa gaga : ucitaniRezultati){
            prveReci.add(gaga.getPocetnaRec());
        }

        boolean postoji = true;

        for(String s1 : prveReci){
            if(prvaRec.equals(s1)){
                s = s1;
                postoji = true;
            }
            else {
                postoji = false;
            }
        }

        if(postoji = false){
            System.out.println("Nije pronadjena takva rec!");

        }




        char[] nizOdB = drugaRec.toCharArray();




        HashMap<String,Integer> mapa = new HashMap<>();

        for (char a : nizOdB){
            String kljuc = "" + a;

            if(mapa.containsKey(kljuc)){
                mapa.put(kljuc,mapa.get(kljuc)+1);
            }else {
                mapa.put(kljuc,1);
            }
        }

        for(Map.Entry<String,Integer> jednaStavkaMape : mapa.entrySet()){
            if((izbrojOdredjenoSlovo(s, jednaStavkaMape.getKey())/jednaStavkaMape.getValue()) < maksimum){
                maksimum = izbrojOdredjenoSlovo(s, jednaStavkaMape.getKey())/jednaStavkaMape.getValue();
            }else{
                maksimum = maksimum;
            }
        }
        List<RezultatKlasa> listaRezultata = ucitajSveRezultate();
        upisivanjeRezultata(nasumicni,maksimum,listaRezultata);
        konacno.add(prvaRec);
        konacno.add(drugaRec);
        konacno.add(maksimum.toString());
        return konacno;
    }

    //URADJENA
    public static String upisivanjeRezultata(int id,int max,List<RezultatKlasa> sviRezultati){
        try{
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("rezultati.txt")));
            RezultatKlasa zaUpis = new RezultatKlasa(id,max);
            sviRezultati.add(zaUpis);
            for(RezultatKlasa jedna : sviRezultati){
                upis.write(jedna.zaUpisivanje());
            }
            upis.close();
        }
        catch (IOException e){
            System.out.println("Doslo je do greske prilikom upisivanja!");
        }
        return "Uspesno upisana vrednost!";
    }

    public static List<RezultatKlasa> ucitajSveRezultate(){
        List<RezultatKlasa>pronadjeniRezultati = new ArrayList<>();
        try {
            File fajl = new File("rezultati.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                RezultatKlasa rezultatKlasa = new RezultatKlasa();
                rezultatKlasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniRezultati.add(rezultatKlasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        return pronadjeniRezultati;
    }


    //URADJENA
    public static List<StringKlasa> ucitajSveReciZaPoredjenje(){
        List<StringKlasa>pronadjeniStringovi = new ArrayList<>();
        try {
            File fajl = new File("upisivanjeVrednosti.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                StringKlasa klasa = new StringKlasa();
                klasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniStringovi.add(klasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        return pronadjeniStringovi;
    }

    //URADJENA
    public static String upisivanjeReciZaPoredjenje(int id,String rec,String drugaRec,List<StringKlasa> ostaliStringovi){
        try {
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("upisivanjeVrednosti.txt")));
            if(rec == null){
                throw new NullPointerException();
            }
            if(drugaRec == null){
                throw new NullPointerException();
            }else {
                StringKlasa noviSklop = new StringKlasa(id,rec,drugaRec);
                ostaliStringovi.add(noviSklop);
                for(StringKlasa jedno : ostaliStringovi){
                    upis.write(jedno.zaUpisivanje());
                }

                upis.close();
            }
        }

        catch (IOException error){
            System.out.println("Doslo je do greske tokom upisivanja vrednosti");
        }
        catch (NullPointerException error){
            System.out.println("Nije upisana vrednost jer je null");
        }

        return "Uspesno upisane vrednosti!";
    }

    //URADJENA - nadji jednu
    public static List<String> ucitajReciZaPoredjenjeIRezultatPrekoIda(int id){
    	List<String> nadjeno = new ArrayList<>();
        List<StringKlasa>pronadjeniStringovi = new ArrayList<>();
        List<RezultatKlasa> pronadjeniRezultati = new ArrayList<>();
        StringKlasa nadjena = new StringKlasa();
        RezultatKlasa rez = new RezultatKlasa();
        try {
            File fajl = new File("upisivanjeVrednosti.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                StringKlasa klasa = new StringKlasa();
                klasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniStringovi.add(klasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        try {
            File fajl = new File("rezultati.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                RezultatKlasa rezultatKlasa = new RezultatKlasa();
                rezultatKlasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniRezultati.add(rezultatKlasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        for(StringKlasa j : pronadjeniStringovi){
            if(j.getIdStringa()==id){
                nadjena = j;
            }
        }

        for(RezultatKlasa k : pronadjeniRezultati){
            if(k.getIdRezultata()==id){
                rez = k;
            }
        }
        
        int lo = rez.getRezultat();
        String olo = String.valueOf(lo);
        nadjeno.add(nadjena.getPocetnaRec());
        nadjeno.add(nadjena.getTrazenaRec());
        nadjeno.add(olo);

        return nadjeno;
    }

    //Za brisanje
    public static String obrisiReciZaPoredjenjeIRezultatPrekoIda(int id){
        List<StringKlasa>pronadjeniStringovi = new ArrayList<>();
        List<RezultatKlasa> pronadjeniRezultati = new ArrayList<>();
        StringKlasa nadjena = new StringKlasa();
        RezultatKlasa rez = new RezultatKlasa();
        try {
            File fajl = new File("upisivanjeVrednosti.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                StringKlasa klasa = new StringKlasa();
                klasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniStringovi.add(klasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        try {
            File fajl = new File("rezultati.txt");
            Scanner scanner = new Scanner(fajl);
            while (scanner.hasNextLine()){
                String linijaKoda = scanner.nextLine();
                RezultatKlasa rezultatKlasa = new RezultatKlasa();
                rezultatKlasa.zaPravljenjeKlase(linijaKoda);
                pronadjeniRezultati.add(rezultatKlasa);
            }

        }
        catch (FileNotFoundException error){
            System.out.println("Doslo je do greske prilikom citanja fajla,fajl nije pronadjen. Pokusajte ponovo!");
        }

        for(StringKlasa j : pronadjeniStringovi){
            if(j.getIdStringa()==id){
                nadjena = j;
                pronadjeniStringovi.remove(j);
            }
        }

        for(RezultatKlasa k : pronadjeniRezultati){
            if(k.getIdRezultata()==id){
                rez = k;
                pronadjeniRezultati.remove(k);
            }
        }
        
        Metode.upisReciZaPoredjenje(pronadjeniStringovi);
        Metode.upisRezultata(pronadjeniRezultati);



        return "Obrisan par reci: " + nadjena.getPocetnaRec() + " i " + nadjena.getTrazenaRec() + "i njihov rezultat: " + rez.getRezultat();
    }
    
    
    public static String upisReciZaPoredjenje(List<StringKlasa> ostaliStringovi){
        try {
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("upisivanjeVrednosti.txt")));

                for(StringKlasa jedno : ostaliStringovi){
                    upis.write(jedno.zaUpisivanje());
                }
                upis.close();
     
        }

        catch (IOException error){
            System.out.println("Doslo je do greske tokom upisivanja vrednosti");
        }
        catch (NullPointerException error){
            System.out.println("Nije upisana vrednost jer je null");
        }

        return "Uspesno upisane vrednosti!";
    }
    
    public static String upisRezultata(List<RezultatKlasa> sviRezultati){
        try{
            BufferedWriter upis = new BufferedWriter(new FileWriter(new File("rezultati.txt")));
            for(RezultatKlasa jedna : sviRezultati){
                upis.write(jedna.zaUpisivanje());
            }
            upis.close();
        }
        catch (IOException e){
            System.out.println("Doslo je do greske prilikom upisivanja!");
        }
        return "Uspesno upisana vrednost!";
    }


}
