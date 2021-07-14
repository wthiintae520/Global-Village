/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

import java.util.Scanner;

//This class contains the implementation of all the methods that do the work of prompting the user
//and accepting the inputs. Once the data is validated, it is saved or retrieved from the
//LendingLibrary object as appropriate. This class contains a LendingLibrary object to access
//or store the items in the LendingLibrary.
//Each public method in this class corresponds to one choice from the user menu.
//Each method will present a menu similar to the one shown in the sample output and process the
//input to perform the required action : create/modify/find/list a User/Book/BookLoan.
//The LendingLibraryController uses the bookLib object to access the LendingLibrary object
//to add/modify/find/list User/Book/BookLoan objects.
public class LendingLibraryController {
	private LendingLibrary bookLib = new LendingLibrary();
	private static Scanner input = new Scanner(System.in);
	
	//constructor
	public LendingLibraryController() {
	}
	
	//You need to validate that age is a number using isValidNumber
	public void addUser() {
		System.out.println("New User Entry");
    	System.out.println("Last name");
    	String lastName = input.nextLine();
    	System.out.println("First name");
    	String firstName = input.nextLine();
    	System.out.println("Age");
    	String age;
    	age = input.nextLine();
    	while (!isValidNumber(age)) {
    		System.out.println("Age must be a number");
    		age = input.nextLine();
    	}
    	int ageNum = Integer.parseInt(age);
    	System.out.println("User address");
    	String address = input.nextLine();
    	User u = new User(firstName, lastName, address, ageNum);
    	if(bookLib.addUser(u)) {
    		System.out.println("User was added");
    	} else {
    		System.out.println("User not added");
    	}
	}
	
	//The only item we can modify is the address. A user is identified by the first and last names
	public void changeUser() {
		System.out.println("Modify user details.");
		String ln = getResponseTo("last name for the user you want to modify:");
		String fn = getResponseTo("first name for the user you want to modify:");
		User user = bookLib.findUser(fn, ln);
		if(user != null) {
			System.out.println(user.toString());
			String add = getResponseTo("Change address (Hit Enter key for no change):");
			if(add != null && add.length() > 0) {
				for(int i = 0; i < bookLib.getUserReg().length; i++) {
					if(bookLib.getUserReg()[i] != null && bookLib.getUserReg()[i].getLastName() == ln && bookLib.getUserReg()[i].getFirstName() == fn) {
						bookLib.getUserReg()[i].setAddress(add);
					}
				}
			}
		} else {		
			System.out.println("No book loan found with this isbn number.");
		}
	}
	
	//A user will be searched by the first and last names.
	public void findUser() {
		System.out.println("Find User");
    	System.out.println("Last name:");
    	String lastName = input.nextLine();
    	System.out.println("First name:");
    	String firstName = input.nextLine();
    	bookLib.findUser(firstName, lastName);
	}
	
	//list user(s)
	public void listUsers() {
		int count = 1;
		for (User user : bookLib.getUserReg()) {
			if (user != null) {
				System.out.println("User #" + count);
				System.out.println(user.toString());
				count++;
			} else {
				break;
			}
		}
	}
	
	//The ISBN number must be 10 digits. This must be checked and if the test fails, the entry should
	//not be added.
	//The publication date consists of the year only in 4 digits format such as 1919. The date must be
	//validated and the entry addition should abort if the test fails.
	public void addBook() {
		System.out.println("New Book Entry");
    	System.out.println("Title:");
    	String title = input.nextLine();
    	System.out.println("Author:");
    	String author = input.nextLine();
    	String publicationDate;
    	int publicationDateLength;
    	do {
	    	System.out.println("Publication date (year in NNNN format)");
	    	publicationDate = input.nextLine();
	    	publicationDateLength = publicationDate.length();
    	} while(publicationDateLength != 4);
    	String isbnNumber;
    	int isbnNumberLength;
    	do {
	    	System.out.println("ISBN number (10 digits):");
	    	isbnNumber = input.nextLine();
	    	isbnNumberLength = isbnNumber.length();
    	} while(isbnNumberLength != 10);
    	Book b = new Book(title, author, isbnNumber, publicationDate);
    	bookLib.addBook(b);
    	System.out.println("");//skip a line
    }
	
