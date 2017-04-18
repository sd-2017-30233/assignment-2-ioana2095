/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.Administrator;
import java.util.List;

/**
 *
 * @author Ioana
 */
public class UserModel {
    private String userName;
    private String password;
    private String accesType;
    private Administrator a=new Administrator();

    public UserModel(String userName, String password, String accesType) {
        this.userName = userName;
        this.password = password;
        this.accesType = accesType;
    }
     public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
     }
    public UserModel(){}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccesType() {
        return accesType;
    }

    public void setAccesType(String accesType) {
        this.accesType = accesType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String Login(String username,String password)
    { 
        return a.readUser(username, password);
    }
    public List<UserModel> ReadUsers()
    {
        return a.readUsers();
    }
    public boolean createUser(String username,String password,String type)
    {
        UserModel u=new UserModel(username,password,type);
        return a.createUser(u);
    }
    public boolean updateUser(String username,String password)
    {
        UserModel u=new UserModel(username,password);
        return a.updateUser(u);
    }
    public boolean deleteUser(String username)
    {
        return a.deleteUser(username);
    }
   
}
