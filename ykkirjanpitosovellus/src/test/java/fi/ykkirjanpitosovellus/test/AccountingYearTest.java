/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.ykkirjanpitosovellus.test;

import fi.ykkirjanpitosovellus.logic.AccountingYear;
import fi.ykkirjanpitosovellus.logic.Entry;
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
public class AccountingYearTest {
    
    AccountingYear testyear;
    Entry testentry1;
    Entry testentry2;
    Entry testentry3;
    
    public AccountingYearTest() {
    }
    
    @Before
    public void setUp() {
        testyear = new AccountingYear("Testimiehen tilikausi");
        int[] date1 = {1, 2, 2018};
        testentry1 = new Entry("Testikirjaus", date1, 300, "Income");
        testyear.addEntry(testentry1);
        int[] date2 = {1, 3, 2018};
        testentry2 = new Entry("Testikirjaus", date2 , -200, "Expense");
        int[] date3 = {13, 4, 2018};
        testyear.addEntry(testentry2);
        testentry3 = new Entry("Testikirjaus", date3 , 350, "Rental income");
        testyear.addEntry(testentry3);
    }
    
    @Test
    public void indexingLogicWorks() {
        assertEquals(testyear.getEntry(1).getId(), 1);
        assertEquals(testyear.getEntry(2).getId(), 2);
        assertEquals(testyear.getEntry(3).getId(), 3);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
