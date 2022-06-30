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

import managers.CopyOfABookManagerWindow;
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
	public ArrayList<CopyOfABook>allActiveCopies;
	
	private Library library;
	
	public CopyOfABookWindow(Library library) {
		
	this.library=library;
	this.allActiveCopies=library.allActiveCopies();
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
		Object[][] content = new Object[library.allActiveCopies().size()][header.length];
		
		
		for(int i=0; i<library.allActiveCopies().size(); i++) {
			CopyOfABook copyOfABook = library.allActiveCopies().get(i);
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
	
	private void initActions() {
		initAddButton();	
		initUpdateButton();
		initDeleteButton();
	}
	
	
	private void initAddButton() {
		this.btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CopyOfABookManagerWindow comw=new CopyOfABookManagerWindow(library);
				comw.setVisible(true);
				initGUI();
				
			}
			
		});
	}
	
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=copyOfABookTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					CopyOfABookManagerWindow comw=new CopyOfABookManagerWindow(library,allActiveCopies.get(selected));
					comw.setVisible(true);		
				}
				
			}
			
		});
			
				
	}
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=copyOfABookTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActiveCopies.get(selected).setDeleted(true);
					library.writeCopyOfABook(library.getAllCopies());
				}
				
			}
			
		});
	}
	
}

