package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import ennumerations.Gender;
import ennumerations.Language;

public class Library {
	
	private String name;

    private String address;

    private String workingHours;

    private String phoneNumber;

    private String id;

    private ArrayList<Book> allBooks = new ArrayList<Book>();

    private ArrayList<Member> allMembers = new ArrayList<Member>();

    private ArrayList<Librarian> allLibrarians = new ArrayList<Librarian>();
    
    private ArrayList<Admin> allAdmins = new ArrayList<Admin>();

    private ArrayList<CopyOfABook> allCopies = new ArrayList<CopyOfABook>();

    private ArrayList<MembershipCost> allTypes = new ArrayList<MembershipCost>();

    private ArrayList<Genre> allGenres = new ArrayList<Genre>();
    
    private ArrayList<RentABook> allRents = new ArrayList<RentABook>();
    
    public Library() {
    	this.name = "";
		this.address = "";
		this.workingHours = "";
		this.phoneNumber = "";
		this.id = "";
    	
    }

	public Library(String name, String address, String workingHours, String phoneNumber, String id,ArrayList<Book> allBooks,
			ArrayList<Member> allMembers,ArrayList<Librarian> allLibrarians,ArrayList<Admin> allAdmins,ArrayList<CopyOfABook> allCopies,
			ArrayList<MembershipCost> allTypes,ArrayList<Genre> allGenres,ArrayList<RentABook> allRents
			) {
		
		this.name = name;
		this.address = address;
		this.workingHours = workingHours;
		this.phoneNumber = phoneNumber;
		this.id = id;
		this.allBooks=allBooks;
		this.allMembers=allMembers;
		this.allLibrarians=allLibrarians;
		this.allAdmins=allAdmins;
		this.allCopies=allCopies;
		this.allTypes=allTypes;
		this.allGenres=allGenres;
		this.allRents=allRents;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(ArrayList<Book> allBooks) {
		this.allBooks = allBooks;
	}

	public ArrayList<Member> getAllMembers() {
		return allMembers;
	}

	public void setAllMembers(ArrayList<Member> allMembers) {
		this.allMembers = allMembers;
	}

	

	public ArrayList<Librarian> getAllLibrarians() {
		return allLibrarians;
	}

	public void setAllLibrarians(ArrayList<Librarian> allLibrarians) {
		this.allLibrarians = allLibrarians;
	}

	public ArrayList<Admin> getAllAdmins() {
		return allAdmins;
	}

	public void setAllAdmins(ArrayList<Admin> allAdmins) {
		this.allAdmins = allAdmins;
	}

	public ArrayList<CopyOfABook> getAllCopies() {
		return allCopies;
	}

	public void setAllCopies(ArrayList<CopyOfABook> allCopies) {
		this.allCopies = allCopies;
	}

	public ArrayList<MembershipCost> getAllTypes() {
		return allTypes;
	}

	public void setAllTypes(ArrayList<MembershipCost> allTypes) {
		this.allTypes = allTypes;
	}

	public ArrayList<Genre> getAllGenres() {
		return allGenres;
	}

	public void setAllGenres(ArrayList<Genre> allGenres) {
		this.allGenres = allGenres;
	}
	
	
	
	
	private String preWritingGenre(Genre genre) {
        return String.format("%s|%s|%s\n", genre.getName(), genre.getDescription(), genre.getId());
    }
    
    public void writeGenre(ArrayList<Genre> allGenres) {
        try {
            
            BufferedWriter genresFile = new BufferedWriter(new FileWriter("src/text/genres.txt"));
            for(Genre g: allGenres) {
                
                genresFile.write(this.preWritingGenre(g));
            }genresFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<Genre> readGenres(){
        
        try {
            File genreFile = new File("src/text/genres.txt");
            BufferedReader reader = new BufferedReader(new FileReader(genreFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String name = splitLines[0];
                String description = splitLines[1];
                String id = splitLines[2];
                Genre genre = new Genre(name,description,id);
                allGenres.add(genre);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allGenres;
        
    } 
    
    
    
    
    
    
//    (String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
//			Genre genre, Language language,boolean isDeleted)
    
    private String preWritingBook(Book book) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s\n", book.getTitle(), book.getOriginalTitle(), book.getWriter(),
        		book.getReleaseDate(),book.getDescription(),book.getId(),book.getGenre().getId(),book.getLanguage(),book.isDeleted());
    }
    
    public void writeBook(ArrayList<Book> allBooks) {
        try {
            
            BufferedWriter bookFile = new BufferedWriter(new FileWriter("src/text/books.txt"));
            for(Book b: allBooks) {
                
                bookFile.write(this.preWritingBook(b));
            }bookFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<Book> readBook(ArrayList<Genre>allGenres){

//    	
//    	
//    	private LocalDate releaseDate;
//    	private String description;
//    	private String id;
//    	private Genre genre;
//    	private Language language;
//    	private boolean isDeleted;
    	
        try {
            File bookFile = new File("src/text/books.txt");
            BufferedReader reader = new BufferedReader(new FileReader(bookFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String title = splitLines[0];
                String originalTitle = splitLines[1];
                String writer = splitLines[2];
                LocalDate releaseDate=LocalDate.parse(splitLines[3]);
                String description= splitLines[4];
                String id= splitLines[5];
                Genre genre= null;
                for(Genre g:allGenres){
                if(g.getId().equals(splitLines[6]))
                	
                genre=g;
                
                }
                Language language= Language.valueOf(splitLines[7]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[8]);
                Book book = new Book(title,originalTitle,writer,releaseDate,description,id,genre,language,isDeleted);
                allBooks.add(book);
                
            
                
                
                
                
                
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allBooks;
        
    } 
    
    
    
    
    

    
    private String preWritingMember(Member member) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", member.getCardNumber(), member.getLastMembershipExtension(), member.getMembershipDuration(),
        		member.isActive,member.getMembership(),member.getFirstName(),member.getLastName(),member.getAdress(),member.getId(),member.getGender(),member.isDeleted());
    }
    
    public void writeMember(ArrayList<Member> allMembers) {
        try {
            
            BufferedWriter membersFile = new BufferedWriter(new FileWriter("src/text/members.txt"));
            for(Member m: allMembers) {
                
                membersFile.write(this.preWritingGenre(m));
            }membersFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    
    public ArrayList<Member> readMembers(){
    	
//      1.String cardNumber,2. LocalDate lastMembershipExtension,3. int membershipDuration,4. boolean isActive,5.MembershipCost membership,5.String firstName,6. String lastName,7. String adress,8. String id,9. Gender gender,10. boolean isDeleted
        
        try {
            File membersFile = new File("src/text/members.txt");
            BufferedReader reader = new BufferedReader(new FileReader(membersFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String cardNumber = splitLines[0];
                LocalDate lastMembershipExtension =LocalDate.parse(splitLines[1]);
                int id = Integer.parseInt(splitLines[2]);
                boolean isActive=Boolean.parseBoolean(splitLines[3]);
                MembershipCost membership=splitLines[4];
                String firstName=splitLines[5];
                String lastName=splitLines[6];
                String adress=splitLines[7];
                String id=splitLines[8];
                Gender gender=splitLines[9];
                boolean isDeleted=Boolean.parseBoolean(splitLines[10]);
                
                
          
                Genre genre = new Genre(name,description,id);
                allGenres.add(genre);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allGenres;
        
    } 
	
    
    

}

