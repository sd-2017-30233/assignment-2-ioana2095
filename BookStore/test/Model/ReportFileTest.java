/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioana
 */
public class ReportFileTest {
    
    public ReportFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of write method, of class ReportFile.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        ArrayList<String> raport = null;
        String file = "";
        ReportFile instance = new ReportFileImpl();
        instance.write(raport, file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ReportFileImpl implements ReportFile {

        public void write(ArrayList<String> raport, String file) {
        }
    }
    
}
