/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.*;
import java.util.List;

/**
 *
 * @author Ioana
 */
public class BookModel {

    private String title;
    private String author;
    private String genre;
    private int quantity;
    private float price;
    private Users user=new Users();
    private Administrator admin=new Administrator();
    
    public BookModel(String title, String author, String genre, int quantity, float price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }
     public BookModel(){}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public List<String> getGenre(String s)
    {
        return user.ReadGenre(s);
    }
    public List<String> getAuthor(String s)
    {
        return user.ReadAuthor(s);
    }
    public List<String> getTitle(String s)
    {
        return user.ReadTitle(s);
    }
    public boolean sellBook(String title,int quantity,String username)
    {
        return user.sellBooks(title, quantity, username);
    }
    public boolean createBook(String title,String autor,String gen,int cantitate,float price)
    {
        BookModel bm=new BookModel(title,autor,gen,cantitate,price);
        return admin.createBook(bm);
    }
    public List<BookModel> readBooks()
    {
       return admin.readBooks();
    }
    public BookModel readBook(String s)
    {
       return admin.readBook(s);
       
    }
    public boolean updateBook(String title,int cantitate,float price)
    {
       BookModel bm=admin.readBook(title);
       if(cantitate==0)
           bm.setPrice(price);
       if(price==0)
           bm.setQuantity(cantitate);
       if(cantitate!=0 && price!=0)
       {
           bm.setPrice(price);
           bm.setQuantity(cantitate);
       }
       return admin.updateBook(bm);
    }
    public boolean deleteBook(String title)
    {
        return admin.deleteBook(title);
    }
    
}
