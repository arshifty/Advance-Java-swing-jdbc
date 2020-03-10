package NotepadAshif;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

import com.sun.glass.events.KeyEvent;



import java.awt.Component;

public class AshifNotepad {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AshifNotepad window = new AshifNotepad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AshifNotepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public Color randomcolor(){
		int r=(int) (Math.random()*256);
		int g=(int)(Math.random()*256);
		int b=(int ) (Math.random()*256);
		System.out.println(r+g+b);
		return (new Color(r,g,b));
	}
	
	JTextArea ta;
	JMenuItem mntmCopy;	
	JMenuItem mntmPaste;	
	JMenuItem mntmCut ;	
	JMenuItem mntmSelectAll;
	
	
	JCheckBox chckbxPlain;	
	JCheckBox chckbxBold ;	
	JCheckBox chckbxItalic;
	private JTextField text2;
	int sizeOfText=16;
	String star="Imprint MT Shadow";
	JMenuItem mntmNewMenuItem_9,mntmNewMenuItem_1,	mntmNewMenuItem_2,	mntmNewMenuItem_3,	mntmNewMenuItem_4,	mntmNewMenuItem_5;
	JMenuItem mntmNewMenuItem,mntmCalibriLightheadings,	mntmNewMenuItem_6,	mntmNewMenuItem_7,	mntmNewMenuItem_8;
	JMenuItem mntmNewMenuItem_10,mntmNewMenuItem_11,	mntmNewMenuItem_12,	mntmNewMenuItem_17;
	private JTextField textField;
	private JMenuItem mntmNew;

	
	
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 691, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		
		
		
		///
		
