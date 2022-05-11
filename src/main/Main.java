package main;

import java.time.LocalDate;
import java.util.ArrayList;

import ennumerations.Language;
import models.*;

public class Main {

	public static void main(String[] args) {
		Library library=new Library();
		
		Genre genre=new Genre("Comedy","This is funny","00001");
		ArrayList<Genre>allGenres=new ArrayList<Genre>();
		allGenres.add(genre);
		library.writeGenre(allGenres);
		System.out.println(library.readGenres());
		
		
		Book book=new Book("Rat i mir","Peace and war", "Tolstoy", LocalDate.of(1887,05,05), "Ovo je dosadna knjiga", "0000000056",
			genre, Language.SERBIAN,false);
		ArrayList<Book>allBooks=new ArrayList<Book>();
		allBooks.add(book);
		library.writeBook(allBooks);
		System.out.println(library.readBook(allGenres));
				
		
		


	}

}
