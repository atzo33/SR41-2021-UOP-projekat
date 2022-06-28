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
	
	
	
	
	public ArrayList<RentABook> getAllRents() {
		return allRents;
	}

	public void setAllRents(ArrayList<RentABook> allRents) {
		this.allRents = allRents;
	}

	public ArrayList<Staff> getAllStaff() {
		return allStaff;
	}

	public void setAllStaff(ArrayList<Staff> allStaff) {
		this.allStaff = allStaff;
	}

	private String preWritingGenre(Genre genre) {
        return String.format("%s|%s|%s|%s\n", genre.getName(), genre.getDescription(), genre.getId(),genre.isDeleted());
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
                boolean isDeleted=Boolean.parseBoolean(splitLines[3]);
//                Genre genre = new Genre(name,description,id,isDeleted);
//                allGenres.add(genre);
                
                
                Genre genre = new Genre(name,description,id,isDeleted);               
                boolean duplicate=false;
                for (Genre gen:this.getAllGenres()) {
                	if(gen.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allGenres.add(genre);
                }
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allGenres;
        
    } 
    
    
    public ArrayList<Genre>allActiveGenres(){
    	ArrayList<Genre> list=new ArrayList<Genre>();
    	for(Genre genre:this.getAllGenres()) {
    		if(!genre.isDeleted()) {
    			list.add(genre);
    		}
    	}
    	return list;
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
    
    public ArrayList<Book> readBook(){

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
                for(Genre g:this.getAllGenres()){
                if(g.getId().equals(splitLines[6]))
                	
                genre=g;
                
                }
                Language language= Language.valueOf(splitLines[7]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[8]);
//                Book book = new Book(title,originalTitle,writer,releaseDate,description,id,genre,language,isDeleted);
//                allBooks.add(book);
                
                
                
                Book book = new Book(title,originalTitle,writer,releaseDate,description,id,genre,language,isDeleted);              
                boolean duplicate=false;
                for (Book bok:this.getAllBooks()) {
                	if(bok.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allBooks.add(book);
                }
            
                
                
                
                
                
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allBooks;
        
    } 
    
    public ArrayList<Book>allActiveBooks(){
    	ArrayList<Book> list=new ArrayList<Book>();
    	for(Book book:this.getAllBooks()) {
    		if(!book.isDeleted()) {
    			list.add(book);
    		}
    	}
    	return list;
    }
    
    
    
    
    private String preWritingMembershipCost(MembershipCost membership) {
        return String.format("%s|%s|%s|%s\n", membership.getId(), membership.getType(), membership.getPrice(),membership.isDeleted());
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
                boolean isDeleted=Boolean.parseBoolean(splitLines[3]);
                
                MembershipCost membership = new MembershipCost(id,type,price,isDeleted);
                
                
                boolean duplicate=false;
                for (MembershipCost memc:this.getAllTypes()) {
                	if(memc.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allTypes.add(membership);
                }
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allTypes;
        
    } 
    
    public ArrayList<MembershipCost>allActiveMemberships(){
    	ArrayList<MembershipCost> list=new ArrayList<MembershipCost>();
    	for(MembershipCost membership:this.getAllTypes()) {
    		if(!membership.isDeleted()) {
    			list.add(membership);
    		}
    	}
    	return list;
    }
    
    
    

    
    private String preWritingMember(Member member) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", member.getCardNumber(), member.getLastMembershipExtension(), member.getMembershipDuration(),
        		member.isActive,member.getMembership().getId(),member.getFirstName(),member.getLastName(),member.getAdress(),member.getId(),member.getGender(),member.isDeleted(),member.getJMBG());
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
                String JMBG=splitLines[11];
                
////            1.String cardNumber,2. LocalDate lastMembershipExtension,3. int membershipDuration,
//            	4. boolean isActive,5.MembershipCost membership,5.String firstName,6.
//            	String lastName,7. String adress,8. String id,9. Gender gender,10. boolean isDeleted
                
                
          
                Member member = new Member(cardNumber,lastMembershipExtension,membershipDuration,isActive,membership,firstName,lastName,adress,id,gender,isDeleted,JMBG);
                boolean duplicate=false;
                for (Member mem:this.getAllMembers()) {
                	if(mem.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allMembers.add(member);
                }
                
                
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allMembers;
        
    } 
    
    public ArrayList<Member>allActiveMembers(){
    	ArrayList<Member> list=new ArrayList<Member>();
    	for(Member member:this.getAllMembers()) {
    		if(!member.isDeleted()) {
    			list.add(member);
    		}
    	}
    	return list;
    }
    
    
    
    
    
// int pageNumbers, int printingYear, boolean isRented, String id, Binding binding, Book book,
//	Language language, boolean isDeleted  	 
    
    private String preWritingCopyOfABook(CopyOfABook copyOfABook) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s\n", copyOfABook.getPageNumbers(), copyOfABook.getPrintingYear(),copyOfABook.isRented(),
        		copyOfABook.getId(),copyOfABook.getBinding(),copyOfABook.getBook().getId(),copyOfABook.getLanguage(),copyOfABook.isDeleted());
    }
    
    public void writeCopyOfABook(ArrayList<CopyOfABook> allCopies) {
        try {
            
            BufferedWriter copiesFile = new BufferedWriter(new FileWriter("src/text/copies.txt"));
            for(CopyOfABook c: allCopies) {
                String line=preWritingCopyOfABook(c);
                System.out.println(line);
                copiesFile.write(this.preWritingCopyOfABook(c));
            }copiesFile.close();
            
        }catch(IOException e) { e.printStackTrace(); }
    }
    
    public ArrayList<CopyOfABook> readCopyOfABook(){
        this.readBook();
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
                boolean duplicate=false;
                for (CopyOfABook cob:this.getAllCopies()) {
                	if(cob.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allCopies.add(copyOfABook);
                }

                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allCopies;
        
    } 
    
    
    public ArrayList<CopyOfABook>allActiveCopies(){
    	ArrayList<CopyOfABook> list=new ArrayList<CopyOfABook>();
    	for(CopyOfABook copyOfABook:this.getAllCopies()) {
    		if(!copyOfABook.isDeleted()) {
    			list.add(copyOfABook);
    		}
    	}
    	return list;
    }
    
    
    
    
    
    
    
////    LocalDate rentalDate, LocalDate returningDate, CopyOfABook copyOfABook,Staff staff,Member member
//   
   private void getStaffList(){
	   this.readLibrarian();
	   this.readAdmin();
    	for(Admin a:allAdmins) {
    		allStaff.add(a);
    		
    	}
    	for (Librarian l:allLibrarians) {
    		allStaff.add(l);
    	}
   }
    
    
    private String preWritingRentABook(RentABook rentABook) {
        return String.format("%s|%s|%s|%s|%s|%s|%s\n", rentABook.getRentalDate(), rentABook.getReturningDate(), rentABook.getCopyOfABook().getId(),rentABook.getStaff().getId(),rentABook.getMember().getId(),rentABook.isDeleted(),rentABook.getId());
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
        this.getStaffList();
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
                for(CopyOfABook cob:this.getAllCopies()) {
                	if (cob.getId().equals(splitLines[2]))
                	copyOfABook=cob;
                }
                Staff staff=null;
                for(Staff s:this.getAllStaff()) {
                	
                	if (s.getId().equals(splitLines[3]))
                	staff=s;
                	System.out.println(s instanceof Admin);
                }
                Member member=null;
                for(Member me:this.getAllMembers()) {
                	if (me.getId().equals(splitLines[4]))
                	member=me;
                }
                boolean isDeleted=Boolean.parseBoolean(splitLines[5]);
                String id=splitLines[6];
                
                
                
                
                
                RentABook rentABook = new RentABook(rentalDate,returningDate,copyOfABook,staff,member,isDeleted,id);      
                boolean duplicate=false;
                for (RentABook rab:this.getAllRents()) {
                	if(rab.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allRents.add(rentABook);
                }
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allRents;
        
    } 
    
    
    public ArrayList<RentABook>allActiveRents(){
    	ArrayList<RentABook> list=new ArrayList<RentABook>();
    	for(RentABook rentABook:this.getAllRents()) {
    		if(!rentABook.isDeleted()) {
    			list.add(rentABook);
    		}
    	}
    	return list;
    }
    
    
//  String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG  
//    String username, String password, double paycheck, String id
    private String preWritingAdmin(Admin admin) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", admin.getUsername(), admin.getPassword(), admin.getPaycheck(),admin.getId(),admin.getFirstName(),admin.getLastName(),admin.getAdress(),admin.getGender(),admin.isDeleted,admin.getJMBG());
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
//    String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG
    public ArrayList<Admin> readAdmin(){
    	
//    	admin.getFirstName(),admin.getLastName(),admin.getAdress(),,admin.getGender(),admin.isDeleted,admin.getJMBG()
        
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
                String FirstName=splitLines[4];
                String LastName=splitLines[5];
                String Adress=splitLines[6];
                Gender gender=Gender.valueOf(splitLines[7]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[8]);
                String JMBG=splitLines[9];
                
//                String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG,String username, String password, double paycheck
                
                
                
                Admin admin = new Admin(FirstName,LastName,Adress,id,gender,isDeleted,JMBG,username,password,paycheck);    
                boolean duplicate=false;
                for (Admin adm:this.getAllAdmins()) {
                	if(adm.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allAdmins.add(admin);
                }
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allAdmins;
        
    } 
    
    public ArrayList<Admin> allActiveAdmins() {
		ArrayList<Admin> active = new ArrayList<Admin>();
		for (Admin admin : this.getAllAdmins()) {
			if(!admin.isDeleted()) {
				active.add(admin);
			}
		}
		return active;
	}
	
    
    
    
    
    
    
    private String preWritingLibrarian(Librarian librarian) {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", librarian.getFirstName(),librarian.getLastName(),librarian.getAdress(),librarian.getId(),librarian.getGender(),librarian.isDeleted(),librarian.getJMBG(),librarian.getUsername(),librarian.getPassword(),librarian.getPaycheck());
    }
//    firstName,lastName,adress,id,gender,isDeleted,JMBG,username,password,paycheck
    public void writeLibrarian(ArrayList<Librarian> allALibrarians) {
        try {
            
            BufferedWriter librarianFile = new BufferedWriter(new FileWriter("src/text/librarians.txt"));
            for(Librarian li: this.getAllLibrarians()) {
                
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
                String firstName=splitLines[0];
                String lastName=splitLines[1];
                String adress=splitLines[2];
                String id= splitLines[3];
                Gender gender=Gender.valueOf(splitLines[4]);
                boolean isDeleted=Boolean.parseBoolean(splitLines[5]);
                String JMBG=splitLines[6];
                String username = splitLines[7];
                String password = splitLines[8];
                double paycheck=Double.parseDouble(splitLines[9]) ;
                
                
                
                
                
                Librarian librarian = new Librarian(firstName,lastName,adress,id,gender,isDeleted,JMBG,username,password,paycheck); 
                boolean duplicate=false;
                for (Librarian lib:this.getAllLibrarians()) {
                	if(lib.getId().equals(id)) {
                		duplicate=true;
                		break;
                	}
                }
                if (!duplicate) {
                	allLibrarians.add(librarian);
                }
                
            }
            reader.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        
    }
        return allLibrarians;
        
    } 
    
    
    public ArrayList<Librarian>allActiveLibrarians(){
    	ArrayList<Librarian> list=new ArrayList<Librarian>();
    	for(Librarian librarian:this.getAllLibrarians()) {
    		if(!librarian.isDeleted()) {
    			list.add(librarian);
    		}
    	}
    	return list;
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
    
    public boolean deleteContent(String path) {
    try {
    	FileWriter writer=new FileWriter(path);
    	writer.write("");
    	writer.close();
    }
    catch(IOException e) {
    	e.printStackTrace();
    	return false;
    }
    return true;
    }
    
    
    
    public Staff login(String username, String password) {
		for(Staff staff : this.getAllStaff()) {
			if(staff.getUsername().equalsIgnoreCase(username) &&
					staff.getPassword().equals(password) && !staff.isDeleted()) {
				return staff;
			}
		}
		return null;
	}
    
    
    
    
// CRUD   
    
    public boolean addNewMember(String cardNumber, LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted,String JMBG) {
		Member member=new Member();
		
		member.setCardNumber(cardNumber);
		member.setLastMembershipExtension(lastMembershipExtension);
		member.setMembershipDuration(membershipDuration);
		member.setActive(true);
		member.setMembership(membership);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setAdress(adress);
		member.setId(id);
		member.setGender(gender);
		member.setDeleted(false);
		member.setJMBG(JMBG);
		for(Member m:this.getAllMembers()) {
			if(m.getJMBG().equals(JMBG)||m.getCardNumber().equals(cardNumber)) {
				
				return false;
				
				
			}
			
		}
		System.out.println("2");
		this.getAllMembers().add(member);
		this.writeMembers(this.getAllMembers());
		
		return true;
		
	}
	
	
	public boolean updateMember( LocalDate lastMembershipExtension, int membershipDuration, boolean isActive,MembershipCost membership,String firstName, String lastName, String adress, String id, Gender gender, boolean isDeleted) {
		
		for (Member member:this.getAllMembers()) {
			if(member.getId().equals(id)) {
				
				
				member.setLastMembershipExtension(lastMembershipExtension);
				member.setMembershipDuration(membershipDuration);
				member.setActive(true);
				member.setMembership(membership);
				member.setFirstName(firstName);
				member.setLastName(lastName);
				member.setAdress(adress);
				member.setId(id);
				member.setGender(gender);
				member.setDeleted(false);
				
				
				System.out.println("test2");
			}
		}
		System.out.println("test3");
		this.writeMembers(this.getAllMembers());	
		return true;
	}
	
	
	public void deleteMember(String id) {
		
		for(Member member:this.getAllMembers()) {
			
			if (member.getId().equals(id)) {
				member.setDeleted(true);
				
			}
			
			this.writeMembers(this.getAllMembers());
		}
	}
	
public void undoDeleteMember(String id) {
		
		for(Member member:this.getAllMembers()) {
			
			if (member.getId().equals(id)) {
				member.setDeleted(false);
				
			}
			
			this.writeMembers(this.getAllMembers());
		}
	}
	
		
	
	
	
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
    
    

}

