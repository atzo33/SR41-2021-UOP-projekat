package managers;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ennumerations.Gender;
import models.Library;
import models.Member;
import models.MembershipCost;
import net.miginfocom.swing.MigLayout;

public class MemberManagerWindow extends JFrame {
	
	
	private Library library;
	private Member member;
	
	private JPanel panel;
	
	private JLabel firstName;
	private JLabel cardNumber;
	private JLabel lastMembershipExtension;
	private JLabel membershipDuration;
	private JLabel isActive;
	private JLabel membership;
	private JLabel lastName;
	private JLabel adress;
	private JLabel id;
	private JLabel gender;
	private JLabel jmbg;
	
	
	private JTextField firstNameField;
	private JTextField cardNumberField;
	private JTextField lastMembershipExtensionField;
	private JTextField membershipDurationField;
	private JCheckBox isActiveField;
	private JComboBox membershipField;
	private JTextField lastNameField;
	private JTextField adressField;
	private JTextField idField;
	private JComboBox genderField;
	private JTextField jmbgField;
	
	private JButton submitBtn,cancelBtn;
	private ArrayList <MembershipCost> memberships;
	
	public MemberManagerWindow(Library library) {
		
		this.library=library;
		this.memberships=library.allActiveMemberships();
		setTitle("Members");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.panel= new JPanel(new MigLayout());
		add(panel);
		writeLabels();
		createEmptyFields();
		fillPanel();
		
		
	}
	
	public MemberManagerWindow(Library library,Member member) {
			
			this.library=library;
			this.member=member;
			this.memberships=library.allActiveMemberships();
			setTitle("Members");
			setSize(700, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			this.panel= new JPanel(new MigLayout());
			add(panel);
			writeLabels();
			createFields();
			fillPanel();
			
			
		}
	private void writeLabels() {
		
		this.firstName = new JLabel("First Name");
		this.cardNumber = new JLabel("Card Number");
		this.lastMembershipExtension = new JLabel("Last Membership Extension");
		this.membershipDuration = new JLabel("Membership Duration");
		this.isActive = new JLabel("Is Active?");
		this.membership = new JLabel("Membership");
		this.lastName = new JLabel("Last Name");
		this.adress = new JLabel("Address");
		this.id = new JLabel("Id");
		this.gender = new JLabel("Gender");
		this.jmbg = new JLabel("Jmbg");
	}
	
	private void createEmptyFields() {
	
		 DefaultComboBoxModel memlist= new DefaultComboBoxModel();
		 for(MembershipCost membership:this.memberships) {
			 memlist.addElement(membership.getType());
		 }
		
		 this.firstNameField = new JTextField();
		 this.cardNumberField = new JTextField();
		 this.lastMembershipExtensionField = new JTextField();
		 this.membershipDurationField = new JTextField();
		 this.isActiveField = new JCheckBox();
		 this.membershipField = new JComboBox(memlist);
		 this.lastNameField = new JTextField();
		 this.adressField = new JTextField();
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.genderField = new JComboBox(Gender.values());
		 this.jmbgField = new JTextField();
		
		
	}
	
	private void createFields() {
		
		
		DefaultComboBoxModel memlist= new DefaultComboBoxModel();
		 for(MembershipCost membership:this.memberships) {
			 memlist.addElement(membership.getType());
		 }
		
		 this.firstNameField = new JTextField(member.getFirstName());
		 this.cardNumberField = new JTextField(member.getCardNumber());
		 this.lastMembershipExtensionField = new JTextField(member.getLastMembershipExtension().toString());
		 this.membershipDurationField = new JTextField(String.valueOf(member.getMembershipDuration()));
		 this.isActiveField = new JCheckBox();
		 isActiveField.setSelected(member.isActive());
		 this.membershipField = new JComboBox(memlist);
		 membershipField.setSelectedItem(member.getMembership().getType());
		 this.lastNameField = new JTextField(member.getLastName());
		 this.adressField = new JTextField(member.getAdress());
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.genderField = new JComboBox(Gender.values());
		 genderField.setSelectedItem(member.getGender());
		 this.jmbgField = new JTextField(member.getJMBG());
		
		
		
	}
	
	
	
	
	
	
	private void fillPanel() {
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(firstName);
		panel.add(firstNameField,"width 100%,wrap");
		panel.add(lastName);
		panel.add(lastNameField,"width 100%,wrap");
		panel.add(adress);
		panel.add(adressField,"width 100%,wrap");
		panel.add(cardNumber);
		panel.add(cardNumberField,"width 100%,wrap");
		panel.add(lastMembershipExtension);
		panel.add(lastMembershipExtensionField,"width 100%,wrap");
		panel.add(membershipDuration);
		panel.add(membershipDurationField,"width 100%,wrap");
		panel.add(isActive);
		panel.add(isActiveField,"width 100%,wrap");
		panel.add(membership);
		panel.add(membershipField,"width 100%,wrap");
		panel.add(gender);
		panel.add(genderField,"width 100%,wrap");
		panel.add(jmbg);
		panel.add(jmbgField,"width 100%,wrap");
	}

}
