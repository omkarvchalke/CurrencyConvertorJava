import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class page1{
    public static void main(String[] args)
    {
        firstpage ob=new firstpage();
    }
}

class firstpage extends Frame
{
 JLabel l1;
 JButton bt1,bt2,bt3;

 public firstpage()
 {
    JFrame f= new JFrame("Currency Converter ");
    f.setVisible(true); 
    f.setSize(450,400);
    f.setLayout(null);
     
    l1=new JLabel("Welcome to Currency Convertor !");
    l1.setBounds(120,50,300,50);
    JButton bt1=new JButton("Admin");
    bt1.setBounds(60,250,95,30);
    bt1.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            new adminpage();
            
            dispose();
        }
    });
    JButton bt2=new JButton("Exit");  
    bt2.setBounds(260,250,95,30);
    bt2.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
        
    });
    JButton bt3=new JButton("User");  
    bt3.setBounds(160,250,95,30);
    bt3.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            new event1();
            dispose();
        }
    });
    
    f.add(l1);
    f.add(bt1);
    f.add(bt2);
    f.add(bt3);
 }
}