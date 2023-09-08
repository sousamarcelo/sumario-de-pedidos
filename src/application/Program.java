package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date =sdf.parse(sc.next());
		
		Client client = new Client(clientName, email, date);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
				
		OrderItem orderItem;
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Procut price: ");			
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int produtcQuantity = sc.nextInt();
			orderItem = new OrderItem(produtcQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println();		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		double sum = 0.0;
		for(OrderItem oi : order.getOrderItems()) {
			sum = sum+oi.subTotal();
		}
		
		System.out.printf("Total price: $%.2f", sum);
		
		sc.close();		

	}

}
