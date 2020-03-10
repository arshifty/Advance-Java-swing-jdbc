package PictorialDictonary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//import image.TheModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;



class dictionary
{
	//private int id;
	private String word;
	private String text;
	private byte[] image;
	
	
	public dictionary( String word , String text , byte[] image)
	{
		// this.id = id;
		this.word = word;
		this.text = text ;
		this.image = image ; 
	}
	
//	public int getId()
	//{
		//return this.id;
	//}
	
	public String getWord()
	{
		return this.word;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public byte[] getMyImage()
	{
	        return image;
    }
}






public class PictorialDictionary {

	private JFrame frame;
	private static JTextField tf;
	private JTable table;
	JPanel panel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PictorialDictionary window = new PictorialDictionary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PictorialDictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame("Pictorial Dictionary");
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setBounds(100, 100, 1264, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		tf = new JTextField();
		tf.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		tf.setBounds(137, 11, 382, 40);
		frame.getContentPane().add(tf);
		tf.setColumns(10);		
                    
          tf.addKeyListener(new KeyListener()
		{
			
	
	 
		public void keyPressed(java.awt.event.KeyEvent e)
		{
		   

	
		}
		
		public void keyReleased(java.awt.event.KeyEvent e) 
		{
			String str1= tf.getText();
			

			if(str1 != null && str1.trim().length() > 0)
			{	
				
				ArrayList<dictionary> usersOne = new ArrayList<dictionary>();
				dictionary u1;
				
				Connection con = null;
				PreparedStatement st=null;
				ResultSet rs=null ;
				
				
			
			
				
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/pictorialdictionary","root","");
					String str = tf.getText(); 
					str = "%" + str ;
					
					
				
					String s="SELECT * FROM dictionary where word like ? ORDER BY word ASC";
					st=con.prepareStatement(s);
					st.setString(1, str);
					rs=st.executeQuery();
					
		      
		       
		        
		        
		        while(rs.next())
		        {
		        	u1 = new dictionary(
		        			
		        		//	rs.getInt("id"),
		        			rs.getString("word"),
		        			rs.getString("text"),        		
		        			rs.getBytes("img_data")
		        			
		        			);        			
		        	usersOne.add(u1);
		        			
		        }
		        
		        
		       
		        
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
				
			////column
			    String[] columnName = {"word","text","img_data"};
			
				
				//row
				Object[][] row = new Object[usersOne.size()][3];
				for(int i =0 ; i<usersOne.size(); i++)
				{
			//		row[i][0] = usersOne.get(i).getId();
					row[i][0] = usersOne.get(i).getWord();
					row[i][1] = usersOne.get(i).getText();
				
					
					
			        if(usersOne.get(i).getMyImage() != null){
		                
		             ImageIcon image = new ImageIcon(new ImageIcon(usersOne.get(i).getMyImage()).getImage()
		             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
		                
		            row[i][2] = image;
		            }
		            else{
		                row[i][2] = null;
		            }

					
				}
				table = new JTable();
				
				  TheModel model = new TheModel(row, columnName);
			        table.setModel(model);
			        table.setRowHeight(120);
			        table.getColumnModel().getColumn(2).setPreferredWidth(150);
		
				JScrollPane jsp=new JScrollPane(table);
				jsp.setBounds(2, 10, 1245, 530);
			
			  	panel_1.add(jsp);
		
			}
                   else
			    {		
                	   
       				
       				ArrayList<dictionary> users = new ArrayList<dictionary>();
       				dictionary u;
       				
       				Connection con = null;
       				Statement st=null;
       				ResultSet rs=null ;
       				
       				
       				try
       				{
       					con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/pictorialdictionary","root","");
       		        st = (Statement) con.createStatement();
       		        rs = st.executeQuery("SELECT * FROM dictionary ORDER BY word ASC");
       		        
       		        
       		        while(rs.next())
       		        {
       		        	u = new dictionary(
       		        			
       		       // 			rs.getInt("id"),
       		        			rs.getString("word"),
       		        			rs.getString("text"),
       		        		
       		        			rs.getBytes("img_data")
       		        			
       		        			);
       		        			
       		        			
       		        	 users.add(u);
       		        			
       		        }
       		        
       		        
       		       
       		        
       				}
       				catch(Exception ex)
       				{
       					ex.printStackTrace();
       				}
       				

					////column
				    String[] columnName = {"word","text","img_data"};
				
					
					//row
					Object[][] row = new Object[users.size()][3];
					for(int i =0 ; i<users.size(); i++)
					{
					//	row[i][0] = users.get(i).getId();
						row[i][0] = users.get(i).getWord();
						row[i][1] = users.get(i).getText();
					
						
						
				        if(users.get(i).getMyImage() != null){
			                
			             ImageIcon image = new ImageIcon(new ImageIcon(users.get(i).getMyImage()).getImage()
			             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
			                
			            row[i][2] = image;
			            }
			            else{
			                row[i][2] = null;
			            }

						
					}
					table = new JTable();
					
					  TheModel model = new TheModel(row, columnName);
				        table.setModel(model);
				        table.setRowHeight(120);
				        table.getColumnModel().getColumn(2).setPreferredWidth(150);
			
					JScrollPane jsp=new JScrollPane(table);
					jsp.setBounds(2, 10, 1245, 530);
				
				  	panel_1.add(jsp);
				  	
				  	
					
				}
				
				
					


		}

		public void keyTyped(java.awt.event.KeyEvent e) 
		{
			
		}
		
		}
		
		);
		
		
		

		
		JLabel lblNewLabel = new JLabel("Find Word");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 117, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btns = new JButton("Start");
		btns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				ArrayList<dictionary> users = new ArrayList<dictionary>();
				dictionary u;
				
				Connection con = null;
				Statement st=null;
				ResultSet rs=null ;
				
				
				try
				{
					con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/pictorialdictionary","root","");
		        st = (Statement) con.createStatement();
		        rs = st.executeQuery("SELECT * FROM dictionary ORDER BY word ASC");
		        
		        
		        while(rs.next())
		        {
		        	u = new dictionary(
		        			
		        		///	rs.getInt("id"),
		        			rs.getString("word"),
		        			rs.getString("text"),
		        		
		        			rs.getBytes("img_data")
		        			
		        			);
		        			
		        			
		        	 users.add(u);
		        			
		        }
		        
		        
		       
		        
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
				
				

				////column
			    String[] columnName = {"word","text","img_data"};
			
				
				//row
				Object[][] row = new Object[users.size()][3];
				for(int i =0 ; i<users.size(); i++)
				{
					//row[i][0] = users.get(i).getId();
					row[i][0] = users.get(i).getWord();
					row[i][1] = users.get(i).getText();
				
					
					
			        if(users.get(i).getMyImage() != null){
		                
		             ImageIcon image = new ImageIcon(new ImageIcon(users.get(i).getMyImage()).getImage()
		             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
		                
		            row[i][2] = image;
		            }
		            else{
		                row[i][2] = null;
		            }

					
				}
				table = new JTable();
				
				  TheModel model = new TheModel(row, columnName);
			        table.setModel(model);
			        
			        
			        
			        table.setForeground(Color.black);
			      ///  table.setBackground(SystemColor.desktop);		        
					table.setFont(new Font("Calibri Light", Font.PLAIN, 16));
				
					
					
			        table.setRowHeight(120);
			        table.getColumnModel().getColumn(2).setPreferredWidth(150);
  
				JScrollPane jsp=new JScrollPane(table);
				jsp.setBounds(2, 10, 1245, 530);
			  	panel_1.add(jsp);
			}
					
					
					
	    	
		
		});
		btns.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btns.setBounds(535, 11, 89, 40);
		frame.getContentPane().add(btns);
		
		JButton btnNewButton = new JButton("Add word");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				    AddWord obj1 = new AddWord(PictorialDictionary.this);
				    obj1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		            obj1.getContentPane().setLayout(null);
		            obj1.setSize(450, 400);
		            obj1.setTitle("Add Word");
		            obj1.setVisible(true);
		            obj1.setLocationRelativeTo(null);	
				
			}
		});
		btnNewButton.setBounds(719, 11, 93, 40);
		frame.getContentPane().add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 72, 1248, 540);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(634, 11, 78, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBounds(0, 0, 1248, 75);
		frame.getContentPane().add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(106, 90, 205));
		panel_2.setBounds(0, 610, 1248, 51);
		frame.getContentPane().add(panel_2);
		
		
		
	}



}
