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


import models.Admin;
import models.Library;


@SuppressWarnings("serial")
public class AdminWindow extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable adminTable;
	
	private Library library;
	
	public AdminWindow(Library library) {
		
	this.library=library;
	setTitle("Admins");
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
		Object[][] content = new Object[library.allActiveAdmins().size()][header.length];
		
		
		for(int i=0; i<library.allActiveAdmins().size(); i++) {
			Admin admin = library.allActiveAdmins().get(i);
			content[i][0] = admin.getFirstName();
			content[i][1] = admin.getLastName();
			content[i][2] = admin.getAdress();
			content[i][3] = admin.getId();
			content[i][4] = admin.getGender();
			content[i][5] = admin.getJMBG();
			content[i][6] = admin.getUsername();
			content[i][7] = admin.getPassword();
			content[i][8] = admin.getPaycheck();
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		adminTable = new JTable(tableModel);
		
		adminTable.setRowSelectionAllowed(true);
		adminTable.setColumnSelectionAllowed(false);
		adminTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminTable.setDefaultEditor(Object.class, null);
		adminTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(adminTable);
		add(scrollPane, BorderLayout.CENTER);
		
//		String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
	}
	
	private void initActions() {}

}
