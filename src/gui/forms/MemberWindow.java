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

import managers.MemberManagerWindow;
import models.Library;
import models.Member;
import models.Staff;


@SuppressWarnings("serial")
public class MemberWindow extends JFrame{
	
	

	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	
	private DefaultTableModel tableModel;
	private JTable memberTable;
	
	private Library library;
	private Staff staff;
	public ArrayList<Member>allActives;
	
	public MemberWindow(Library library,Staff staff) {
	this.staff=staff;	
	this.library=library;
	this.allActives=library.allActiveMembers();
	setTitle("Members");
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
		
		
//String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG
		String[] header = new String[] {"Card Number", "Last membership extension", "Membership Duration","Is Active","Membership","First Name","Last Name","Adress","ID","Gender","JMBG"};
		Object[][] content = new Object[allActives.size()][header.length];
		
		
		for(int i=0; i<allActives.size(); i++) {
			Member member = allActives.get(i);
			content[i][0] = member.getCardNumber();
			content[i][1] = member.getLastMembershipExtension();
			content[i][2] = member.getMembershipDuration();
			content[i][3] = member.isActive();
			content[i][4] = member.getMembership();
			content[i][5] = member.getFirstName();
			content[i][6] = member.getLastName();
			content[i][7] = member.getAdress();
			content[i][8] = member.getId();
			content[i][9] = member.getGender();
			content[i][10] = member.getJMBG();
			
		}
		
		
		
		tableModel = new DefaultTableModel(content, header);
		memberTable = new JTable(tableModel);
		
		memberTable.setRowSelectionAllowed(true);
		memberTable.setColumnSelectionAllowed(false);
		memberTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		memberTable.setDefaultEditor(Object.class, null);
		memberTable.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(memberTable);
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
				MemberManagerWindow mmw=new MemberManagerWindow(library,staff);
				mmw.setVisible(true);
				initGUI();
				
			}
			
		});
	}
	
	private void initUpdateButton() {
		this.btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selected=memberTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					MemberManagerWindow mmw=new MemberManagerWindow(library,allActives.get(selected),staff);
					mmw.setVisible(true);		
				}
				
			}
			
		});
			
				
	}
	
	private void initDeleteButton() {
		this.btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selected=memberTable.getSelectedRow();
				if(selected==-1) {
					JOptionPane.showMessageDialog(null,"Must select row","Fail :(",JOptionPane.WARNING_MESSAGE);	
				}
				else {
					JOptionPane.showMessageDialog(null,"Task successed successfully","Success!",JOptionPane.INFORMATION_MESSAGE);

					allActives.get(selected).setDeleted(true);
					library.writeMembers(library.getAllMembers());
				}
				
			}
			
		});
	}



}
