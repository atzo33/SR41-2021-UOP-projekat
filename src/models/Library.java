package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import ennumerations.Binding;
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
    
    private ArrayList<Staff> allStaff = new ArrayList<Staff>();
    
    public Library() {
    	this.name = "";
		this.address = "";
		this.workingHours = "";
		this.phoneNumber = "";
		this.id = "";
    	
    }
    
	public Library(String name, String address, String workingHours, String phoneNumber, String id) {
		super();
		this.name = name;
		this.address = address;
		this.workingHours = workingHours;
		this.phoneNumber = phoneNumber;
		this.id = id;
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
    
    
    
    
    private String preWritingMembershipCost(MembershipCost membership) {
        return String.format("%s|%s|%s\n", membership.getId(), membership.getType(), membership.getPrice());
    }
    
    public void writeMembershipCost(ArrayList<MembershipCost> allMemberships) {
        try {
            
            BufferedWriter membershipFile = new BufferedWriter(new FileWriter("src/text/memberships.txt"));
            for(MembershipCost me: allMemberships) {
                
                membershipFile.write(this.preWritingMembershipCost(me));
            }membershipFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<MembershipCost> readMembershipCost(){
        
        try {
            File membershipFile = new File("src/text/memberships.txt");
            BufferedReader reader = new BufferedReader(new FileReader(membershipFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String id = splitLines[0];
                String type = splitLines[1];
                double price =Double.parseDouble(splitLines[2]) ;
                MembershipCost membership = new MembershipCost(id,type,price);
                allTypes.add(membership);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allTypes;
        
    } 
    
    
    
    
    

    
    private String preWritingMember(Member member) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", member.getCardNumber(), member.getLastMembershipExtension(), member.getMembershipDuration(),
        		member.isActive,member.getMembership().getId(),member.getFirstName(),member.getLastName(),member.getAdress(),member.getId(),member.getGender(),member.isDeleted());
    }
    
    public void writeMembers(ArrayList<Member> allMembers) {
        try {
            
            BufferedWriter membersFile = new BufferedWriter(new FileWriter("src/text/members.txt"));
            for(Member m: allMembers) {
                
                membersFile.write(this.preWritingMember(m));
            }membersFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    
    public ArrayList<Member> readMembers(){
    	
////      1.String cardNumber,2. LocalDate lastMembershipExtension,3. int membershipDuration,
//    	4. boolean isActive,5.MembershipCost membership,5.String firstName,6.
//    	String lastName,7. String adress,8. String id,9. Gender gender,10. boolean isDeleted
        
        try {
            File membersFile = new File("src/text/members.txt");
            BufferedReader reader = new BufferedReader(new FileReader(membersFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String cardNumber = splitLines[0];
                LocalDate lastMembershipExtension =LocalDate.parse(splitLines[1]);
                int membershipDuration = Integer.parseInt(splitLines[2]);
                boolean isActive=Boolean.parseBoolean(splitLines[3]);
                MembershipCost membership=null;
                
                for(MembershipCost m : this.allTypes){
                if(m.getId().equals(splitLines[4]))
                	
                membership=m;
                
                }
                
                String firstName=splitLines[5];
                String lastName=splitLines[6];
                String adress=splitLines[7];
                String id=splitLines[8];
                Gender gender=Gender.valueOf(splitLines[9]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[10]);
                
                
////            1.String cardNumber,2. LocalDate lastMembershipExtension,3. int membershipDuration,
//            	4. boolean isActive,5.MembershipCost membership,5.String firstName,6.
//            	String lastName,7. String adress,8. String id,9. Gender gender,10. boolean isDeleted
                
                
          
                Member member = new Member(cardNumber,lastMembershipExtension,membershipDuration,isActive,membership,firstName,lastName,adress,id,gender,isDeleted);
                allMembers.add(member);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allMembers;
        
    } 
    
    
    
    
// int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
//	Language language, boolean isDeleted  	 
    
    private String preWritingCopyOfABook(CopyOfABook copyOfABook) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s\n", copyOfABook.getPageNumbers(), copyOfABook.getPrintingYear(),copyOfABook.isRented(),copyOfABook.isRented(),
        		copyOfABook.getId(),copyOfABook.getBinding(),copyOfABook.getBook(),copyOfABook.getLanguage(),copyOfABook.isDeleted());
    }
    
    public void writeCopyOfABook(ArrayList<CopyOfABook> allCopies) {
        try {
            
            BufferedWriter copiesFile = new BufferedWriter(new FileWriter("src/text/copies.txt"));
            for(CopyOfABook c: allCopies) {
                
                copiesFile.write(this.preWritingCopyOfABook(c));
            }copiesFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<CopyOfABook> readCopyOfABook(){
        
        try {
            File copiesFile = new File("src/text/copies.txt");
            BufferedReader reader = new BufferedReader(new FileReader(copiesFile));
            String line;
            
 //int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
// Language language, boolean isDeleted 

            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                int pageNumbers=Integer.valueOf(splitLines[0]) ;
                int printingYear=Integer.valueOf(splitLines[1]);
                boolean isRented =Boolean.parseBoolean(splitLines[2]);
                String id=splitLines[3];
                Binding binding=Binding.valueOf(splitLines[4]);
                Book book=null;
                for(Book bo:allBooks) {
                	if (bo.getId().equals(splitLines[5]))
                	book=bo;
                }            
                Language language=Language.valueOf(splitLines[6]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[7]);
                CopyOfABook copyOfABook = new CopyOfABook(pageNumbers,printingYear,isRented,id,binding,book,language,isDeleted);
                allCopies.add(copyOfABook);

                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allCopies;
        
    } 
    
    
    
    
    
    
    
//    LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member
   
    private void getallStaff(){
    	for(Admin a:allAdmins) {
    		allStaff.add(a);
    		
    	}
    	for (Librarian l:allLibrarians) {
    		allStaff.add(l);
    	}
    }
    private String preWritingRentABook(RentABook rentABook) {
        return String.format("%s|%s|%s|%s|%s\n", rentABook.getRentalDate(), rentABook.getReturningDate(), rentABook.getCopyOfABook(),rentABook.getStaff(),rentABook.getMember());
    }
    
    public void writeRentABook(ArrayList<RentABook> allRents) {
        try {
            
            BufferedWriter rentsFile = new BufferedWriter(new FileWriter("src/text/rents.txt"));
            for(RentABook r: allRents) {
                
                rentsFile.write(this.preWritingRentABook(r));
            }rentsFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<RentABook> readRentABook(){
        
        try {
            File rentsFile = new File("src/text/rents.txt");
            BufferedReader reader = new BufferedReader(new FileReader(rentsFile));
            String line;
            
// LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member

            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                LocalDate rentalDate=LocalDate.parse(splitLines[0]) ;
                LocalDate returningDate=LocalDate.parse(splitLines[1]);
                CopyOfABook copyOfABook= null;
                for(CopyOfABook cob:allCopies) {
                	if (cob.getId().equals(splitLines[2]))
                	copyOfABook=cob;
                }
                Staff staff=null;
                for(Staff s:allStaff) {
                	if (s.getId().equals(splitLines[3]))
                	staff=s;
                }
                Member member=null;
                for(Member me:allMembers) {
                	if (me.getId().equals(splitLines[4]))
                	member=me;
                }
                
                RentABook rentABook = new RentABook(rentalDate,returningDate,copyOfABook,staff,member);
                allRents.add(rentABook);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allRents;
        
    } 
    
    
    
//    String username, String password, double paycheck, String id
    private String preWritingAdmin(Admin admin) {
        return String.format("%s|%s|%s|%s\n", admin.getUsername(), admin.getPassword(), admin.getPaycheck(),admin.getId());
    }
    
    public void writeAdmin(ArrayList<Admin> allAdmins) {
        try {
            
            BufferedWriter adminFile = new BufferedWriter(new FileWriter("src/text/admins.txt"));
            for(Admin ad: allAdmins) {
                
                adminFile.write(this.preWritingAdmin(ad));
            }adminFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    
//  String username, String password, double paycheck, String id
    public ArrayList<Admin> readAdmin(){
        
        try {
            File adminFile = new File("src/text/admins.txt");
            BufferedReader reader = new BufferedReader(new FileReader(adminFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String username = splitLines[0];
                String password = splitLines[1];
                double paycheck=Double.parseDouble(splitLines[2]) ;
                String id= splitLines[3];
                Admin admin = new Admin(username,password,paycheck,id);
                allAdmins.add(admin);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allAdmins;
        
    } 
    
    
    
    
    
    
    private String preWritingLibrarian(Librarian librarian) {
        return String.format("%s|%s|%s|%s\n", librarian.getUsername(), librarian.getPassword(), librarian.getPaycheck(),librarian.getId());
    }
    
    public void writeLibrarian(ArrayList<Librarian> allALibrarians) {
        try {
            
            BufferedWriter librarianFile = new BufferedWriter(new FileWriter("src/text/librarians.txt"));
            for(Librarian li: allLibrarians) {
                
                librarianFile.write(this.preWritingLibrarian(li));
            }librarianFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    
//  String username, String password, double paycheck, String id
    public ArrayList<Librarian> readLibrarian(){
        
        try {
            File librarianFile = new File("src/text/librarians.txt");
            BufferedReader reader = new BufferedReader(new FileReader(librarianFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String username = splitLines[0];
                String password = splitLines[1];
                double paycheck=Double.parseDouble(splitLines[2]) ;
                String id= splitLines[3];
                Librarian librarian = new Librarian(username,password,paycheck,id);
                allLibrarians.add(librarian);
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allLibrarians;
        
    } 
    
    
    
    
    
    
    
    
    private String preWritingLibrary() {
        return String.format("%s|%s|%s|%s|%s\n", this.getAddress(),this.getName(),this.getPhoneNumber(),this.getWorkingHours() ,this.getId());
    }
    
    public void writeLibrary() {
        try {
            
            BufferedWriter libraryFile = new BufferedWriter(new FileWriter("src/text/library.txt"));
            libraryFile.write(this.preWritingLibrary());
            
            libraryFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    
//  String username, String password, double paycheck, String id
    public static Library readLibrary(){
        Library libraryRet=null;
        try {
            File libraryFile = new File("src/text/library.txt");
            BufferedReader reader = new BufferedReader(new FileReader(libraryFile));
            String line;
            while((line = reader.readLine()) != null) {
                String[] splitLines = line.split("\\|");
                String adress = splitLines[0];
                String name = splitLines[1];
                String phoneNumber=splitLines[2] ;
                String workingHours= splitLines[3];
                String id=splitLines[4];
                Library library = new Library(adress,name,phoneNumber,workingHours,id);
               
                libraryRet=library;   
            }
            
//this.getAddress(),this.getName(),this.getPhoneNumber(),this.getWorkingHours() ,this.getId());
            reader.close();
            
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return libraryRet;    
        
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
    
    

}

