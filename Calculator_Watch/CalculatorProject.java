package Calculator_Watch;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import javazoom.jl.player.Player;
import sun.audio.AudioStream;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CalculatorProject {

	private JFrame frame;
	private JTextField tf;
	JLabel label1;
	JLabel label2;
	
	double num1;
	double num2;
	double result;
	String operation;
	String answer;
	private JTextField tfhour;
	private JTextField tfminute;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorProject window = new CalculatorProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public void checkAlarm(final int a, final int b)
	{
		Thread t=new Thread()
				{
			public void run()
			{
				int wl=0;
				while(wl==0)
				{
					Calendar c = new GregorianCalendar();
					int ahour=c.get(Calendar.HOUR);
					int amin=c.get(Calendar.MINUTE);
					
					if(a==ahour  && b==amin)
					{
						/// JOptionPane.showMessageDialog(null, "Alarm worked");
					
						
						try
						{
							
							File file=new File("G:\\1 project\\src\\Calculator_Watch\\3idiots05.mp3");
							FileInputStream fis=new FileInputStream(file);
							BufferedInputStream bis=new BufferedInputStream(fis);
							
							try
							{
								Player player=new Player(bis);
								player.play();
							}
							catch(Exception eee)
							{
								
							}
							
							
							
							
						}
						catch(Exception ex)
						{
							
						}
						
						
						
					}
				}
			}
				};
				t.setPriority(Thread.MIN_PRIORITY);
				t.start();
	}
	
	
	
	
	public void clock()
	{
		
		Thread clock=new Thread()
				{
			public void run()
			{
				try
				{
				   for(; ;)
				   {
						
					    Calendar cal=new GregorianCalendar();
						int day=cal.get(Calendar.DAY_OF_MONTH);
						int month=cal.get(Calendar.MONTH);
						int year=cal.get(Calendar.YEAR);
						
						
						int second=cal.get(Calendar.SECOND);
						int minute=cal.get(Calendar.MINUTE);
						int hour=cal.get(Calendar.HOUR);
						int AM_PM=cal.get(Calendar.AM_PM);
						
						String dayNight="";
						if(AM_PM==1)
						{
							dayNight="PM";
						}
						else
						{
							dayNight="AM";
						}
						label1.setText("   "+hour+" : "+minute+" : "+second+"    "+dayNight);
						label2.setText(day+"/"+month+"/"+year+"");

						
						
						
				

						
						sleep(1000);
				   }
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
				};
	
	clock.start();
	
	
	
	}

	/**
	 * Create the application.
	 */
	public CalculatorProject() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 205, 170));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 703, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tf = new JTextField();
		tf.setForeground(new Color(0, 0, 0));
		tf.setBackground(new Color(245, 245, 245));
		tf.setFont(new Font("Calibri Light", Font.BOLD, 20));
		tf.setHorizontalAlignment(SwingConstants.RIGHT);
		tf.setBounds(48, 84, 308, 44);
		frame.getContentPane().add(tf);
		tf.setColumns(10);
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String EnterNumber = tf.getText()+btn7.getText();
				tf.setText(EnterNumber);
				
			}
		});
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setBounds(48, 155, 52, 44);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn8.getText();
				tf.setText(EnterNumber);
			}
		});
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setBounds(110, 155, 52, 44);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(new Color(0, 0, 0));
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn9.getText();
				tf.setText(EnterNumber);
			}
		});
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setBounds(172, 155, 52, 44);
		frame.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn4.getText();
				tf.setText(EnterNumber);
			}
		});
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setBounds(48, 210, 52, 44);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber=tf.getText()+btn5.getText();
				tf.setText(EnterNumber);
			}
		});
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setBounds(110, 210, 52, 44);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn6.getText();
				tf.setText(EnterNumber);
			}
		});
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setBounds(172, 210, 52, 44);
		frame.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn1.getText();
				tf.setText(EnterNumber);
			}
		});
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setBounds(48, 265, 52, 44);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn2.getText();
				tf.setText(EnterNumber);
			}
		});
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setBounds(110, 265, 52, 44);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn3.getText();
				tf.setText(EnterNumber);
			}
		});
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setBounds(172, 265, 52, 44);
		frame.getContentPane().add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber=tf.getText()+btn0.getText();
				tf.setText(EnterNumber);
			}
		});
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setBounds(48, 320, 52, 44);
		frame.getContentPane().add(btn0);
		
		JButton btne = new JButton("=");
		btne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				try
				{
					num2=Double.parseDouble(tf.getText());
					
					if(operation=="+")
					{
						result=num1+num2;
						answer=String.format("%.6f", result);
						tf.setText(answer);
					}
					else if(operation=="-")
					{
						result=num1-num2;
						answer=String.format("%.6f", result);
						tf.setText(answer);

					}
					else if(operation=="*")
					{
						result=num1*num2;
						answer=String.format("%.6f", result);
						tf.setText(answer);

					}
					else if(operation=="/")
					{
						result=num1/num2;
						answer=String.format("%.6f", result);
						tf.setText(answer);

					}
					else if(operation=="%")
					{
						result=num1%num2;
						answer=String.format("%.26", result);
						tf.setText(answer);

					}
					else if(operation=="^")
					{
						result=Math.pow(num1, num2);
						answer=String.format("%.6f", result);
						tf.setText(answer);

					}
					
					else if(operation=="sqrt")
					{
						result=Math.sqrt(num2);
						answer=String.format("%.6f", result);
						tf.setText(answer);

					}
					
					else
					{
						
						answer="Syntax Error";
						tf.setText(answer);

					}

				}
				catch(Exception ee)
				{
					
					tf.setText("Syntax Error");
				}
				
				
			}
		});
		btne.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btne.setBackground(new Color(153, 255, 0));
		btne.setBounds(296, 321, 60, 44);
		frame.getContentPane().add(btne);
		
		JButton btnm = new JButton("%");
		btnm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					num1=Double.parseDouble(tf.getText());
					tf.setText("");
					operation="%";
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btnm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnm.setBackground(new Color(204, 255, 102));
		btnm.setBounds(172, 321, 52, 43);
		frame.getContentPane().add(btnm);
		
		JButton btnadd = new JButton("+");
		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					num1=Double.parseDouble(tf.getText());
					tf.setText("");
					operation="+";
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btnadd.setBackground(new Color(204, 255, 102));
		btnadd.setBounds(234, 155, 52, 44);
		frame.getContentPane().add(btnadd);
		
		JButton btnsub = new JButton("-");
		btnsub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
					
						num1=Double.parseDouble(tf.getText());
						tf.setText("");
						operation="-";
				
					
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btnsub.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnsub.setBackground(new Color(204, 255, 102));
		btnsub.setBounds(234, 210, 52, 44);
		frame.getContentPane().add(btnsub);
		
		JButton btnmul = new JButton("*");
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					num1=Double.parseDouble(tf.getText());
					tf.setText("");
					operation="*";
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btnmul.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnmul.setBackground(new Color(204, 255, 102));
		btnmul.setBounds(234, 265, 52, 44);
		frame.getContentPane().add(btnmul);
		
		JButton btndiv = new JButton("/");
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					num1=Double.parseDouble(tf.getText());
					tf.setText("");
					operation="/";
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btndiv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btndiv.setBackground(new Color(204, 255, 102));
		btndiv.setBounds(234, 321, 52, 44);
		frame.getContentPane().add(btndiv);
		
		JButton clear = new JButton("C");
		clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText(null);
			}
		});
		clear.setBackground(new Color(255, 255, 204));
		clear.setBounds(296, 155, 60, 44);
		frame.getContentPane().add(clear);
		
		JLabel lblCalculator = new JLabel("SMART CALCULATOR");
		lblCalculator.setBackground(new Color(255, 255, 255));
		lblCalculator.setForeground(new Color(255, 255, 255));
		lblCalculator.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCalculator.setBounds(93, 11, 230, 54);
		frame.getContentPane().add(lblCalculator);
		
		JButton btndot = new JButton(".");
		btndot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber=tf.getText()+btndot.getText();
				tf.setText(EnterNumber);
			}
		});
		btndot.setFont(new Font("Arial Black", Font.BOLD, 25));
		btndot.setBackground(new Color(255, 255, 255));
		btndot.setBounds(110, 320, 52, 44);
		frame.getContentPane().add(btndot);
		
		JButton btnpow = new JButton("^");
		btnpow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					num1=Double.parseDouble(tf.getText());
					tf.setText("");
					operation="^";
				}
				catch(Exception ex)
				{
					tf.setText("Syntax Error");

				}
			}
		});
		btnpow.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnpow.setBackground(new Color(204, 255, 102));
		btnpow.setBounds(296, 210, 60, 44);
		frame.getContentPane().add(btnpow);
		
		JButton btnSqrt = new JButton("sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operation="sqrt";
			}
		});
		btnSqrt.setHorizontalAlignment(SwingConstants.LEFT);
		btnSqrt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSqrt.setBackground(new Color(204, 255, 102));
		btnSqrt.setBounds(296, 265, 60, 44);
		frame.getContentPane().add(btnSqrt);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(127, 255, 212));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(402, 103, 223, 44);
		frame.getContentPane().add(panel);
		
		label2 = new JLabel("Date");
		label2.setForeground(new Color(255, 255, 255));
		panel.add(label2);
		label2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(402, 36, 223, 44);
		frame.getContentPane().add(panel_1);
		
		label1 = new JLabel("Clock");
		panel_1.add(label1);
		label1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label1.setForeground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(391, 11, 245, 163);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		panel_3.setBounds(44, 76, 317, 297);
		frame.getContentPane().add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Alarm");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(427, 213, 178, 44);
		frame.getContentPane().add(lblNewLabel);
		
		tfhour = new JTextField();
		tfhour.setBounds(526, 265, 99, 29);
		frame.getContentPane().add(tfhour);
		tfhour.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Hour");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(427, 265, 89, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblEnterMinutes = new JLabel("Enter Minutes");
		lblEnterMinutes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterMinutes.setBounds(427, 305, 89, 29);
		frame.getContentPane().add(lblEnterMinutes);
		
		tfminute = new JTextField();
		tfminute.setColumns(10);
		tfminute.setBounds(526, 305, 99, 29);
		frame.getContentPane().add(tfminute);
		
		JButton btnalarm = new JButton("Set");
		btnalarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=Integer.parseInt(tfhour.getText());
				int b=Integer.parseInt(tfminute.getText());

				
				checkAlarm(a,b);
			}
		});
		btnalarm.setBounds(526, 341, 99, 29);
		frame.getContentPane().add(btnalarm);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(391, 210, 245, 163);
		frame.getContentPane().add(panel_4);
		
		
		
	}
}
