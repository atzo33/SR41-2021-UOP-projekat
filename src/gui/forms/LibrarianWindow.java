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
import managers.LibrarianManagerWindow;
import models.Admin;
import models.Librarian;
import models.Library;
import models.Staff;

@SuppressWarnings("serial")
public class LibrarianWindow extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable librarianTable;
	
	private Library library;
	private Staff staff;
	public ArrayList<Librarian>allActiveLibrarians;
	
	public LibrarianWindow(Library library) {
		
	this.library=library;
	this.staff=staff;
	this.allActiveLibrarians=library.allActiveLibrarians();
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
	
	private void initActions() {
		initAddButton();	
		initUpdateButton();
		initDeleteButton();
	}
	
	private void initAddButton() {
		this.btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibrarianManagerWindow lmw=new LibrarianManagerWindow(library,staff);
				lmw.setVisible(true);
				initGUI();
				
			}
			
		});
	}
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=librarianTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					LibrarianManagerWindow lmw=new LibrarianManagerWindow(library,allActiveLibrarians.get(selected),staff);
					lmw.setVisible(true);		
				}
				
			}
			
		});
			
				
	}
	
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=librarianTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActiveLibrarians.get(selected).setDeleted(true);
					library.writeLibrarian(library.getAllLibrarians());
				}
				
			}
			
		});
	}

}
