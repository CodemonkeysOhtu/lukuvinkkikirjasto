package lukuvinkkikirjasto.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KirjaTest {
    private Kirja kirja;

    @Test
    public void initializationTest() {
        String kirjoittaja = "Robert Martin";
        String otsikko = "Clean Code";
        kirja = new Kirja(kirjoittaja, otsikko);

        assertEquals(kirja.getKirjoittaja(),kirjoittaja);
        assertEquals(kirja.getOtsikko(),otsikko);
    }
}

