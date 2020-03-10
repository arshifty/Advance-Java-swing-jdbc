package Loyalty_System;

import java.awt.*;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.*;

import javax.management.timer.*;
import javax.swing.*;
import javax.swing.Timer;



public class mainFrame extends JFrame{
	
	JLabel pic;
	Timer tm;
	int x=0;
	String[] list=
		{
				"src\\Loyalty_System\\a.jpg",
				"src\\Loyalty_System\\b.jpg",
				"src\\Loyalty_System\\c.jpg",
				"src\\Loyalty_System\\d.jpg",
				"src\\Loyalty_System\\e.jpg",
				"src\\Loyalty_System\\f.jpg",
				"src\\Loyalty_System\\g.jpg",
				"src\\Loyalty_System\\h.jpg",
				"src\\Loyalty_System\\i.jpg",
				"src\\Loyalty_System\\j.jpg",
				"src\\Loyalty_System\\k.jpg",
				"src\\Loyalty_System\\l.jpg"
		};
	JMenuBar menubar;
	JMenuItem exit;
	JMenu file;
	JLabel l1,l2,l3;
	
	String[]  filename1={"Registration" ,"Update Account", "Customer Information"};
	JComboBox box1=new JComboBox(filename1);
	
	String[]  filename2={"Pay Money" ,"Star Customer"};
	JComboBox box2=new JComboBox(filename2);
	
	CustomerInformation obj3;
	starCustomer obj5;
	
	
	public mainFrame()
	{
		super("Restaurant Management System");
		pic=new JLabel();
		pic.setBounds(5,150,1000,500);
		SetImageSize(11);
		
		
		
		
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		file=new JMenu(" File ");
		menubar.add(file);		
		exit=new JMenuItem(" Exit ");
		file.add(exit);
		
		
		
		///combobox start
		
		
	
		box1.setSelectedIndex(1);
		box1.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						

						if(e.getSource()==box1)
						{
							JComboBox cb=(JComboBox)e.getSource();
							String mgs=(String)cb.getSelectedItem();
							switch(mgs)
							{
							case "Registration":
								registration obj1 = new registration(mainFrame.this);
					            obj1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					            obj1.setLayout(null);
					            obj1.setSize(450, 400);
					            obj1.setTitle("Create Account");
					            obj1.setVisible(true);
					            obj1.setLocationRelativeTo(null);	
								///JOptionPane.showMessageDialog(null, "Select Something");

								break;
								
							case "Update Account":
								///JOptionPane.showMessageDialog(null, "Select Something");

								UpdateInformation obj2 = new UpdateInformation(mainFrame.this);
					            obj2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					            obj2.setLayout(null);
					            obj2.setSize(460, 490);
					            obj2.setTitle("Update Information");
					            obj2.setVisible(true);
					            obj2.setLocationRelativeTo(null);
								
								break;
							case "Customer Information":
					        	obj3=new CustomerInformation();
							///	JOptionPane.showMessageDialog(null, "Select Something");

								break;
								default:
									JOptionPane.showMessageDialog(null, "Select Something");
							
							
							
							}
							
						}
						
					}
					
					
				}				);
		
		JTextField t1=new JTextField("Hungry Time Restaurant");
		t1.setBounds(300,5,450,50);
	    t1.setEditable(false);
		t1.setFont(new Font("Arial Black",Font.BOLD,30));
	    t1.setForeground(Color.decode("#b123cc"));
	    t1.setBackground(Color.decode("#12b3cc"));
		t1.setAlignmentX(CENTER_ALIGNMENT);
		add(t1);
		

		
		
		l1=new JLabel("Account Setting");
		l1.setForeground(Color.white);
		l1.setFont(new Font("Arial Black",Font.BOLD,20));
		l1.setBounds(100,60,200,40);
		add(l1);
		
		box1.setBounds(100,100,200,40);
		add(box1);
		   
		box2.setSelectedIndex(1);
		box2.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent ex)
					{
						

						if(ex.getSource()==box2)
						{
							JComboBox cb=(JComboBox)ex.getSource();
							String mgs=(String)cb.getSelectedItem();
							switch(mgs)
							{
							case "Pay Money":
								PayMoney obj4 = new PayMoney(mainFrame.this);
					            obj4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					            obj4.setLayout(null);
					            obj4.setSize(480, 510);
					            obj4.setTitle("Pay Money");
					            obj4.setVisible(true);
					            obj4.setLocationRelativeTo(null);
								break;
								
							case "Star Customer":
								///JOptionPane.showMessageDialog(null, "Select Something");

							 obj5=new starCustomer();
								
								break;
						
								default:
									JOptionPane.showMessageDialog(null, "Select Something");
							
							
							
							}
							
						}
						
					}
					
					
				}				);
		
		

		
		
		l2=new JLabel("Payment System");
		l2.setForeground(Color.white);
		l2.setFont(new Font("Arial Black",Font.BOLD,20));
		l2.setBounds(430,60,200,40);
		add(l2);
		
		box2.setBounds(430,100,200,40);
		add(box2);
		
		///combobox end
		l3=new JLabel("Admin Panel");
		l3.setForeground(Color.white);
		l3.setFont(new Font("Arial Black",Font.BOLD,20));
		l3.setBounds(750,60,200,40);
		add(l3);
		
		JButton btn=new JButton("Admin");		
		btn.setBounds(750,100,200,40);
		add(btn);
		btn.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent exx)
					{						
						adminPanel obj7 = new adminPanel(mainFrame.this);
			            obj7.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			            obj7.setLayout(null);
			            obj7.setSize(480, 510);
			            obj7.setTitle("Admin Panel");
			            obj7.setVisible(true);
			            obj7.setLocationRelativeTo(null);
						
					}
					
					
				}				);
		
		
		
		
		tm=new Timer(3000 , new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				
				SetImageSize(x);
				x +=1;
				if(x>=list.length)
					x=0;
				
			}
				});
		
		add(pic);
		tm.start();
		setLayout(null);
		setSize(1025,715);
		getContentPane().setBackground(Color.decode("#bdb67b"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
		
		  event1 e1 = new event1();
	      exit.addActionListener(e1);
	}
	
	

	
	
	
	public class event1 implements ActionListener {

        public void actionPerformed(ActionEvent e1) {
            System.exit(0);
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void SetImageSize(int i)
	{
		ImageIcon icon=new ImageIcon(list[i]);
		Image img=icon.getImage();
		Image newImg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon newImc=new ImageIcon(newImg);
		
		pic.setIcon(newImc);
	
	}
	
	
	public static void main(String args[])
	{
		new mainFrame();
		
		
	}

}
