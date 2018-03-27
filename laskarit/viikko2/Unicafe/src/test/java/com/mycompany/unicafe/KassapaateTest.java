/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yllapitaja
 */
public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
   
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @Test
    public void rahanLatausToimiiKortille() {
        paate.lataaRahaaKortille(kortti, 500);
        assertEquals(1500, kortti.saldo());
        assertEquals(100500, paate.kassassaRahaa());
    }
    
    @Test
    public void rahanLatausEiToimiJosNegKortille() {
        paate.lataaRahaaKortille(kortti, -500);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    
    @Test
    public void luotuPaateOikeaMaararahaa() {
        assertEquals(100000, paate.kassassaRahaa());
    }
    
        
    @Test
    public void luotuPaateOikeaMaaraMaukkaita() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void luotuPaateOikeaMaaraEdullisia() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateisOstoToimiiEdullinenRahaaTarpeeksi(){
        assertEquals(60, paate.syoEdullisesti(300));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(100240, paate.kassassaRahaa());
    }
    
    @Test
    public void kateisOstoToimiiEdullinenRahaaEiTarpeeksi(){
        assertEquals(200, paate.syoEdullisesti(200));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void kateisOstoToimiiMaukasRahaaTarpeeksi(){
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void kateisOstoToimiiMaukasRahaaEiTarpeeksi(){
        assertEquals(200, paate.syoMaukkaasti(200));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void KorttiOstoToimiiMaukasRahaaTarpeeksi(){
        assertEquals(true, paate.syoMaukkaasti(kortti));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void KorttiOstoToimiiMaukasEiRahaaTarpeeksi(){
        Maksukortti kortti2 = new Maksukortti(300);
        assertEquals(false, paate.syoMaukkaasti(kortti2));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void KorttiOstoToimiiEdullinenRahaaTarpeeksi(){
        assertEquals(true, paate.syoEdullisesti(kortti));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void KorttiOstoToimiiEdullinenEiRahaaTarpeeksi(){
        Maksukortti kortti3 = new Maksukortti(200);
        assertEquals(false, paate.syoEdullisesti(kortti3));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }

}
    



