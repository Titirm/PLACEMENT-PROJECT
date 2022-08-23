
/**
 * Write a description of class CODE here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

    import java.awt.*;
import javax.swing.*;
class Welcome implements Runnable
{
JFrame f;
JLabel l1,l2,l3;
Thread t;
Login l;
ImageIcon img;
Welcome()
{
img=new ImageIcon("indian-rail.jpg");
t=new Thread(this);
f=new JFrame("Welcome");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.yellow);
l1=new JLabel("OnLine Reservation");
l1.setBounds(250,300,900,50);
l1.setFont(new Font("Courier new",Font.BOLD,60));
l1.setForeground(Color.red);
l2=new JLabel(" _By  Dushmanta Pradhan");
l2.setFont(new Font("Courier new",Font.BOLD,35));
l2.setBounds(350,380,800,40);
l2.setForeground(Color.red);
l3=new JLabel(img);
l3.setBounds(0,0,1300,1000);
f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(l3);
f.setSize(1300,1000);
f.setVisible(true);
t.start();
}
public void run()
{
int x=1;
while(x<=5)
{
try
{
Thread.sleep(1000);
}
catch(Exception e)
{}
x++;
}
f.setVisible(false);
l=new Login();
}
}


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Login implements ActionListener
{
JFrame f;
JLabel l1,l2;
JTextField t1;
JPasswordField t2;
JButton b1,b2;
Main M;
Login()
{
f=new JFrame("Login");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.pink);
l1=new JLabel("User Name");
l1.setForeground(Color.yellow);
l1.setBounds(50,50,100,30);
l2=new JLabel("Password");
l2.setForeground(Color.yellow);
l2.setBounds(50,80,100,30);
t1=new JTextField(10);
t1.setForeground(Color.blue);
t1.addActionListener(this);
t1.setBounds(150,50,100,30);
t2=new JPasswordField(10);
t2.setForeground(Color.blue);
t2.setEchoChar('*');
t2.addActionListener(this);
t2.setBounds(150,80,100,30);
b1=new JButton("Ok");
b1.setForeground(Color.blue);
b1.addActionListener(this);
b1.setBounds(50,120,100,30);
b2=new JButton("Cancel");
b2.setForeground(Color.blue);
b2.addActionListener(this);
b2.setBounds(180,120,100,30);

b1.setMnemonic('O');
b2.setMnemonic('C');

f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(t1);
f.getContentPane().add(t2);
f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.setBounds(300,300,300,200);
f.setResizable(false);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
if(t1.getText().length()==0||t2.getText().length()==0)
{
JOptionPane.showMessageDialog(null,"Fields are empty");
}
else if(t1.getText().equals("dush") && t2.getText().equals("1234"))
{
f.setVisible(false);
M=new Main();
}
else
{
JOptionPane.showMessageDialog(null,"Invalid User Name or Password");
}
}
if(e.getSource()==b2)
{
f.setVisible(false);
System.exit(0);
}
}
}




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Main implements ActionListener
{
JFrame f;
JButton b1,b2,b3,b4;
Reservation r;
Enquiry q;
Cancellation c;
JLabel imgL;
ImageIcon img;
Main()
{
img=new ImageIcon("Indian-Railway-Network.jpg");
imgL=new JLabel(img);
imgL.setBounds(0,0,1300,1000);
f=new JFrame("Main");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.green);
b1=new JButton("Reservation Form");
b1.addActionListener(this);
b1.setBounds(150,390,210,60);
b2=new JButton("PNR-enquiry");
b2.addActionListener(this);
b2.setBounds(150,490,210,60);
b3=new JButton("Cancellation Form");
b3.addActionListener(this);
b3.setBounds(580,390,210,60);
b4=new JButton("Exit");
b4.addActionListener(this);
b4.setBounds(580,490,210,60);

b1.setBackground(new Color(100,200,0));
b1.setForeground(new Color(255,255,255));
b2.setBackground(new Color(100,200,0));
b2.setForeground(new Color(255,255,255));
b3.setBackground(new Color(100,200,0));
b3.setForeground(new Color(255,255,255));
b4.setBackground(new Color(100,200,0));
b4.setForeground(new Color(255,255,255));

b1.setMnemonic('R');
b2.setMnemonic('P');
b3.setMnemonic('C');
b4.setMnemonic('E');

f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(b3);
f.getContentPane().add(b4);
f.getContentPane().add(imgL);
f.setSize(1300,1000);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
f.setVisible(false);
r=new Reservation();
}
if(e.getSource()==b2)
{
f.setVisible(false);
q=new Enquiry();
}
if(e.getSource()==b3)
{
f.setVisible(false);
c=new Cancellation();
}
if(e.getSource()==b4)
{
f.setVisible(false);
System.exit(0);
}
}
public static void main(String args[])
{
new Main();
}
}


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Reservation extends Connect implements ActionListener,FocusListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
JTextField t1,t2,t3,t4,t5,t6,t7;
Choice h;
JTextArea ta;
JButton b1,b2,b3;
PreparedStatement ps;
Statement st;
ResultSet rs;
int x;
JLabel imgL;
ImageIcon img;
void disable()
{
t1.setEnabled(false);
t2.setEnabled(false);
t3.setEnabled(false);
t4.setEnabled(false);
t5.setEnabled(false);
t6.setEnabled(false);
t7.setEnabled(false);
h.setEnabled(false);
b2.setEnabled(false);
}
void enable()
{
t1.setEnabled(true);
t2.setEnabled(true);
t3.setEnabled(true);
t4.setEnabled(true);
t5.setEnabled(true);
t6.setEnabled(true);
t7.setEnabled(true);
h.setEnabled(true);
b2.setEnabled(true);
}
Reservation()
{
img=new ImageIcon("LOGO1.jpg");
imgL=new JLabel(img);
imgL.setBounds(0,320,500,250);
f=new JFrame("Reservation");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.green);
l1=new JLabel("PNR No");
l1.setBounds(130,50,100,30);
l2=new JLabel("Train No");
l2.setBounds(50,80,100,30);
l3=new JLabel("Train Name");
l3.setBounds(50,110,100,30);
l4=new JLabel("Class");
l4.setBounds(50,140,100,30);
l5=new JLabel("Date of Journey");
l5.setBounds(50,170,100,30);
l6=new JLabel("From");
l6.setBounds(50,200,100,30);
l7=new JLabel("To");
l7.setBounds(250,200,50,30);
l8=new JLabel("Boarding at");
l8.setBounds(50,230,100,30);
t1=new JTextField(10);
t1.setBounds(230,50,120,30);
t2=new JTextField(10);
t2.addFocusListener(this);
t2.setBounds(150,80,100,30);
t3=new JTextField(10);
t3.setBounds(150,110,100,30);
t4=new JTextField(10);
t4.setBounds(150,170,100,30);
t5=new JTextField(10);
t5.setBounds(150,200,100,30);
t6=new JTextField(10);
t6.setBounds(300,200,100,30);
t7=new JTextField(10);
t7.setBounds(150,230,100,30);
h=new Choice();
h.setBounds(150,140,100,30);
h.add("AC");
h.add("SL");
b1=new JButton("Insert");
b1.setBackground(Color.yellow);
b1.setBounds(50,270,100,30);
b1.addActionListener(this);
b2=new JButton("Next");
b2.setBackground(Color.yellow);
b2.setBounds(160,270,100,30);
b2.addActionListener(this);
b3=new JButton("Main");
b3.setBackground(Color.yellow);
b3.setBounds(270,270,100,30);
b3.addActionListener(this);

b1.setMnemonic('I');
b2.setMnemonic('N');
b3.setMnemonic('M');

f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(l3);
f.getContentPane().add(l4);
f.getContentPane().add(l5);
f.getContentPane().add(l6);
f.getContentPane().add(l7);
f.getContentPane().add(l8);
f.getContentPane().add(t1);
f.getContentPane().add(t2);
f.getContentPane().add(t3);
f.getContentPane().add(t4);
f.getContentPane().add(t5);
f.getContentPane().add(t6);
f.getContentPane().add(t7);
f.getContentPane().add(h);
f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(b3);
f.getContentPane().add(imgL);
f.setSize(1300,1000);
f.setVisible(true);
disable();
}
public void focusLost(FocusEvent e)
{
if(t2.getText().length()!=0)
{
try
{
ps=con.prepareStatement("select Train_Name from Train where Train_No=?");
ps.setString(1,t2.getText());
rs=ps.executeQuery();
if(rs.next())
{
t3.setText(rs.getString(1));
}
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
}
public void focusGained(FocusEvent e)
{}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
enable();
b1.setEnabled(false);
try
{
st=con.createStatement();
rs=st.executeQuery("select * from PNR");
rs.next();
x=rs.getInt(1);
t1.setText(String.valueOf(x));

}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
if(e.getSource()==b2)
{
try
{
ps=con.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?,?)");
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,h.getSelectedItem());
ps.setString(5,t4.getText());
ps.setString(6,t5.getText());
ps.setString(7,t6.getText());
ps.setString(8,t7.getText());
ps.executeUpdate();


//update PNR no.
ps=con.prepareStatement("update PNR set PNR_No=? where PNR_No=?");
ps.setInt(1,(x+1));
ps.setInt(2,x);
ps.executeUpdate();
JOptionPane.showMessageDialog(null, "Record Saved");

b1.setEnabled(true);
b2.setEnabled(false);
f.setVisible(false);
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
try
{
st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery("select * from Reservation");
rs.last();
x=rs.getInt(1);
Passenger P=new Passenger(x);
st=con.createStatement();
rs=st.executeQuery("select * from PassengerID");
rs.next();
x=rs.getInt(1);
P.t1.setText(String.valueOf(x));
ps=con.prepareStatement("update PassengerID set PID=? where PID=?");
ps.setInt(1,(x+1));
ps.setInt(2,x);
ps.executeUpdate();
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
if(e.getSource()==b3)
{
f.setVisible(false);
new Main();
}
}
public static void main(String args[])
{
new Reservation();
}
}


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Passenger extends Connect implements ActionListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6;
JTextField t1,t2,t3;
JButton b1,b2,b3;
Checkbox c1,c2,c3,c4,c5;
CheckboxGroup cbg;
JTextArea ta;
PreparedStatement ps;
Statement st;
ResultSet rs;
int pno;
JLabel imgL;
ImageIcon img;
Passenger(int p)
{
pno=p;
img=new ImageIcon("LOGO2.jpg");
imgL=new JLabel(img);
imgL.setBounds(0,400,400,200);
f=new JFrame("Passenger");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.green);
l1=new JLabel("PId");
l1.setBounds(50,50,100,30);
t1=new JTextField(10);
t1.setBounds(170,50,100,30);
l2=new JLabel("Name of Passenger");
l2.setBounds(50,80,120,30);
t2=new JTextField(10);
t2.setBounds(170,80,100,30);
l3=new JLabel("Age");
l3.setBounds(50,130,100,30);
t3=new JTextField(10);
t3.setBounds(150,130,50,30);
l4=new JLabel("Gender");
l4.setBounds(250,130,50,30);
ta=new JTextArea(5,10);
ta.setBounds(150,170,130,70);
l5=new JLabel("Address");
l5.setBounds(50,170,100,30);
l6=new JLabel("Catagory");
l6.setBounds(50,240,100,30);
b1=new JButton("More");
b1.setBackground(Color.yellow);
b1.addActionListener(this);
b1.setBounds(50,330,100,30);
b2=new JButton("Save");
b2.setBackground(Color.yellow);
b2.addActionListener(this);
b2.setBounds(170,330,100,30);
b3=new JButton("Back");
b3.setBackground(Color.yellow);
b3.addActionListener(this);
b3.setBounds(290,330,100,30);

b1.setMnemonic('M');
b2.setMnemonic('S');
b3.setMnemonic('B');

cbg=new CheckboxGroup();
c1=new Checkbox("Male",cbg,true);
c1.setBounds(300,130,100,30);
c2=new Checkbox("Female",cbg,false); 
c2.setBounds(300,160,100,30);
c3=new Checkbox("General");
c3.setBounds(150,240,100,30);
c4=new Checkbox("Senior Citizen");
c4.setBounds(150,270,100,30);
c5=new Checkbox("Ex-serviceman");
c5.setBounds(150,300,100,30);
f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(l3);
f.getContentPane().add(l4);
f.getContentPane().add(l5);
f.getContentPane().add(l6);
f.getContentPane().add(t1);
f.getContentPane().add(t2);
f.getContentPane().add(t3);
f.getContentPane().add(ta);
f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(b3);
f.getContentPane().add(c1);
f.getContentPane().add(c2);
f.getContentPane().add(c3);
f.getContentPane().add(c4);
f.getContentPane().add(c5);
f.getContentPane().add(imgL);
f.setSize(1300,1000);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
try
{
//saving existing record
String cat="";
ps=con.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?)");
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,cbg.getSelectedCheckbox().getLabel());
ps.setString(5,ta.getText());
if(c3.getState())
cat+=c3.getLabel()+",";
if(c4.getState())
cat+=c4.getLabel()+",";
if(c5.getState())
cat+=c5.getLabel()+",";
ps.setString(6,cat);
ps.setInt(7,pno);
ps.executeUpdate();
ps.close();

//opening new form
Passenger P=new Passenger(pno);
st=con.createStatement();
rs=st.executeQuery("select * from PassengerID");
rs.next();
int x=rs.getInt(1);
P.t1.setText(String.valueOf(x));
st.close();
//update passenger id
ps=con.prepareStatement("update PassengerID set PID=? where PID=?");
ps.setInt(1,(x+1));
ps.setInt(2,x);
ps.executeUpdate();
ps.close();
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
if(e.getSource()==b2)
{

try
{
String cat="";
ps=con.prepareStatement("insert into TempPassenger values(?,?,?,?,?,?,?)");
ps.setString(1,t1.getText());
ps.setString(2,t2.getText());
ps.setString(3,t3.getText());
ps.setString(4,cbg.getSelectedCheckbox().getLabel());
ps.setString(5,ta.getText());
if(c3.getState())
cat+=c3.getLabel()+",";
if(c4.getState())
cat+=c4.getLabel()+",";
if(c5.getState())
cat+=c5.getLabel()+",";
ps.setString(6,cat);
ps.setInt(7,pno);
ps.executeUpdate();
ps.close();

st=con.createStatement();
rs=st.executeQuery("select * from TempPassenger");
while(rs.next())
{
ps=con.prepareStatement("insert into Passenger values(?,?,?,?,?,?,?)");
ps.setString(1,rs.getString(1));
ps.setString(2,rs.getString(2));
ps.setString(3,rs.getString(3));
ps.setString(4,rs.getString(4));
ps.setString(5,rs.getString(5));
ps.setString(6,rs.getString(6));
ps.setString(7,rs.getString(7));
ps.executeUpdate();
ps.close();
}
st=con.createStatement();
st.executeUpdate("delete from TempPassenger");
JOptionPane.showMessageDialog(null,"Record Saved");
b2.setEnabled(false);
b1.setEnabled(false);
st.close();
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}

if(e.getSource()==b3)
{
f.setVisible(false);
new Reservation();
}
}
public static void main(String args[])
{
new Passenger(0);
}
}


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Enquiry extends Connect implements ActionListener
{
JFrame f;
JLabel l1,l2;
JTextField t;
List li;
JButton b1,b2;
PreparedStatement ps;
ResultSet rs;
JLabel imgL;
ImageIcon img; 
Enquiry()
{
img=new ImageIcon("LOGO1.jpg");
imgL=new JLabel(img);
imgL.setBounds(0,340,500,200);
f=new JFrame("PNR-Enquiry");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.green);
l1=new JLabel("PNR No");
l1.setBounds(50,50,60,30);
l2=new JLabel("PNR Details");
l2.setBounds(50,80,100,30);
t=new JTextField(10);
t.addActionListener(this);
t.setBounds(110,50,150,30);
li=new List();
li.setBounds(50,110,390,180);
b1=new JButton("Check");
b1.setBackground(Color.yellow);
b1.addActionListener(this);
b1.setBounds(70,300,100,30);
b2=new JButton("Back");
b2.setBackground(Color.yellow);
b2.addActionListener(this);
b2.setBounds(210,300,100,30);

b1.setMnemonic('C');
b2.setMnemonic('B');

f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(t);
f.getContentPane().add(li);
f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(imgL);
f.setSize(1300,1000);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
try
{
//reservation information
ps=con.prepareStatement("select * from Reservation where PNR_No=?");
ps.setString(1,t.getText());
rs=ps.executeQuery();
rs.next();
li.clear();
li.add("Train No.: "+rs.getString(2));
li.add("Train Name: "+rs.getString(3));
li.add("Class: "+rs.getString(4));
li.add("Date of Journey: "+rs.getString(5));
li.add("From: "+rs.getString(6));
li.add("To: "+rs.getString(7));
li.add("Boarding at: "+rs.getString(8));

//passeneger information
ps=con.prepareStatement("select * from Passenger where PNR_No=?");
ps.setString(1,t.getText());
rs=ps.executeQuery();
while(rs.next())
{
li.add("Passenger Name: "+rs.getString(2));
li.add("Age: "+rs.getString(3));
li.add("Gender: "+rs.getString(4));
}
}
catch(Exception e1)
{
System.out.println("connection failed:"+e1);
}
}
if(e.getSource()==b2)
{
f.setVisible(false);
new Main();
}
}
public static void main(String args[])
{
new Enquiry();
}
}



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Cancellation extends Connect implements ActionListener,ItemListener
{
JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JTextField t1,t2,t3,t4,t5,t6,t7;
JButton b1,b2;
Choice h;
List li;
PreparedStatement ps;
ResultSet rs;
Statement st;
Cancellation()
{
f=new JFrame("Cancellation");
f.getContentPane().setLayout(null);
f.getContentPane().setBackground(Color.green);
l1=new JLabel("PNR No");
l1.setBounds(130,50,50,30);
l2=new JLabel("Train No");
l2.setBounds(50,90,100,30);
l3=new JLabel("Train Name");
l3.setBounds(50,120,100,30);
l4=new JLabel("Class");
l4.setBounds(50,150,100,30);
l5=new JLabel("Date of Journey");
l5.setBounds(50,180,100,30);
l6=new JLabel("From");
l6.setBounds(50,210,100,30);
l7=new JLabel("To");
l7.setBounds(250,210,50,30);
l8=new JLabel("Boarding at");
l8.setBounds(50,240,100,30);
l9=new JLabel("Name of Passenger");
l9.setBounds(90,290,120,30);
l10=new JLabel("Age");
l10.setBounds(240,290,30,30);
l11=new JLabel("Gender");
l11.setBounds(290,290,100,30);
b1=new JButton("Ok");
b1.setBackground(Color.yellow);
b1.addActionListener(this);
b1.setBounds(50,480,100,30);
b2=new JButton("Back");
b2.setBackground(Color.yellow);
b2.addActionListener(this);
b2.setBounds(200,480,100,30);

b1.setMnemonic('O');
b2.setMnemonic('B');

h=new Choice();
h.setBounds(230,50,140,30);
h.addItemListener(this);
t1=new JTextField(10);
t1.addActionListener(this);
t1.setBounds(150,90,100,30);
t2=new JTextField(10);
t2.addActionListener(this);
t2.setBounds(150,120,100,30);
t3=new JTextField(10);
t3.addActionListener(this);
t3.setBounds(150,150,100,30);
t4=new JTextField(10);
t4.addActionListener(this);
t4.setBounds(150,180,100,30);
t5=new JTextField(10);
t5.addActionListener(this);
t5.setBounds(150,210,100,30);
t6=new JTextField(10);
t6.addActionListener(this);
t6.setBounds(300,210,100,30);
t7=new JTextField(10);
t7.addActionListener(this);
t7.setBounds(150,240,100,30);
li=new List(5,true);
li.setBounds(80,320,320,100);
f.getContentPane().add(l1);
f.getContentPane().add(l2);
f.getContentPane().add(l3);
f.getContentPane().add(l4);
f.getContentPane().add(l5);
f.getContentPane().add(l6);
f.getContentPane().add(l7);
f.getContentPane().add(l8);
f.getContentPane().add(l9);
f.getContentPane().add(l10);
f.getContentPane().add(l11);
f.getContentPane().add(b1);
f.getContentPane().add(b2);
f.getContentPane().add(h);
f.getContentPane().add(t1);
f.getContentPane().add(t2);
f.getContentPane().add(t3);
f.getContentPane().add(t4);
f.getContentPane().add(t5);
f.getContentPane().add(t6);
f.getContentPane().add(t7);
f.getContentPane().add(li);
f.setSize(1300,1000);
f.setVisible(true);
start();
}
public void start()
{
try
{
st=con.createStatement();
rs=st.executeQuery("select * from Reservation");
while(rs.next())
{
h.add(rs.getString(1));
}
}
catch(Exception e)
{
System.out.println("Connection failed:"+e);
}
}
public void itemStateChanged(ItemEvent e)
{
System.out.println((String)h.getSelectedItem());
try
{
li.removeAll();
ps=con.prepareStatement("select * from Reservation where PNR_No=?");
ps.setString(1,h.getSelectedItem());
rs=ps.executeQuery();
rs.next();
t1.setText(rs.getString(2));
t2.setText(rs.getString(3));
t3.setText(rs.getString(4));
t4.setText(rs.getString(5));
t5.setText(rs.getString(6));
t6.setText(rs.getString(7));
t7.setText(rs.getString(8));
ps=con.prepareStatement("select * from Passenger where PNR_No=?");
ps.setString(1,h.getSelectedItem());
rs=ps.executeQuery();
while(rs.next())
{
li.add(rs.getString(2)+"                                  "+rs.getString(3)+"                           "+rs.getString(4));
}
}
catch(Exception e1)
{
System.out.println("Connection failed"+e1);
}
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{
try
{
ps=con.prepareStatement("delete from Reservation where PNR_No=?");
ps.setString(1,h.getSelectedItem());
ps.executeUpdate();

ps=con.prepareStatement("delete from Passenger where PNR_No=?");
ps.setString(1,h.getSelectedItem());
ps.executeUpdate();

JOptionPane.showMessageDialog(null,"Reservation Cancelled");
f.setVisible(false);
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
if(e.getSource()==b2)
{
f.setVisible(false);
new Main();
}
}
public static void main(String args[])
{
new Cancellation();
}}


import java.sql.*;
public class Connect
{
public Connection con;
public Connect()
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=Railway.mdb;DriverID=22");
}
catch(Exception e1)
{
System.out.println("Connection failed:"+e1);
}
}
}