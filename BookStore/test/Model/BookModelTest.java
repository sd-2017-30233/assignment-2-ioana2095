/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ioana
 */
public class BookModelTest {
    
    public BookModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getTitle method, of class BookModel.
     */
    
    @Test
    public void testGetGenre_String() {
        System.out.println("getGenre");
        String s = "Roman Politist";
        BookModel instance = new BookModel();
        List<String> expResult = new ArrayList<String>();
        expResult.add("Povestea taietorului de bambus");
        List<String> result = instance.getGenre(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getAuthor method, of class BookModel.
     */
    @Test
    public void testGetAuthor_String() {
        System.out.println("getAuthor");
        String s = "Anonim";
        BookModel instance = new BookModel();
        List<String> expResult = new ArrayList<>();
        expResult.add("Povestea taietorului de bambus");
        expResult.add("O mie si una de nopti");
        expResult.add("Viata lui Lazarillo de Tormes");
        List<String> result = instance.getAuthor(s);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of getTitle method, of class BookModel.
     */
    @Test
    public void testGetTitle_String() {
        System.out.println("getTitle");
        String s = "Povestea taietorului de bambus";
        BookModel instance = new BookModel();
        List<String> expResult =  new ArrayList<String>();
        expResult.add("Anonim");
        List<String> result = instance.getTitle(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of sellBook method, of class BookModel.
     */
    @Test
    public void testSellBook() {
        System.out.println("sellBook");
        String title = "Povestea taietorului de bambus";
        int quantity = 5;
        String username = "ana23";
        BookModel instance = new BookModel();
        boolean expResult = true;
        boolean result = instance.sellBook(title, quantity, username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of createBook method, of class BookModel.
     */
    @Test
    public void testCreateBook() {
        System.out.println("createBook");
        String title = "Regele maimuta: Calatoria spre vest";
        String autor = "Wu Chengen";
        String gen = "Drama";
        int cantitate = 45;
        float price = 125.0F;
        BookModel instance = new BookModel();
        boolean expResult = true;
        boolean result = instance.createBook(title, autor, gen, cantitate, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of readBooks method, of class BookModel.
     */
    @Test
    public void testReadBooks() {
        System.out.println("readBooks");
        BookModel instance = new BookModel();
        List<BookModel> expResult = new ArrayList<BookModel>();
        BookModel carte=new BookModel("Povestea taietorului de bambus","Anonim","Roman Politist",17,(float)123.9);
        expResult.add(carte);
        carte=new BookModel("O mie si una de nopti","Anonim","Roman De Dragoste",20,(float)59.90);
        expResult.add(carte);
        carte=new BookModel("Povestea lui Genji","Murasaki Shikibu","Science_Fiction",20,(float)59.90);
        expResult.add(carte);
        carte=new BookModel("Cronica celor trei regate","Luo Guanzhong","Science_Fiction",20,(float)59.90);
        expResult.add(carte);
        carte=new BookModel("Marginea apei","Luo Guanzhong","Enciclopedie",20,(float)59.90);
        expResult.add(carte);
        carte=new BookModel("Viata lui Lazarillo de Tormes","Anonim","Roman De Dragoste",20,(float)59.90);
        expResult.add(carte);
        carte=new BookModel("Regele maimuta: Calatoria spre vest","Wu Chengen","Drama",45,(float)125.0);
        expResult.add(carte);
        List<BookModel> result = instance.readBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of readBook method, of class BookModel.
     */
    @Test
    public void testReadBook() {
        System.out.println("readBook");
        String s = "Viata lui Lazarillo de Tormes";
        BookModel instance = new BookModel();
        BookModel expResult = new BookModel("Viata lui Lazarillo de Tormes","Anonim","Roman De Dragoste",20,(float)59.90);
        BookModel result = instance.readBook(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of updateBook method, of class BookModel.
     */
    @Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        String title = "Viata lui Lazarillo de Tormes";
        int cantitate = 34;
        float price = 120.0F;
        BookModel instance = new BookModel();
        boolean expResult = true;
        boolean result = instance.updateBook(title, cantitate, price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of deleteBook method, of class BookModel.
     */
    @Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        String title = "Regele maimuta: Calatoria spre vest";
        BookModel instance = new BookModel();
        boolean expResult = true;
        boolean result = instance.deleteBook(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
    
}
