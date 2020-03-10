import java.util.Vector;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


class arts extends JFrame{

	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	    JTextField t1,t2,t3,t4,t5,t6,t7;
	    JButton b1,b2,b3,export;
	 

	    public arts(JFrame frame)
	    {

	  final  JTable table=new JTable();
	  final DefaultTableModel model=new DefaultTableModel();
	  Object[] column={" Roll "," Bangla "," English "," General Knowledge "," Total "};
	  model.setColumnIdentifiers(column);
	  table.setPreferredScrollableViewportSize(new Dimension(1000,1000));
	  table.setFillsViewportHeight(true);
	  table.setModel(model);
	  table.setRowHeight(20);



	        t1=new JTextField();
	        t2=new JTextField();
	        t3=new JTextField();
	        t4=new JTextField();
	       
	    
	     



	      l1=new JLabel("Student Roll :");
	      l1.setBounds(10,350,200,25);
	      add(l1);
	      l2=new JLabel("Bangla score :");
	      l2.setBounds(10,380,200,25);
	      add(l2);
	      l3=new JLabel("English score :");
	      l3.setBounds(10,410,200,25);
	      add(l3);
	      l4=new JLabel("General Knowledge score :");
	      l4.setBounds(10,440,200,25);
	      add(l4);
	   
	      




	      b1=new JButton("Add");
	      b1.setBounds(410,350,100,25);
	       b2=new JButton("Update");
	      b2.setBounds(410,380,100,25);
	      b3=new JButton("Delete");
	      b3.setBounds(410,410,100,25);
	             export=new JButton("Save");
	      export.setBounds(410,440,100,25);

	      

	        t1.setBounds(210,350, 100, 25);
	        t2.setBounds(210, 380, 100, 25);
	        t3.setBounds(210, 410, 100, 25);
	        t4.setBounds(210, 440, 100, 25);
	     
	     



	       



	        JScrollPane pane=new JScrollPane(table);
	        pane.setBounds(0,0,800,300);

	        setLayout(null);
	        add(pane);

	        add(t1);
	        add(t2);
	        add(t3);
	        add(t4);
	       

	         add(b1);
	        add(b2);
	        add(b3);
	        


	         final Object[] row=new Object[100];
	         b1.addActionListener(new ActionListener()

	         {
	             public void actionPerformed(ActionEvent event)
	             {

	                row[0]=t1.getText();
	                row[1]=t2.getText();
	                row[2]=t3.getText();
	                row[3]=t4.getText();

	               
	                 double num2=Double.parseDouble(t2.getText());
	                  double num3=Double.parseDouble(t3.getText());
	                   double num4=Double.parseDouble(t4.getText());

	                    if(num2<=30 && num3<=30 && num4<=30)
	                    {
		                 double sum=num2+num3+num4;
	                    String result=String.valueOf(sum);
	                    row[4]=result;
	                    model.addRow(row);
	                    }
	                    
                        t1.setText(null);		
                        t2.setText(null);	
                        t3.setText(null);	
                        t4.setText(null);

	             }
	         }
	                 );



	                  b2.addActionListener(new ActionListener()

	           {
	               public void actionPerformed(ActionEvent event)
	               {
	                    int i=table.getSelectedRow();
	                    if(i>=0)
	                    {                  
	                   
	                      double num2=Double.parseDouble(t2.getText());
		                  double num3=Double.parseDouble(t3.getText());
		                   double num4=Double.parseDouble(t4.getText());
		                    
		                   if(num2<=30 && num3<=30 && num4<=30)
		                    {
		                	   model.setValueAt(t1.getText(), i, 0);
			                    model.setValueAt(t2.getText(), i, 1);
			                    model.setValueAt(t3.getText(), i, 2);
			                    model.setValueAt(t4.getText(), i, 3);
		                	   
		                	   double sum=num2+num3+num4;

		                     String result=String.valueOf(sum);
		                     row[4]=result;
		                     model.setValueAt(row[4], i, 4);
                             t1.setText(null);		
                             t2.setText(null);	
                             t3.setText(null);	
                             t4.setText(null);	
		                    }

	                    }
	                    else
	                        System.out.println("Update Error");
	                    }

	           }
	        );

	        ////delete

	          b3 .addActionListener(new ActionListener()

	                 {
	                     public void actionPerformed(ActionEvent e)
	                     {
	                         int i=table.getSelectedRow();
	                         if(i>=0)
	                         {
	                             model.removeRow(i);
	                         }
	                         else
	                             System.out.println("Delete error");
	                     }
	                 }
	                         );



	                              export.addActionListener(new ActionListener()

	           {
	               public void actionPerformed(ActionEvent event)
	               {

	              try{

	            ExcelExporter obj=new ExcelExporter();
	            obj.exportTable(table,new File("C:\\Users\\Ashif Rahman\\workspace\\project\\src\\result\\nnarts.xls"));

	                  }

	        catch(IOException e)
	        {
	            e.getMessage();
	        }



	               }

	                  }
	                  );

	      add(export);


	                 table.addMouseListener(new MouseAdapter()
	           {
	               public void mouseClicked(MouseEvent e)
	               {
	                   int i=table.getSelectedRow();
	                  t1.setText(model.getValueAt(i, 0).toString());
	                   t2.setText(model.getValueAt(i, 1).toString());
	                    t3.setText(model.getValueAt(i, 2).toString());
	                    t4.setText(model.getValueAt(i, 3).toString());
	                    
	                   


	               }

	           }
	           );

	                 TableRowSorter sorter=new TableRowSorter(model);
	                 table.setRowSorter(sorter);
	    }
	   

	
}
