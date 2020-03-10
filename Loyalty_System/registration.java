package Loyalty_System;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class registration extends JFrame{
	 JLabel l2,l3,l4,l5,l6,l7,l8,l9,la;
	 JTextField t2,t3,t4,t5,t7;
	 JButton ok;
	 JPasswordField t6;
	 JPanel contentPane;
	 JTextArea ta;
	 JScrollPane scroll;
	public registration(JFrame frame)
	{
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(5,20,20,20));
		contentPane.setLayout(new BorderLayout(0,0));
		//contentPane.setBackground(Color.gray);
		setContentPane(contentPane);
      
        t2=new JTextField();
        ta=new JTextArea();
        t4=new JTextField();
        t5=new JTextField();
       
        
       




      l8=new JLabel("Complete The Registration Form");	 
      l8.setFont(new Font("Arial Black",Font.BOLD,16));
     
      l8.setBounds(10,10,450,25);
	  add(l8);
      l2=new JLabel("Customer  Name :");
      l2.setBounds(10,60,200,25);
      add(l2);
      l3=new JLabel("Customer  Address :");
      l3.setBounds(10,90,200,25);
      add(l3);
      l4=new JLabel("Customer  E-Mail :");
      l4.setBounds(10,200,200,25);
      add(l4);
      l5=new JLabel("Contact Number :");
      l5.setBounds(10,230,200,25);
      add(l5);
      



    
      t2.setBounds(210, 60, 200, 25);
      ta.setBounds(210, 90, 200, 100);
      t4.setBounds(210, 200, 200, 25);
      t5.setBounds(210, 230, 200, 25);
     
    

     
      add(t2);
      add(ta);
      add(t4);
      add(t5);
      
      
      ok=new JButton("Submit");
      ok.setBounds(130,280,150,40);      
      add(ok);
      
      event e=new event();
      ok.addActionListener(e);
	}
	
	public class event implements ActionListener	
	{
		public void actionPerformed(ActionEvent e)				
		{
			String namee=t2.getText();
			String addresss=ta.getText();
			String emaill=t4.getText();
			long numberr=Long.parseLong(t5.getText());
			
			
			
			
			Connection con=null;
			PreparedStatement st=null;
			String s;
			
			try
			{
				con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
                System.out.println("Connection successful");
				
			    s="INSERT INTO customer(name,address,email,number) VALUES(?,?,?,?)";
			    st=con.prepareStatement(s);
			    st.setString(1, namee);
			    st.setString(2, addresss);
			    st.setString(3, emaill);			   
			    st.setLong(4, numberr);
		
			    
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Account Created");
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
					con.close();
					st.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"Error");
				}
				
			}
			
			t2.setText(null);
			ta.setText(null);
			t4.setText(null);
			t5.setText(null);
			
			
		}
	}
}