package models;

import ennumerations.Gender;

public abstract class User {
	protected String firstName;
	protected String lastName;
	protected String adress;
	protected String id;
	protected Gender gender;
	protected boolean isDeleted;
	protected String JMBG;
	
	public User() {
		this.firstName="";
		this.lastName="";
		this.adress="";
		this.id="";
		this.gender=null;		
		this.isDeleted=false;
		this.JMBG="";
				
		
	}
	public User(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.id = id;
		this.gender = gender;
		this.isDeleted = isDeleted;
		this.JMBG=JMBG;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getJMBG() {
		return JMBG;
	}
	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}
	
	
	
	
	

}
