package models;

import java.time.LocalDate;
import java.util.UUID;

import ennumerations.Gender;

public class Librarian extends Staff {

	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Librarian(String username, String password, double paycheck, String id) {
		super(username, password, paycheck);
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
	

}
