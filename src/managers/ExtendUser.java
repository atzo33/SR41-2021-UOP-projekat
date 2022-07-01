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

public class ExtendUser extends JFrame {

	
	
	private Library library;
	private Member member;
	private MembershipCost membership;
	
	private JPanel panel;
	
	private JLabel firstName;
	private JLabel lastName;
	private JLabel cardNumber;
	private JLabel lastMembershipExtension;
	private JLabel amount;
	
	
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField cardNumberField;
	private JTextField lastMembershipExtensionField;
	private JTextField amountField;
	
	
	
	private JButton submitBtn,cancelBtn;
	
	

	
	public ExtendUser(Library library,Member member) {
			
			this.membership=membership;
			this.library=library;
			this.member=member;
			
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
			
			firstNameField.setEditable(false);
			lastNameField.setEditable(false);
			cardNumberField.setEditable(false);
			lastMembershipExtensionField.setEditable(false);
			
			
			
		}
	private void writeLabels() {
		
		this.firstName = new JLabel("First Name");
		this.cardNumber = new JLabel("Card Number");
		this.lastMembershipExtension = new JLabel("Last Membership Extension");
		this.lastName = new JLabel("Last Name");
		this.amount=new JLabel("Extension months");
		
	}
	
	
	
	private void createFields() {
		
		
		
		
		 this.firstNameField = new JTextField(member.getFirstName());
		 this.cardNumberField = new JTextField(member.getCardNumber());
		 this.lastMembershipExtensionField = new JTextField(member.getLastMembershipExtension().toString());
		 this.lastNameField = new JTextField(member.getLastName());
		 this.amountField=new JTextField();
		 
		
		
		
	}
	
	
	
	
	
	
	private void fillPanel() {
		
		panel.add(firstName);
		panel.add(firstNameField,"width 100%,wrap");
		panel.add(lastName);
		panel.add(lastNameField,"width 100%,wrap");
		
		panel.add(cardNumber);
		panel.add(cardNumberField,"width 100%,wrap");
		panel.add(lastMembershipExtension);
		panel.add(lastMembershipExtensionField,"width 100%,wrap");
		panel.add(amount);
		panel.add(amountField,"width 100%,wrap");
		
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
				JOptionPane.showMessageDialog(null,"You have saved "+ExtensionPrice()+ " dollars","Success!",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				ExtendUser eu=new ExtendUser(library,member);
				eu.setVisible(false);
			}
			
		});
	}
	
	private double ExtensionPrice() {
        int extensionAmount = Integer.parseInt(amountField.getText());
        double price = 0;
        if (extensionAmount >= 6 && extensionAmount < 12) {
            price = (extensionAmount * member.getMembership().getPrice()) - ((extensionAmount * member.getMembership().getPrice()) * 0.1);
        }
        else if (extensionAmount >= 12) {
            price = (extensionAmount * member.getMembership().getPrice()) - ((extensionAmount * member.getMembership().getPrice()) * 0.2);
        }
        else {
            price = extensionAmount * member.getMembership().getPrice();
        }
        return price;
    }
	
	private void initButtons() {
		initSubmit();
		initCancel();
		
		
	}



}
