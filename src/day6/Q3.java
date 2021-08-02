package day6;
import java.util.*;

/**
 * dOcUemENtatIon ReQUIred
 * 
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day6
 * Class: Q3
 * Description: 
 * Created On:01 August 2021
 * @author Ananya Srivastava
 *	
 */
class Book implements Comparable<Book>{
	private String title;
	private String author;
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return title+"(:by "+author+")";
	}
	
	 @Override
	 public int compareTo(Book o) {
	       return this.getTitle().compareTo(o.getTitle());
	 }
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	 
	
}
class BookCollection{
	private String ownerName;
	private Set<Book> bookSet;
	BookCollection(String ownerName, Set<Book> bookSet){
		this.ownerName = ownerName;
		this.bookSet = bookSet;
	}
	@Override
	public String toString() {
		String ans = ownerName+"\n";
		for(Book bk:bookSet) {
			ans += "\t"+bk.toString()+"\n";
		}
		return ans;
	}
	public boolean checkBook(Book bk) {
		return bookSet.contains(bk);
	}
	public void sort() {
		List<Book> bookList = new ArrayList<Book>(bookSet);
		Collections.sort(bookList);
		bookSet = new HashSet<Book>(bookList);
	}
	
}
public class Q3 {
	public static void main(String[] args) {
		Set<Book> booksSet = new HashSet<Book>();
		booksSet.add(new Book("Java In Depth", "Doug Lea"));
		booksSet.add(new Book("Effective Java", "Josh Bloach"));
		booksSet.add(new Book("Core Java", "Tanweer Alam"));
		booksSet.add(new Book("Playing It My Way", "Sachin Tendulkar"));
		booksSet.add(new Book("Head First Java", "Kathy Sierra"));
		BookCollection bookCollection = new BookCollection("Ananya Srivastava", booksSet);
		if(bookCollection.checkBook(new Book("Java In Depth", "Doug Lea"))) 
			System.out.println("Yes! You have Java In Depth");
		else
			System.out.println("No! You don't have Java In Depth");
		
		bookCollection.sort();
		
		System.out.println(bookCollection);
		
	}
}
