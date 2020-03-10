package Loyalty_System;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;








public class adminPanel extends JFrame{
	JLabel l1,l2,l3,l4,l6,l7,l8,l9,la,l11,lstatus;
    JTextField  tname,tnumber,tmail,tprice,t7,tstatus;
    JButton update,okay;
 
  
    public adminPanel(JFrame frame)
    {
       
     
        
        tname=new JTextField();
        tnumber=new JTextField();
        tmail=new JTextField();
       
        tprice=new JTextField();
        tprice.setEditable(false);
        tstatus=new JTextField();
        tstatus.setEditable(false);
     




     
     

      t7=new JTextField("Admin Panel");
      t7.setEditable(false);
      t7.setFont(new Font("Arial Black",Font.BOLD,14));
      t7.setBounds(170,40,130,30);
      add(t7);
      
      l2=new JLabel("Silver amount :");
      l2.setBounds(10,80,200,25);
      add(l2);
      l3=new JLabel("Platinum Amount :");
      l3.setBounds(10,110,200,25);
      add(l3);
      l4=new JLabel("Gold Amount :");
      l4.setBounds(10,140,200,25);
      add(l4);
      
      l6=new JLabel("Total Amount :");
      l6.setBounds(10,200,200,25);
      add(l6);
      lstatus=new JLabel("Total Customer :");
      lstatus.setBounds(10,230,200,25);
      add(lstatus);
      



    
     
      
      
      tname.setBounds(210, 80, 200, 25);
      tnumber.setBounds(210, 110, 200, 25);
      tmail.setBounds(210, 140, 200, 25);
     
      tprice.setBounds(210, 200, 200, 25);
      tstatus.setBounds(210, 230, 200, 25);
     

  
    
      add(tname);
      add(tnumber);
      add(tmail);

      add(tprice);
      add(tstatus);
   
      
      update=new JButton(" Update ");
      update.setBounds(210,390,100,40);         
      add(update);
      
      okay=new JButton("Click Here");
      okay.setBounds(200,5, 100, 25);     
      add(okay);
      
      event2 ex=new event2();
      okay.addActionListener(ex);
    
      
      event e=new event();
      update.addActionListener(e);
      
     
      
    
    }
    
    
    public class event implements ActionListener	
	{
		public void actionPerformed(ActionEvent e)				
		{
			
			int ssilver=Integer.parseInt(tname.getText());
			int pplatinum=Integer.parseInt(tnumber.getText());
			int ggold=Integer.parseInt(tmail.getText());
			
			///float price=Float.parseFloat(tprice.getText());
			///String status=tstatus.getText();
		


			
			
			
			
			Connection con=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			PreparedStatement st2=null;
			PreparedStatement st3=null;

			String s,s1,s2,s3;
			try
			{
			
				con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
				System.out.println("Connection successful");
				
				s="UPDATE customer SET silver=? , platinum=? ,gold=?";
				st=con.prepareStatement(s);
			
				st.setInt(1, ssilver);				
				st.setInt(2, pplatinum);
				st.setInt(3, ggold);
				

			  
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Updated Successfully");
			    
			    
			    s1="ALTER TABLE customer ALTER silver SET DEFAULT "+ssilver+";";
				st1=con.prepareStatement(s1);
			    st1.executeUpdate();
			    
			    
			    s2="ALTER TABLE customer ALTER platinum SET DEFAULT "+pplatinum+";";
				st2=con.prepareStatement(s2);
			    st2.executeUpdate();
			    

			    s3="ALTER TABLE customer ALTER gold SET DEFAULT "+ggold+";";
				st3=con.prepareStatement(s3);
			    st3.executeUpdate();


				
			}
			
			catch(Exception ex)
			{
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null,"Error");
			}
			finally
			{
				try
				{
					st.close();
					con.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
			
		     	   
		        tname.setText(null);
		        tnumber.setText(null);
		        tmail.setText(null);  
		        tprice.setText(null);
		        tstatus.setText(null);
		    
		        
		}
			
		}
    
    public class event2 implements ActionListener	
   	{
   		public void actionPerformed(ActionEvent ex)				
   		{
   			
   			
   		
   		
   			
   			Connection con=null;
   			PreparedStatement st=null;
   			PreparedStatement st1=null;
   			PreparedStatement st2=null;
   			ResultSet rs=null;
   			ResultSet rs1=null;
   			ResultSet rs2=null;
   			String s,s1,s2;
   			try
   			{
   				
   				con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
   				System.out.println("Connection successful");
   				
   				s="SELECT * FROM customer WHERE number=1845041010";
   				st=con.prepareStatement(s);			

   				rs=st.executeQuery();
   				while(rs.next())
   				{
   					///System.out.println(rs.getInt("id")+"  "+rs.getString("first_name")+" "+rs.getString("last_name")+" "+rs.getString("email")+" "+rs.getString("salary")+" "+rs.getString("city"));

   					
   					
   				
   						tname.setText(rs.getString("silver"));						
   						tnumber.setText(rs.getString("platinum"));
   						tmail.setText(rs.getString("gold"));
   						
   					///	tprice.setText(rs.getString("price"));
   						///tstatus.setText(rs.getString("status"));
   					
   						}
   				
   				s1="SELECT * FROM customer";
   				st=con.prepareStatement(s1);			
               float sumPrice=0;
   				rs1=st.executeQuery();
   				while(rs1.next())
   				{ 
   					     sumPrice=sumPrice+rs1.getFloat("price");  
   					    
   				}
   				System.out.println(sumPrice);
   				String numberAsString = Float.toString(sumPrice);
   			  	tprice.setText(numberAsString);
   					
   				
   				
   			 s2="SELECT COUNT(CustomerId) FROM customer";
				st=con.prepareStatement(s1);			
                int customerNumber=0;
				rs2=st.executeQuery();
				while(rs2.next())
				{ 		   				
					
					System.out.println(rs2.getInt("CustomerId"));  
					customerNumber=customerNumber+1;
						
						
					
						}
				System.out.println(customerNumber);
				String ii= Integer.toString(customerNumber);
				tstatus.setText(ii);
					

   				
   			}
   			
   			catch(Exception exc)
   			{
   				exc.printStackTrace();
   				JOptionPane.showMessageDialog(null,"Error");
   			}
   			finally
   			{
   				try
   				{
   					st.close();
   					con.close();
   				}
   				catch(Exception exc)
   				{
   					exc.printStackTrace();
   					JOptionPane.showMessageDialog(null,"Error");
   				}
   			}
   			
   		}
   	}
   
  
}