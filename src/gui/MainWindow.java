package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

	
	
	private Library library;
	
	
	

	public MainWindow(Library library,Staff loggedIn) {
		this.library=library;
		
		setTitle("Staff: " + loggedIn.getUsername());
		setSize(700, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
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
	
	private void initActions() {
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
				MemberWindow mw = new MemberWindow(library);
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
	
	
	
}
