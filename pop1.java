import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class pop1{
    public static void main(String[] args)
    {
        pop ob=new pop();
    }
}

class pop extends Frame
{
    JLabel l1;
    public pop()
 {
    JFrame f= new JFrame("Invalid");
    f.setVisible(true); 
    f.setSize(400,200);
    f.setLayout(null);
    l1=new JLabel("Invalid Username or Password ");
    l1.setBounds(100,55,250,40); //(x,y,width,height)

    f.add(l1);

}
}