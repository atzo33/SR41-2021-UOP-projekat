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


import models.Library;

import models.RentABook;


@SuppressWarnings("serial")
public class RentABookWindow extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable rentABookTable;
	
	private Library library;
	
	public RentABookWindow(Library library) {
		
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
		
//LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member,boolean isDeleted,String id
		
		String[] header = new String[] {"Rental date", "Returning date", "Copy Of A Book","Staff","Member","ID"};
		Object[][] content = new Object[library.getAllRents().size()][header.length];
		
		
		for(int i=0; i<library.getAllRents().size(); i++) {
			RentABook rentABook = library.getAllRents().get(i);
			content[i][0] = rentABook.getRentalDate();
			content[i][1] = rentABook.getReturningDate();
			content[i][2] = rentABook.getCopyOfABook().getId();
			content[i][3] = rentABook.getStaff().getId();
			content[i][4] = rentABook.getMember().getId();
			content[i][5] = rentABook.getId();
			
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		rentABookTable = new JTable(tableModel);
		
		rentABookTable.setRowSelectionAllowed(true);
		rentABookTable.setColumnSelectionAllowed(false);
		rentABookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rentABookTable.setDefaultEditor(Object.class, null);
		rentABookTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(rentABookTable);
		add(scrollPane, BorderLayout.CENTER);
		
//		String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
	}
	
	private void initActions() {}
	

}
