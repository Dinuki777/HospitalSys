/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import business.Consultant;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Date;
/**
 *
 * @author icbt1
 */
public class ConsultantDB {

    private ArrayList<Consultant> ConsultantList;
    private Connection cn;
    private int getcID;

    public ConsultantDB() {
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
        }catch(Exception e){
            e.printStackTrace();
        }        
        
    }
    public boolean add(Consultant c) {
    String insert="INSERT INTO consultants(cID,firstName,lastName,category, hospital,telephone) VALUES (?,?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
             ps.setInt(1, c.getcID());  
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.setString(4, c.getCategory());  
            ps.setString(5, c.getHospital());  
            ps.setString(6, c.getTelephone());
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
}

    
    public ArrayList<Consultant> getAll() {
    ArrayList<Consultant> conList = new ArrayList<>();
    String select = "SELECT * FROM consultants";  
    try {
        PreparedStatement ps = cn.prepareStatement(select);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int cID = rs.getInt("cID");  
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String category = rs.getString("category");  
            String hospital = rs.getString("hospital");  
            String telephone = rs.getString("telephone");  

            Consultant c = new Consultant(cID, firstName, lastName, category, hospital, telephone);
            conList.add(c);  
        }
        rs.close();
        ps.close();
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return conList;
}

    public boolean delete(int cID) {
    String delete = "DELETE FROM consultants WHERE cID = ?";
    try {
        PreparedStatement ps = cn.prepareStatement(delete);
        ps.setInt(1, cID);  // Fixed incorrect variable name

        int rowsAffected = ps.executeUpdate();
        ps.close();

        return rowsAffected > 0;  // Returns true if at least one row was deleted
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
}

  public Consultant get(int ConsultantID){
      Consultant c=null;
        String select="SELECT * FROM consultants WHERE cID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(select);
            ps.setInt(1, ConsultantID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
            int cID = rs.getInt("cID");  
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String category = rs.getString("category");  
            String hospital = rs.getString("hospital");  
            String telephone = rs.getString("telephone");  
            c=new Consultant(cID, firstName, lastName, category, hospital, telephone);
            }
            rs.close();
            ps.close();
            return c;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
      
  }
  public boolean update(Consultant c){
       String update="UPDATE consultants SET firstName=?,lastName=?,category=?,hospital=?,telephone=? WHERE cID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(update);  
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getCategory());  
            ps.setString(4, c.getHospital());  
            ps.setString(5, c.getTelephone());
             ps.setInt(6, c.getcID());
            ps.executeUpdate();
            ps.close();
            return true; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
    }
  }
}
