package managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ennumerations.Binding;
import ennumerations.Language;
import models.Book;
import models.CopyOfABook;
import models.Genre;
import models.Library;
import models.MembershipCost;
import net.miginfocom.swing.MigLayout;

public class CopyOfABookManagerWindow extends JFrame {


	



	
	
	private Library library;
	
	
	private JPanel panel;
	
	private JLabel pageNumbers;
	private JLabel printingYear;
	private JLabel isRented;
	private JLabel id;
	private JLabel binding;
	private JLabel book;
	private JLabel language;
	
	
	
	
	
	private JTextField pageNumbersField;
	private JTextField printingYearField;
	private JCheckBox isRentedField;
	private JTextField idField;
	private JComboBox bindingField;
	private JComboBox bookField;
	private JComboBox languageField;
	
	
	
	
	private JButton submitBtn,cancelBtn;
	private ArrayList<Book>books;
	private CopyOfABook copyOfABook;
	
	
	
	
	
	public CopyOfABookManagerWindow(Library library) {
		
		this.library=library;
		this.book=book;
		this.copyOfABook=copyOfABook;
		
		this.books=library.allActiveBooks();
		
		
		
		setTitle("Copies of a book");
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
	
	public CopyOfABookManagerWindow(Library library,CopyOfABook copyOfABook) {
			
			this.books=library.allActiveBooks();
			this.library=library;
			this.copyOfABook=copyOfABook;
			
			
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
		
		this.pageNumbers = new JLabel("Page numbers");
		this.printingYear = new JLabel("Printing year");
		this.isRented = new JLabel("Is rented?");
		this.id = new JLabel("Id");
		this.binding = new JLabel("Binding");
		this.book = new JLabel("Book");
		this.language = new JLabel("Language");
		
		
		
	}
	
	private void createEmptyFields() {
		
		 DefaultComboBoxModel booklist= new DefaultComboBoxModel();
		 for(Book book:this.books) {
			 booklist.addElement(book.getTitle());
		 }
	
		 
		 this.pageNumbersField = new JTextField();
		 this.printingYearField = new JTextField();
		 this.isRentedField = new JCheckBox();
		 this.idField = new JTextField(UUID.randomUUID().toString());
		 this.bindingField = new JComboBox(Binding.values());
		 this.bookField=new JComboBox(booklist);
		 this.languageField = new JComboBox(Language.values());
		 
		 
		 
		
		
	}
	
	private void createFields() {
		
		DefaultComboBoxModel booklist= new DefaultComboBoxModel();
		 for(Book book:this.books) {
			 booklist.addElement(book.getTitle());
		 }
		
		
		 this.pageNumbersField = new JTextField(String.valueOf(copyOfABook.getPageNumbers()));
		 this.printingYearField = new JTextField(String.valueOf(copyOfABook.getPrintingYear()));
		 this.isRentedField = new JCheckBox();
		 isRentedField.setSelected(copyOfABook.isRented());
		 this.idField = new JTextField(copyOfABook.getId());
		 this.bookField = new JComboBox(booklist);
		 bookField.setSelectedItem(copyOfABook.getBook().getTitle());
		 this.bindingField=new JComboBox(Binding.values());
		 this.languageField = new JComboBox(Language.values());
		 
		 
	
	}
	
	
	
	
	private void fillPanel() {
		panel.add(pageNumbers);
		panel.add(pageNumbersField,"width 100%,wrap");
		panel.add(printingYear);
		panel.add(printingYearField,"width 100%,wrap");
		panel.add(isRented);
		panel.add(isRentedField,"width 100%,wrap");
		panel.add(id);
		panel.add(idField,"width 100%,wrap");
		panel.add(book);
		panel.add(bookField,"width 100%,wrap");
		panel.add(binding);
		panel.add(bindingField,"width 100%,wrap");
		panel.add(language);
		panel.add(languageField,"width 100%,wrap");
		
		
		
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
				int pageNumbers=Integer.parseInt(pageNumbersField.getText());
				int printingYear=Integer.parseInt(printingYearField.getText());
				boolean isRented=isRentedField.isSelected();
				String id=idField.getText();
				Binding binding=Binding.valueOf(bindingField.getSelectedItem().toString());
				int selectedBook=bookField.getSelectedIndex();
				Book book=books.get(selectedBook);
				Language language=Language.valueOf(languageField.getSelectedItem().toString());
				
				
				
				boolean isDeleted=false;
				if(copyOfABook==null) {
					if(library.addNewCopyOfABook(pageNumbers, printingYear, isRented, id, binding, book, language, isDeleted)) {
						System.out.println("4");
						JOptionPane.showMessageDialog(null,"Copy of a book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);
					}	
					else {
						JOptionPane.showMessageDialog(null,"Copy of a book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

					}
					
				}
				else {
					if(library.updateCopyOfABook(pageNumbers, printingYear, isRented, id, binding, book, language, isDeleted)) {
						JOptionPane.showMessageDialog(null,"Copy of a book successfully added","Success!",JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Copy of a book not added!!","Fail :(",JOptionPane.WARNING_MESSAGE);

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
