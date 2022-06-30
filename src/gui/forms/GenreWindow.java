package gui.forms;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import managers.AdminManagerWindow;
import managers.GenreManagerWindow;
import models.Genre;
import models.Library;

@SuppressWarnings("serial")
public class GenreWindow extends JFrame {
	

	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	public ArrayList<Genre>allActiveGenres;
	private DefaultTableModel tableModel;
	private JTable genreTable;
	
	private Library library;
	
	public GenreWindow(Library library) {
		
	this.library=library;
	this.allActiveGenres=library.allActiveGenres();
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
	
	private void initActions() {
		initAddButton();	
		initUpdateButton();
		initDeleteButton();
	}
	
	private void initAddButton() {
		this.btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GenreManagerWindow gmw=new GenreManagerWindow(library);
				gmw.setVisible(true);
				initGUI();
				
			}
			
		});
	}
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=genreTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					GenreManagerWindow gmw=new GenreManagerWindow(library,allActiveGenres.get(selected));
					gmw.setVisible(true);		
				}
				
			}
			
		});
			
				
	}
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=genreTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActiveGenres.get(selected).setDeleted(true);
					library.writeGenre(library.getAllGenres());
				}
				
			}
			
		});
	}
	



}
