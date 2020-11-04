package com.wipro.sales.main;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.Product;
import com.wipro.sales.service.Administrator;
public class SalesApplication {
	public static void main(String[] args) throws ParseException {
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
				System.out.print("Enter product id to be deleted: ");
				String removeId = sc.nextLine();
				removeId = admin.deleteStock(removeId);
				if (removeId != null) System.out.println(removeId + " removed successfully");
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
