package sait.bms.problemdomain;

public class ChildrenBook extends Book {

	private String authors;
	private char format;
	
	
	public ChildrenBook() {
		super();
	}


	public ChildrenBook(String  isbn, String callNumber, int booksAvailable, int booksTotal,
			String bookTitle, String authors, char format) {
		super(isbn, callNumber, booksAvailable, booksTotal, bookTitle);
		this.authors = authors;
		this.format = format;
		
	}

	public String getAuthors() {
		return authors;
	}


	public void setAuthors(String authors) {
		this.authors = authors;
	}


	public char getFormat() {
		return format;
	}


	public void setFormat(char format) {
		this.format = format;
	}


	@Override
	public String toString() {
		return "\nISBN:" + "\t" + "\t" +getIsbn() + "\n"
				+"Call number:" + "\t" + getCallNumber()+ "\n"
				+"Available:" + "\t" + getBooksAvailable() + "\n"
				+"Total:" + "\t" + "\t" + getBooksTotal() + "\n"
				+"Title:" + "\t" + "\t" + getBookTitle()+ "\n"
				+"Authors:" + "\t" + getAuthors() + "\n"
				+"Format:" + "\t" + "\t" + getFormat() + "\n"
				+ "";
	}
	

	
}
