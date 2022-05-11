package models;

public class Admin extends Staff{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, double paycheck, String id) {
		super(username, password, paycheck, id);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", paycheck=" + paycheck + ", id=" + id
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", adress=" + adress + ", gender=" + gender
				+ ", isDeleted=" + isDeleted + "]";
	}

	public void regNewEmployee() {
		
	}
	
	
	

}
