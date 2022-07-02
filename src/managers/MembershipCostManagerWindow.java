package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Library;
import models.MembershipCost;
import net.miginfocom.swing.MigLayout;

public class MembershipCostManagerWindow extends JFrame{
	



	
	
	private Library library;
	private MembershipCost membership;
	
	
	private JPanel panel;
	
	private JLabel id;
	private JLabel type;
	private JLabel price;
	
	
	
	
	private JTextField idField;
	private JTextField typeField;
	private JTextField priceField;
	
	
	
	private JButton submitBtn,cancelBtn;
	
	
	public MembershipCostManagerWindow(Library library) {
		
		this.library=library;
		this.membership=membership;
		
		
		
		
		
		setTitle("Memberships");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.panel= new JPanel(new MigLayout());
		add(panel);
		writeLabels();
		createEmptyFields();
		fillPanel();
		initButtons();
		
		idField.setEditable(false);
		
		
	}
	
	public MembershipCostManagerWindow(Library library,MembershipCost membership) {
			
			this.membership=membership;
			this.library=library;
			
			
			setTitle("Members");
			setSize(700, 500);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			this.panel= new JPanel(new MigLayout());
			add(panel);
			writeLabels();
			createFields();
			fillPanel();
			initButtons();
			
			
			
		}
	private void writeLabels() {
		
		this.id = new JLabel("ID");
		this.type = new JLabel("Type");
		this.price = new JLabel("Price");
		
		
	}
	
	private void createEmptyFields() {
	
		this.idField = new JTextField(UUID.randomUUID().toString());
		this.typeField = new JTextField();
		 this.priceField = new JTextField();
		 
		 
		 
		
		
	}
	
	private void createFields() {
		
		
		
		
		this.idField = new JTextField(membership.getId());
		this.typeField = new JTextField(membership.getType());
		 this.priceField = new JTextField(String.valueOf(membership.getPrice()));
		 
		
		
	}
	
	
	
	
	
	
	private void fillPanel() {
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(type);
		panel.add(typeField,"width 100%,wrap");
		panel.add(price);
		panel.add(priceField,"width 100%,wrap");
		
		
		this.submitBtn=new JButton("Submit");
		this.cancelBtn=new JButton("Cancel");
		panel.add(submitBtn);
		panel.add(cancelBtn);
	}
	private void initCancel() {
		this.cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				
				
			}
			
		});
	}
	private void initSubmit() {
		this.submitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id=idField.getText();
				String type=typeField.getText();
				double price=Double.parseDouble(priceField.getText());
				
				boolean isDeleted=false;
				if(membership==null) {
					if(library.addNewMembership(id, type,price, isDeleted)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Membership successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Membership not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateMembership(id, type, price, isDeleted)) {
						JOptionPane.showMessageDialog(null,"Membership successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Membership not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
				}
				
				
				
			}
			
		});
	}
	
	private void initButtons() {
		initSubmit();
		initCancel();
		
		
	}





}
