
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class admin {
 public static void main(String[] args)
 {
     adminpage ob= new adminpage();
     
     
 }
}
class adminpage extends Frame
{
    JButton login,exit;
    JLabel l1,l2,l3;
    JPasswordField ps1;
    JTextField t1,t2;
    public adminpage()
    {
        JFrame f= new JFrame("Currency Converter | Admin Login");
        f.setVisible(true); 
        f.setSize(450,400);
        f.setLayout(null);

        l1=new JLabel("Username:");  
        l1.setBounds(50,50, 100,30);
        t1=new JTextField();
        t1.setBounds(150, 52,200,30);
        l2=new JLabel("Password:");
        l2.setBounds(50,100, 100,30);
        ps1=new JPasswordField();
        ps1.setBounds(150, 102,200,30);
        JButton login=new JButton("Login"); 
        login.setBounds(100,230,95,30);  
        JButton exit=new JButton("Exit");  
        exit.setBounds(250,230,95,30);

        exit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.exit(0);  
                    }  
                });

        l3=new JLabel("");
        l3.setBounds(275,100,115,30);
        
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(ps1);
        f.add(login);
        f.add(exit);
        f.add(l3);

        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String s1=t1.getText();
                String s2=ps1.getText();
                if( t1.getText().equals("admin") &&  ps1.getText().equals("admin123"))
                {
                    //System.out.println("Admin");
                    //l3.setText("Admin Logged In");   
                 new dataentry(); //classname of the window which you have to link with this
                 dispose(); //closes the previous window
                }
		else{
                    new pop();
                    dispose();
                }
            }
        });

    }
    
}
