/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class CashierAccountCreate {
    private int userID;
    private String name;
    private String password;
    private String phoneNumber;
    private String email;

    public CashierAccountCreate() {
    }

    public CashierAccountCreate(int userID, String name, String password, String phoneNumber, String email) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
