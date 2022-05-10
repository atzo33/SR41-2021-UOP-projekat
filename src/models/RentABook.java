package models;

import java.time.LocalDate;

public class RentABook {
	private LocalDate rentalDate;
	private LocalDate returningDate;
	private CopyOfABook copyOfABook;
	
	public RentABook() {
		this.rentalDate = null;
		this.returningDate = null;
		this.copyOfABook = null;
		
	}

	public RentABook(LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook) {
		super();
		this.rentalDate = rentalDate;
		this.returningDate = returningDate;
		this.copyOfABook = copyOfABook;
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
	
	

}
