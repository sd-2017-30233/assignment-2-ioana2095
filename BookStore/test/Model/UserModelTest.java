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
public class UserModelTest {
    
    public UserModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    /**
     * Test of Login method, of class UserModel.
     */
    @Test
    public void testLogin() {
        System.out.println("Login");
        String username = "ana23";
        String password = "12345678";
        UserModel instance = new UserModel();
        String expResult = "employee";
        String result = instance.Login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of ReadUsers method, of class UserModel.
     */
    @Test
    public void testReadUsers() {
        System.out.println("ReadUsers");
        UserModel instance = new UserModel();
        List<UserModel> expResult = new ArrayList<>();
        UserModel user=new UserModel("ana23","12345678","employee");
        expResult.add(user);
        List<UserModel> result = instance.ReadUsers();
        for(int i=0;i<result.size();i++){
        assertEquals(expResult.get(i).getUserName(), result.get(i).getUserName());
        assertEquals(expResult.get(i).getPassword(), result.get(i).getPassword());
        assertEquals(expResult.get(i).getAccesType(), result.get(i).getAccesType());
        }
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of createUser method, of class UserModel.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String username = "andreea12";
        String password = "afrdgredgb";
        String type = "employee";
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.createUser(username, password, type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of updateUser method, of class UserModel.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        String username = "andreea12";
        String password = "segfyshajk123";
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.updateUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of deleteUser method, of class UserModel.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        String username = "andreea12";
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.deleteUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
