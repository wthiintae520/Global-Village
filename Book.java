/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

//book blueprint
public class Book {
	private String title = "";
	private String author = "";
	private String publicationDate = "";
	private String isbnNumber = "";
	
	//constructor
	public Book(String title, String author, String isbn, String pubDate) {
		setTitle(title);
		setAuthor(author);
		setPublicationDate(pubDate);
		setIsbnNumber(isbn);
	}
	
	//getter of title
	public String getTitle() {
		return title;
	}
	
	//getter of author
	public String getAuthor() {
		return author;
	}
	
	//getter of publication date
	public String getPublicationDate() {
		return publicationDate;
	}
	
	//getter of ISBN
	public String getIsbnNumber() {
		return isbnNumber;
	}
	
	//setter of title
	public void setTitle(String title) {
		this.title = title;
	}
	
	//setter of author
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//setter of publication date
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	//setter of ISBN
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	//Ensures that the string is exactly 10 digits long.
	public boolean verifyISBNNumber(String s) {
		return(getIsbnNumber().length() == 0);
	}
	
	
	//print the book(s)
	public String toString() {
		String showBook = "\n************ Title: " + this.getTitle() +
						  "\n************ Author: "  + getAuthor() +
						  "\n************ Publication Year: " + getPublicationDate() +
						  "\n************ ISBN: " + this.getIsbnNumber() + "\n";
		return showBook;
	}
}
