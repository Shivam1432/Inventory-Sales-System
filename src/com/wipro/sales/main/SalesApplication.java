package com.wipro.sales.main;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.*;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Sales;
import com.toedter.calendar.JDateChooser;
import com.wipro.sales.bean.Product;
import com.wipro.sales.service.Administrator;
import com.wipro.sales.util.DBUtil;

import net.proteanit.sql.DbUtils;
public class SalesApplication {
	Administrator admin = new Administrator();
	JFrame f;
	JTable table,table1,table2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
	SalesApplication()
	{
		f = new JFrame("Stock Management");
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.setBounds(0, 0, 1220, 751);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		f.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1706, 33);
		f.getContentPane().add(panel);
		
		JButton b1 = new JButton("Insert Stock");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.RED);
		b1.setBounds(42, 43, 149, 36);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("Delete Stock");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.RED);
		b2.setBounds(42, 127, 149, 36);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("Insert Sales");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.RED);
		b3.setBounds(42, 216, 149, 36);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("Sales Report");
		b4.setForeground(Color.WHITE);
		b4.setBackground(Color.RED);
		b4.setBounds(42, 302, 149, 36);
		f.getContentPane().add(b4);
		
		JButton b8 = new JButton("Refill Stock");
		b8.setForeground(Color.WHITE);
		b8.setBackground(Color.RED);
		b8.setBounds(42, 390, 149, 36);
		f.getContentPane().add(b8);
		
		JButton b10 = new JButton("Display Stock");
		b10.setForeground(Color.WHITE);
		b10.setBackground(Color.RED);
		b10.setBounds(42, 484, 149, 36);
		f.getContentPane().add(b10);
		
		JButton b11 = new JButton("View Orders");
		b11.setForeground(Color.WHITE);
		b11.setBackground(Color.RED);
		b11.setBounds(42, 574, 149, 36);
		f.getContentPane().add(b11);
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.DARK_GRAY);
		p1.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p1);
		p1.setLayout(null);
		p1.setVisible(false);
		
		JLabel l1 = new JLabel("Enter Product Name: ");
		l1.setForeground(Color.WHITE);
		l1.setBounds(50, 57, 255, 13);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setBackground(Color.LIGHT_GRAY);
		t1.setColumns(10);
		t1.setBounds(50, 80, 255, 19);
		p1.add(t1);
		
		JLabel l2 = new JLabel("Enter Quantity on Hand: ");
		l2.setForeground(Color.WHITE);
		l2.setBounds(379, 57, 255, 13);
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBackground(Color.LIGHT_GRAY);
		t2.setBounds(379, 80, 255, 19);
		p1.add(t2);
		
		JLabel l3 = new JLabel("Enter Product Unit Price: ");
		l3.setForeground(Color.WHITE);
		l3.setBounds(50, 150, 255, 13);
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setBackground(Color.LIGHT_GRAY);
		t3.setColumns(10);
		t3.setBounds(50, 173, 255, 19);
		p1.add(t3);
		
		t4 = new JTextField();
		t4.setBackground(Color.LIGHT_GRAY);
		t4.setColumns(10);
		t4.setBounds(379, 173, 255, 19);
		p1.add(t4);
		
		JLabel l4 = new JLabel("Enter Reorder Level: ");
		l4.setForeground(Color.WHITE);
		l4.setBounds(379, 150, 255, 13);
		p1.add(l4);
		
		JButton b5 = new JButton("Submit");
		b5.setForeground(Color.WHITE);
		b5.setBackground(new Color(72, 209, 204));
		b5.setBounds(275, 241, 136, 36);
		p1.add(b5);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.DARK_GRAY);
		p3.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p3);
		p3.setLayout(null);
		p3.setVisible(false);
		
		JLabel l6 = new JLabel("Enter Date:");
		l6.setForeground(Color.WHITE);
		l6.setBounds(48, 53, 255, 13);
		p3.add(l6);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(48, 76, 255, 19);
		p3.add(date);
		
		JLabel l7 = new JLabel("Enter Product ID: ");
		l7.setForeground(Color.WHITE);
		l7.setBounds(354, 53, 255, 13);
		p3.add(l7);
		
		JLabel l8 = new JLabel("Enter Quantity Sold: ");
		l8.setForeground(Color.WHITE);
		l8.setBounds(48, 154, 255, 13);
		p3.add(l8);
		
		t7 = new JTextField();
		t7.setBackground(Color.LIGHT_GRAY);
		t7.setColumns(10);
		t7.setBounds(48, 177, 255, 19);
		p3.add(t7);
		
		t6 = new JTextField();
		t6.setBackground(Color.LIGHT_GRAY);
		t6.setColumns(10);
		t6.setBounds(354, 76, 255, 19);
		p3.add(t6);
		
		JLabel l9 = new JLabel("Enter Sales Price Per Unit: ");
		l9.setForeground(Color.WHITE);
		l9.setBounds(354, 154, 255, 13);
		p3.add(l9);
		
		t8 = new JTextField();
		t8.setBackground(Color.LIGHT_GRAY);
		t8.setColumns(10);
		t8.setBounds(354, 177, 255, 19);
		p3.add(t8);
		
		JLabel l12 = new JLabel("Enter UserName: ");
		l12.setForeground(Color.WHITE);
		l12.setBounds(48, 254, 255, 13);
		p3.add(l12);
		
		t11 = new JTextField();
		t11.setBackground(Color.LIGHT_GRAY);
		t11.setColumns(10);
		t11.setBounds(48, 277, 255, 19);
		p3.add(t11);
		
		JButton b7 = new JButton("Submit");
		b7.setForeground(Color.WHITE);
		b7.setBackground(new Color(72, 209, 204));
		b7.setBounds(275, 341, 136, 36);
		p3.add(b7);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.DARK_GRAY);
		p2.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p2);
		p2.setLayout(null);
		p2.setVisible(false);
		
		JLabel l5 = new JLabel("Enter Product ID to be deleted: ");
		l5.setForeground(Color.WHITE);
		l5.setBounds(42, 32, 255, 13);
		p2.add(l5);
		
		t5 = new JTextField();
		t5.setBackground(Color.LIGHT_GRAY);
		t5.setColumns(10);
		t5.setBounds(42, 55, 255, 19);
		p2.add(t5);
		
		JButton b6 = new JButton("Submit");
		b6.setForeground(Color.WHITE);
		b6.setBackground(new Color(72, 209, 204));
		b6.setBounds(107, 129, 136, 36);
		p2.add(b6);
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.DARK_GRAY);
		p4.setBounds(243, 33, 890, 681);
		f.getContentPane().add(p4);
		p4.setLayout(null);
		p4.setVisible(false);
		
		/*JTextArea t = new JTextArea();
		t.setBackground(Color.ORANGE);
		t.setBounds(28, 34, 737, 366);
		p4.add(t);*/
		JScrollPane scrollPane1 = new JScrollPane();
		p4.add(scrollPane1);
		scrollPane1.setBackground(new Color(230, 230, 250));
		scrollPane1.setBounds(10, 25, 869, 120);
		
		table1 = new JTable();
		scrollPane1.setViewportView(table1);
		
		JPanel p5 = new JPanel();
		p5.setBackground(Color.DARK_GRAY);
		p5.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p5);
		p5.setLayout(null);
		p5.setVisible(false);
		
		t9 = new JTextField();
		t9.setBackground(Color.LIGHT_GRAY);
		t9.setBounds(51, 80, 253, 19);
		p5.add(t9);
		t9.setColumns(10);
		
		JLabel l10 = new JLabel("Enter Product ID");
		l10.setForeground(Color.WHITE);
		l10.setBounds(51, 57, 253, 13);
		p5.add(l10);
		
		JLabel l11 = new JLabel("Enter quantity:");
		l11.setForeground(Color.WHITE);
		l11.setBounds(51, 160, 253, 13);
		p5.add(l11);
		
		t10 = new JTextField();
		t10.setBackground(Color.LIGHT_GRAY);
		t10.setBounds(51, 183, 253, 19);
		p5.add(t10);
		t10.setColumns(10);
		
		JButton b9 = new JButton("Submit");
		b9.setForeground(Color.WHITE);
		b9.setBackground(new Color(72, 209, 204));
		b9.setBounds(51, 250, 136, 36);
		p5.add(b9);
		
		JPanel p6 = new JPanel();
		p6.setBackground(Color.DARK_GRAY);
		p6.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p6);
		p6.setLayout(null);
		p6.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		p6.add(scrollPane);
		scrollPane.setBackground(new Color(230, 230, 250));
		scrollPane.setBounds(10, 25, 769, 120);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel p7 = new JPanel();
		p7.setBackground(Color.DARK_GRAY);
		p7.setBounds(243, 33, 763, 681);
		f.getContentPane().add(p7);
		p7.setLayout(null);
		p7.setVisible(false);
		
		JScrollPane scrollPane2 = new JScrollPane();
		p7.add(scrollPane2);
		scrollPane2.setBackground(new Color(230, 230, 250));
		scrollPane2.setBounds(10, 25, 769, 120);
		
		
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(true);
				p4.setVisible(false);
				p3.setVisible(false);
				p2.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(true);
				p4.setVisible(false);
				p3.setVisible(false);
				p1.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p3.setVisible(true);
				p4.setVisible(false);
				p1.setVisible(false);
				p2.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p4.setVisible(true);
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
				ArrayList<SalesReport> l=new ArrayList<SalesReport>();
				l=admin.getSalesReport();
				/*String data="";
				String newLine="\n";
				data+=String.valueOf("Sales ID  \tSales Date  \tProduct ID  \tProduct Name  \tQuantity Sold  \tProduct Unit Price  \tSales Price Per Unit  \tProfit Amount \n");
				for(SalesReport r:l)
				{
					data+=String.valueOf(r.getSalesID()+" ");
					data+=String.valueOf("\t "+r.getSalesDate()+" ");
					data+=String.valueOf("\t "+r.getProductID()+" ");
					data+=String.valueOf("\t "+r.getProductName()+" ");
					data+=String.valueOf("\t "+r.getQuantitySold()+" ");
					data+=String.valueOf("\t"+r.getProductUnitPrice()+" ");
					data+=String.valueOf("\t \t"+r.getSalesPricePerUnit()+" ");
					data+=String.valueOf("\t \t"+r.getProfitAmount());
					data+=newLine;
				}
				t.setText(data);*/
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql="select * from HR.V_SALES_REPORT";
				try {
					conn = DBUtil.getDBConnection();
					pstmt = conn.prepareStatement(sql);
					ResultSet rs=pstmt.executeQuery();
					table1.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p5.setVisible(true);
				p4.setVisible(false);
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p6.setVisible(false);
				p7.setVisible(false);
			}
		});
		
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p6.setVisible(true);
				p4.setVisible(false);
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p5.setVisible(false);
				p7.setVisible(false);
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
		
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p7.setVisible(true);
				p4.setVisible(false);
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				p5.setVisible(false);
				p6.setVisible(false);
				Connection conn = null;
				PreparedStatement pstmt = null;
				String sql="select * from HR.TBL_ORDERS";
				try {
					conn = DBUtil.getDBConnection();
					pstmt = conn.prepareStatement(sql);
					ResultSet rs=pstmt.executeQuery();
					table2.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product stock = new Product();
				String pname=t1.getText();
				String qty=t2.getText();
				int q=Integer.parseInt(qty);
				String pup=t3.getText();
				Double p=Double.parseDouble(pup);
				String re=t4.getText();
				int r=Integer.parseInt(re);
				if(pname.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Product Name cannot be empty");
					t1.setText("");
				}
				if(q<0 || qty.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Quantity must be a positive number");
					t2.setText("");
				}
				if(pup.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Reenter Product Unit Price");
					t3.setText("");
				}
				else
				{
					stock.setProductName(pname);
					stock.setQuantityOnHand(q);
					stock.setProductUnitPrice(p);
					stock.setReorderLevel(r);
				}
				String str=admin.insertStock(stock);
				JOptionPane.showMessageDialog(null,str);
			}
		});
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeId=t5.getText();
				String remove = admin.deleteStock(removeId);
				if(removeId!=null)
				{
					String str=String.valueOf(removeId + " "+remove+ " successfully");
					JOptionPane.showMessageDialog(null,str);
				}
				else
				{
					String str="This product id does not exist";
					JOptionPane.showMessageDialog(null,str);
				}
			}
		});
		
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pId=t9.getText();
				String qt=t10.getText();
				int item=Integer.parseInt(qt);
				if(pId.isEmpty())
				{

					JOptionPane.showMessageDialog(null,"Reenter Product ID");
					t9.setText("");
				}
				if(item<0)
				{
					JOptionPane.showMessageDialog(null,"Quantity must be greater than zero");
					t10.setText("");
				}
				else
				{
					String str=admin.refillStock(pId, item);
					JOptionPane.showMessageDialog(null,str);
				}
				
			}
		});
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales sales = new Sales();
				String pid=String.valueOf(t6.getText());
				String qsold=t7.getText();
				int qty=Integer.parseInt(qsold);
				String sunit=t8.getText();
				double salun=Double.parseDouble(sunit);
				String uname=t11.getText();
				if(pid.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Reenter Product ID");
					t6.setText("");
				}
				if(qty<0 || qsold.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Quantity must be greater than zero");
					t7.setText("");
				}
				if(sunit.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Sales per unit cannot be empty");
					t8.setText("");
				}
				if(uname.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"UserName cannot be empty");
					t11.setText("");
				}
				else
				{
					sales.setSalesDate(date.getDate());
					sales.setProductID(pid);
					sales.setQuantitySold(qty);
					sales.setSalesPricePerUnit(salun);
					sales.setUserName(uname);
					String str1=admin.insertSales(sales);
					JOptionPane.showMessageDialog(null,str1);
				}
				
			}
		});
	}
	public static void main(String[] args) throws ParseException {
		new SalesApplication();
		/*Scanner sc = new Scanner(System.in);
		
		
		Administrator admin = new Administrator();
		
		int choice = 0;
		
		do {
			System.out.println("1. Insert Stock");
			System.out.println("2. Delete Stock");
			System.out.println("3. Insert Sales");
			System.out.println("4. View Sales Report");
			System.out.print("Enter your Choice: ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				Product stock = new Product();
				sc.nextLine();
				System.out.println("Enter product name: ");
				stock.setProductName(sc.nextLine());
				//sc.nextLine();
				System.out.println("Enter quantity on hand: ");
				stock.setQuantityOnHand(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter product unit price: ");
				stock.setProductUnitPrice(sc.nextDouble());
				System.out.println("Enter product reorder level: ");
				stock.setReorderLevel(sc.nextInt());
				sc.nextLine();
				String str=admin.insertStock(stock);
				System.out.println(str);
				break;
			case 2:
				System.out.println("Enter product id to be deleted: ");
				sc.nextLine();
				String removeId = sc.nextLine();
				String remove = admin.deleteStock(removeId);
				if (removeId != null) System.out.println(removeId + " "+remove+ " successfully");
				break;
			case 3:
				Sales sales = new Sales();
				sc.nextLine();
				System.out.print("Enter date (dd-mm-yyyy): ");
				String sDate = sc.nextLine();  
			    Date date = new SimpleDateFormat("dd-mm-yyyy").parse(sDate); 
				sales.setSalesDate(date);
				System.out.print("Enter product id: ");
				sales.setProductID(sc.nextLine());
				//sc.nextLine();
				System.out.print("Enter quantity sold: ");
				sales.setQuantitySold(sc.nextInt());
				sc.nextLine();
				System.out.print("Enter sales price per unit: ");
				sales.setSalesPricePerUnit(sc.nextDouble());
				String str1=admin.insertSales(sales);
				System.out.println(str1);
				break;
			case 4:
				ArrayList<SalesReport> l=new ArrayList<SalesReport>();
				l=admin.getSalesReport();
				System.out.print("\tSales ID  ");
				System.out.print("\tSales Date  ");
				System.out.print("\tProduct ID  ");
				System.out.print("\tProduct Name  ");
				System.out.print("\t\tQuantity Sold  ");
				System.out.print("\tProduct Unit Price  ");
				System.out.print("\tSales Price Per Unit  ");
				System.out.print("\tProfit Amount ");
				System.out.println();
				for(SalesReport r:l)
				{
					System.out.print("\t "+r.getSalesID()+" ");
					System.out.print("\t "+r.getSalesDate()+" ");
					System.out.print("\t "+r.getProductID()+" ");
					System.out.print("\t "+r.getProductName()+" ");
					System.out.print("\t"+r.getQuantitySold()+" ");
					System.out.print("\t \t"+r.getProductUnitPrice()+" ");
					System.out.print("\t \t"+r.getSalesPricePerUnit()+" ");
					System.out.print("\t \t"+r.getProfitAmount());
					System.out.println();
				}
					
				break;
			default:
				System.out.println("Exiting...");
				choice = 0;
				break;
			}
		} while (choice >= 1 && choice <= 4);
		
		sc.close();*/
	}

}
