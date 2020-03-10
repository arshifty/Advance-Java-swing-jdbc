import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;


public class Admission_System extends JFrame{

    private JButton btn1, btn2, btn3,btn4;
    private JLabel l1, l2, l3, l4, l5, l6;
    JMenuBar menubar;
    JMenu file, ffont, help, font_color, layout_color;
    JMenuItem exit, open, save, about, black, yellow, red, green, blue, random_color;
 
    public Admission_System() {
        getContentPane().setBackground(Color.getHSBColor(6, 10, 80));
        menubar = new JMenuBar();
        setJMenuBar(menubar);

        file = new JMenu("File ");
        menubar.add(file);


        exit = new JMenuItem("Exit");
        file.add(exit);

        help = new JMenu("Help ");
        menubar.add(help);
        about = new JMenuItem("About");
        help.add(about);
        

        event1 e1 = new event1();
        exit.addActionListener(e1);

        event2 e2 = new event2();
        about.addActionListener(e2);




        l1 = new JLabel("UNIVERSITY OF BARISAL");
        l1.setFont(new Font("Arial Black", Font.BOLD, 28));
        l1.setBounds(300, 0, 500, 50);
        l1.setForeground(Color.getHSBColor(60, 160, 120));
        add(l1);

        btn1 = new JButton("Science");
        btn1.setBounds(400, 150, 200, 50);
        btn1.setForeground(Color.getHSBColor(90, 60, 20));
        btn1.setBackground(Color.getHSBColor(200, 150, 200));
        add(btn1);


        btn2 = new JButton("Arts");
        btn2.setBounds(400, 250, 200, 50);
        btn2.setForeground(Color.getHSBColor(90, 60, 20));
        btn2.setBackground(Color.getHSBColor(200, 150, 200));
        add(btn2);


        btn3 = new JButton("Commerce");
        btn3.setBounds(400, 350, 200, 50);
        btn3.setForeground(Color.getHSBColor(90, 60, 20));
        btn3.setBackground(Color.getHSBColor(200, 150, 200));
        add(btn3);
        
        btn4 = new JButton("Show Result");
        btn4.setBounds(400, 450, 200, 50);
        btn4.setForeground(Color.getHSBColor(90, 60, 20));
        btn4.setBackground(Color.getHSBColor(200, 150, 200));
        add(btn4);

        eventbtn1 ebtn1 = new eventbtn1();
        btn1.addActionListener(ebtn1);
        
        eventbtn4 ebtn4 = new eventbtn4();
        btn4.addActionListener(ebtn4);


        eventbtn2 ebtn2 = new eventbtn2();
        btn2.addActionListener(ebtn2);


        eventbtn3 ebtn3 = new eventbtn3();
        btn3.addActionListener(ebtn3);

    }
    
    public class eventbtn4 implements ActionListener {

        public void actionPerformed(ActionEvent eventbtn4) {
        	excelTojTable obj4 = new excelTojTable(Admission_System.this);
            obj4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            obj4.setLayout(null);
            obj4.setSize(900, 650);
            obj4.setTitle("Result");
            obj4.setVisible(true);
            obj4.setLocationRelativeTo(null);
        }
    }

    public class eventbtn1 implements ActionListener {

        public void actionPerformed(ActionEvent eventbtn1) {
            science obj1 = new science(Admission_System.this);
            obj1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            obj1.setLayout(null);
            obj1.setSize(900, 650);
            obj1.setTitle("Science");
            obj1.setVisible(true);
            obj1.setLocationRelativeTo(null);
        }
    }

    public class eventbtn2 implements ActionListener {

        public void actionPerformed(ActionEvent eventbtn2) {
            arts obj2 = new arts(Admission_System.this);
            obj2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            obj2.setLayout(null);
            obj2.setSize(900, 650);
            obj2.setTitle("Arts");
            obj2.setVisible(true);
            obj2.setLocationRelativeTo(null);
        }
    }

    public class eventbtn3 implements ActionListener {

        public void actionPerformed(ActionEvent eventbtn3) {
            commerce obj3 = new commerce(Admission_System.this);
            obj3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            obj3.setLayout(null);
            obj3.setSize(900, 650);
            obj3.setTitle("Commerce");
            obj3.setVisible(true);
            obj3.setLocationRelativeTo(null);
        }
    }

    public class event2 implements ActionListener {

        public void actionPerformed(ActionEvent e2) {
            about obj = new about(Admission_System.this);
            obj.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            obj.setLayout(null);
            obj.setSize(1000, 500);
            obj.setTitle("About");
            obj.setVisible(true);
        }
    }

    public class event1 implements ActionListener {

        public void actionPerformed(ActionEvent e1) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        Admission_System gui = new Admission_System();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setSize(1000, 700);
        gui.setVisible(true);
        gui.setTitle("Admission System");
    }
	
}
