import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class data{
    public static void main(String[] args)
    {
        dataentry ob=new dataentry();
    }
}

class dataentry extends Frame
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField INR, GBP, EUR, YEN;
    JButton enter,reset,exit;

 public dataentry()
 {
    JFrame f= new JFrame("Currency Converter | Data Entry");
    f.setVisible(true); 
    f.setSize(450,400);
    f.setLayout(null);

    l1=new JLabel("Enter all rates in terms of 1 USD");
    l1.setBounds(120,15,300,25); //(x,y,width,height)
    l2=new JLabel("Indian Rupee (INR) :"); //label for Currency
    l2.setBounds(75,50,150,25);
    INR=new JTextField(); //textfield to enter data
    INR.setBounds(250,50,100,25);
    l3=new JLabel("G B Pound (GBP) :");
    l3.setBounds(75,85,150,25); // increase y coordinate by 35
    GBP=new JTextField();
    GBP.setBounds(250,85,100,25); // increase y coordinate by 35
    l4=new JLabel("Euro (EUR) :");
    l4.setBounds(75,120,150,25); // increase y coordinate by 30
    EUR=new JTextField();
    EUR.setBounds(250,120,100,25); 
    l5=new JLabel("Japanese Yenn (YEN) :");
    l5.setBounds(75,155,150,25); 
    YEN=new JTextField();
    YEN.setBounds(250,155,100,25); 
    JButton enter=new JButton("Enter");
    enter.setBounds(50,250,95,30);
    enter.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency?useTimezoneShift=true&serverTimezone=UTC","root","");
            
            String sql = "insert into converter values(?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, Double.parseDouble(INR.getText()));
            pstmt.setDouble(2, Double.parseDouble(GBP.getText()));
            pstmt.setDouble(3, Double.parseDouble(EUR.getText()));
            pstmt.setDouble(4, Double.parseDouble(YEN.getText()));
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertion Successful");
            conn.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    );

    JButton exit=new JButton("Exit");  
    exit.setBounds(250,250,95,30);
    exit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
        
    });
    JButton reset=new JButton("Reset");  
    reset.setBounds(150,250,95,30);
    reset.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            INR.setText("");
            GBP.setText("");
            EUR.setText("");
            YEN.setText("");
        }
    }); 
    
    
    f.add(l1);
    f.add(l2);
    f.add(INR);
    f.add(l3);
    f.add(GBP);
    f.add(l4);
    f.add(EUR);
    f.add(l5);
    f.add(YEN);
    f.add(enter);
    f.add(reset);
    f.add(exit);

 }    
}