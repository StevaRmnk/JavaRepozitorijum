import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetodeTest {



    @Test
    void izbrojOdredjenoSlovoTEST() {

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

}