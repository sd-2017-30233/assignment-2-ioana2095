/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ioana
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Model.CSVFileTest.class, Model.BookModelTest.class, Model.SellingModelTest.class, Model.ReportFileTest.class, Model.PDFFileTest.class, Model.UserModelTest.class, Model.ReportFactoryTest.class})
public class ModelSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
