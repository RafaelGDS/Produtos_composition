package entities;

public class Item {

	private Integer quantity;
	private Float price;
	
	private Product product;
	
	public Item() {}

	public Item(Integer quantity, Float price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public float subTotal() {
		return quantity * price;
	}
	
	public String toString() {
		return product.getName()
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity
				+ ", subtotal: $"
				+ String.format("%.2f", subTotal());
	}
}
