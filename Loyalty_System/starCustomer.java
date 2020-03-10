package Loyalty_System;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;




public class starCustomer {
	private JTable table;
	public starCustomer()
	{
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String s;
		try
		{
			
			con=DriverManager.getConnection("jdbc:mysql://LocalHost:3306/project1","root","");
			System.out.println("Connection successful");
			
			st=con.createStatement();
			s="SELECT name,number,email,item,price,status,address FROM customer where price>=25000 ORDER BY price DESC ";
			
			rs=st.executeQuery(s);
			ResultSetMetaData rsmt=rs.getMetaData();
			int c=rsmt.getColumnCount();
			
			Vector column=new Vector(c);
			for(int i=1;i<=c;i++)
			{
				column.add(rsmt.getColumnName(i));
				
			}
			
			Vector data=new Vector();
			Vector row=new Vector();
			while(rs.next())
			{
				row=new Vector(c);
				for(int i=1;i<=c;i++)
				{
					row.add(rs.getString(i));
				}
				
				data.add(row);
			}
			
			JFrame frame=new JFrame();
			frame.setSize(800,500);
			frame.setLocationRelativeTo(null);
		///	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			JPanel panel=new JPanel();
			JTable table= new JTable(data,column);
			table.setRowHeight(40);
			JScrollPane jsp=new JScrollPane(table);
			///panel.setLayout(new BorderLayout());
			panel.setBorder(new EmptyBorder(10,10,10,10));
			panel.setLayout(new BorderLayout(0,0));
			panel.add(jsp,BorderLayout.CENTER);
			frame.setContentPane(panel);
	        frame.setVisible(true);		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Error");
		}
		finally
		{
			try
			{
				st.close();
				rs.close();
				con.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,"Error");
			}
		}
	}
	
	
	public static void main(String args[])
	{
		starCustomer gui=new starCustomer();
	}
}
