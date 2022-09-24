import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetodeTest {



    @Test
    void izbrojOdredjenoSlovoTEST() {
        System.out.println();
        assertEquals(3,Metode.izbrojOdredjenoSlovo("parangal","a"));
    }


    @Test
    void pronadjiRecTEST() {

    }


    @Test
    void ucitavanjeUnesenihPodatakaTEST() {
        List<String > a = Metode.ucitavanjeUnesenihPodataka();
        String t = a.get(0);
        Assertions.assertEquals("katapult",t);
    }

    @AfterEach
    public void ispisiKraj(){

        System.out.println("Test zavrsen u:" + LocalDateTime.now());
    }

}