package Loyalty_System;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;






public class main extends JFrame{
	JMenuBar menubar;
	JMenuItem exit;
	JMenu file;
	JPanel p1,p2,p3,p4,p5,contentPane;
	JTabbedPane tab;
	JLabel l1,l3,l4,l5,l6,l7,l8,l9;
	JButton stubtn1,stubtn2,techerbtn1,techerbtn2,stubtn3;
	 JTextField t3,t4,t5,t6;
	 CustomerInformation obj3;
	 starCustomer obj5;
	
	public main()
	{
		contentPane =new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);
		
		
		
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		file=new JMenu(" File ");
		menubar.add(file);		
		exit=new JMenuItem(" Exit ");
		file.add(exit);
		
		
		
		p3=new JPanel();		
		p3.setBackground(Color.darkGray);
		
		FlowLayout flowlayout=(FlowLayout) p3.getLayout();
		flowlayout.setAlignment(FlowLayout.CENTER);
		contentPane.add(p3,BorderLayout.PAGE_START);
		l1=new JLabel("Hungry Time Restaurant");
		l1.setFont(new Font("Arial Black",Font.BOLD,40));
	    l1.setForeground(Color.white);
		p3.add(l1);
		
		
		
		p5=new JPanel();		
		p5.setBackground(Color.darkGray);
		
		FlowLayout fl=(FlowLayout) p5.getLayout();
		fl.setAlignment(FlowLayout.CENTER);
		
		contentPane.add(p5,BorderLayout.AFTER_LAST_LINE);
		ImageIcon i=new ImageIcon("G:\\THIRD SEMESTER\\JAVA\\see program\\database connector\\programs\\databaseProject\\src\\labProject\\b.jpg");
		l3=new JLabel(i);
	    l3.setToolTipText("This is label 3");
		p5.add(l3);
		
		ImageIcon j=new ImageIcon("G:\\THIRD SEMESTER\\JAVA\\see program\\database connector\\programs\\databaseProject\\src\\labProject\\d.jpg");
		l4=new JLabel(j);
	    l4.setToolTipText("This is label 3");
		p5.add(l4);
		
		ImageIcon k=new ImageIcon("G:\\THIRD SEMESTER\\JAVA\\see program\\database connector\\programs\\databaseProject\\src\\labProject\\c.jpg");
		l6=new JLabel(k);
	    l6.setToolTipText("This is label 3");
		p5.add(l6);
		
		ImageIcon l=new ImageIcon("G:\\THIRD SEMESTER\\JAVA\\see program\\database connector\\programs\\databaseProject\\src\\labProject\\f.jpg");
		l7=new JLabel(l);
		p5.add(l7);
		
		ImageIcon m=new ImageIcon("G:\\THIRD SEMESTER\\JAVA\\see program\\database connector\\programs\\databaseProject\\src\\labProject\\g.jpg");
		l8=new JLabel(m);
		p5.add(l8);
		
		
		
		
		
		
			
		p1=new JPanel();
		p1.setBackground(Color.gray);
		FlowLayout flowlayout2=(FlowLayout) p1.getLayout();
		flowlayout2.setAlignment(FlowLayout.CENTER);
	
		
		stubtn1=new JButton(" Registration ");
		stubtn3=new JButton("Customer Information");
		stubtn2=new JButton(" Update Account ");
	    p1.add(stubtn1);
	    p1.add(stubtn2);
	    p1.add(stubtn3);	
		
		
		p2=new JPanel();		
		p2.setBackground(Color.gray);
		FlowLayout flowlayout3=(FlowLayout) p2.getLayout();
		flowlayout3.setAlignment(FlowLayout.CENTER);
		
		
		techerbtn1=new JButton(" Pay Money ");
		techerbtn2=new JButton(" See Star Customer ");
		p2.add(techerbtn1);
		p2.add(techerbtn2);
		
		
		tab=new JTabbedPane();	
		tab.add(" Account Setting ",p1);
		
		tab.add(" Payment System ",p2);
		
		tab.setFont(new Font("Arial Black",Font.BOLD,14));
	    add(tab);
		
		
		

        event1 e1 = new event1();
        exit.addActionListener(e1);
        
        eventbtn1 ebtn1 = new eventbtn1();
        stubtn1.addActionListener(ebtn1);
        
       eventbtn2 ebtn2 = new eventbtn2();
       stubtn2.addActionListener(ebtn2);
        
       eventbtn3 ebtn3 = new eventbtn3();
        stubtn3.addActionListener(ebtn3);
        
       
        
        eventbtn4 ebtn4 = new eventbtn4();
        techerbtn1.addActionListener(ebtn4);
        
        eventbtn5 ebtn5 = new eventbtn5();
        techerbtn2.addActionListener(ebtn5);
        
        
	}
	
	   public class eventbtn3 implements ActionListener {

	        public void actionPerformed(ActionEvent eventbtn3) {
	        	obj3=new CustomerInformation();
	        }
	    }
	
	
	
	
	   public class eventbtn5 implements ActionListener {

	        public void actionPerformed(ActionEvent eventbtn5) {
	        	obj5=new starCustomer();
	        }
	    }
	
	   
	
	
	   public class eventbtn2 implements ActionListener {

	        public void actionPerformed(ActionEvent eventbtn2) {
	        	UpdateInformation obj2 = new UpdateInformation(main.this);
	            obj2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            obj2.setLayout(null);
	            obj2.setSize(460, 490);
	            obj2.setTitle("Update Information");
	            obj2.setVisible(true);
	            obj2.setLocationRelativeTo(null);
	        }
	    }
	

	
	   public class eventbtn4 implements ActionListener {

	        public void actionPerformed(ActionEvent eventbtn4) {
	        	PayMoney obj4 = new PayMoney(main.this);
	            obj4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            obj4.setLayout(null);
	            obj4.setSize(480, 510);
	            obj4.setTitle("Pay Money");
	            obj4.setVisible(true);
	            obj4.setLocationRelativeTo(null);
	        }
	    }

	    public class eventbtn1 implements ActionListener {

	        public void actionPerformed(ActionEvent eventbtn1) {
	        	registration obj1 = new registration(main.this);
	            obj1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	            obj1.setLayout(null);
	            obj1.setSize(450, 400);
	            obj1.setTitle("Create Account");
	            obj1.setVisible(true);
	            obj1.setLocationRelativeTo(null);
	        }
	    }

	   

	    


	
	

    public class event1 implements ActionListener {

        public void actionPerformed(ActionEvent e1) {
            System.exit(0);
        }
    }
	
	
	public static void main(String args[])
	{
		main gui=new main();
		gui.setTitle("Restaurant Management System");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setSize(1245,700);
		gui.setLocationRelativeTo(null);
		
	
	}

}