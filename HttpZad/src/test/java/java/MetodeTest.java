package java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import paket.Metode;
import paket.RezultatKlasa;
import paket.StringKlasa;


public class MetodeTest {
	

    @BeforeEach
    void pocetak(){
        System.out.println("Pocetak testa u:" + LocalDateTime.now());
    }

    @Test
    void izbrojOdredjenoSlovoTEST() {
        System.out.println();
        assertEquals(3, Metode.izbrojOdredjenoSlovo("parangal","a"));
    }

    @Test
    void sacuvajReciIDajRezultatTEST() {
        assertEquals(2,Metode.sacuvajReciIDajRezultat("baraba","baba"));
    }

    @Test
    void upisivanjeRezultataTEST() {
        List<RezultatKlasa> sve = Metode.ucitajSveRezultate();
        Assertions.assertEquals("Uspesno upisane vrednosti!",Metode.upisivanjeRezultata(100,1,sve));
    }

    @Test
    void ucitajSveRezultateTEST(){
        List<RezultatKlasa> bla = Metode.ucitajSveRezultate();
        assertTrue(bla!=null);
    }

    @Test
    void ucitajSveReciZaPoredjenjeTEST() {
        List<StringKlasa>  bla = Metode.ucitajSveReciZaPoredjenje();
        assertTrue(bla!=null);
    }

    @Test
    void upisivanjeReciZaPoredjenjeTEST() {
        Random random = new Random();
        int gornja = 200;
        int nasumicni = random.nextInt(gornja);
        List<StringKlasa> sve = Metode.ucitajSveReciZaPoredjenje();
        Assertions.assertEquals("Uspesno upisane vrednosti!",Metode.upisivanjeReciZaPoredjenje(100,"barakuda","bara",sve));
    }

    @AfterEach
    public void ispisiKraj(){

        System.out.println("Test zavrsen u:" + LocalDateTime.now());
    }

}
