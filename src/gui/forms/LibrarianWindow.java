package gui.forms;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


import models.Librarian;
import models.Library;

@SuppressWarnings("serial")
public class LibrarianWindow extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable librarianTable;
	
	private Library library;
	
	public LibrarianWindow(Library library) {
		
	this.library=library;
	setTitle("Librarians");
	setSize(500, 300);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
	initGUI();
	initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		
		String[] header = new String[] {"First Name", "Last Name", "Adress", "ID", "Gender","JMBG","Username","Password","Paycheck"};
		Object[][] content = new Object[library.allActiveLibrarians().size()][header.length];
		
		
		for(int i=0; i<library.allActiveLibrarians().size(); i++) {
			Librarian librarian = library.allActiveLibrarians().get(i);
			content[i][0] = librarian.getFirstName();
			content[i][1] = librarian.getLastName();
			content[i][2] = librarian.getAdress();
			content[i][3] = librarian.getId();
			content[i][4] = librarian.getGender();
			content[i][5] = librarian.getJMBG();
			content[i][6] = librarian.getUsername();
			content[i][7] = librarian.getPassword();
			content[i][8] = librarian.getPaycheck();
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		librarianTable = new JTable(tableModel);
		
		librarianTable.setRowSelectionAllowed(true);
		librarianTable.setColumnSelectionAllowed(false);
		librarianTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		librarianTable.setDefaultEditor(Object.class, null);
		librarianTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(librarianTable);
		add(scrollPane, BorderLayout.CENTER);
		
//		String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
	}
	
	private void initActions() {}
	

}