	//A book is identified by the ISBN number. We can change the author, the title, or the publication
	//date. The date must be validated and the modification should abort if the validation fails.
	public void changeBook() {
		System.out.println("Modify book details.");
		String isbnNumber = getResponseTo("ISBN number for the book you want to modify:");
		Book b = bookLib.findBook(isbnNumber);
		if(b != null) {
			System.out.println(b.toString());
			String bookChangeItem = getResponseTo("t: title, a: author, pd: publication date:");
			switch(bookChangeItem) {
			case "t":
				String t = getResponseTo("Change title (Hit Enter key for no change):");
				if(t != null && t.length() > 0) {
					for(int i = 0; i < bookLib.getBookReg().length; i++) {
						if(bookLib.getBookReg()[i] != null && bookLib.getBookReg()[i].getIsbnNumber() == isbnNumber) {
							bookLib.getBookReg()[i].setTitle(t);
						}
					}
				}
	        	break;
			case "a":
				String a = getResponseTo("Change author (Hit Enter key for no change):");
				if(a != null && a.length() > 0) {
					for(int i = 0; i < bookLib.getBookReg().length; i++) {
						if(bookLib.getBookReg()[i] != null && bookLib.getBookReg()[i].getIsbnNumber() == isbnNumber) {
							bookLib.getBookReg()[i].setAuthor(a);
						}
					}
				}
	        	break;
			case "pd":
				String pd = getResponseTo("Change publication date (Hit Enter key for no change):");
				if(pd != null && pd.length() > 0) {
					for(int i = 0; i < bookLib.getBookReg().length; i++) {
						if(bookLib.getBookReg()[i] != null && bookLib.getBookReg()[i].getIsbnNumber() == isbnNumber) {
							bookLib.getBookReg()[i].setPublicationDate(pd);
						}
					}
				}
	        	break;
			}
		} else {		
			System.out.println("No book found with this isbn number.");
		}
	}
	
	//A book is searched by the ISBN number.
	public void findBook() {
		System.out.println("Book isbn number");
		bookLib.findBook(input.nextLine());
	}
	
	//show all the books 
	public void listBooks() {
		int count = 1;
		
		for (Book book : bookLib.getBookReg()) {
			  if (book != null) {
			  System.out.println("Book #" + count);
			  System.out.println(book.toString());
			  count++;
			  }
			  else {
				  break;
			  }
			  
		}
	}
	
	//The book’s ISBN number, the user’s first and last names are required to create a book loan.
	//The entry will fail if:
	//	 The ISBN number is invalid
	//	 The user does not exist
	//	 The book is already loaned
	//	 The user has borrowed 2 books
	public void addBookLoan() {
		System.out.println("New Loan Entry");
    	System.out.println("User last name:");
    	String lastName = input.nextLine();
    	System.out.println("User first name:");
    	String firstName = input.nextLine();
		User userTest = bookLib.findUser(firstName, lastName);
		System.out.println("Book isbn number");
    	Book bookTest = bookLib.findBook(input.nextLine());
    	System.out.println("Loan date (format yyyy-mm-dd)");
    	String dueDate = input.nextLine();
    	BookLoan l = new BookLoan(userTest, bookTest, dueDate);
    	bookLib.addLoan(l);
	}
	
	//A loan can be modified using the ISBN number.
	//The only change allowed is the due date.
	public void changeBookLoan() {
		System.out.println("Modify loan details.");
		String isbn = getResponseTo("ISBN number for the loan you want to modify:");
		BookLoan bl = bookLib.findLoan(isbn);
		if(bl != null) {
			System.out.println(bl.toString());
			String date = getResponseTo("Change due date (Hit Enter key for no change):");
			if(date != null && date.length() > 0) {
				for(int i = 0; i < bookLib.getLoanReg().length; i++) {
					if(bookLib.getLoanReg()[i] != null && bookLib.getLoanReg()[i].getBook().getIsbnNumber() == isbn) {
						bookLib.getLoanReg()[i].setDueDate(date);
					}
				}
			}
		} else {		
			System.out.println("No book loan found with this isbn number.");
		}
	}
	
	//A loan can be searched using the ISBN number.
	public void findBookLoan() {
		System.out.println("Find a book loan. Enter ISBN number:");
		bookLib.findLoan(input.nextLine());
	}
	
	//list book loan(s)
	public void listBookLoans() {
		int count = 1;
		for (BookLoan bookLoan : bookLib.getLoanReg()) {
			if (bookLoan != null) {
				System.out.println("Loan #" + count);
				System.out.println(bookLoan.toString());
				count++;
			} else {
				break;
			}
		}
	}
	
	//A helper method that prints out the String as a parameter, and then scans the input and returns
	//the user’s response as a String. The purpose of the method is to make the code cleaner and
	//improve code readability.We make it private as there is no need for external use.
	//Sample code that you can use as is in your project:
	private static String getResponseTo(String s) {
		System.out.println(s);
		return(input.nextLine());
	}
	
	//check the input is numeric number
	private Boolean isValidNumber(String input) {
	    if (input == null) {
	        return false;
	    }
	    try {
	        Integer.parseInt(input);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
