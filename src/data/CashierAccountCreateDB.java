/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import business.CashierAccountCreate;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class CashierAccountCreateDB {
    private Connection cn;
    
    public CashierAccountCreateDB() {
        try{            
            String url="jdbc:mysql://localhost:3306/hospitaldb";
            String user="root";
            String password="";
            cn=DriverManager.getConnection(url, user, password);
            if(cn!=null){
                System.out.println("Database connected sucessfully");
            }else{
                 System.out.println("Database connection failed");
            }
        }catch(SQLException e){
        }
    }
    
   public boolean add(CashierAccountCreate ca){
        String insert="INSERT INTO cashieraccountcreate(userID,name,password,phoneNumber,email) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, ca.getUserID());
            ps.setString(2, ca.getName());
            ps.setString(3, ca.getPassword());
            ps.setString(4, ca.getPhoneNumber());
            ps.setString(5, ca.getEmail());
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
        
    }
    
    public ArrayList<CashierAccountCreate> getAll(){
        ArrayList<CashierAccountCreate> CashierAccountList=new ArrayList<>();
        String select="SELECT * FROM cashieraccountcreate";
        try{
           PreparedStatement ps=cn.prepareStatement(select); 
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
                int userID=rs.getInt("userID");
               String name=rs.getString("name");
               String password=rs.getString("password");
               String phoneNumber=rs.getString("phoneNumber");
               String email=rs.getString("email");
               CashierAccountCreate ca;
               ca = new CashierAccountCreate(userID,name,password,phoneNumber,email);
               CashierAccountList.add(ca);
           }
           return CashierAccountList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null ;
    }
    }
    
    public boolean delete(int userID){
        String delete="DELETE FROM cashieraccountcreate WHERE userID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(delete);
            ps.setInt(1, userID);
            ps.executeUpdate();
            ps.close();
            return true;
            }catch(SQLException e){
            System.out.println(e.getMessage());
            return false; 
        }
    }
    
    public CashierAccountCreate get(int userID){
        CashierAccountCreate ca=null;
        String select="SELECT * FROM cashieraccountcreate WHERE userID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(select);
            ps.setInt(1, userID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int uID = rs.getInt("userID");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phoneNumber=rs.getString("phoneNumber");
                String email=rs.getString("email");
                ca = new CashierAccountCreate(uID,name,password,phoneNumber,email);
            }
            rs.close();
            ps.close();
            return ca;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
}
    public boolean update(CashierAccountCreate ca){
        String update="UPDATE cashieraccountcreate SET name=?,password=?,phoneNumber=?,email=? WHERE userID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(update);
            ps.setString(1, ca.getName());
            ps.setString(2, ca.getPassword());
            ps.setString(3, ca.getPhoneNumber());
            ps.setString(4, ca.getEmail());
            ps.setInt(5, ca.getUserID());
            ps.executeUpdate();
            ps.close();
            return true; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
    }
}  

    
}
