/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

import java.util.Scanner;

//The add/find methods process the addition and searching of items in the corresponding arrays.
public class LendingLibrary {
	private static final int MAX_BOOK_NUMBER = 10;
	private static final int MAX_USER_NUMBER = 5;
	private static final int MAX_LOAN_NUMBER = 5;
	private static final int MAX_LOAN_PER_USER = 2;
	private static int lastBookIndex = 0;
	private static int lastUserIndex = 0;
	private static int lastLoanIndex = 0;
	private Book[] bookReg= new Book[MAX_BOOK_NUMBER];
	private User[] userReg = new User[MAX_USER_NUMBER];
	private BookLoan[] loanReg = new BookLoan[MAX_LOAN_NUMBER];
	private static Scanner input = new Scanner(System.in);
	
	//constructor
	public LendingLibrary() {
	}
	
	//prompts the program user to enter all five expected values required to instantiate 
	//a new User()—there is no requirement to check for any other possibilities
	//(such as the possibility that the user doesn't enter their age).
	public User makeUser(int id, String firstName, String lastName, String address, int age) {
		System.out.println("Enter ID");
		int idInput = input.nextInt();
		System.out.println("Enter first name");
		String firstNameINput = input.nextLine();
		System.out.println("Enter last name");
		String lastNameINput = input.nextLine();
		System.out.println("Enter address");
		String addressINput = input.nextLine();
		System.out.println("Enter age");
		int ageInput = input.nextInt();
		User u = new User(idInput, firstNameINput, lastNameINput, addressINput, ageInput);
		return u;
	}
	
	//add user to the list
	public boolean addUser(User u) {
		userReg[lastUserIndex] = u;
		lastUserIndex++;
		if(userReg[lastUserIndex - 1] == u) {
			return true;
		} else {
			return false;
		}
	}
	
	//add book to the list
	public boolean addBook(Book b) {
		bookReg[lastBookIndex] = b;
		lastBookIndex++;
		if(bookReg[lastBookIndex - 1] == b) {
			return true;
		} else {
			return false;
		}
	}
	
	//add loan to the list
	public boolean addLoan(BookLoan l) {
		loanReg[lastLoanIndex] = l;
		lastLoanIndex++;
		if(loanReg[lastLoanIndex - 1] == l) {
			return true;
		} else {
			return false;
		}
	}
	
	//search user
	public User findUser(String firstName, String lastName) {
		for(User user : userReg) {
		String firstNameCheck = user.getFirstName();
		String lastNameCheck = user.getLastName();
			if(firstNameCheck.equals(firstName) && lastNameCheck.equals(lastName)) {
				System.out.println(user.toString());
				return user;
			} else {
				System.out.println("No user with this name!");
			}
		}return null;
	}
	
	//search book
	public Book findBook(String isbnNumber) {
		for(Book b: bookReg) {
			String testIsbn = b.getIsbnNumber();
			if(testIsbn.equals(isbnNumber)) {
				return b;
			} else {
				System.out.println("Could not find a book with this isbn!");
			}
		} return null;
	}
	
	//search loan
	public BookLoan findLoan(String isbnNumber) {
		for(BookLoan bookLoan: loanReg) {
			if (bookLoan != null) {
				String inputIsbn = bookLoan.getBook().getIsbnNumber();
				if(isbnNumber.equals(inputIsbn)) {
					System.out.println(bookLoan.toString());
					return bookLoan;
				} else {
				System.out.println("No book loan found with this isbn number.");
				}
			} else {
			System.out.println("No book loan found with this isbn number.");
			}
		}return null;
	}
	
	//check if user can borrow
	public boolean userCanBorrow(User u) {
		int count = 0;
		for(BookLoan bookLoan: loanReg) {
			if(bookLoan.getUser() == u) {
				count++;
			}
		}
		if(count > MAX_LOAN_PER_USER) {
			return false;
		} else {
			return true;
		}
	}
	
	//check if book been loaned
	public boolean isBookLoaned(Book b) {
		for(BookLoan bookLoan: loanReg) {
			if(bookLoan.getBook() == b) {
				return true;
			}
		}
		return false;
	}
	
	//getter of book list
	public Book[] getBookReg() {
		return bookReg;
	}
	
	//getter of user list
	public User[] getUserReg() {
		return userReg;
	}
	
	//getter of loan list
	public BookLoan[] getLoanReg() {
		return loanReg;
	}
	
	//setter of book list
	public void setBookReg(Book[] bookReg) {
		this.bookReg = bookReg;
	}
	
	//setter of user list
	public void setUserReg(User[] userReg) {
		this.userReg = userReg;
	}
	
	//setter of loan list
	public void setLoanReg(BookLoan[] loanReg) {
		this.loanReg = loanReg;
	}
}
