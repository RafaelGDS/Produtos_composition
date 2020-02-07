package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Item;
import entities.Order;
import entities.Product;
import entities.enums.Status;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("ENTER CLIENT DATA:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (dd/mm/yyyy): ");
		Date birthDate = sdf.parse(sc.next());
		Client client = new Client(name, email, birthDate);
		
		System.out.println("ENTER ORDER DATA:");
		System.out.print("Status: ");
		Status status = Status.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("ENTER #" + i + " ITEM DATA: ");
			System.out.print("Product Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			float productPrice = sc.nextFloat();
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			Item item = new Item(quantity, productPrice, product);
			
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMMARY:");
		System.out.println(order);
		
		sc.close();

	}

}
