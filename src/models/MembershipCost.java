package models;

public class MembershipCost {
	private String id;
	private String type;
	private double price;
	private boolean isDeleted;
	
	public MembershipCost() {
		this.id = "";
		this.type = "";
		this.price = -1;
		this.isDeleted=false;
		
	}

	public MembershipCost(String id, String type, double price,boolean isDeleted) {
		
		this.id = id;
		this.type = type;
		this.price = price;
		this.isDeleted=isDeleted;
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
	

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "MembershipCost [id=" + id + ", type=" + type + ", price=" + price + "]";
	}
	
	
	
	
	

}
