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

import models.Genre;

import models.Library;

@SuppressWarnings("serial")
public class GenreWindow extends JFrame {
	

	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable genreTable;
	
	private Library library;
	
	public GenreWindow(Library library) {
		
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
		
//		String name, String description, String id
		String[] header = new String[] {"Name", "Description", "ID"};
		Object[][] content = new Object[library.allActiveGenres().size()][header.length];
		
		
		for(int i=0; i<library.allActiveGenres().size(); i++) {
			Genre genre = library.allActiveGenres().get(i);
			content[i][0] = genre.getName();
			content[i][1] = genre.getDescription();
			content[i][2] = genre.getId();
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		genreTable = new JTable(tableModel);
		
		genreTable.setRowSelectionAllowed(true);
		genreTable.setColumnSelectionAllowed(false);
		genreTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		genreTable.setDefaultEditor(Object.class, null);
		genreTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(genreTable);
		add(scrollPane, BorderLayout.CENTER);
		
//		String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
	}
	
	private void initActions() {}
	



}
