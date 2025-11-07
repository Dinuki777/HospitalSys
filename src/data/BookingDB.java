/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import business.Booking;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Date;
/**
 *
 * @author DELL
 */
public class BookingDB {
    private ArrayList<Booking> bookingList;
    private Connection cn;
    
    public BookingDB() {
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
    
    public boolean add(Booking p){
        String insert="INSERT INTO booking(bookingID,patientID,consultantID,bookingDate,time,room,paid) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps=cn.prepareStatement(insert);
            ps.setInt(1, p.getBookingID());
            ps.setInt(2, p.getPatientID());
            ps.setInt(3, p.getConsultantID());
            ps.setDate(4, (Date) p.getBookingDate());
            ps.setString(5, p.getTime());
            ps.setInt(6, p.getRoom());
            ps.setString(7, p.getPaid());
            ps.executeUpdate();
            ps.close();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        
        
    }
    
    public ArrayList<Booking> getAll(){
        ArrayList<Booking> bookingList=new ArrayList<>();
        String select="SELECT * FROM booking";
        try{
           PreparedStatement ps=cn.prepareStatement(select); 
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
                int bookingID=rs.getInt("bookingID");
               int patientID=rs.getInt("patientID");
               int consultantID=rs.getInt("consultantID");
               Date bookingDate=rs.getDate("bookingDate");
               String time=rs.getString("time"); 
               int room=rs.getInt("room");
               String paid=rs.getString("paid");
               Booking p=new Booking(bookingID,patientID,consultantID,bookingDate,time,room,paid);
               bookingList.add(p);
           }
           return bookingList;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null ;
    }
    }
    
    public boolean delete(int bookingID){
        String delete="DELETE FROM booking WHERE bookingID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(delete);
            ps.setInt(1, bookingID);
            ps.executeUpdate();
            ps.close();
            return true;
            }catch(SQLException e){
            System.out.println(e.getMessage());
            return false; 
        }
    }
    
    public Booking get(int bookingID){
        Booking p=null;
        String select="SELECT * FROM booking WHERE bookingID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(select);
            ps.setInt(1, bookingID);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
               int patientID=rs.getInt("patientID");
               int consultantID=rs.getInt("consultantID");
               Date bookingDate=rs.getDate("bookingDate");
               String time=rs.getString("time"); 
               int room=rs.getInt("room");
               String paid=rs.getString("paid");
               p=new Booking(bookingID,patientID,consultantID,bookingDate,time,room,paid);
            }
            rs.close();
            ps.close();
            return p;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
}
    public boolean update(Booking p){
        String update="UPDATE booking SET patientID=?,consultantID=?,bookingDate=?,time=?,room=?,paid=? WHERE bookingID=?";
        try{
            PreparedStatement ps=cn.prepareStatement(update);
            ps.setInt(1, p.getPatientID());
            ps.setInt(2, p.getConsultantID());
            ps.setDate(3, (Date) p.getBookingDate());
            ps.setString(4, p.getTime());
            ps.setInt(5, p.getRoom());
            ps.setString(6, p.getPaid());
            ps.setInt(7, p.getBookingID());
            ps.executeUpdate();
            ps.close();
            return true; 
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
    }
}
    
    
}
