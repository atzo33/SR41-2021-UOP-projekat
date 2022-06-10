package models;

public class Genre {
	private String name;
	private String description;
	private String id;
	private boolean isDeleted;
	


public Genre() {
	this.name = "";
	this.description = "";
	this.id = "";
	this.isDeleted=false;
	
}
public Genre(String name, String description, String id,boolean isDeleted) {
	
	this.name = name;
	this.description = description;
	this.id = id;
	this.isDeleted=isDeleted;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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

public boolean isDeleted() {
	return isDeleted;
}
public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}
@Override
public String toString() {
	return "Genre [name=" + name + ", description=" + description + ", id=" + id + "]";
}

}

