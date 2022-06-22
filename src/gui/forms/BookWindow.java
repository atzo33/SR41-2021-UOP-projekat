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

@SuppressWarnings("serial")
public class BookWindow extends JFrame{
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable bookTable;
	
	private Library library;
	
	public BookWindow(Library library) {
		
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
		
		
		String[] header = new String[] {"Title", "Original title", "Writer", "Release Date", "Description","id","Genre","Language"};
		Object[][] content = new Object[library.getAllBooks().size()][header.length];
		
//		String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
//		Genre genre, Language language,boolean isDeleted
		for(int i=0; i<library.getAllBooks().size(); i++) {
			models.Book book = library.getAllBooks().get(i);
			content[i][0] = book.getTitle();
			content[i][1] = book.getOriginalTitle();
			content[i][2] = book.getWriter();
			content[i][3] = book.getReleaseDate();
			content[i][4] = book.getDescription();
			content[i][5] = book.getId();
			content[i][6] = book.getGenre().getId();
			content[i][7] = book.getLanguage();
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		bookTable = new JTable(tableModel);
		
		bookTable.setRowSelectionAllowed(true);
		bookTable.setColumnSelectionAllowed(false);
		bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookTable.setDefaultEditor(Object.class, null);
		bookTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bookTable);
		add(scrollPane, BorderLayout.CENTER);
		

	}
	
	private void initActions() {}
	
	

}
