import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class pop2{
    public static void main(String[] args)
    {
        popup ob=new popup();
    }
}

class popup extends Frame
{
    JLabel l1;
    public popup()
 {
    JFrame f= new JFrame("Succesfull");
    f.setVisible(true); 
    f.setSize(400,200);
    f.setLayout(null);
    l1=new JLabel("Data Entered Succesfully ");
    l1.setBounds(100,55,250,40); //(x,y,width,height)

    f.add(l1);

}
}