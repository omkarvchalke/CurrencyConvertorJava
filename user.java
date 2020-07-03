import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class event1 extends Frame implements ActionListener
{
JButton bt,bt1,bt2;
JLabel l1,l2,l3,l4;
JComboBox cb,cb1;
JTextField t1,t2;
 
event1()
{
JFrame f= new JFrame("Currency Converter");  
   
    l1=new JLabel("Convert From");  
    l1.setBounds(50,50, 100,30);  
    l2=new JLabel("To");  
    l2.setBounds(110,100, 100,30);  
    String country[]={"Indian Rupee (INR)","US Dollar (USD)","Euro (EUR)","Japanese Yen (JPY)","Pound sterling (GBP)"};        
    JComboBox cb=new JComboBox(country);    
    cb.setBounds(150, 52,200,30);           
    JComboBox cb1=new JComboBox(country);    
    cb1.setBounds(150, 102,200,30); 
    cb1.setSelectedIndex(1);  
    l3=new JLabel("Amount");  
    l3.setBounds(82,150, 100,30);  
    t1=new JTextField("");  
    t1.setBounds(150,150, 200,30);
    l4=new JLabel("Conversion");  
    l4.setBounds(70,200, 100,30);  
    t2=new JTextField("");  
    t2.setBounds(150,200, 200,30);
    JButton bt=new JButton("Convert"); 
    bt.setBounds(50,250,95,30);  
    JButton bt1=new JButton("Exit");  
    bt1.setBounds(250,250,95,30);
    bt1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            System.exit(0);  
                }  
            });
    JButton bt2=new JButton("Reset");  
    bt2.setBounds(150,250,95,30);  
    bt2.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            t1.setText("");
            t2.setText("");
            cb.setSelectedIndex(0); 
            cb1.setSelectedIndex(1); 
                }  
            });

    f.add(l1); 
    f.add(cb); 
    f.add(l2); 
    f.add(cb1); 
    f.add(l3);
    f.add(t1);
    f.add(l4);
    f.add(t2);
    f.add(bt);
    f.add(bt1);
    f.add(bt2);

    f.setSize(450,400);  
    f.setLayout(null);  
    f.setVisible(true); 
    

    bt.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
            double a, c=0, INR=0, YEN=0, GBP=0, EUR=0;
            int count=0;
            a=Double.valueOf(t1.getText());
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");	
			    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/currency?useTimezoneShift=true&serverTimezone=UTC","root","");
                Statement st = conn.createStatement();
                String rows = "SELECT COUNT(*) from converter";
                ResultSet rs = st.executeQuery(rows);
                if(rs.next())
                    count = Integer.parseInt(rs.getString(1));

                String lastrow = "SELECT * FROM converter LIMIT 1 OFFSET "+(count-1);
                ResultSet rs1 = st.executeQuery(lastrow);
                if(rs1.next()){
                    INR = Double.parseDouble(rs1.getString(1));
                    GBP = Double.parseDouble(rs1.getString(2));
                    EUR = Double.parseDouble(rs1.getString(3));
                    YEN = Double.parseDouble(rs1.getString(4));
                }
            

               //INR
                if(cb.getSelectedIndex()==0 & cb1.getSelectedIndex()==0){
                    c= a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==0 & cb1.getSelectedIndex()==1){
                    c = a/INR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==0 & cb1.getSelectedIndex()==2){
                    c= (EUR*a)/INR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==0 & cb1.getSelectedIndex()==3){
                    c= (YEN*a)/INR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==0 & cb1.getSelectedIndex()==4){
                    c= (GBP*a)/INR;
                t2.setText(String.valueOf(c));}

                //USD
                if(cb.getSelectedIndex()==1 & cb1.getSelectedIndex()==0){
                    c= INR*a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==1 & cb1.getSelectedIndex()==1){
                    c= a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==1 & cb1.getSelectedIndex()==2){
                    c= EUR*a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==1 & cb1.getSelectedIndex()==3){
                    c= YEN*a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==1 & cb1.getSelectedIndex()==4){
                    c= GBP*a;
                t2.setText(String.valueOf(c));}
                
                //EUR
                if(cb.getSelectedIndex()==2 & cb1.getSelectedIndex()==0){
                    c= (INR*a)/EUR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==2 & cb1.getSelectedIndex()==1){
                    c= a/EUR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==2 & cb1.getSelectedIndex()==2){
                    c= a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==2 & cb1.getSelectedIndex()==3){
                    c= (YEN*a)/EUR;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==2 & cb1.getSelectedIndex()==4){
                    c= (GBP*a)/EUR;
                t2.setText(String.valueOf(c));}

                //JPY
                if(cb.getSelectedIndex()==3 & cb1.getSelectedIndex()==0){
                    c= (INR*a)/YEN;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==3 & cb1.getSelectedIndex()==1){
                    c= a/YEN;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==3 & cb1.getSelectedIndex()==2){
                    c= (EUR*a)/YEN;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==3 & cb1.getSelectedIndex()==3){
                    c= a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==3 & cb1.getSelectedIndex()==4){
                    c= (GBP*a)/YEN;
                t2.setText(String.valueOf(c));}

                //GBP
                if(cb.getSelectedIndex()==4 & cb1.getSelectedIndex()==0){
                    c= (INR*a)/GBP;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==4 & cb1.getSelectedIndex()==1){
                    c= GBP/a;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==4 & cb1.getSelectedIndex()==2){
                    c= (EUR*a)/GBP;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==4 & cb1.getSelectedIndex()==3){
                    c= (YEN*a)/GBP;
                t2.setText(String.valueOf(c));}
                if(cb.getSelectedIndex()==4 & cb1.getSelectedIndex()==4){
                    c= a;
                t2.setText(String.valueOf(c));}
                
                }catch(Exception x){System.out.println("Error"+x);
                
 } 
                }  
            });

}
public void actionPerformed(ActionEvent ae)
{ 
}

}
public class user{
     /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    
    event1 o = new event1();
    
 }
}

