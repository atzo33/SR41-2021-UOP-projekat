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

import managers.BookManagerWindow;
import models.Book;
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
	private ArrayList<Book>allActiveBooks;
	
	public BookWindow(Library library) {
		
	this.library=library;
	this.allActiveBooks=library.allActiveBooks();
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
		Object[][] content = new Object[library.allActiveBooks().size()][header.length];
		
//		String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
//		Genre genre, Language language,boolean isDeleted
		for(int i=0; i<library.allActiveBooks().size(); i++) {
			Book book = library.allActiveBooks().get(i);
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
	
	private void initActions() {
		initAddButton();	
		initUpdateButton();
		initDeleteButton();
	}
	
	private void initAddButton() {
		this.btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookManagerWindow bmw=new BookManagerWindow(library);
				bmw.setVisible(true);
				initGUI();
				
			}
			
		});
		
		
	}
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=bookTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					BookManagerWindow bmw=new BookManagerWindow(library,allActiveBooks.get(selected));
					bmw.setVisible(true);		
				}
				
			}
			
		});
			
	}
	
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=bookTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActiveBooks.get(selected).setDeleted(true);
					library.writeBook(library.getAllBooks());
				}
				
			}
			
		});
	}
	
	

}
