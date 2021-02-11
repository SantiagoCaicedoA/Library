package sait.bms.problemdomain;

public class Paperback extends Book{

	private String authors;
	private String year;
	private char genre;
	
	
	
	public Paperback() {
		super();
	}

	public Paperback(String isbn, String callNumber, int booksAvailable, int booksTotal,
			String bookTitle, String authors, String year, char genre) {
		super(isbn, callNumber, booksAvailable, booksTotal, bookTitle);
		this.authors = authors;
		this.year = year;
		this.genre = genre;
		
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "\nISBN:" + "\t" + "\t" + getIsbn() + "\n"
				+"Call number:" + "\t" + getCallNumber()+ "\n"
				+"Available:" + "\t" + getBooksAvailable() + "\n"
				+"Total:" + "\t" + "\t" + getBooksTotal() + "\n"
				+"Title:" + "\t" + "\t" + getBookTitle()+ "\n"
				+"Authors:" + "\t" + getAuthors() + "\n"
				+"Year:" + "\t" + "\t" +getYear() + "\n"
				+"Genre:" + "\t" + "\t" + getGenre() + "\n"
				+ "";
	}

}
