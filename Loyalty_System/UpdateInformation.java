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







public class UpdateInformation extends JFrame{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,la,l11,lstatus;
    JTextField  num,tname,tnumber,tmail,titem,tprice,t7,tstatus;
    JButton ok,okay,update;
 
    JTextArea ta;
    public UpdateInformation(JFrame frame)
    {
        num=new JTextField();
     
        
        tname=new JTextField();
        tnumber=new JTextField();
        tmail=new JTextField();
        titem=new JTextField();
        tprice=new JTextField();
        tprice.setEditable(false);
        tstatus=new JTextField();
        tstatus.setEditable(false);
        ta=new JTextArea();




      l1=new JLabel("Enter Contact Number :");
      l1.setBounds(25,5,180,25);
      add(l1);
     

      t7=new JTextField("Update Info");
      t7.setEditable(false);
      t7.setFont(new Font("Arial Black",Font.BOLD,14));
      t7.setBounds(170,40,130,30);
      add(t7);
      
      l2=new JLabel("Customer  Name :");
      l2.setBounds(10,80,200,25);
      add(l2);
      l3=new JLabel("Contact Number :");
      l3.setBounds(10,110,200,25);
      add(l3);
      l4=new JLabel("Customer  E-Mail :");
      l4.setBounds(10,140,200,25);
      add(l4);
      l5=new JLabel("Item Name  :");
      l5.setBounds(10,170,200,25);
      add(l5);
      l6=new JLabel("Total Amount :");
      l6.setBounds(10,200,200,25);
      add(l6);
      lstatus=new JLabel("Customer Status  :");
      lstatus.setBounds(10,230,200,25);
      add(lstatus);
      l6=new JLabel("Customer  Address :");
      l6.setBounds(10,260,200,25);
      add(l6);



     num.setBounds(210,5, 150, 25);
     
      okay=new JButton("Ok");
      okay.setBounds(370,5, 70, 25);     
      add(okay);
      
      
      tname.setBounds(210, 80, 200, 25);
      tnumber.setBounds(210, 110, 200, 25);
      tmail.setBounds(210, 140, 200, 25);
      titem.setBounds(210, 170, 200, 25);
      tprice.setBounds(210, 200, 200, 25);
      tstatus.setBounds(210, 230, 200, 25);
      ta.setBounds(210, 260, 200, 100);


      add(num);
    
      add(tname);
      add(tnumber);
      add(tmail);
      add(titem);
      add(tprice);
      add(tstatus);
      add(ta);
      
      update=new JButton(" Update ");
      update.setBounds(210,390,100,40);         
      add(update);
      
   
      
      
     event e=new event();
     update.addActionListener(e);
     
     
      
      event2 ex=new event2();
      okay.addActionListener(ex);

    }
    
    
    public class event2 implements ActionListener	
	{
		public void actionPerformed(ActionEvent ex)				
		{
			
			
			long number=Long.parseLong(num.getText());
		
			
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			String s;
			try
			{
				
				con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
				System.out.println("Connection successful");
				
				s="SELECT * FROM customer WHERE number=?";
				st=con.prepareStatement(s);			

				st.setLong(1, number);
				rs=st.executeQuery();
				while(rs.next())
				{
					///System.out.println(rs.getInt("id")+"  "+rs.getString("first_name")+" "+rs.getString("last_name")+" "+rs.getString("email")+" "+rs.getString("salary")+" "+rs.getString("city"));

					long s1=rs.getLong("number");
					
					if(number==s1)
						{
						tname.setText(rs.getString("name"));						
						tnumber.setText(rs.getString("number"));
						tmail.setText(rs.getString("email"));
						titem.setText(rs.getString("item"));
						tprice.setText(rs.getString("price"));
						tstatus.setText(rs.getString("status"));
						ta.setText(rs.getString("address"));
						}
					else
					{
						JOptionPane.showMessageDialog(null,"\n\nWrong Contact Number\n\n");
					}
					
				
				}
			  

				
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
    
public class event implements ActionListener	
	{
		public void actionPerformed(ActionEvent e)				
		{
			
			String name=tname.getText();
			long number=Long.parseLong(tnumber.getText());
			String email=tmail.getText();
			String item=titem.getText();
			float price=Float.parseFloat(tprice.getText());
			String status=tstatus.getText();
			String address=ta.getText();


			
			
			
			
			Connection con=null;
			PreparedStatement st=null;
			String s;
			try
			{
			
				con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
				System.out.println("Connection successful");
				
				s="UPDATE customer SET name=? , number=? ,email=? ,item=? ,price=? , status=? , address=? WHERE  number=?";
				st=con.prepareStatement(s);
			
				st.setString(1, name);				
				st.setLong(2, number);
				st.setString(3, email);
				st.setString(4, item);
				st.setFloat(5, price);
				st.setString(6, status);
				st.setString(7, address);
				st.setLong(8, number);

			  
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Updated Successfully");
				
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
			
		     	num.setText(null);        
		        tname.setText(null);
		        tnumber.setText(null);
		        tmail.setText(null);
		        titem.setText(null);
		        tprice.setText(null);
		        tstatus.setText(null);
		        ta.setText(null);
		        
		}
			
		}
}