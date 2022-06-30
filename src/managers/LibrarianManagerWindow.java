package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ennumerations.Gender;
import models.Admin;
import models.Librarian;
import models.Library;
import models.Staff;
import net.miginfocom.swing.MigLayout;

public class LibrarianManagerWindow extends JFrame {




	
	private Staff staff;
	private Library library;
	private Librarian librarian;
	
	private JPanel panel;
	
	private JLabel firstName;
	private JLabel lastName;
	private JLabel adress;
	private JLabel id;
	private JLabel gender;
	private JLabel jmbg;
	private JLabel username;
	private JLabel password;
	private JLabel paycheck;
	
	
	
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField adressField;
	private JTextField idField;
	private JComboBox genderField;
	private JTextField jmbgField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField paycheckField;
	
	
	private JButton submitBtn,cancelBtn;
	
	
	public LibrarianManagerWindow(Library library,Staff staff) {
		
		this.library=library;
		this.staff=staff;
		
		
		
		setTitle("Admins");
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
	
	public LibrarianManagerWindow(Library library,Librarian librarian,Staff staff) {
			
			this.staff=staff;
			this.library=library;
			this.librarian=librarian;
			
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
			
			idField.setEditable(false);
			
			
		}
	private void writeLabels() {
		
		this.firstName = new JLabel("First Name");
		this.lastName = new JLabel("Last Name");
		this.adress = new JLabel("Address");
		this.id = new JLabel("Id");
		this.gender = new JLabel("Gender");
		this.jmbg = new JLabel("Jmbg");
		this.username = new JLabel("Username");
		this.password = new JLabel("Password");
		this.paycheck = new JLabel("Paycheck");
		
	}
	
	private void createEmptyFields() {
	
		 
		 this.firstNameField = new JTextField();
		 this.lastNameField = new JTextField();
		 this.adressField = new JTextField();
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.genderField = new JComboBox(Gender.values());
		 this.jmbgField = new JTextField();
		 this.usernameField = new JTextField();
		 this.passwordField = new JTextField();
		 this.paycheckField = new JTextField();
		 
		
		
	}
	
	private void createFields() {
		
		
		
		
		this.firstNameField = new JTextField(librarian.getFirstName());
		 this.lastNameField = new JTextField(librarian.getLastName());
		 this.adressField = new JTextField(librarian.getAdress());
		 this.idField = new JTextField(librarian.getId());
		 this.genderField = new JComboBox(Gender.values());
		 this.jmbgField = new JTextField(librarian.getJMBG());
		 this.usernameField = new JTextField(librarian.getUsername());
		 this.passwordField = new JTextField(librarian.getPassword());
		 this.paycheckField = new JTextField(String.valueOf(librarian.getPaycheck()));
		 
		
		
	}
	
	
	
	
	
	
	private void fillPanel() {
		panel.add(firstName);
		panel.add(firstNameField,"width 100%,wrap");
		panel.add(lastName);
		panel.add(lastNameField,"width 100%,wrap");
		panel.add(adress);
		panel.add(adressField,"width 100%,wrap");
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(gender);
		panel.add(genderField,"width 100%,wrap");
		panel.add(jmbg);
		panel.add(jmbgField,"width 100%,wrap");
		panel.add(username);
		panel.add(usernameField,"width 100%,wrap");
		panel.add(password);
		panel.add(passwordField,"width 100%,wrap");
		panel.add(paycheck);
		panel.add(paycheckField,"width 100%,wrap");
		
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
				String firstName=firstNameField.getText();
				String lastName=lastNameField.getText();
				String adress=adressField.getText();
				String id=idField.getText();
				Gender gender=Gender.valueOf(genderField.getSelectedItem().toString());
				String jmbg=jmbgField.getText();
				String username=usernameField.getText();
				String password=passwordField.getText();
				double paycheck=Double.parseDouble(paycheckField.getText());
				
				boolean isDeleted=false;
				if(librarian==null) {
					if(library.addNewLibrarian(firstName, lastName, adress, id, gender, isDeleted, jmbg, username, password, paycheck)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Librarian successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Librarian not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateLibrarian(firstName, lastName, adress, id, gender, isDeleted, jmbg, username, password, paycheck)) {
						JOptionPane.showMessageDialog(null,"Librarian successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Librarian not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

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
