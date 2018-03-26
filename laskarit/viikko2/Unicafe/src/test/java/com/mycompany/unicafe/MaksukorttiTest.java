package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }
    
    public void saldoOikeinAlussa(){
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    public void saldonLisaysToimii(){
        kortti.lataaRahaa(10);
        assertEquals("Kortilla on rahaa 20.0 euroa", kortti.toString());
    }
    
    public void saldonOttoToimii(){
        kortti.otaRahaa(9);
        assertEquals("Kortilla on rahaa 1.0 euroa", kortti.toString());
    }
    
    public void saldoEiMeneNegatiiviseksi(){
        kortti.otaRahaa(11);
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    public void otaRahaaPalauttaaTrue(){
        assertEquals(true, kortti.otaRahaa(9));
    }
    
    public void otaRahaaPalauttaaFalse(){
        assertEquals(true, kortti.otaRahaa(11));
    }
    

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
