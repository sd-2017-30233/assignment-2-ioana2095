/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AccountController;
import Controller.UserController;
import DB.Administrator;
import DB.Users;
import Model.BookModel;
import Model.*;
import Model.UserModel;

/**
 *
 * @author Ioana
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Login theView= new Login();
        UserModel theModel=new UserModel();
        AccountController theController=new AccountController(theView,theModel);
        theView.setVisible(true);
        ShareData d=new ShareData();
        
    }
    
}
