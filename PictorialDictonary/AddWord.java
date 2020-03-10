package PictorialDictonary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddWord extends JFrame {

    public String path ;
	public AddWord(PictorialDictionary pictorialDictionary) {

		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 25, 119, 33);
		add(lblNewLabel);
		
		JLabel lblMeaning = new JLabel("Meaning");
		lblMeaning.setForeground(new Color(0, 128, 128));
		lblMeaning.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblMeaning.setBounds(27, 81, 119, 33);
		add(lblMeaning);
		
		JLabel lblChoosePhoto = new JLabel("Choose photo");
		lblChoosePhoto.setForeground(new Color(0, 128, 128));
		lblChoosePhoto.setFont(new Font("Calibri Light", Font.BOLD, 18));
		lblChoosePhoto.setBounds(27, 145, 119, 33);
		add(lblChoosePhoto);
		
		
       JTextArea ta = new JTextArea();		
		ta.getLineWrap();	
		JScrollPane jsp = new JScrollPane(ta);
		jsp.setBounds(175, 81, 221, 50);
		add(jsp);
		
		JTextField tf1 = new JTextField();
		tf1.setBounds(175, 25, 221, 33);
		add(tf1);
		tf1.setColumns(10);
		
		
		JLabel l1 = new JLabel("Max size 64Kb");
		l1.setForeground(new Color(0, 128, 128));
		l1.setFont(new Font("Calibri Light", Font.BOLD,14));
		l1.setBounds(320, 145, 150, 33);
		add(l1);
		
		JButton btnpic = new JButton("Upload");
		btnpic.setBounds(175, 145, 126, 33);
		add(btnpic);
		btnpic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				  JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              path = selectedFile.getAbsolutePath();
		           ///   label.setIcon(ResizeImage(path));
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              JOptionPane.showMessageDialog(null, "No File Selected");
		          }
				
			}
	    }
	    );
		
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(175, 199, 126, 33);
	    add(btnNewButton_1);
	    btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String word = tf1.getText();
				String text = ta.getText();				

				
				
				Connection con=null;
				PreparedStatement st=null;
				
				String s;

				
				
				try
				{

				
					
			    con = DriverManager.getConnection("jdbc:mysql://LocalHost:3306/pictorialdictionary","root","");		        
		        s="INSERT INTO dictionary(word,text,img_data) VALUES(?,?,?)";
			    st=con.prepareStatement(s);
			    st.setString(1, word);
			    st.setString(2, text);
			    
				File file=new File(path);
	            FileInputStream fis=new FileInputStream(file);
			    
	            st.setBinaryStream(3,fis,(int)file.length());
			    
		
			    
			    st.executeUpdate();
			    JOptionPane.showMessageDialog(null,"Inserted Successfully");

			    
			    
			    tf1.setText(null);
			    ta.setText(null);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
		              JOptionPane.showMessageDialog(null, "Check Image Size \nMax : 64Kb");

				}
				
				
			}
	    }
	    );
		
		
	
	}
	
	
	

}
