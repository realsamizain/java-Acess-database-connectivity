import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
public class Driver implements ActionListener{
JButton b1;
JButton b2;
JTextField tname;
JTextField tcnic;
JTextField tdob;
JTextField taddress;
JTextField tid;
JTextField tprogram;
JTextField temail;
public void initDriver(){
JFrame window=new JFrame("Registration Form");
Container c=window.getContentPane();
c.setLayout(new FlowLayout());
JLabel lname = new JLabel("Student Name");
tname = new JTextField(20);
JLabel lcnic = new JLabel("Student CNIC");
tcnic= new JTextField(20);
JLabel ldob = new JLabel("Date of Birth");
tdob= new JTextField(20);
JLabel laddress = new JLabel("Address");
taddress = new JTextField(20);
JLabel lid = new JLabel("Stdent ID");
tid = new JTextField(20);
JLabel lprogram = new JLabel("Study program");
tprogram = new JTextField(20);
JLabel lemail= new JLabel("Email");
temail = new JTextField(20);
b1=new JButton("Register");
b2=new JButton("Search");
c.add(lname);
c.add(tname);
c.add(lcnic);
c.add(tcnic);
c.add(ldob);
c.add(tdob);
c.add(laddress);
c.add(taddress);
c.add(lid);
c.add(tid);
c.add(lprogram);
c.add(tprogram);
c.add(lemail);
c.add(temail);
c.add(b1);
c.add(b2);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setSize(270,410);
window.setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
}
public Driver(){
initDriver();
}
public void actionPerformed(ActionEvent event)
{
if(event.getSource()==b1){
student b = new student(tname.getText(), tdob.getText(),tcnic.getText(),taddress.getText(),tprogram.getText(),tid.getText(),temail.getText());
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:mc160401491"; //Here is mc160401491 is datasource name...
Connection con=DriverManager.getConnection(url);
Statement s = con.createStatement();
String st = "INSERT INTO Registration VALUES (?,?,?,?,?,?,?)";
PreparedStatement stmt = con.prepareStatement(st);
stmt.setString(1,b.getname());
stmt.setString(2, b.getcnic());
stmt.setString(3,b.getdob());
stmt.setString(4,b.getaddress());
stmt.setString(5,b.getid());
stmt.setString(6, b.getprogram());
stmt.setString(7,b.getemail());
stmt.executeUpdate();
}
catch(Exception sqlEx){
System.out.println(sqlEx);
}
}
if(event.getSource()==b2){
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url="jdbc:odbc:mc160401491";
Connection con=DriverManager.getConnection(url);
Statement s = con.createStatement();
String stu = JOptionPane.showInputDialog("Student Name or CNIC");
String st = "SELECT * FROM Registration WHERE Sname='"+stu+"' OR Scnic='"+stu+"'";
s.execute(st);
ResultSet rs = s.getResultSet();
while((rs!=null) && (rs.next())){
String name=rs.getString("Sname");
String cnic=rs.getString("Scnic");
String dob=rs.getString("DOB");
String add=rs.getString("Address");
String id=rs.getString("SID");
String prog=rs.getString("Program");
String email=rs.getString("Email");
JOptionPane.showMessageDialog(null,"Student Name:"+name+ "\nStdent CNIC"+ cnic+"\nDate of Birth: "+dob+"\nAddress: "+add+"\nStudent ID:"+id+"\nStudent Program:"+prog+"\nEmail: "+email);
System.out.println(name);
break;
}  
con.close();            
}
catch(Exception sqlEx){
System.out.println(sqlEx);
}}}
public static void main(String args[]){
Driver gui=new Driver();
}}