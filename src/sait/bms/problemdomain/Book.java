package sait.bms.problemdomain;


public class Book {
	private String isbn;
	private String callNumber;
	private int booksAvailable;
	private int booksTotal;
	private String bookTitle;
	

	
	

	public Book() {
		super();
	}
	
	public Book(String isbn, String callNumber, int booksAvailable, int booksTotal, String bookTitle) {
		super();
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.booksAvailable = booksAvailable;
		this.booksTotal = booksTotal;
		this.bookTitle = bookTitle;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setisbn(String isbn) {
		this.isbn = isbn;
	}


	public String getCallNumber() {
		return callNumber;
	}


	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}


	public int getBooksAvailable() {
		return booksAvailable;
	}


	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}


	public int getBooksTotal() {
		return booksTotal;
	}


	public void setBooksTotal(int booksTotal) {
		this.booksTotal = booksTotal;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", callNumber=" + callNumber + ", booksAvailable=" + booksAvailable
				+ ", booksTotal=" + booksTotal + ", bookTitle=" + bookTitle + "]";
	}



	
	

	
}
