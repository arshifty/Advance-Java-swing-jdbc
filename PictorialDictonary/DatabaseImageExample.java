package PictorialDictonary;
import java.sql.*;
import java.io.*;
 
public class DatabaseImageExample {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            /// con=DriverManager.getConnection("jdbc:mysql://localhost/demo","root","root");
            Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            
            
            File file=new File("G:\\1 project\\src\\PictorialDictonary\\d.jpg");
            FileInputStream fis=new FileInputStream(file);
            
            PreparedStatement ps=con.prepareStatement("insert into image_table (name,image) values(?,?)"); 
            ps.setString(1,"image 1");
            ps.setBinaryStream(2,fis,(int)file.length());
            ps.executeUpdate();
 
            ps.close();
            fis.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}