package com.wipro.sales.main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Sales;
import com.toedter.calendar.JDateChooser;
import com.wipro.sales.bean.Product;
import com.wipro.sales.service.Administrator;
public class SalesApplication {
	Administrator admin = new Administrator();
	JFrame f;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	SalesApplication()
	{
		f = new JFrame();
		f.setBounds(100, 100, 1220, 479);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JButton b1 = new JButton("Insert Stock");
		b1.setBounds(42, 43, 149, 36);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("Delete Stock");
		b2.setBounds(42, 127, 149, 36);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("Insert Sales");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b3.setBounds(42, 216, 149, 36);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("Sales Report");
		b4.setBounds(42, 302, 149, 36);
		f.getContentPane().add(b4);
		
		JPanel p1 = new JPanel();
		p1.setBounds(262, 10, 697, 328);
		f.getContentPane().add(p1);
		p1.setLayout(null);
		p1.setVisible(false);
		
		JLabel l1 = new JLabel("Enter Product Name: ");
		l1.setBounds(50, 57, 255, 13);
		p1.add(l1);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(50, 80, 255, 19);
		p1.add(t1);
		
		JLabel l2 = new JLabel("Enter Quantity on Hand: ");
		l2.setBounds(379, 57, 255, 13);
		p1.add(l2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(379, 80, 255, 19);
		p1.add(t2);
		
		JLabel l3 = new JLabel("Enter Product Unit Price: ");
		l3.setBounds(50, 150, 255, 13);
		p1.add(l3);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(50, 173, 255, 19);
		p1.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(379, 173, 255, 19);
		p1.add(t4);
		
		JLabel l4 = new JLabel("Enter Reorder Level: ");
		l4.setBounds(379, 150, 255, 13);
		p1.add(l4);
		
		JButton b5 = new JButton("Submit");
		b5.setBounds(275, 241, 136, 21);
		p1.add(b5);
		
		JPanel p3 = new JPanel();
		p3.setBounds(262, 10, 697, 328);
		f.getContentPane().add(p3);
		p3.setLayout(null);
		p3.setVisible(false);
		
		JLabel l6 = new JLabel("Enter Date:");
		l6.setBounds(48, 53, 255, 13);
		p3.add(l6);
		
		JDateChooser date = new JDateChooser();
		date.setBounds(48, 76, 255, 19);
		p3.add(date);
		
		JLabel l7 = new JLabel("Enter Product ID: ");
		l7.setBounds(354, 53, 255, 13);
		p3.add(l7);
		
		JLabel l8 = new JLabel("Enter Quantity Sold: ");
		l8.setBounds(48, 154, 255, 13);
		p3.add(l8);
		
		t7 = new JTextField();
		t7.setColumns(10);
		t7.setBounds(48, 177, 255, 19);
		p3.add(t7);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(354, 76, 255, 19);
		p3.add(t6);
		
		JLabel l9 = new JLabel("Enter Sales Price Per Unit: ");
		l9.setBounds(354, 154, 255, 13);
		p3.add(l9);
		
		t8 = new JTextField();
		t8.setColumns(10);
		t8.setBounds(354, 177, 255, 19);
		p3.add(t8);
		
		JButton b7 = new JButton("Submit");
		b7.setBounds(270, 232, 136, 21);
		p3.add(b7);
		
		JPanel p2 = new JPanel();
		p2.setBounds(262, 10, 359, 189);
		f.getContentPane().add(p2);
		p2.setLayout(null);
		p2.setVisible(false);
		
		JLabel l5 = new JLabel("Enter Product ID to be deleted: ");
		l5.setBounds(42, 32, 255, 13);
		p2.add(l5);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(42, 55, 255, 19);
		p2.add(t5);
		
		JButton b6 = new JButton("Submit");
		b6.setBounds(107, 129, 136, 21);
		p2.add(b6);
		
		JPanel p4 = new JPanel();
		p4.setBounds(262, 10, 897, 328);
		f.getContentPane().add(p4);
		p4.setLayout(null);
		p4.setVisible(false);
		
		JTextArea t = new JTextArea();
		t.setBounds(28, 34, 837, 266);
		p4.add(t);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(true);
				p4.setVisible(false);
				p3.setVisible(false);
				p2.setVisible(false);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.setVisible(true);
				p4.setVisible(false);
				p3.setVisible(false);
				p1.setVisible(false);
			}
		});
		
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p3.setVisible(true);
				p4.setVisible(false);
				p1.setVisible(false);
				p2.setVisible(false);
			}
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p4.setVisible(true);
				p1.setVisible(false);
				p2.setVisible(false);
				p3.setVisible(false);
				ArrayList<SalesReport> l=new ArrayList<SalesReport>();
				l=admin.getSalesReport();
				String data="";
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
				t.setText(data);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product stock = new Product();
				String pname=t1.getText();
				stock.setProductName(pname);
				String qty=t2.getText();
				int q=Integer.parseInt(qty);
				stock.setQuantityOnHand(q);
				String pup=t3.getText();
				Double p=Double.parseDouble(pup);
				stock.setProductUnitPrice(p);
				String re=t4.getText();
				int r=Integer.parseInt(re);
				stock.setReorderLevel(r);
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
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales sales = new Sales();
				sales.setSalesDate(date.getDate());
				String pid=String.valueOf(t6.getText());
				sales.setProductID(pid);
				String qsold=t7.getText();
				int qty=Integer.parseInt(qsold);
				sales.setQuantitySold(qty);
				String sunit=t8.getText();
				double salun=Double.parseDouble(sunit);
				sales.setSalesPricePerUnit(salun);
				String str1=admin.insertSales(sales);
				JOptionPane.showMessageDialog(null,str1);
			}
		});
	}
	public static void main(String[] args) throws ParseException {
		new SalesApplication();
		Scanner sc = new Scanner(System.in);
		
		
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
				System.out.print("\tQuantity Sold  ");
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
					System.out.print("\t "+r.getQuantitySold()+" ");
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
		
		sc.close();
	}

}
