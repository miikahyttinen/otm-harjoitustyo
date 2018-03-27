package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void saldoOikeinAlussa(){
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void saldonLisaysToimii(){
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 20.0", kortti.toString());
    }
    
    @Test
    public void saldonOttoToimii(){
        kortti.otaRahaa(900);
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void saldoEiMeneNegatiiviseksi(){
        kortti.otaRahaa(1100);
        assertEquals("saldo: 10.0", kortti.toString());
    }
    
    @Test
    public void otaRahaaPalauttaaTrue(){
        assertEquals(true, kortti.otaRahaa(900));
    }
    
    @Test
    public void otaRahaaPalauttaaFalse(){
        assertEquals(false, kortti.otaRahaa(1100));
    }
    
    @Test
    public void onkoSaldoSama(){
        assertEquals(1000, kortti.saldo());
    }
    

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
}
