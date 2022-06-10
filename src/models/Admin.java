package models;

import java.time.LocalDate;
import java.util.UUID;

import ennumerations.Gender;
import ennumerations.Language;

public class Admin extends Staff{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, double paycheck) {
		super(username, password, paycheck);
		// TODO Auto-generated constructor stub
	}
	
	
	public Admin(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		super(firstName, lastName, adress, id, gender, isDeleted,JMBG,username,password,paycheck);
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
	
	public void addNewAdmin(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		Admin admin=new Admin();
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setAdress(adress);
		admin.setId(id);
		admin.setGender(gender);
		admin.setDeleted(false);
		admin.setJMBG(JMBG);
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setPaycheck(paycheck);
		admin.setLibrary(library);
		library.getAllAdmins().add(admin);
		library.writeAdmin(library.getAllAdmins());
		
	}
		
		public void updateAdmin(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
			for (Admin admin:library.getAllAdmins()) {
				if(admin.getId().equals(id)) {
					admin.setFirstName(firstName);
					admin.setLastName(lastName);
					admin.setAdress(adress);
					admin.setId(id);
					admin.setGender(gender);
					admin.setDeleted(false);
					admin.setJMBG(JMBG);
					admin.setUsername(username);
					admin.setPassword(password);
					admin.setPaycheck(paycheck);
					admin.setLibrary(library);
					library.deleteContent("src/text/admins.txt");
					library.writeAdmin(library.getAllAdmins());	
				}
				
				
				
			}
			
		}
		
	public void deleteAdmin(String id) {
		
		for(Admin admin:library.getAllAdmins()) {
			
			if (admin.getId().equals(id)) {
				admin.setDeleted(true);
				
			}
			
			library.writeAdmin(library.getAllAdmins());
		}
	}
	
	public void undoDeleteAdmin(String id) {
			
			for(Admin admin:library.getAllAdmins()) {
				
				if (admin.getId().equals(id)) {
					admin.setDeleted(false);
					
				}
				
				library.writeAdmin(library.getAllAdmins());
			}
		}
	
	
	
	public void addNewLibrarian(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		Librarian librarian=new Librarian();
		librarian.setFirstName(firstName);
		librarian.setLastName(lastName);
		librarian.setAdress(adress);
		librarian.setId(id);
		librarian.setGender(gender);
		librarian.setDeleted(false);
		librarian.setJMBG(JMBG);
		librarian.setUsername(username);
		librarian.setPassword(password);
		librarian.setPaycheck(paycheck);
		librarian.setLibrary(library);
		library.getAllLibrarians().add(librarian);
		library.writeLibrarian(library.getAllLibrarians());
		
	}
	
	
	
	public void updateLibrarian(String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck) {
		for (Librarian librarian:this.getLibrary().getAllLibrarians()) {
			if(librarian.getId().equals(id)) {
				librarian.setFirstName(firstName);
				librarian.setLastName(lastName);
				librarian.setAdress(adress);
				librarian.setId(id);
				librarian.setGender(gender);
				librarian.setDeleted(false);
				librarian.setJMBG(JMBG);
				librarian.setUsername(username);
				librarian.setPassword(password);
				librarian.setPaycheck(paycheck);
				librarian.setLibrary(library);
				library.deleteContent("src/text/librarians.txt");
				library.writeLibrarian(library.getAllLibrarians());	
			}
			
			
			
		}
		
		
		
		
	}
	
	
	public void deleteLibrarian(String id) {
			
			for(Librarian librarian:library.getAllLibrarians()) {
				
				if (librarian.getId().equals(id)) {
					librarian.setDeleted(true);
					
				}
				
				library.writeLibrarian(library.getAllLibrarians());
			}
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
	
	
	public void updateMember(String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG) {
		for (Member member:library.getAllMembers()) {
			if(member.getId().equals(id)) {
				member.setCardNumber(cardNumber);
				member.setLastMembershipExtension(lastMembershipExtension);
				member.setMembershipDuration(membershipDuration);
				member.setActive(true);
				member.setMembership(membership);
				member.setFirstName(firstName);
				member.setLastName(lastName);
				member.setAdress(adress);
				member.setId(id);
				member.setGender(gender);
				member.setDeleted(false);
				member.setJMBG(JMBG);
				
				library.writeMembers(library.getAllMembers());	
			}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public void deleteMember(String id) {
		
		for(Member member:this.getLibrary().getAllMembers()) {
			
			if (member.getId().equals(id)) {
				member.setDeleted(true);
				
			}
			
			library.writeMembers(library.getAllMembers());
		}
	}
	
	
	
	public void addNewMembership(String id, String type, double price,boolean isDeleted) {
		MembershipCost membership=new MembershipCost();
		String newId=UUID.randomUUID().toString();
		membership.setId(newId);
		membership.setType(type);
		membership.setPrice(price);
		membership.setDeleted(isDeleted);
		this.getLibrary().getAllTypes().add(membership);
		this.getLibrary().writeMembershipCost(library.getAllTypes());
		
			
	}
	
	
	public void updateMembership(String id, String type, double price,boolean isDeleted) {
		for ( MembershipCost membership:this.getLibrary().getAllTypes()) {
			if(membership.getId().equals(id)) {
				membership.setId(id);
				membership.setType(type);
				membership.setPrice(price);
				membership.setDeleted(isDeleted);
				
				
				
				library.writeMembershipCost(library.getAllTypes());	
			}
		
	}
	
	
	}
	
	
	public void deleteMembership(String id) {
		
	for(MembershipCost membership:this.getLibrary().getAllTypes()) {
			
			if (membership.getId().equals(id)) {
				membership.setDeleted(true);
				
			}
			
			library.writeMembershipCost(library.getAllTypes());
		}
		
	}
	
	
	public void addNewBook(String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
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
		
		this.getLibrary().getAllBooks().add(book);
		this.getLibrary().writeBook(library.getAllBooks());
		
		
	}
	
	
	
	
	public void updateBook(String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
			Genre genre, Language language,boolean isDeleted) {
		for ( Book book:this.getLibrary().getAllBooks()) {
			if(book.getId().equals(id)) {
				book.setTitle(title);
				book.setOriginalTitle(originalTitle);
				book.setWriter(writer);
				book.setReleaseDate(releaseDate);
				book.setDescription(description);
				book.setId(id);
				book.setGenre(genre);
				book.setLanguage(language);
				book.setDeleted(isDeleted);
				
				library.writeBook(library.getAllBooks());	
			}
		
	}
	
	
	}
	
	
	
	public void deleteBook(String id) {
		
	for(Book book:this.getLibrary().getAllBooks()) {
			
			if (book.getId().equals(id)) {
				book.setDeleted(true);
				
			}
			
			library.writeBook(library.getAllBooks());
		}
		
	}
	
	
	public void addNewGenre(String name, String description, String id,boolean isDeleted) {
		
		Genre genre=new Genre();
		String newId=UUID.randomUUID().toString();
		genre.setName(name);
		genre.setDescription(description);
		genre.setId(newId);
		genre.setDeleted(false);
		
		this.getLibrary().getAllGenres().add(genre);
		this.getLibrary().writeGenre(library.getAllGenres());
		
	}
	
	
	
	
	public void updateGenre(String name, String description, String id,boolean isDeleted) {
		for ( Genre genre:this.getLibrary().getAllGenres()) {
			if(genre.getId().equals(id)) {
				genre.setName(name);
				genre.setDescription(description);
				genre.setId(id);
				genre.setDeleted(false);
				
				library.writeGenre(library.getAllGenres());	
			}
		
	}
		
		
		
	}
	
	
	
	public void deleteGenre(String id) {
		
		for(Genre genre:this.getLibrary().getAllGenres()) {
				
				if (genre.getId().equals(id)) {
					genre.setDeleted(true);
					
				}
				
				library.writeGenre(library.getAllGenres());
			}
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

