package models;

import ennumerations.Binding;
import ennumerations.Language;

public class CopyOfABook {
	private int pageNumbers;
	private int printingYear;
	private boolean isRented;
	private String id;
	private Binding binding;
	private Book book;
	private Language language;
	private boolean isDeleted;
	
	public CopyOfABook() {
		this.pageNumbers = -1;
		this.printingYear = -1;
		this.isRented = false;
		this.id = "";
		this.binding = null;
		this.book = null;
		this.language = null;
		this.isDeleted = false;
		
	}

	public CopyOfABook(int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
			Language language, boolean isDeleted) {
		
		this.pageNumbers = pageNumbers;
		this.printingYear = printingYear;
		this.isRented = isRented;
		this.id = id;
		this.binding = binding;
		this.book = book;
		this.language = language;
		this.isDeleted = isDeleted;
	}

	public int getPageNumbers() {
		return pageNumbers;
	}

	public void setPageNumbers(int pageNumbers) {
		this.pageNumbers = pageNumbers;
	}

	public int getPrintingYear() {
		return printingYear;
	}

	public void setPrintingYear(int printingYear) {
		this.printingYear = printingYear;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Binding getBinding() {
		return binding;
	}

	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}
