/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BookModel;
import View.BookStoreOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ioana
 */
public class UserController {
    private BookStoreOperation theView;
    private BookModel theModel;

    public UserController(BookStoreOperation theView) {
        this.theView = theView;
        this.theModel = new BookModel();
        this.theView.addGenreListener(new GenreListener() );
    }
    
    class GenreListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String s=null;
            String s1=null;
            try{
                s=theView.getText();
                s1=theView.getText2();
                if(theView.getNameButton().equals("Genre"))
                    theView.setList(theModel.getGenre(s),"");
                if(theView.getNameButton().equals("Author"))
                    theView.setList(theModel.getAuthor(s),"");
                 if(theView.getNameButton().equals("Title"))
                    theView.setList(theModel.getTitle(s),"Autori care au cartea cu numele "+s);
                 if(theView.getNameButton().equals("Sell Book"))
                     if(theModel.sellBook(s, Integer.parseInt(s1), theView.getUsername()))
                        theView.setMessage("Carte vanduta");
                     else
                         theView.setMessage("Prea putine cartii");
            }
            catch(NullPointerException e)
            {
                theView.displayErrorMessage("Nu ati introdus nici un string");
            }
        }
        
    }
    
}
