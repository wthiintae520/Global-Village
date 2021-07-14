/**
Class Name: CST8284
Author Name: Yunting Yin
Date: Jun 19, 2021
**/

import java.util.Scanner;

//This class contains the main loop of the application to accept and process the user choices.
//It verifies the user’s input and based on the selection, the relevant method to execute is called.
public class AppDriver {
	private static final int APP_EXIT = 0;
	private static final int APP_ADD_BOOK = 1;
	private static final int APP_MOD_BOOK = 2;
	private static final int APP_FIND_BOOK = 3;
	private static final int APP_LIST_BOOKS = 4;
	private static final int APP_ADD_USER = 5;
	private static final int APP_MOD_USER = 6;
	private static final int APP_FIND_USER = 7;
	private static final int APP_LIST_USERS = 8;
	private static final int APP_ADD_LOAN = 9;
	private static final int APP_MOD_LOAN = 10;
	private static final int APP_FIND_LOAN = 11;
	private static final int APP_LIST_LOANS = 12;
	private static int choice = 0;
	private static Scanner input = new Scanner(System.in);
	public LendingLibraryController appControl = new LendingLibraryController();
	
	//Is the method that is called by the AppLauncher
	//It calls displayAppMenu() to display the menu to the user. As the user makes the selection, the
	//choice is returned to be used by the executeMenuItem().
	//The two methods need to be in a loop that will be exited when the user selects APP_EXIT.
	public void startApp() {
		do {
	    	choice = displayAppMenu();
	    	if (choice == APP_EXIT)
	    		break;
	    	executeMenuItem(choice);
	    } while(choice != APP_EXIT);
	    System.out.print("Good Bye!");
	}
	
	//prompt the menu
	private int displayAppMenu() {
	    System.out.printf("%s\n%s\n%s\n%s\n%s\n\n%s\n%s\n%s\n%s\n\n%s\n%s\n%s\n%s\n\n%s\n", 
	    	    	      "Enter a selection from the following menu:",
	    	    	      APP_ADD_BOOK + ". Enter a new book",
	    	    	      APP_MOD_BOOK + ". Modify the book details. Enter the book isbn number",
	    	    	      APP_FIND_BOOK + ". Find a book by isbn number",
	    	    	      APP_LIST_BOOKS + ". Display list of all books",
					  	  APP_ADD_USER + ". Add a new user",
						  APP_MOD_USER + ". Modify user details",
						  APP_FIND_USER + ". Find a user by name",
						  APP_LIST_USERS + ". Display all users",
						  APP_ADD_LOAN + ". Add a loan. Link a user name to a book by isbn number",
						  APP_MOD_LOAN + ". Modify a loan. Loan is identified by isbn number",
						  APP_FIND_LOAN + ". Find a loan. Loan is identified by isbn number",
						  APP_LIST_LOANS + ". Display all loans",
						  APP_EXIT + ". Exit program");
	    return(input.nextInt());
	}
	
	//Based on the menu item chosen, it executes the action requested by the user.
	//The AppDriver uses the appControl reference to call the corresponding method in
	//LendingLibraryController
	private void executeMenuItem(int choice) {
		switch(choice) {
			case APP_ADD_BOOK:
	        	appControl.addBook();
	        	break;
			case APP_MOD_BOOK:
				appControl.changeBook();
				break;
   	     	case APP_FIND_BOOK:
   	     		appControl.findBook();
   	     		break;
        	case APP_LIST_BOOKS:
        		appControl.listBooks();
        		break;
        	case APP_ADD_USER:
        		appControl.addUser();
        		break;
        	case APP_MOD_USER:
        		appControl.changeUser();
        		break;
        	case APP_FIND_USER:
        		appControl.findUser();
        		break;
        	case APP_LIST_USERS:
        		appControl.listUsers();
        		break;
        	case APP_ADD_LOAN:
        		appControl.addBookLoan();
        		break;
        	case APP_MOD_LOAN:
        		appControl.changeBookLoan();
        		break;
        	case APP_FIND_LOAN:
        		appControl.findBookLoan();
        		break;
        	case APP_LIST_LOANS:
        		appControl.listBookLoans();
        		break;
        	default:
        		choice = APP_EXIT;
		}
	}
}
