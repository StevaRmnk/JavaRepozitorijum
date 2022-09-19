import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Metode {

    public static int izbrojOdredjenoSlovo(String pp, String slovo){
        int n = pp.length() - pp.replace(slovo,"").length();
        return n;
    }

    public static int PronadjiRec(){


        String s = "";
        String b = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite pocetni niz: ");
//        while (scanner.hasNextLine()){
//
//        }

        s = scanner.nextLine();


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


}
