/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BookModel;
import Model.UserModel;
import View.BookStoreOperation;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ioana
 */
public class AccountController {
    private Login theView;
    private UserModel theModel;
    public AccountController(Login theView, UserModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addLoginListener(new LoginListener() );
        
    }
     class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String username=null;
            String password=null;
            
            try
            {
                username=theView.getUserName();
                password=theView.getPassword();
                String s=theModel.Login(username, password);
                if(theModel.Login(username, password).equals("employee"))
                    theView.displayBookStoreOperationUser(s,username);
                
                if(theModel.Login(username, password).equals("admin")) 
                
                    theView.displayBookStoreOperationUser(s,username);
               
                    
            }catch(NullPointerException e)
            {
                theView.displayErrorMessage("Utilizatorul nu exista sau a gresit parola");
            }
        }
         
     }
    
    
}
