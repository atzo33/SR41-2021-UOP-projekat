package main;

import java.time.LocalDate;
import java.util.ArrayList;

import ennumerations.Binding;
import ennumerations.Gender;
import ennumerations.Language;
import models.*;

public class Main {

	public static void main(String[] args) {
		Library library=new Library("Library of Atzo", "Varraghova 14", "non-stop", "1-234567-789", "789456");
		
		Admin admin=new Admin("Ranko","Jakonjac","Gorana Bogdana","123",Gender.FEMALE,false,"1234567897894","JR","Jaka sifra",1000000000000.00);
		admin.setLibrary(library);
		Genre genre=new Genre("Comedy","This is funny","00001",false);
		ArrayList<Genre>allGenres=new ArrayList<Genre>();
		allGenres.add(genre);
		library.writeGenre(allGenres);
		System.out.println(library.readGenres());
		
		
		
		Book book=new Book("Rat i mir","Peace and war", "Tolstoy", LocalDate.of(1887,05,05), "Ovo je dosadna knjiga", "0000000056",
			genre, Language.SERBIAN,false);
		ArrayList<Book>allBooks=new ArrayList<Book>();
		allBooks.add(book);
		library.writeBook(allBooks);
		System.out.println(library.readBook(allGenres));
		
		
		MembershipCost membership=new MembershipCost("45986","Full",15.0,true);
		ArrayList<MembershipCost>allTypes=new ArrayList<MembershipCost>();
		allTypes.add(membership);
		library.writeMembershipCost(allTypes);
		System.out.println(library.readMembershipCost());
		
		
		
//		String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted
		
		
		Member member=new Member("005",LocalDate.of(2021, 6, 7),5,true,membership,"Mitar","Miric","Jovana Stojana 420","55",Gender.MALE,false,"1234567897897");
				
			ArrayList<Member>allMembers=new ArrayList<Member>();
			allMembers.add(member);
			library.writeMembers(allMembers);
			library.readMembers();
			admin.updateMember("005",LocalDate.of(2021, 6, 7),5,true,membership,"Petar","Miric","Jovana Stojana 420","55",Gender.MALE,false,"1234567897897");
			System.out.println(library.getAllMembers().get(0));
			System.out.println(library.readMembers());
			


			
			
			CopyOfABook copyOfABook=new CopyOfABook(500, 1997, true, "9595",Binding.HARD,book,
					 Language.SERBIAN,false);
			System.out.println(copyOfABook);
			ArrayList<CopyOfABook>allCopies=new ArrayList<CopyOfABook>();
			allCopies.add(copyOfABook);
			System.out.println(allCopies);
			library.writeCopyOfABook(allCopies);
			System.out.println(library.readCopyOfABook());
			
			
//			String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
			ArrayList<Admin>allAdmins=new ArrayList<Admin>();
			allAdmins.add(admin);
			library.writeAdmin(allAdmins);
			System.out.println(library.readAdmin());
			
			
//			RentABook rentABook=new RentABook(LocalDate.of(2021, 6, 7),LocalDate.of(2021, 6, 7),copyOfABook,admin,member);
//			ArrayList<RentABook>allRents=new ArrayList<RentABook>();
//			allRents.add(rentABook);
//			library.writeRentABook(allRents);
//			System.out.println(library.readRentABook());
			
			
			
			
			
			
			
			
			Librarian librarian=new Librarian("VaaraghSmallVersion", "VeryWeakPassword", 154.3,"78812223");
			ArrayList<Librarian>allLibrarians=new ArrayList<Librarian>();
			allLibrarians.add(librarian);
			library.writeLibrarian(allLibrarians);
			System.out.println(library.readLibrarian());
			
			
			
			
			
//			Library library=new Library("Library of master Atzo","Bonka Zvogdana 33","00-24", "123-456-666", "1");
			
			library.writeLibrary();
			library.readLibrary();
			
			
			
			
			
			
			
				
	}
	
	
	
	
	

}
