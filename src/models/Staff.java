package models;

import java.time.LocalDate;
import java.util.UUID;

import ennumerations.Gender;

public abstract class Staff extends User {
	protected String username;
	protected String password;
	protected double paycheck;
	protected Library library;

	public Staff() {
		this.username="";
		this.password ="";
		this.paycheck = -1;
		this.library=null;
		
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Staff(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		super(firstName, lastName, adress, id, gender, isDeleted,JMBG);
		
		this.username = username;
		this.password = password;
		this.paycheck = paycheck;
		// TODO Auto-generated constructor stub
	}


	public Staff(String username, String password, double paycheck) {
		super();
		this.username = username;
		this.password = password;
		this.paycheck = paycheck;
		
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
	

	public Library getLibrary() {
		return library;
	}


	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
	

}
