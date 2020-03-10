package PictorialDictonary;

import java.awt.BorderLayout;
import java.awt.Image;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



//import image.TheModel;

class Users
{
	private int Id;
	private String Fname;
	private String Lname;
	private int Age;
	private byte[] Image;
	
	public Users(int id , String fname ,String lname ,int age, byte[] image)
	{
		this.Id = id;
		this.Fname = fname;
		this.Lname = lname;
		this.Age = age;
		this.Image = image;
	}
	
	public int getId()
	{
		return this.Id;
	}
	
	public String getFname()
	{
		return this.Fname;
	}
	
	public String getLname()
	{
		return this.Lname;
	}

	public int getAge()
	{
		return this.Age;
	}
	
	public byte[] getMyImage()
	{
	        return Image;
    }
	
}




public class Work extends JFrame
{

	
	public Work()
	{
		super("Jtable example using array list");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(700,400);
		
	}
	
	
	static Connection getConnection()
	{
		Connection con = null;
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/test_db","root","");
			
		}
		catch(Exception ex)
		{
			
		}
		return con;
	}
	
	
	static ArrayList<Users> getUsers()
	{
		ArrayList<Users> users = new ArrayList<Users>();
		Users u;
		
		Connection con = getConnection();
		Statement st=null;
		ResultSet rs=null ;
		
		
		try
		{
        st = (Statement) con.createStatement();
        rs = st.executeQuery("SELECT * FROM users");
        
        
        while(rs.next())
        {
        	u = new Users(
        			
        			rs.getInt("id"),
        			rs.getString("fname"),
        			rs.getString("lname"),
        			rs.getInt("age"),
        			rs.getBytes("img_data")
        			
        			);
        			
        			
        	 users.add(u);
        			
        }
        
        
       
        
		}
		catch(Exception ex)
		{
			
		}
		
		return users;
	
	}
	
	
	
	public static void main(String[] args) {
	
		
		JTable table = new JTable();
	///	DefaultTableModel model = new DefaultTableModel();
		
		
		
		
		////column
	    String[] columnName = {"id","fname","lname","age","img_data"};
	
		
		//row
		Object[][] row = new Object[getUsers().size()][5];
		for(int i =0 ; i<getUsers().size(); i++)
		{
			row[i][0] = getUsers().get(i).getId();
			row[i][1] = getUsers().get(i).getFname();
			row[i][2] = getUsers().get(i).getLname();
			row[i][3] = getUsers().get(i).getAge();
			
			
	        if(getUsers().get(i).getMyImage() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(getUsers().get(i).getMyImage()).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
                
            row[i][4] = image;
            }
            else{
                row[i][4] = null;
            }

			
		}
		
		  TheModel model = new TheModel(row, columnName);
	        table.setModel(model);
	        table.setRowHeight(120);
	        table.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		
		
		
		
		
		Work window = new Work();
		JPanel panel =new JPanel();
		JScrollPane pane = new JScrollPane(table);
		panel.setLayout(new BorderLayout());
		panel.add(pane,BorderLayout.CENTER);
		window.setContentPane(pane);
		

	}

}
