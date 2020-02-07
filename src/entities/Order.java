package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.Status;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private Status status;
	
	private Client client;
	private List<Item> items = new ArrayList<>();
	
	public Order() {}

	public Order(Date moment, Status status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public float total() {
		float sum = 0;
		for(Item it : items) {
			sum += it.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(client + "\n");
		sb.append("Order Items:\n");
		for(Item it : items) {
			sb.append(it + "\n");
		}
		sb.append("Total price: " + total());
		return sb.toString();
	}
}
