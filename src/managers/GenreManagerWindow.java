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

import ennumerations.Gender;
import models.Admin;
import models.Genre;
import models.Library;
import models.Staff;
import net.miginfocom.swing.MigLayout;

public class GenreManagerWindow extends JFrame {



	
	private Genre genre;
	private Library library;
	private Admin admin;
	
	private JPanel panel;
	
	private JLabel name;
	private JLabel description;
	private JLabel id;
	
	
	
	
	private JTextField nameField;
	private JTextField descriptionField;
	private JTextField idField;
	
	
	
	private JButton submitBtn,cancelBtn;
	
	
	public GenreManagerWindow(Library library) {
		
		this.library=library;
		this.genre=genre;
		
		
		
		
		setTitle("Genres");
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
	
	public GenreManagerWindow(Library library,Genre genre) {
			
			
			this.library=library;
			this.genre=genre;
			
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
		
		this.name = new JLabel("Name");
		this.description = new JLabel("Description");
		this.id = new JLabel("Id");
		
		
	}
	
	private void createEmptyFields() {
	
		this.nameField = new JTextField();
		 this.descriptionField = new JTextField();
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 
		 
		 
		
		
	}
	
	private void createFields() {
		
		
		
		
		this.nameField = new JTextField(genre.getName());
		 this.descriptionField = new JTextField(genre.getDescription());
		 this.idField = new JTextField(genre.getId());
		 
		
		
	}
	
	
	
	
	
	
	private void fillPanel() {
		panel.add(name);
		panel.add(nameField,"width 100%,wrap");
		panel.add(description);
		panel.add(descriptionField,"width 100%,wrap");
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		
		
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
				String name=nameField.getText();
				String description=descriptionField.getText();
				String id=idField.getText();
				
				boolean isDeleted=false;
				if(genre==null) {
					if(library.addNewGenre(name, description, id, isDeleted)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Genre successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Genre not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateGenre(name, description, id, isDeleted)) {
						JOptionPane.showMessageDialog(null,"Member successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Member not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

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
