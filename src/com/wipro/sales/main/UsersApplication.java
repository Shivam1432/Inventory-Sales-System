package com.wipro.sales.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.wipro.sales.bean.Orders;
import com.wipro.sales.bean.Receipt;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.User;
import com.wipro.sales.util.DBUtil;

import net.proteanit.sql.DbUtils;

public class UsersApplication {
  User user=new User();
  JFrame f;
  JTable table;
  JTextField t1,t2,t3,t4,t5;
	UsersApplication(){
	    f = new JFrame("User Page");
		f.setBounds(100, 100, 825, 532);
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1706, 33);
		f.getContentPane().add(panel);
		
		JButton b1 = new JButton("View Stock");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.RED);
		b1.setBounds(64, 49, 134, 33);
		f.add(b1);
		b1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b2 = new JButton("Place Order");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
		b2.setBounds(321, 49, 141, 35);
		f.add(b2);
		b2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton b3 = new JButton("View Receipt");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.RED);
		b3.setBounds(592, 49, 141, 35);
		f.add(b3);
		b3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.DARK_GRAY);
		p2.setBounds(10,122,791,363);
		f.getContentPane().add(p2);
		p2.setLayout(null);
		p2.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		p2.add(scrollPane);
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(10, 25, 769, 120);
	
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.DARK_GRAY);
		p3.setBounds(10,122,791,363);
		f.getContentPane().add(p3);
		p3.setLayout(null);
		p3.setVisible(false);
		
		JLabel l1 = new JLabel("Enter Product Name: ");
		l1.setForeground(Color.WHITE);
		l1.setBounds(37, 36, 160, 13);
		p3.add(l1);
		
		t1 = new JTextField();
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setColumns(10);
		t1.setBounds(37, 63, 214, 19);
		p3.add(t1);
		
		JLabel l2 = new JLabel("Enter Product ID: ");
		l2.setForeground(Color.WHITE);
		l2.setBounds(37, 129, 148, 13);
		p3.add(l2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setBounds(37, 152, 214, 19);
		p3.add(t2);
		
		JLabel l3 = new JLabel("Enter Quantity: ");
		l3.setForeground(Color.WHITE);
		l3.setBounds(458, 36, 183, 13);
		p3.add(l3);
		
		t3 = new JTextField();
		t3.setBackground(Color.LIGHT_GRAY);
		t3.setColumns(10);
		t3.setBounds(458, 63, 214, 19);
		p3.add(t3);
		
		t4 = new JTextField();
		t4.setBackground(Color.LIGHT_GRAY);
		t4.setColumns(10);
		t4.setBounds(458, 152, 212, 19);
		p3.add(t4);
		
		JLabel l4 = new JLabel("Enter UserName: ");
		l4.setForeground(Color.WHITE);
		l4.setBounds(458, 129, 183, 13);
		p3.add(l4);
		
		JButton b4 = new JButton("Submit");
		b4.setForeground(Color.WHITE);
		b4.setBackground(new Color(72, 209, 204));
		b4.setBounds(311, 236, 85, 21);
		p3.add(b4);
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.DARK_GRAY);
		p4.setBounds(10,122,791,363);
		f.getContentPane().add(p4);
		p4.setLayout(null);
		p4.setVisible(false);
		
		JLabel l5 = new JLabel("Enter UserName: ");
		l5.setForeground(Color.WHITE);
		l5.setBounds(37, 36, 160, 13);
		p4.add(l5);
		
		t5 = new JTextField();
		t5.setBackground(Color.LIGHT_GRAY);
		t5.setColumns(10);
		t5.setBounds(37, 63, 214, 19);
		p4.add(t5);
		
		JButton b5 = new JButton("Submit");
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(72, 209, 204));
		b5.setBounds(311, 236, 85, 21);
		p4.add(b5);
	    
		JTextArea t = new JTextArea();
		t.setBackground(Color.PINK);
		t.setBounds(62, 30, 687, 274);
		p4.add(t);
		t.setVisible(false);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(true);
				p3.setVisible(false);
				p4.setVisible(false);
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql="select * from HR.TBL_STOCK";
				try {
					conn = DBUtil.getDBConnection();
					pstmt = conn.prepareStatement(sql);
					ResultSet rs=pstmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p3.setVisible(true);
				p2.setVisible(false);
				p4.setVisible(false);
			}	
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders order=new Orders();
				String pname=t1.getText();
				String pid=t2.getText();
				String qty=t3.getText();
				int q=Integer.parseInt(qty);
				String uname=t4.getText();
				String item="No";
				if(pname.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Product Name cannot be empty");
					t1.setText("");
				}
				if(q<0 || qty.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Quantity must be a positive number");
					t3.setText("");
				}
				if(pid.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Product ID cannot be empty");
					t2.setText("");
				}
				if(uname.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Username cannot be empty");
					t4.setText("");
				}
				else
				{
					order.setProductName(pname);
					order.setProductID(pid);
					order.setQuantity(q);
					order.setUname(uname);
					order.setItemSold(item);
				}
				String str=user.insertOrder(order);
				JOptionPane.showMessageDialog(null,str);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p4.setVisible(true);
				p3.setVisible(false);
				p2.setVisible(false);
				t.setVisible(false);
				t5.setVisible(true);
				l5.setVisible(true);
				b5.setVisible(true);
			}	
		});
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t5.setVisible(false);
				l5.setVisible(false);
				b5.setVisible(false);
				String uname=t5.getText();
				ArrayList<Receipt> l=new ArrayList<Receipt>();
				l=user.getReceipt(uname);
				if(l.isEmpty())
				{
					String str="Your order is being processed.Please wait!!";
					JOptionPane.showMessageDialog(null,str);
				}
				else
				{
					t.setVisible(true);
					String data="";
					int i=1;
					String newLine="\n";
					for(Receipt r:l)
					{
						data+=String.valueOf("\t\t***************************RECEIPT "+i+"***************************"+newLine+newLine);
						//data+=String.valueOf("Sales ID  \tSales Date  \tProduct ID  \tProduct Name  \tQuantity Sold  \tSales Price Per Unit  \tCustomer ID \n");
						data+=String.valueOf("\t1.  Sales ID: \t\t\t\t\t"+r.getSalesID()+" "+newLine);
						data+=String.valueOf("\t2.  Sales Date: \t\t\t\t\t"+r.getSalesDate()+" "+newLine);
						data+=String.valueOf("\t3.  Product ID: \t\t\t\t\t"+r.getProductID()+" "+newLine);
						data+=String.valueOf("\t4.  Product Name: \t\t\t\t"+r.getProductName()+" "+newLine);
						data+=String.valueOf("\t5.  Quantity: \t\t\t\t\t"+r.getQuantity()+" "+newLine);
						data+=String.valueOf("\t6.  Sales Price Per Unit \t\t\t\t"+r.getSalesPricePerUnit()+" "+newLine);
						data+=String.valueOf("\t7.  Customer Name/ID: \t\t\t\t"+r.getUserName()+" "+newLine+newLine);
						data+=newLine;
						data+=newLine;
						data+=String.valueOf("\t***************************THANK YOU FOR SHOPPING WITH US***************************"+newLine);
						data+=newLine;
						data+=newLine;
						data+=newLine;
						data+=newLine;
						i++;
					}
					t.setText(data);
				}
			}
		});
  }
  public static void main(String[] args)
  {
	  new UsersApplication();
  }
}
