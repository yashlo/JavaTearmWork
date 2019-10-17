package St;
//import St.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Home implements  ActionListener
{

	JButton Update,Display,Insert;
	JLabel l1,l2,l3,l4,l5;
	 JFrame frame = new JFrame("Home");
	 JMenuBar mbar = new JMenuBar();
	Home(){
	l1=new JLabel("Select Option");
	 l2=new JLabel("Update");
	 l3=new JLabel("Display");
	 l4=new JLabel("Insert");
	 frame.setVisible(true);
	 frame.setSize(800,800);
	 Update = new JButton("Update");
	 Display = new JButton("Display");
	 Insert = new JButton("Insert");
	 l1.setBounds(100,30,400,30);
	 l2.setBounds(80,70,200,30);
	 l3.setBounds(80,110,200,30);
	 l4.setBounds(80,150,200,30);
	 Update.setBounds(300,70,200,30);
	 Display.setBounds(300,110,200,30);
	 Insert.setBounds(300,150,200,30);
	 l5=new JLabel("");
	 l5.setBounds(400,400,400,400);
	 frame.add(l1);
	 frame.add(l2);
	 frame.add(Update);
	  frame.add(l3);
	  frame.add(Display);
	 frame.add(l4);
	 frame.add(Insert);
	 frame.add(l5);
	 Update.addActionListener(this);
	 Display.addActionListener(this);
	 Insert.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
				{
					if(e.getSource()==Update)
					{
					Update s =new Update();
					}
					else if(e.getSource()==Display)
					{
						SearchResult sr = new SearchResult();
						sr.createUI();
					}
					else
					{
							ItemInsert i = new ItemInsert();
					}
			}
	/*public static void main(String []args)
	{
		Home h= new Home();

	}*/






}