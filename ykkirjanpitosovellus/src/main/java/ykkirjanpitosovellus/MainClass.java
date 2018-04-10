/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ykkirjanpitosovellus;

/**
 *
 * @author yllapitaja
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountingYear tilikausi = new AccountingYear("Miikan tilikausi");
        Entry kirjaus1 = new Entry("Testikirjaus", 300, "Income");
        tilikausi.addEntry(kirjaus1);
        Entry kirjaus2 = new Entry("Testikirjaus", -200, "Expense");
        tilikausi.addEntry(kirjaus2);
        Entry kirjaus3 = new Entry("Testikirjaus", 350, "Rental income");
        tilikausi.addEntry(kirjaus3);
        String[] lista = tilikausi.allEntriesToString();
        for (String kirjaus : lista) {
            System.out.println(kirjaus);
        }
    }
    
}
