/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import business.CashierLogin;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class CashierLoginDB {
    private Connection cn;
    
    public CashierLoginDB() {
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
    
     public boolean add(CashierLogin log){
        String insert="INSERT INTO `cashierlogin`(`name`, `userID`, `password`) VALUES(?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setString(1, log.getName());
            ps.setString(2, log.getUserID());
            ps.setString(3, log.getPassword());
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
        
    }
    
    public ArrayList<CashierLogin> getAll(){
        ArrayList<CashierLogin> logList=new ArrayList<>();
        String select="SELECT * FROM `cashierlogin` WHERE 1";
        try{
           PreparedStatement ps=cn.prepareStatement(select); 
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
               String name=rs.getString("name");
               String userID=rs.getString("userID");
               String password=rs.getString("password");
               CashierLogin log=new CashierLogin(name,userID, password);
               logList.add(log);
           }
           return logList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null ;
    }
    }
    
    public boolean delete(String userID){
        String delete="DELETE FROM `cashierlogin` WHERE userID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(delete);
            ps.setString(1, userID);
            ps.executeUpdate();
            ps.close();
            return true;
            }catch(SQLException e){
            System.out.println(e.getMessage());
            return false; 
        }
    }
    
    public CashierLogin get(String userID) {
        CashierLogin log = null;
        String select = "SELECT * FROM `cashierlogin` WHERE userID=?";
        try (PreparedStatement ps = cn.prepareStatement(select)) {
            ps.setString(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String uID = rs.getString("userID");
                    String password = rs.getString("password");
                    log = new CashierLogin(name, uID, password);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving cashier: " + e.getMessage());
        }
        return log;
    }
    public boolean update(CashierLogin log){
        String update="update CashierLogin set password=? where userID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(update);
            ps.setString(1,log.getUserID());
            ps.setString(2,log.getPassword());
          
            ps.executeUpdate();
            ps.close();
            return true; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
    }
}
    
}
