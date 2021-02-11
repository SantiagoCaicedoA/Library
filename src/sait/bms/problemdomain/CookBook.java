package sait.bms.problemdomain;

public class CookBook  extends Book{

	private String publisher;
	private char diet;
	
	
	
	public CookBook () {
		super();
	}

	public CookBook(String isbn, String callNumber, int booksAvailable, int booksTotal, 
			String bookTitle, String publisher, char diet) {
		super(isbn, callNumber, booksAvailable, booksTotal, bookTitle);
		this.publisher = publisher;
		this.diet = diet;
		
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public char getDiet() {
		return diet;
	}

	public void setDiet(char diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		
		return "\nISBN:" + "\t" + "\t" + getIsbn() + "\n"
				+"Call number:" + "\t" + getCallNumber()+ "\n"
				+"Available:" + "\t" + getBooksAvailable() + "\n"
				+"Total:" + "\t" + "\t" + getBooksTotal() + "\n"
				+"Title:" + "\t" + "\t" + getBookTitle()+ "\n"
				+"Publisher:" + "\t" + getPublisher() + "\n"
				+"Year:"+ "\t" + "\t" + getDiet() + "\n"
				+ "";
	}



}
