/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.BookStoreOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ioana
 */
public class AdminController {
    private BookStoreOperation theView;
    private BookModel theModel;
    private UserModel theModel1;
    private SellingModel theModel2;

     public AdminController(BookStoreOperation theView) {
        this.theView = theView;
        this.theModel = new BookModel();
        this.theModel1 = new UserModel();
        this.theModel2 = new SellingModel();
        this.theView.addListener(new Listener() );
        
    }
     class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            String s1=null;
            String s2=null;
            String s3=null;
            try{
                if(theView.getNameButton1().equals("ReadUsers"))
                {
                    List<UserModel> bm=theModel1.ReadUsers();
                    ArrayList<String> sb=new ArrayList<String>();
                    String s=new String();
                    for(int i=0;i<bm.size();i++)
                    {
                        s+="Username: "+bm.get(i).getUserName()+" Password: "+bm.get(i).getPassword()+" Type: "+bm.get(i).getAccesType();
                        sb.add(s);
                    }
                    theView.setUser(sb);
                }
                s1=theView.getInfo1();
                s2=theView.getInfo2();
                if(theView.getNameButton1().equals("UpdateUser"))
                {
                    if(theModel1.updateUser(s1, s2))
                        theView.setMessage("user updated");
                }
                if(!theView.getInfo3().equals(""))
                    s3=theView.getInfo3();
                if(theView.getNameButton1().equals("CreateUser"))
                {
                    if(theModel1.createUser(s1, s2, s3))
                        theView.setMessage("user create");
                }
                if(theView.getNameButton1().equals("DeleteUser"))
                {
                    if(theModel1.deleteUser(s1))
                        theView.setMessage("user delete");
                }
                if(theView.getNameButton1().equals("ReadBook"))
                {
                    if(s1.equals("")){
                    List<BookModel> bm=theModel.readBooks();
                    ArrayList<String> sb=new ArrayList<String>();
                    String s=new String();
                    for(int i=0;i<bm.size();i++)
                    {
                        s+="Title: "+bm.get(i).getTitle()+" Author: "+bm.get(i).getAuthor()+" Genre: "+bm.get(i).getGenre()+" Quantity: "+bm.get(i).getQuantity()+" Price: "+bm.get(i).getPrice();
                        sb.add(s);
                        s="";
                    }
                        theView.setBook(sb);
                    }
                    else
                    {
                        BookModel bm=theModel.readBook(s1);
                        String s=new String();
                        s+="Title: "+bm.getTitle()+" Authot: "+bm.getAuthor()+" Genre: "+bm.getGenre()+" Quantity: "+bm.getQuantity()+" Price: "+bm.getPrice();
                        theView.setValori(s);
                    }
                }
                if(theView.getNameButton1().equals("UpdateBook"))
                {
                    int nr1=0;float nr2=(float) 0.0;
                    if(s3.equals(""))
                        nr1=0;
                    else
                        nr1=Integer.parseInt(s3);
                     if(!s2.equals(""))
                        nr2=Float.parseFloat(s2);
                     else
                        nr2=(float) 0.0;
                     if(theModel.updateBook(s1,nr1,nr2))
                        theView.setMessage("Book updated");
                }
                if(theView.getNameButton1().equals("CreateBook"))
                {
                    int nr1=0;float nr2=(float) 0.0;
                    if(theView.getInfo4().equals(""))
                        nr1=0;
                    else
                        nr1=Integer.parseInt(theView.getInfo4());
                     if(!theView.getInfo5().equals(""))
                        nr2=Float.parseFloat(theView.getInfo5());
                     else
                        nr2=(float) 0.0;
                     if(theModel.createBook(s1, s2, s3, nr1, nr2))
                        theView.setMessage("Book creted");
                }
                if(theView.getNameButton1().equals("DeleteBook"))
                {
                     if(theModel.deleteBook(s1))
                        theView.setMessage("Book delete");
                }
                 if(theView.getNameButton1().equals("Report"))
                 {
                     ArrayList<String> b=theModel2.getData();
                     ReportFactory rf=new ReportFactory();
                     ReportFile rfile=rf.getReportFile(theView.getTypeReport());
                     rfile.write(b, theView.getTypeReport());
                 }
            }
            catch(NullPointerException e)
            {
                theView.displayErrorMessage("Eroare");
            } 
        }
         
     }
}
