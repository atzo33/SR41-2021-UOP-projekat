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

import managers.MembershipCostManagerWindow;
import models.Library;
import models.MembershipCost;

@SuppressWarnings("serial")
public class MembershipCostWindow extends JFrame {
	


	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private ArrayList<MembershipCost>allActiveMemberships;
	private DefaultTableModel tableModel;
	private JTable membershipCostTable;
	
	private Library library;
	
	public MembershipCostWindow(Library library) {
	
	this.allActiveMemberships=library.allActiveMemberships();	
	this.library=library;
	setTitle("Membership costs");
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
		
//		String id, String type, double price,boolean isDeleted
		
		String[] header = new String[] {"ID", "Type", "Price"};
		Object[][] content = new Object[library.allActiveMemberships().size()][header.length];
		
		
		for(int i=0; i<library.allActiveMemberships().size(); i++) {
			MembershipCost membership = library.allActiveMemberships().get(i);
			content[i][0] = membership.getId();
			content[i][1] = membership.getType();
			content[i][2] = membership.getPrice();
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		membershipCostTable = new JTable(tableModel);
		
		membershipCostTable.setRowSelectionAllowed(true);
		membershipCostTable.setColumnSelectionAllowed(false);
		membershipCostTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		membershipCostTable.setDefaultEditor(Object.class, null);
		membershipCostTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(membershipCostTable);
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
				MembershipCostManagerWindow mcmw=new MembershipCostManagerWindow(library);
				mcmw.setVisible(true);
				initGUI();
				
			}
			
		});
	}
	
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=membershipCostTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					MembershipCostManagerWindow mcmw=new MembershipCostManagerWindow(library,allActiveMemberships.get(selected));
					mcmw.setVisible(true);		
				}
				
			}
			
		});
			
				
	}
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=membershipCostTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActiveMemberships.get(selected).setDeleted(true);
					library.writeMembershipCost(library.getAllTypes());
				}
				
			}
			
		});
	}
	



}
