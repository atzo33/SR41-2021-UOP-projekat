package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.forms.AdminWindow;
import gui.forms.BookWindow;
import gui.forms.CopyOfABookWindow;
import gui.forms.GenreWindow;
import gui.forms.LibrarianWindow;
import gui.forms.MemberWindow;
import gui.forms.MembershipCostWindow;
import gui.forms.RentABookWindow;
import models.Admin;
import models.Library;
import models.Staff;
import net.miginfocom.swing.MigLayout;




@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenuItem adminMenu = new JMenuItem("Admin");
	private JMenuItem librarianMenu = new JMenuItem("Librarian");
	private JMenuItem bookMenu = new JMenuItem("Book");
	private JMenuItem genreMenu = new JMenuItem("Genre");
	private JMenuItem memberMenu = new JMenuItem("Member");
	private JMenuItem membershipCostMenu = new JMenuItem("MembershipCost");
	private JMenuItem rentABookMenu = new JMenuItem("RentABook");
	private JMenuItem copyOfABookMenu = new JMenuItem("CopyOfABook");

	private JPanel libraryPanel;
	private JLabel name;
	private JLabel workingHours;
	private JLabel adress;
	private JLabel phoneNumber;
	
	private JTextField nameField;
	private JTextField workingHoursField;
	private JTextField adressField;
	private JTextField phoneNumberField;
	private JButton updateLibrary;
	
	
	private Library library;
	private Staff staff;
	
	
	

	public MainWindow(Library library,Staff loggedIn) {
		this.library=library;
		this.staff=loggedIn;
		
		
		setTitle("Staff: " + loggedIn.getUsername());
		setSize(700, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		if(staff instanceof Admin) {
			initAdminMenu();
			initAdminActions();
			initActions();
			initLibrary();
			initLibraryUpdate();
		}
		else {
			initLibrarianMenu();
			initActions();
			initLibrary();
		}
	}
	
	private void initAdminMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(adminMenu);
		mainMenu.add(librarianMenu);
		mainMenu.add(bookMenu);
		mainMenu.add(genreMenu);
		mainMenu.add(memberMenu);
		mainMenu.add(membershipCostMenu);
		mainMenu.add(rentABookMenu);
		mainMenu.add(copyOfABookMenu);
		
	}
	private void initLibrarianMenu() {
		setJMenuBar(mainMenu);
		
		mainMenu.add(bookMenu);
		mainMenu.add(genreMenu);
		mainMenu.add(memberMenu);
		mainMenu.add(membershipCostMenu);
		mainMenu.add(rentABookMenu);
		mainMenu.add(copyOfABookMenu);
		
	}
	private void initAdminActions() {
		
		adminMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow aw = new AdminWindow(library);
				aw.setVisible(true);
				
			}
		});
		
		librarianMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LibrarianWindow lw = new LibrarianWindow(library);
				lw.setVisible(true);
				
			}
		});
		
	}
	
	
	private void initActions() {
		
		
		
		
		
		bookMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookWindow bw = new BookWindow(library);
				bw.setVisible(true);
				
			}
		});
		
		genreMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GenreWindow gw = new GenreWindow(library);
				gw.setVisible(true);
				
			}
		});
		
		memberMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberWindow mw = new MemberWindow(library,staff);
				mw.setVisible(true);
				
			}
		});
		
		membershipCostMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MembershipCostWindow mcw = new MembershipCostWindow(library);
				mcw.setVisible(true);
				
			}
		});
		
		rentABookMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RentABookWindow rabw = new RentABookWindow(library);
				rabw.setVisible(true);
				
			}
		});
		
		copyOfABookMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CopyOfABookWindow cobw = new CopyOfABookWindow(library);
				cobw.setVisible(true);
				
			}
		});
		
		
		
		
	
}
	private void initLibrary() {
//		LibraryWindow liw = new LibraryWindow(library);
//		liw.setVisible(true);
//		liw.setAlwaysOnTop(true);
		
		libraryPanel=new JPanel(new MigLayout());
		add(libraryPanel);
		this.name=new JLabel("Name: ");
		this.adress=new JLabel("Address: ");
		this.workingHours=new JLabel("Working Hours: ");
		this.phoneNumber= new JLabel("Phone number: ");
		this.nameField=new JTextField(library.getName());
		this.adressField=new JTextField(library.getAddress());
		this.workingHoursField=new JTextField(library.getWorkingHours());
		this.phoneNumberField=new JTextField(library.getPhoneNumber());
		libraryPanel.add(name);
		libraryPanel.add(nameField,"wrap,width 50%");
		nameField.setEditable(false);
		libraryPanel.add(adress);
		libraryPanel.add(adressField,"wrap,width 50%");
		adressField.setEditable(false);
		libraryPanel.add(workingHours);
		libraryPanel.add(workingHoursField,"wrap,width 50%");
		workingHoursField.setEditable(false);
		libraryPanel.add(phoneNumber);
		libraryPanel.add(phoneNumberField,"wrap,width 50%");
		phoneNumberField.setEditable(false);
		
	}
	private void initLibraryUpdate() {
	
		this.updateLibrary=new JButton("Update");
		libraryPanel.add(updateLibrary);
		
		nameField.setEditable(true);
		adressField.setEditable(true);
		workingHoursField.setEditable(true);
		phoneNumberField.setEditable(true);
		initUpdatable();
	
	
}
	private void initUpdatable() {
		this.updateLibrary.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText();
				String adress=adressField.getText();
				String workingHours=workingHoursField.getText();
				String phoneNumber=phoneNumberField.getText();
				library.updateLibrary(name, adress, workingHours, phoneNumber);
				
				
			}
			
		});
	}
}
