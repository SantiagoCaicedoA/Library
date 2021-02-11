package sait.bms.problemdomain;

public class Periodicals extends Book {

	private char frequency;
	
	
	public Periodicals() {
		super();
	}


	public Periodicals(String  isbn, String callNumber, int booksAvailable, int booksTotal,
			String bookTitle, char frecuency) {
		super(isbn, callNumber, booksAvailable, booksTotal, bookTitle);
		this.frequency = frecuency;
	}

	public char getFrequency() {
		return frequency;
	}


	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}


	@Override
	public String toString() {
		return "\nISBN:" + "\t" + "\t" +getIsbn() + "\n"
				+"Call number:" + "\t" + getCallNumber()+ "\n"
				+"Available:" + "\t" + getBooksAvailable() + "\n"
				+"Total:" + "\t" + "\t" + getBooksTotal() + "\n"
				+"Title:" + "\t" + "\t" + getBookTitle()+ "\n"
				+"Frecuency:" + "\t" + getFrequency() + "\n"
				+ "";
	}

}
