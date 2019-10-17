//package javaPratical9;
//import javaPratical9.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class Search  implements ActionListener
{
	JFrame f;
			JLabel l1,l2,l3,l4,l5;
			JTextField tf1,tf2,tf3,tf4;
		JButton btn1,btn2;
	Search()
	{
			f=new JFrame(" stock management system");
			f.setVisible(true);
			f.setSize(800,800);
			l1=new JLabel("Insert Stock Item into the system");
			l2 = new JLabel("Enter Item  ID");
			l3 = new JLabel("Enter Item Type");
			l4 = new JLabel("Enter Item Price");
			l5 = new JLabel("Enter Item Quantaty");
			tf1 = new JTextField();
			tf2 = new JTextField();
			tf3 = new JTextField();
			tf4 = new JTextField();
			btn1 = new JButton("Submit");
			btn2 = new JButton("Update");
			l1.setBounds(100,30,400,30);
			l2.setBounds(80,70,200,30);
			l3.setBounds(80,110,200,30);
			l4.setBounds(80,150,200,30);
			l5.setBounds(80,190,200,30);
			tf1.setBounds(300,70,200,30);
			tf2.setBounds(300,110,200,30);
			tf3.setBounds(300,150,200,30);
			tf4.setBounds(300,190,200,30);
			btn1.setBounds(150,240,100,30);
			btn2.setBounds(160,240,250,30);
			f.add(l1);
			f.add(l2);
			f.add(tf1);
			f.add(l3);
			f.add(tf2);
			f.add(l4);
			f.add(tf3);
			f.add(l5);
			f.add(tf4);
			f.add(btn1);
			f.add(btn2);
			f.setLayout(null);
			btn1.addActionListener(this);
			btn2.addActionListener(this);
	}
	 public void actionPerformed(ActionEvent e)
	 {
		 		if(e.getSource()==btn1)
		 		{
	 				 Function f = new Function();
					    ResultSet rs = null;
					    String iN = "itemNumber";
					    String iT = "itemType";
					    String iP = "itemPrice";
					    String iQ="itemQty";



					    rs = f.find(tf1.getText());
					    try{
					      if(rs.next()){
					          tf2.setText(rs.getString("itemType"));
					            tf3.setText(rs.getString("itemPrice"));
					              tf4.setText(rs.getString("itemQty"));
					      }  else{

					          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
					      }
					    }catch(Exception ex){
					           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
		}
		if(e.getSource()==btn2)
		{
				//	Function f = new Function();
					Function1 s = new Function1();
										    ResultSet rs = null;
										    String iN = "itemNumber";
										    String iT = "itemType";
										    String iP = "itemPrice";
										    String iQ="itemQty";
										int    a = Integer.parseInt(tf3.getText());
										int     b = Integer.parseInt(tf4.getText());

										    s.find1(tf1.getText());
		}
	}

             public class Function{
			       Connection con = null;
			       ResultSet rs = null;
			       PreparedStatement ps = null;
			       public ResultSet find(String s){
			           try{
			           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userregist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			           ps = con.prepareStatement("select * from item where itemNumber = ? ");
			           ps.setString(1,s);
			            rs=ps.executeQuery();
			           }catch(Exception ex){
			              JOptionPane.showMessageDialog(null, ex.getMessage());
			           }
			           return rs;
			       }
			   }
			public class Function1
			{
				  Connection con = null;
			       ResultSet rs = null;
			       PreparedStatement ps = null;
			       String t2 = tf2.getText();
			       int t3=Integer.parseInt(tf3.getText());
			       int t4=Integer.parseInt(tf4.getText());
			       public void find1(String s){
			           try{
			           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userregist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			           ps = con.prepareStatement("update item set itemType = ? ,itemPrice = ? ,itemQty = ?  where itemNumber = ? ");
			           ps.setString(1,t2);
			           ps.setInt(2,t3);
			            ps.setInt(3,t4);
			            ps.setString(4,s);
			            ps.executeUpdate();
			           }catch(Exception ex){
			              JOptionPane.showMessageDialog(null, ex.getMessage());
			           }

			       }
			}
			 public static void main(String[] args){
			  new Search();
 		}


}