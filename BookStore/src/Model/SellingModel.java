/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.Administrator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ioana
 */
public class SellingModel {
    private String date;
    private String username;
    private BookModel b;
    private Administrator a=new Administrator();

    public SellingModel(String date, String username, BookModel b) {
        this.date = date;
        this.username = username;
        this.b = b;
    }
    public SellingModel(){};
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BookModel getB() {
        return b;
    }

    public void setB(BookModel b) {
        this.b = b;
    }
    
    public ArrayList<String> getData()
    {
        List<SellingModel> lsm=a.getDate();
        StringBuilder builder=new StringBuilder();
        ArrayList<String> b=new ArrayList<String>();
       for(int i=0;i<lsm.size();i++){
            builder.append("Username: ");
            builder.append(lsm.get(i).getUsername());
            builder.append(" Title: ");
            builder.append(lsm.get(i).getB().getTitle());
            builder.append(" Author: ");
            builder.append(lsm.get(i).getB().getAuthor());
            builder.append(" Genre: ");
            builder.append(lsm.get(i).getB().getGenre());
            builder.append(" Quantity: ");
            builder.append(lsm.get(i).getB().getQuantity());
            builder.append(" Price: ");
            builder.append(lsm.get(i).getB().getPrice());
            builder.append(" Data: ");
            builder.append(lsm.get(i).getDate());
            builder.append(" \n ");
            String s =builder.toString();
            b.add(s);  
            builder=new StringBuilder();
      }
        return b;
    }
}
