package main;

import java.time.LocalDate;
import java.util.ArrayList;

import ennumerations.Binding;
import ennumerations.Gender;
import ennumerations.Language;
import models.*;

public class Main {

	public static void main(String[] args) {
		Library library=new Library();
		
		Genre genre=new Genre("Comedy","This is funny","00001");
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
		
		
		MembershipCost membership=new MembershipCost("45986","Full",15.0);
		ArrayList<MembershipCost>allTypes=new ArrayList<MembershipCost>();
		allTypes.add(membership);
		library.writeMembershipCost(allTypes);
		System.out.println(library.readMembershipCost());
		
		
		
//		String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted
		
		
		Member member=new Member("005",LocalDate.of(2021, 6, 7),5,true,membership,"Mitar","Miric","Jovana Stojana 420","55",Gender.MALE,false);
				
			ArrayList<Member>allMembers=new ArrayList<Member>();
			allMembers.add(member);
			library.writeMembers(allMembers);
			System.out.println(library.readMembers());
			


			
			
			CopyOfABook copyOfABook=new CopyOfABook(500, 1997, true, "9595",Binding.HARD,book,
					 Language.SERBIAN,false);
			ArrayList<CopyOfABook>allCopies=new ArrayList<CopyOfABook>();
			allCopies.add(copyOfABook);
			library.writeCopyOfABook(allCopies);
			System.out.println(library.readCopyOfABook());
			
			
			
			
			
			
			RentABook rentABook=new RentABook(LocalDate.of(2021, 6, 7),LocalDate.of(2021, 6, 7),copyOfABook,staff,member);
			ArrayList<RentABook>allRents=new ArrayList<RentABook>();
			allRents.add(rentABook);
			library.writeRentABook(allRents);
			System.out.println(library.readRentABook());
			
			
			
			
			
				
	}
	
	
	
	
	

}
