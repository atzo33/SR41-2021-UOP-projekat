package models;

public class MembershipCost {
	private String id;
	private String type;
	private double price;
	
	public MembershipCost() {
		this.id = "";
		this.type = "";
		this.price = -1;
		
	}

	public MembershipCost(String id, String type, double price) {
		
		this.id = id;
		this.type = type;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MembershipCost [id=" + id + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
	
	

}
