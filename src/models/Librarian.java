package models;

import java.time.LocalDate;
import java.util.UUID;

import ennumerations.Binding;
import ennumerations.Gender;
import ennumerations.Language;

public class Librarian extends Staff {

	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Librarian(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		super(firstName,lastName,adress,id,gender,isDeleted,JMBG,username,password,paycheck);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public boolean addNewMember(String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG) {
		Member member=new Member();
		String newId=UUID.randomUUID().toString();
		member.setCardNumber(cardNumber);
		member.setLastMembershipExtension(lastMembershipExtension);
		member.setMembershipDuration(membershipDuration);
		member.setActive(true);
		member.setMembership(membership);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setAdress(adress);
		member.setId(newId);
		member.setGender(gender);
		member.setDeleted(false);
		member.setJMBG(JMBG);
		for(Member m:this.getLibrary().getAllMembers()) {
			if(m.getJMBG().equals(JMBG)||m.getCardNumber().equals(cardNumber)) {
				return false;
				
				
			}
			
		}
		library.getAllMembers().add(member);
		library.writeMembers(library.getAllMembers());
		return true;
		
	}
	
	
	public boolean addNewBook(String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
			Genre genre, Language language,boolean isDeleted) {
		
		Book book=new Book();
		String newId=UUID.randomUUID().toString();
		book.setTitle(title);
		book.setOriginalTitle(originalTitle);
		book.setWriter(writer);
		book.setReleaseDate(releaseDate);
		book.setDescription(description);
		book.setId(newId);
		book.setGenre(genre);
		book.setLanguage(language);
		book.setDeleted(isDeleted);
		
		for(Book b:this.getLibrary().getAllBooks()) {
			if(b.getId().equals(newId)||b.getDescription().equals(description)) {
				return false;
					
			}	
			
		}
		
		this.getLibrary().getAllBooks().add(book);
		this.getLibrary().writeBook(library.getAllBooks());
		return true;
		
		
	}
	
	public boolean addNewMembership(String id, String type, double price,boolean isDeleted) {
		MembershipCost membership=new MembershipCost();
		String newId=UUID.randomUUID().toString();
		membership.setId(newId);
		membership.setType(type);
		membership.setPrice(price);
		membership.setDeleted(isDeleted);
		for(MembershipCost me:this.getLibrary().getAllTypes()) {
			if(me.getId().equals(id)||me.getType().equals(type)) {
				return false;
					
			}	
			
		}
		this.getLibrary().getAllTypes().add(membership);
		this.getLibrary().writeMembershipCost(library.getAllTypes());
		return true;
			
	}
	
public boolean addNewGenre(String name, String description, String id,boolean isDeleted) {
		
		Genre genre=new Genre();
		String newId=UUID.randomUUID().toString();
		genre.setName(name);
		genre.setDescription(description);
		genre.setId(newId);
		genre.setDeleted(false);
		
		for(Genre g:this.getLibrary().getAllGenres()) {
			if(g.getId().equals(id)||g.getDescription().equals(description)) {
				return false;
					
			}	
			
		}
		
		this.getLibrary().getAllGenres().add(genre);
		this.getLibrary().writeGenre(library.getAllGenres());
		return true;
		
	}

	public void addNewCopyOfABook(int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
			Language language, boolean isDeleted) {
		
		CopyOfABook copyOfABook=new CopyOfABook();
		String newId=UUID.randomUUID().toString();
		copyOfABook.setPageNumbers(pageNumbers);
		copyOfABook.setPrintingYear(printingYear);
		copyOfABook.setRented(false);
		copyOfABook.setId(newId);
		copyOfABook.setBinding(binding);
		copyOfABook.setBook(book);
		copyOfABook.setLanguage(language);
		copyOfABook.setDeleted(false);
		
		
		
		this.getLibrary().getAllCopies().add(copyOfABook);
		this.getLibrary().writeCopyOfABook(library.getAllCopies());
		
}
	
	
	public void addNewRentABook(LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member,boolean isDeleted) {
			
			RentABook rentABook=new RentABook();
			String newId=UUID.randomUUID().toString();
			rentABook.setRentalDate(rentalDate);
			rentABook.setReturningDate(returningDate);
			rentABook.setCopyOfABook(copyOfABook);
			rentABook.setStaff(staff);
			rentABook.setMember(member);
			rentABook.setDeleted(false);
			rentABook.setId(newId);
			
			
			
			
			this.getLibrary().getAllRents().add(rentABook);
			this.getLibrary().writeRentABook(library.getAllRents());
			
		}
	
	
	


	
	
	
	
	

}
