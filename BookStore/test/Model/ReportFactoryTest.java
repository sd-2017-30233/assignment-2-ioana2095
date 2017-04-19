/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioana
 */
public class ReportFactoryTest {
    
    public ReportFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getReportFile method, of class ReportFactory.
     */
    @Test
    public void testGetReportFile() {
        System.out.println("getReportFile");
        String file = "";
        ReportFactory instance = new ReportFactory();
        ReportFile expResult = null;
        ReportFile result = instance.getReportFile(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
