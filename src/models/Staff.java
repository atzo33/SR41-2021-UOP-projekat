package models;

public abstract class Staff extends User {
	protected String username;
	protected String password;
	protected double paycheck;
	protected String id;
	public Staff() {
		this.username="";
		this.password ="";
		this.paycheck = -1;
		this.id = "";
		
		// TODO Auto-generated constructor stub
	}
	
	public Staff(String username, String password, double paycheck, String id) {
		super();
		this.username = username;
		this.password = password;
		this.paycheck = paycheck;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getPaycheck() {
		return paycheck;
	}

	public void setPaycheck(double paycheck) {
		this.paycheck = paycheck;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void addMember() {
		
	}
	
	

}
