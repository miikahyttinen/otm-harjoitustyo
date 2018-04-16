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
        int[] startdate = {01, 01, 2018};
        int[] enddate = {31, 12, 2018};
        testyear.setStartDate(startdate);
        testyear.setEndDate(enddate);
        int[] date1 = {01, 02, 2018};
        testentry1 = new Entry("Testikirjaus", date1, 300, "Income");
        testyear.addEntry(testentry1);
        int[] date2 = {01, 03, 2018};
        testentry2 = new Entry("Testikirjaus", date2 , -200, "Expense");
        int[] date3 = {13, 04, 2018};
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
    
    @Test 
    public void yearInfoToStringWorks() {
        String[] compare = {"Testimiehen tilikausi", "1", "1", "2018", "31", "12", "2018"};
        assertEquals(testyear.yearInfoToString(), compare);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
