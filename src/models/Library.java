package models;

import java.util.ArrayList;

public class Library {
	
	private String name;

    private String address;

    private String workingHours;

    private String phoneNumber;

    private String id;

    private ArrayList<Book> allBooks = new ArrayList<Book>();

    private ArrayList<Member> allMembers = new ArrayList<Member>();

    private ArrayList<Staff> allStaff = new ArrayList<Staff>();

    private ArrayList<CopyOfABook> allCopies = new ArrayList<CopyOfABook>();

    private ArrayList<MembershipCost> allTypes = new ArrayList<MembershipCost>();

    private ArrayList<Genre> allGenres = new ArrayList<Genre>();
    
    public Library() {
    	this.name = "";
		this.address = "";
		this.workingHours = "";
		this.phoneNumber = "";
		this.id = "";
		this.allBooks = null;
		this.allMembers = null;
		this.allStaff = null;
		this.allCopies = null;
		this.allTypes = null;
		this.allGenres = null;
    	
    }

	public Library(String name, String address, String workingHours, String phoneNumber, String id,
			ArrayList<Book> allBooks, ArrayList<Member> allMembers, ArrayList<Staff> allStaff,
			ArrayList<CopyOfABook> allCopies, ArrayList<MembershipCost> allTypes, ArrayList<Genre> allGenres) {
		
		this.name = name;
		this.address = address;
		this.workingHours = workingHours;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.allBooks = allBooks;
		this.allMembers = allMembers;
		this.allStaff = allStaff;
		this.allCopies = allCopies;
		this.allTypes = allTypes;
		this.allGenres = allGenres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(ArrayList<Book> allBooks) {
		this.allBooks = allBooks;
	}

	public ArrayList<Member> getAllMembers() {
		return allMembers;
	}

	public void setAllMembers(ArrayList<Member> allMembers) {
		this.allMembers = allMembers;
	}

	public ArrayList<Staff> getAllStaff() {
		return allStaff;
	}

	public void setAllStaff(ArrayList<Staff> allStaff) {
		this.allStaff = allStaff;
	}

	public ArrayList<CopyOfABook> getAllCopies() {
		return allCopies;
	}

	public void setAllCopies(ArrayList<CopyOfABook> allCopies) {
		this.allCopies = allCopies;
	}

	public ArrayList<MembershipCost> getAllTypes() {
		return allTypes;
	}

	public void setAllTypes(ArrayList<MembershipCost> allTypes) {
		this.allTypes = allTypes;
	}

	public ArrayList<Genre> getAllGenres() {
		return allGenres;
	}

	public void setAllGenres(ArrayList<Genre> allGenres) {
		this.allGenres = allGenres;
	}
	
    
    

}

