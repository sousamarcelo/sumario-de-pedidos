package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;	
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
	public Order() {
	}
	
	public Order(OrderStatus status, Client client) {
		super();
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public void addItem(OrderItem orderItem) {
		orderItems.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orderItems.remove(orderItem);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: " + sdf.format(getMoment()) + "\n");
		sb.append("Order status: " + getStatus() + "\n");
		sb.append("Client: " + getClient().getName() + " (");
		sb.append(sdf2.format(getClient().getBirthDate()) + ") - ");
		sb.append(getClient().getEmail() + "\n");
		sb.append("Order items: \n");
		for(OrderItem oi : orderItems) {
			sb.append(oi.getProduct().getName() + ", ");
			sb.append("$" + String.format("%.2f", oi.getPrice()) + ", ");
			sb.append("Quantity " + oi.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", oi.subTotal()) + "\n");
		}
		return sb.toString();
	}

}
