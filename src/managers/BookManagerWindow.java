package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ennumerations.Language;
import models.Admin;
import models.Book;
import models.Genre;
import models.Library;
import models.Staff;
import net.miginfocom.swing.MigLayout;

public class BookManagerWindow extends JFrame{
	



	
	private Staff staff;
	private Library library;
	private Admin admin;
	
	private JPanel panel;
	
	private JLabel title;
	private JLabel originalTitle;
	private JLabel writer;
	private JLabel id;
	private JLabel releaseDate;
	private JLabel description;
	private JLabel genre;
	private JLabel language;
	
	
	
	
	private JTextField titleField;
	private JTextField originalTitleField;
	private JTextField writerField;
	private JTextField idField;
	private JComboBox genreField;
	private JTextField releaseDateField;
	private JTextField descriptionField;
	private JComboBox languageField;
	
	
	
	private JButton submitBtn,cancelBtn;
	private ArrayList<Genre>genres;
	private Book book;
	
	
	
	
	public BookManagerWindow(Library library) {
		
		this.library=library;
		
		
		this.genres=library.allActiveGenres();
		
		
		
		setTitle("Books");
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.panel= new JPanel(new MigLayout());
		add(panel);
		writeLabels();
		createEmptyFields();
		fillPanel();
		initButtons();
		
		
	}
	
	public BookManagerWindow(Library library,Book book) {
			
			this.genres=library.allActiveGenres();
			this.library=library;
			this.book=book;
			
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
			
			
			idField.setEditable(false);
			
			
		}
	private void writeLabels() {
		
		this.title = new JLabel("Title");
		this.originalTitle = new JLabel("Original title");
		this.writer = new JLabel("Writer");
		this.id = new JLabel("Id");
		this.genre = new JLabel("Genre");
		this.releaseDate = new JLabel("Release date");
		this.description = new JLabel("Description");
		this.language = new JLabel("Language");
		
		
	}
	
	private void createEmptyFields() {
		
		 DefaultComboBoxModel genlist= new DefaultComboBoxModel();
		 for(Genre genre:this.genres) {
			 genlist.addElement(genre.getName());
		 }
	
		 
		 this.titleField = new JTextField();
		 this.originalTitleField = new JTextField();
		 this.writerField = new JTextField();
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.genreField = new JComboBox(genlist);
		 this.releaseDateField=new JTextField();
		 this.languageField = new JComboBox(Language.values());
		 this.descriptionField = new JTextField();
		 
		 
		
		
	}
	
	private void createFields() {
		
		 DefaultComboBoxModel genlist= new DefaultComboBoxModel();
		 for(Genre genre:this.genres) {
			 genlist.addElement(genre.getName());
		 }
		
		
		 this.titleField = new JTextField(book.getTitle());
		 this.originalTitleField = new JTextField(book.getOriginalTitle());
		 this.writerField = new JTextField(book.getWriter());
		 this.idField = new JTextField(book.getId());
		 this.genreField = new JComboBox(genlist);
		 genreField.setSelectedItem(book.getGenre().getName());
		 this.releaseDateField=new JTextField(book.getReleaseDate().toString());
		 this.languageField = new JComboBox(Language.values());
		 this.descriptionField = new JTextField(book.getDescription());
		 
	
	}
	
	
	
	
	private void fillPanel() {
		panel.add(title);
		panel.add(titleField,"width 100%,wrap");
		panel.add(originalTitle);
		panel.add(originalTitleField,"width 100%,wrap");
		panel.add(writer);
		panel.add(writerField,"width 100%,wrap");
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(genre);
		panel.add(genreField,"width 100%,wrap");
		panel.add(releaseDate);
		panel.add(releaseDateField,"width 100%,wrap");
		panel.add(language);
		panel.add(languageField,"width 100%,wrap");
		panel.add(description);
		panel.add(descriptionField,"width 100%,wrap");
		
		
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
				String title=titleField.getText();
				String originalTitle=originalTitleField.getText();
				String writer=writerField.getText();
				LocalDate releaseDate=LocalDate.parse(releaseDateField.getText());
				String description=descriptionField.getText();
				String id=idField.getText();
				int selectedGenre=genreField.getSelectedIndex();
				Genre genre=genres.get(selectedGenre);
				Language language=Language.valueOf(languageField.getSelectedItem().toString());
				
				
				boolean isDeleted=false;
				if(book==null) {
					if(library.addNewBook(title, originalTitle, writer, releaseDate, description, id, genre, language, isDeleted)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateBook(title, originalTitle, writer, releaseDate, description, id, genre, language, isDeleted)) {
						JOptionPane.showMessageDialog(null,"Book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

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
