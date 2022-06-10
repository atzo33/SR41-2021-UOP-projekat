package models;

import java.time.LocalDate;

public class RentABook {
	private LocalDate rentalDate;
	private LocalDate returningDate;
	private CopyOfABook copyOfABook;
	private Staff staff;
	private Member member;
	private boolean isDeleted;
	private String id;
	
	
	public RentABook() {
		this.rentalDate = null;
		this.returningDate = null;
		this.copyOfABook = null;
		this.staff=null;
		this.member=null;
		this.isDeleted=false;
		this.id="";
		
	}

	public RentABook(LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member,boolean isDeleted,String id) {
		super();
		this.rentalDate = rentalDate;
		this.returningDate = returningDate;
		this.copyOfABook = copyOfABook;
		this.staff=staff;
		this.member=member;
		this.isDeleted=isDeleted;
		this.id=id;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDate getReturningDate() {
		return returningDate;
	}

	public void setReturningDate(LocalDate returningDate) {
		this.returningDate = returningDate;
	}

	public CopyOfABook getCopyOfABook() {
		return copyOfABook;
	}

	public void setCopyOfABook(CopyOfABook copyOfABook) {
		this.copyOfABook = copyOfABook;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RentABook [rentalDate=" + rentalDate + ", returningDate=" + returningDate + ", copyOfABook="
				+ copyOfABook + ", staff=" + staff + ", member=" + member + "]";
	}
	
	
	
	
	

}
