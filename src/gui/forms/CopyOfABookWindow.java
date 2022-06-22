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



import models.CopyOfABook;
import models.Library;


@SuppressWarnings("serial")
public class CopyOfABookWindow extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable copyOfABookTable;
	
	private Library library;
	
	public CopyOfABookWindow(Library library) {
		
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
		
//	int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
//		Language language	
		String[] header = new String[] {"Page Numbers", "Printing year", "Is Rented","ID","Binding","Book","Language"};
		Object[][] content = new Object[library.getAllCopies().size()][header.length];
		
		
		for(int i=0; i<library.getAllCopies().size(); i++) {
			CopyOfABook copyOfABook = library.getAllCopies().get(i);
			content[i][0] = copyOfABook.getPageNumbers();
			content[i][1] = copyOfABook.getPrintingYear();
			content[i][2] = copyOfABook.isRented();
			content[i][3] = copyOfABook.getId();
			content[i][4] = copyOfABook.getBinding();
			content[i][5] = copyOfABook.getBook().getId();
			content[i][6] = copyOfABook.getLanguage();
			
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		copyOfABookTable = new JTable(tableModel);
		
		copyOfABookTable.setRowSelectionAllowed(true);
		copyOfABookTable.setColumnSelectionAllowed(false);
		copyOfABookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		copyOfABookTable.setDefaultEditor(Object.class, null);
		copyOfABookTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(copyOfABookTable);
		add(scrollPane, BorderLayout.CENTER);
		
//		String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
	}
	
	private void initActions() {}
	
}
