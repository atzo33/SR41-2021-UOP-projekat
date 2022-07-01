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

import ennumerations.Binding;
import ennumerations.Language;
import models.Book;
import models.CopyOfABook;
import models.Library;
import models.Member;
import models.RentABook;
import models.Staff;
import net.miginfocom.swing.MigLayout;

public class RentABookManagerWindow extends JFrame {


	private Library library;
	
	
	private JPanel panel;
	
	private JLabel rentalDate;
	private JLabel returningDate;
	private JLabel copyOfABook;
	private JLabel staff;
	private JLabel member;
	private JLabel id;
	
	
	
	
	
	
	private JTextField rentalDateField;
	private JTextField returningDateField;
	private JComboBox copyOfABookField;
	private JTextField idField;
	private JComboBox staffField;
	private JComboBox memberField;
	
	
	
	
	
	private JButton submitBtn,cancelBtn;
	private ArrayList<RentABook>rents;
	private ArrayList<CopyOfABook>copies;
	private ArrayList<Staff>staffs;
	private ArrayList<Member>members;
	
	private RentABook rentABook;
	
	
	
	
	
	public RentABookManagerWindow(Library library) {
		
		this.library=library;
		this.rents=library.allActiveRents();
		this.copies=library.allActiveCopies();
		this.staffs=library.allActiveStaff();
		this.members=library.allActiveMembers();
		this.rentABook=rentABook;
		
		this.rents=library.allActiveRents();
		
		
		
		setTitle("Rents of a book");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.panel=new JPanel(new MigLayout());
		add(panel);
		writeLabels();
		createEmptyFields();
		fillPanel();
		initButtons();
		
		
	}
	
	public RentABookManagerWindow(Library library,RentABook	rentABook) {
			
			this.rents=library.allActiveRents();
			this.copies=library.allActiveCopies();
			this.staffs=library.allActiveStaff();
			this.members=library.allActiveMembers();
			this.library=library;
			this.rentABook=rentABook;
			
			
			setTitle("Rents");
			setSize(700, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			this.panel= new JPanel(new MigLayout());
			add(panel);
			writeLabels();
			createFields();
			fillPanel();
			initButtons();
			
			
			idField.setEditable(false);
			
			
		}
	private void writeLabels() {
		
		this.rentalDate = new JLabel("Rental date");
		this.returningDate = new JLabel("Returning date");
		this.copyOfABook = new JLabel("Copy of a book");
		this.staff = new JLabel("Staff");
		this.member = new JLabel("Member");
		this.id = new JLabel("Id");
		
		
		
		
	}
	
	private void createEmptyFields() {
		
		 DefaultComboBoxModel copylist= new DefaultComboBoxModel();
		 for(CopyOfABook copyOfABook:this.copies) {
			 copylist.addElement(copyOfABook.getId());
		 }
		 
		 DefaultComboBoxModel staflist= new DefaultComboBoxModel();
		 for(Staff staff:this.staffs) {
			 staflist.addElement(staff.getFirstName());
		 }
		 
		 DefaultComboBoxModel memlist= new DefaultComboBoxModel();
		 for(Member member :this.members) {
			 memlist.addElement(member.getFirstName());
		 }
		 		 
		 this.rentalDateField = new JTextField();
		 this.returningDateField = new JTextField();
		 this.copyOfABookField = new JComboBox(copylist);
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.staffField = new JComboBox(staflist);
		 this.memberField=new JComboBox(memlist);
		 
		 
		 
		 
		
		
	}
	
	private void createFields() {
		
		 DefaultComboBoxModel copylist= new DefaultComboBoxModel();
		 for(CopyOfABook copyOfABook:this.copies) {
			 copylist.addElement(copyOfABook.getId());
		 }
		 
		 DefaultComboBoxModel staflist= new DefaultComboBoxModel();
		 for(Staff staff:this.staffs) {
			 staflist.addElement(staff.getFirstName());
		 }
		 
		 DefaultComboBoxModel memlist= new DefaultComboBoxModel();
		 for(Member member :this.members) {
			 memlist.addElement(member.getFirstName());
		 }
		
		
		 
		 
		 this.rentalDateField = new JTextField(rentABook.getRentalDate().toString());
		 this.returningDateField = new JTextField(rentABook.getReturningDate().toString());
		 this.copyOfABookField = new JComboBox(copylist);
		 this.idField = new JTextField(rentABook.getId());
		 this.staffField = new JComboBox(staflist);
		 this.memberField=new JComboBox(memlist);
		 
	
	}
	
	
	
	
	private void fillPanel() {
		panel.add(rentalDate);
		panel.add(rentalDateField,"width 100%,wrap");
		panel.add(returningDate);
		panel.add(returningDateField,"width 100%,wrap");
		panel.add(copyOfABook);
		panel.add(copyOfABookField,"width 100%,wrap");
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(staff);
		panel.add(staffField,"width 100%,wrap");
		panel.add(member);
		panel.add(memberField,"width 100%,wrap");
		
		
		
		
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
				LocalDate rentalDate=LocalDate.parse(rentalDateField.getText());
				LocalDate returningDate=LocalDate.parse(returningDateField.getText());
				int selectedCopy=copyOfABookField.getSelectedIndex();
				CopyOfABook copyOfABook=copies.get(selectedCopy);
				int selectedStaff=staffField.getSelectedIndex();
				Staff staff=staffs.get(selectedStaff);
				int selectedMember=memberField.getSelectedIndex();
				Member member=members.get(selectedMember);
				
				
				String id=idField.getText();
				
				
				boolean isDeleted=false;
				if(rentABook==null) {
					if(library.addNewRentABook(rentalDate, returningDate, copyOfABook, staff, member, isDeleted,id)&&rentalDate.isBefore(returningDate)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Rent of a book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Rent of a book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateRentABook(rentalDate, returningDate, copyOfABook, staff, member, isDeleted,id)) {
						JOptionPane.showMessageDialog(null,"Rent of a book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Rent of a book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

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