	    ta = new JTextArea();
		ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		ta.setLineWrap(true);
		//JScrollPane ob=new JScrollPane(ta);
		ta.setBounds(0, 21,675, 560);
		frame.getContentPane().add(ta);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 675, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e11) {
			
				if(e11.getSource()==mntmNew)
				{
					
					
					
					       ta.setText("");
					       ta.setEditable(true);
					      
				}
				
			}
				}		);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		mntmOpen.addActionListener(new ActionListener()
				{
			
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser filechooser = new JFileChooser();
				filechooser.showOpenDialog(null);
				
				File file = filechooser.getSelectedFile();
				
				try
				{
					FileReader fr =new  FileReader(file);
					ta.read(fr, "");
				}
				catch(Exception ex)
				{
					 JOptionPane.showMessageDialog(null, "Can not open file.");
				}
				
			
			}	
			
				}
				);
		
		JMenu mnSave = new JMenu("Save as");
		mnFile.add(mnSave);
		
		
		
		
		textField = new JTextField();
		mnSave.add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		mnSave.add(btnSave);
		
		btnSave.addActionListener(new ActionListener()
		{
			
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getActionCommand()==btnSave.getActionCommand())
		{
			try
			{
				String s1=textField.getText();
				int length=s1.length();
				if(length>=1)
				{
					String s2="G:\\1 project\\src\\NotepadAshif\\"+s1+".txt";
					FileWriter fileWriter=new FileWriter(s2);
					fileWriter.write(System.getProperty("line.separator"));

					fileWriter.write(ta.getText());
					fileWriter.close();
					
					JOptionPane.showMessageDialog(null, "File saved succesfully ");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "File name is missing");

				}

			}
			
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Failed to save file");
			}
		}
	
	}	
	
		}
		);
		
		
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener()
		{
			
	public void actionPerformed(ActionEvent arg0)
	{
		
		System.exit(0);
	
	}	
	
		}
		);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		 mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		 mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		 mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		 mntmSelectAll = new JMenuItem("Select All");
		mnEdit.add(mntmSelectAll);
		
		event e=new event();
		mntmCopy.addActionListener(e);
		mntmPaste.addActionListener(e);
		mntmCut.addActionListener(e);
		mntmSelectAll.addActionListener(e);
		
		
		JMenu mnFont = new JMenu("Font");
		menuBar.add(mnFont);
		
		JMenu mnSiz = new JMenu("Size");
		mnFont.add(mnSiz);
		
		text2 = new JTextField();
		mnSiz.add(text2);
		text2.setColumns(10);
		
		JButton btnSetSize = new JButton("Set Size");
		btnSetSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sizeOfText = Integer.parseInt(text2.getText());
				ta.setFont(new Font(star, Font.PLAIN, sizeOfText));


				
			}
		});
		btnSetSize.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		mnSiz.add(btnSetSize);
		
		JMenu mnFace = new JMenu("Face");
		mnFont.add(mnFace);
		
		mntmNewMenuItem = new JMenuItem("Vrinda (Headings CS)");
		mnFace.add(mntmNewMenuItem);
		
		 mntmCalibriLightheadings = new JMenuItem("Calibri Light (Headings)");
		mnFace.add(mntmCalibriLightheadings);
		
		 mntmNewMenuItem_1 = new JMenuItem("Gabriola");
		mnFace.add(mntmNewMenuItem_1);
		
		 mntmNewMenuItem_2 = new JMenuItem("Curlz MT");
		mnFace.add(mntmNewMenuItem_2);
		
		 mntmNewMenuItem_3 = new JMenuItem("Colonna MT");
		mnFace.add(mntmNewMenuItem_3);
		
		 mntmNewMenuItem_4 = new JMenuItem("Chiller");
		mnFace.add(mntmNewMenuItem_4);
		
		 mntmNewMenuItem_5 = new JMenuItem("Castellar");
		mnFace.add(mntmNewMenuItem_5);
		
		 mntmNewMenuItem_6 = new JMenuItem("Blackadder ITC");
		mnFace.add(mntmNewMenuItem_6);
		
		 mntmNewMenuItem_7 = new JMenuItem("Arial Black");
		mnFace.add(mntmNewMenuItem_7);
		
		 mntmNewMenuItem_8 = new JMenuItem("Aharoni");
		mnFace.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("Imprint MT Shadow");
		mnFace.add(mntmNewMenuItem_9);
		
		 mntmNewMenuItem_10 = new JMenuItem("Jokerman");
		mnFace.add(mntmNewMenuItem_10);
		
		 mntmNewMenuItem_11 = new JMenuItem("Papyrus");
		mnFace.add(mntmNewMenuItem_11);
		
	 mntmNewMenuItem_12 = new JMenuItem("Microsoft Sa");
		mnFace.add(mntmNewMenuItem_12);
		
	 mntmNewMenuItem_17 = new JMenuItem("Times New Roman");
		mnFace.add(mntmNewMenuItem_17);
		
		event10 e10=new event10();
		mntmCalibriLightheadings.addActionListener(e10);
		mntmNewMenuItem.addActionListener(e10);
		mntmNewMenuItem_1.addActionListener(e10);
		mntmNewMenuItem_2.addActionListener(e10);
		mntmNewMenuItem_3.addActionListener(e10);
		mntmNewMenuItem_4.addActionListener(e10);
		mntmNewMenuItem_5.addActionListener(e10);
		 mntmNewMenuItem_6 .addActionListener(e10);
		 mntmNewMenuItem_7.addActionListener(e10);
		 mntmNewMenuItem_8.addActionListener(e10);
		 mntmNewMenuItem_9.addActionListener(e10);
		 mntmNewMenuItem_10.addActionListener(e10);
		 mntmNewMenuItem_11.addActionListener(e10);
		 mntmNewMenuItem_12.addActionListener(e10);
		 mntmNewMenuItem_17.addActionListener(e10);
		
		JMenu mnStyle = new JMenu("Style");
		mnFont.add(mnStyle);
		
		chckbxPlain = new JCheckBox("Plain");
		mnStyle.add(chckbxPlain);
		
	    chckbxBold = new JCheckBox("Bold");
		mnStyle.add(chckbxBold);
		
	    chckbxItalic = new JCheckBox("Italic");
		mnStyle.add(chckbxItalic);
		
		
		 event3 e3=new event3();
		  chckbxPlain.addItemListener(e3);
		  chckbxBold.addItemListener(e3);
		  chckbxItalic.addItemListener(e3);
		
		JMenu mnDisplay = new JMenu("Display");
		menuBar.add(mnDisplay);
		
		JMenuItem mntmNormal = new JMenuItem("Normal");
		mnDisplay.add(mntmNormal);
		
		
		mntmNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			///	ta.setFont(new Font("Calibri Light", Font.PLAIN, sizeOfText));

				
				ta.addKeyListener(new KeyListener()
				{
			
			 
				public void keyPressed(java.awt.event.KeyEvent e) {
					ta.setForeground(Color.black);					
				}
				
				public void keyReleased(java.awt.event.KeyEvent e) {
					
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					
				}
				
				
				
				}		);



		ta.addMouseListener(new MouseListener()
				
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
		            ta.setBackground(Color.white);						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
			
			
				}
				
				);

			}
		});
				
				
				
		
		
		JMenuItem mntmRandom = new JMenuItem("Random");
		mnDisplay.add(mntmRandom);
		
		mntmRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ta.addKeyListener(new KeyListener()
				{
			
			 
				public void keyPressed(java.awt.event.KeyEvent e) {
					ta.setForeground(randomcolor());					
				}
				
				public void keyReleased(java.awt.event.KeyEvent e) {
					
				}

				public void keyTyped(java.awt.event.KeyEvent e) {
					
				}
				
				
				
				}		
			);



		ta.addMouseListener(new MouseListener()
				
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
		            ta.setBackground(randomcolor());						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
			
			
				}
				
				);

			}
		});
		
		
		
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==mntmAbout)
				{
					String sss="\n Star\n  Life is temporary ... current je dike jay oi dike cole jao ..."
							+ "\n  Moska koro \n"
							+ "no , never , impossible\n"
							+ "Life to colbei eta vul kotha ...life holo setai ... ami jevabe calabo life oi vabei colbe ...\n"
							+ "Ami luck ke onek believe kori \n"
							+ "Wine khowar iccha ache life e \n"
							+ "13 july amar birthday \n"
							+ "first meet hoyechilo 15 july at bels park";
						
					
					
					       ta.setText(sss);
					       ta.setEditable(false);
					      
				}
				
			}
				}		);
		
		
		///
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	
	
	
	public class event implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {    
		if(e.getSource()==mntmCut)    
		ta.cut();    
		if(e.getSource()==mntmPaste)    
		ta.paste();    
		if(e.getSource()==mntmCopy)    
		ta.copy();    
		if(e.getSource()==mntmSelectAll)    
		ta.selectAll();  
		}     
	}
	
	public class event10 implements ActionListener
	{
		public void actionPerformed(ActionEvent e10) {    
		if(e10.getSource()==mntmNewMenuItem)    
		{
			star="Vrinda (Headings CS)";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));

		}
		
		else if(e10.getSource()== mntmCalibriLightheadings)   
		{
			star="Calibri Light (Headings)";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		
		else if(e10.getSource()== mntmNewMenuItem_1)   
		{
			star="Gabriola";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}		 
			
		else if(e10.getSource()==  mntmNewMenuItem_2)   
		{
			star="Curlz MT";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()== mntmNewMenuItem_3)   
		{
			star="Colonna MT";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		
		
		
			
			
			
			
		
		else if(e10.getSource()== mntmNewMenuItem_4)   
		{
			star="Chiller";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()== mntmNewMenuItem_5 )   
		{
			star="Castellar";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()==  mntmNewMenuItem_6)   
		{
			star="Blackadder ITC";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
	
		
		else if(e10.getSource()==  mntmNewMenuItem_7)   
		{
			star="Arial Black";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()==  mntmNewMenuItem_8)   
		{
			star="Aharoni";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()== mntmNewMenuItem_9)   
		{
			star="Imprint MT Shadow";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()== mntmNewMenuItem_10 )   
		{
			star="Jokerman";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()==  mntmNewMenuItem_11 )   
		{
			star="Papyrus";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()==  mntmNewMenuItem_12 )   
		{
			star="Microsoft Sa";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		else if(e10.getSource()== mntmNewMenuItem_17 )   
		{
			star="Times New Roman";
			ta.setFont(new Font(star, Font.PLAIN, sizeOfText));
		}
		
		}     
	}

	public class event3 implements ItemListener
	{
	    public void itemStateChanged(ItemEvent e3)
	    {
	        Font font=null;
	        if(chckbxBold.isSelected() && chckbxItalic.isSelected() &&  chckbxPlain.isSelected())
	        {
	            font=new Font("Serif",Font.BOLD+Font.ITALIC+Font.PLAIN,sizeOfText);
	        }
	        else if(chckbxBold.isSelected() && chckbxItalic.isSelected())
	        {
	            font=new Font("Serif",Font.BOLD+Font.ITALIC,sizeOfText);
	        }
	        
	       
	        
	        else if(chckbxItalic.isSelected() && chckbxPlain.isSelected())
	        {
	            font=new Font("Serif",Font.ITALIC+Font.PLAIN,sizeOfText);
	        }
	        else if(chckbxItalic.isSelected())
	        {
	          font=new Font("Serif",Font.ITALIC,sizeOfText);
	        }
	        else if(chckbxBold.isSelected())
	        {
	            font=new Font("Serif",Font.BOLD,sizeOfText);
	        }
	        else
	        
	            font=new Font("Serif",Font.PLAIN,sizeOfText);
	       
	            ta.setFont(font);

	    }
	}
}


