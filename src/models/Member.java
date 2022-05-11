package models;

import java.time.LocalDate;

import ennumerations.Gender;

public class Member extends User {
	protected String cardNumber;
	protected LocalDate lastMembershipExtension;
	protected int membershipDuration;
	protected boolean isActive;
	protected MembershipCost membership;
	
	public Member() {
		super();
		this.cardNumber = "";
		this.lastMembershipExtension = null;
		this.membershipDuration = -1;
		this.isActive = true;
		this.membership=null;
		
	}
	
	

	public Member(String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted) {
		super(firstName, lastName, adress, id, gender, isDeleted);
		this.cardNumber = cardNumber;
		this.lastMembershipExtension = lastMembershipExtension;
		this.membershipDuration = membershipDuration;
		this.isActive = isActive;
		this.membership=membership;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getLastMembershipExtension() {
		return lastMembershipExtension;
	}
	public void setLastMembershipExtension(LocalDate lastMembershipExtension) {
		this.lastMembershipExtension = lastMembershipExtension;
	}
	public int getMembershipDuration() {
		return membershipDuration;
	}
	public void setMembershipDuration(int membershipDuration) {
		this.membershipDuration = membershipDuration;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public MembershipCost getMembership() {
		return membership;
	}
	public void setMembership(MembershipCost membership) {
		this.membership = membership;
	}
	
	

}
