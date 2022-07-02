package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ennumerations.Gender;
import models.Library;
import models.Member;
import models.MembershipCost;
import models.Staff;
import net.miginfocom.swing.MigLayout;

public class MemberManagerWindow extends JFrame {
	
	private Staff staff;
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
	
	public MemberManagerWindow(Library library,Staff staff) {
		
		this.library=library;
		this.staff=staff;
		this.member=null;
		
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
		initButtons();
		
		
	}
	
	public MemberManagerWindow(Library library,Member member,Staff staff) {
			
			this.staff=staff;
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
			initButtons();
			jmbgField.setEditable(false);
			cardNumberField.setEditable(false);
			idField.setEditable(false);
			
			
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
		 this.idField = new JTextField(member.getId().toString());
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
		this.submitBtn=new JButton("Submit");
		this.cancelBtn=new JButton("Cancel");
		panel.add(submitBtn);
		panel.add(cancelBtn);
	}
	private void initCancel() {
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				
				
			}
			
		});
	}
	private void initSubmit() {
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String jmbg=jmbgField.getText();
				String id=idField.getText();
				Gender gender=Gender.valueOf(genderField.getSelectedItem().toString());
				String adress=adressField.getText();
				String lastName=lastNameField.getText();
				String firstName=firstNameField.getText();
				int selectedMembership=membershipField.getSelectedIndex();
				MembershipCost membership=memberships.get(selectedMembership);
				boolean isActive=isActiveField.isSelected();
				int membershipDuration=Integer.parseInt(membershipDurationField.getText());
				LocalDate lastMembershipExtension=LocalDate.parse(lastMembershipExtensionField.getText());
				String cardNumber=cardNumberField.getText();
				boolean isDeleted=false;
				if(member==null) {
					if(library.addNewMember(cardNumber, lastMembershipExtension, membershipDuration, isActive, membership, firstName, lastName, adress, id, gender, isDeleted, jmbg)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Member successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Member not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateMember( lastMembershipExtension, membershipDuration, isActive, membership, firstName, lastName, adress, id, gender,isDeleted)) {
						JOptionPane.showMessageDialog(null,"Member successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Member not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
				}
				
				
				
			}
			
		});
	}
	
	private void initButtons() {
		initSubmit();
		initCancel();
		
		
	}

}
