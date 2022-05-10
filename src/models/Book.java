package models;

import java.time.LocalDate;

import ennumerations.Language;

public class Book {
	private String title;
	private String originalTitle;
	private String writer;
	private LocalDate releaseDate;
	private String description;
	private String id;
	private Genre genre;
	private Language language;
	private boolean isDeleted;
	
	public Book() {
		this.title = "";
		this.originalTitle = "";
		this.writer = "";
		this.releaseDate = null;
		this.description ="";
		this.id = "";
		this.genre = null;
		this.language = null;
		this.isDeleted=false;
		
	}

	public Book(String title, String originalTitle, String writer, LocalDate releaseDate, String description, String id,
			Genre genre, Language language,boolean isDeleted) {
		
		this.title = title;
		this.originalTitle = originalTitle;
		this.writer = writer;
		this.releaseDate = releaseDate;
		this.description = description;
		this.id = id;
		this.genre = genre;
		this.language = language;
		this.isDeleted=isDeleted;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}
