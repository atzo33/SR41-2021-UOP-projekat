package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import models.Library;
import models.Staff;
import net.miginfocom.swing.MigLayout;
import osobe.Prodavac;




public class loginWindow extends JFrame {
	
	private JLabel lblGreeting = new JLabel("Welcome, please log in!");
	private JLabel lblUsername = new JLabel("Username");
	private JTextField txtUsername = new JTextField(20);
	private JLabel lblPassword = new JLabel("Password");
	private JPasswordField pfPassword = new JPasswordField(20);
	private JButton btnOk = new JButton("OK");
	private JButton btnCancel = new JButton("Cancel");
	private Library library;
	
	
	public loginWindow(Library library) {
		this.library = library;
		setTitle("Log in");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
		pack();
	}
	
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblGreeting, "span 2");
		add(lblUsername);
		add(txtUsername);
		add(lblPassword);
		add(pfPassword);
		add(new JLabel());
		add(btnOk, "split 2");
		add(btnCancel);
		
		
		txtUsername.setText("");
		pfPassword.setText("");
		getRootPane().setDefaultButton(btnOk);
	}
	
	
	
	public void initActions() {
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginWindow.this.dispose();
				loginWindow.this.setVisible(false);
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				String password = new String(pfPassword.getPassword()).trim();
				
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "You didn't enter login credentials", "Error", JOptionPane.WARNING_MESSAGE);
				}else {
					Staff staff = staff(username, password);
					if(staff == null) {
						JOptionPane.showMessageDialog(null, "Wrong login credentials", "Error", JOptionPane.WARNING_MESSAGE);
					}else {
						loginWindow.this.dispose();
						loginWindow.this.setVisible(false);
						MainWindow mw = new MainWindow(library, staff);
						mw.setVisible(true);
					}
				}
			}
		});
		
	}
	
	
	
	
}
