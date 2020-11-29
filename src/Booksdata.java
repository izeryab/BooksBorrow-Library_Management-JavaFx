import java.io.Serializable;

/**
 * BooksData Class design to Handle Books Data
 * */
public class Booksdata implements Serializable{
//Data Members
	private static final long serialVersionUID = 1L;
	private int quantity;
	private String callno,bookname,author,publisher;
	//constructor
		public Booksdata() {
			this.callno="";
			this.bookname="";
			this.author="";
			this.publisher="";
			this.quantity=0;	
		}
		//constructor
	public Booksdata(String callno,String bookname,String author,String publisher,int quantity){
		this.callno=callno;
		this.bookname=bookname;
		this.author=author;
		this.publisher=publisher;
		this.quantity=quantity;
	}
	/**
	 * Getter and Setter for Data Members
	 * */	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCallno() {
		return callno;
	}
	public void setCallno(String callno) {
		this.callno = callno;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Booksdata [quantity=" + quantity + ", callno=" + callno + ", bookname=" + bookname + ", author="
				+ author + ", publisher=" + publisher + "]";
	}
	
}
