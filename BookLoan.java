/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

//loan blueprint
public class BookLoan {
	private User user;
	private Book book;
	private String dueDate;
	
	//constructor
	public BookLoan(User user, Book book, String dueDate) {
		setUser(user);
		setBook(book);
		setDueDate(dueDate);
	}
	
	//print the bookloan(s)
	public String toString() {
		String bookLoan = "************ User name: " + this.getUser().getFirstName() + " " + this.getUser().getLastName() +
						  "\n************ Title: " + this.getBook().getTitle() + 
						  "\n************ Author: "  + this.getBook().getAuthor() + 
						  "\n************ ISBN: " + this.getBook().getIsbnNumber() +
						  "\n************ Due date: " + this.getDueDate() + "\n";
		return bookLoan;
	}
	
	//getter of user
	public User getUser() {
		return user;
	}
	
	//getter of book
	public Book getBook() {
		return book;
	}
	
	//getter of due date
	public String getDueDate() {
		return dueDate;
	}
	
	//setter of user
	public void setUser(User user) {
		this.user = user;
	}
	
	//setter of book
	public void setBook(Book book) {
		this.book = book;
	}
	
	//setter of due date
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
