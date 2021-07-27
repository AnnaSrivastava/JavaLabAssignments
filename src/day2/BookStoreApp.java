/**
// * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day2
 * Class: BookStoreApp
 * Description: class to help a book store keep records of its books
 * Created On:23 July 2021
 * @author Ananya Srivastava
 *	
 */
package day2;
//import java.io.IOException;
import java.util.Scanner;
class Book{
	private String bookTitle;
	private String author;
	private String ISBN;
	private int numOfCopies;
	
	public Book(String bookTitle, String author, String ISBN, int numOfCopies) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.ISBN = ISBN;
		this.numOfCopies = numOfCopies;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	
	
	public String getISBN() {
		return ISBN;
	}
	public int getNumOfCopies() {
		return numOfCopies;
	}
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	public void display() {
		System.out.println(bookTitle+"-"+author+"-"+ISBN+"-"+numOfCopies);
	}
}
class BookStore{
	private final int MAX_SIZE = 10;
	private static int bookCount = 0;
	private Book books[] = new Book[MAX_SIZE];
	
	public static int getBookCount() {
		return bookCount;
	}

	void sell(String bookTitle, int noOfCopies) {
		for(int i=0;i<bookCount;i++) {
			if(books[i].getBookTitle()==bookTitle) {
				books[i].setNumOfCopies(books[i].getNumOfCopies() - noOfCopies);
				System.out.println(noOfCopies+" of "+bookTitle+" sold.");
				return;
			}
		}
		System.out.println(bookTitle+" not in inventory.");
		return;
	}
	void display() {
		for(int i=0;i<bookCount;i++)
		{
			books[i].display();
		}
	}
	void order(String isbn, int noOfCopies, Scanner sc) {
		for(int i=0;i<bookCount;i++) {
			if(books[i].getISBN()==isbn) {
				books[i].setNumOfCopies(books[i].getNumOfCopies()+noOfCopies);
				System.out.println("Books added");
				return;
			}
		}
		if(bookCount>=MAX_SIZE)
		{
			System.out.println("Array full! Book with isbn "+isbn+" not found and no new books can be added");
			return;
		}
		System.out.println("Book with ISBN:"+isbn+" not found! Please enter details");
//		Scanner sc = new Scanner(System.in);
		String title, author;
		System.out.println("Title:");
		title = sc.next(); 
		System.out.println("Author:");
		author = sc.next();
		books[bookCount++] = new Book(title, author, isbn, noOfCopies);
//		sc.close();
//		System.out.println("ftydhjujds");
		return;
		
	}
}
public class BookStoreApp {
	public static void main(String args[]) {
		BookStore bStore = new BookStore();
		
		while(true) {
			Scanner scMain = new Scanner(System.in);
			int choice = 0;
			
			System.out.println("Enter “1”, to display the Books: Title – Author – ISBN - Quantity.\n" + 
					"Enter “2”, to order new books.\n" + 
					"Enter “3”, to sell books.\n" + 
					"Enter “0”, to exit the system");
			choice = scMain.nextInt();
			switch(choice){
				case 1: bStore.display();
						break;
				case 2: System.out.println("ISBN:");
						String isbn = scMain.next();
						System.out.println("Number of copies:");
						int noOfCopies = scMain.nextInt();
						bStore.order(isbn, noOfCopies, scMain);
						break;
				case 3: System.out.println("Book Title:");
						String title = scMain.next();
						System.out.println("Number of copies:");
						int numOfCopies = scMain.nextInt();
						bStore.sell(title, numOfCopies);
						break;
				case 0: scMain.close();
						System.exit(0);
						break;
				default:System.out.println("Wrong Input");
			}
			
		}
		
		
	}//main
}//class
