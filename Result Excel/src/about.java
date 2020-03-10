import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;


class about extends JFrame{
	private JLabel l1,l2,l3,l4;

    public about(JFrame frame)
    {
        l1=new JLabel("This software exhibits the University Admission System of University of Barisal.");
        l1.setFont(new Font("Vrinda (Body CS)",Font.BOLD,14));
        l1.setBounds(0,0,1200,20);
        add(l1);

        l2=new JLabel("There are 3 groups Science , arts and commerce.Click any of the group , you will find the new window where you can make result yourself.");
         l2.setFont(new Font("Vrinda (Body CS)",Font.BOLD,14));
        l2.setBounds(0,30,1200,20);
        add(l2);

        l3=new JLabel("First enter the student roll .Then enter the scores  of the selected student according to the  subjects");
         l3.setFont(new Font("Vrinda (Body CS)",Font.BOLD,14));
        l3.setBounds(0,60,1200,20);
        add(l3);

        l4=new JLabel("Then you will find the total score automatically.After entering all the students scores Click on merit  list .This software shows the merit list. ");
        l4.setFont(new Font("Vrinda (Body CS)",Font.BOLD,14));
        l4.setBounds(0,90,1300,20);
        add(l4);
    }


}
