package sait.bms.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import sait.bms.problemdomain.*;

public class Manager {
	private ArrayList<Book> books;
	private final String PATH = "res/books.txt";
	

	public Manager() throws FileNotFoundException {
		this.books = new ArrayList<>();
		displayMenu();

		loadBookListFromFile();

		userOption();

	}

	private void displayMenu() throws FileNotFoundException {
		System.out.println("\nWelcome to ABC Company, How Can We Assit You?");
		System.out.printf("%-8d %s %n", 1, "Checkout Book");
		System.out.printf("%-8d %s %n", 2, "Find Book By Title");
		System.out.printf("%-8d %s %n", 3, "Display Book By Type");
		System.out.printf("%-8d %s %n", 4, "Produce Random Book List");
		System.out.printf("%-8d %s %n", 5, "Save & Exit");
		System.out.println(" ");

	}

	private void loadBookListFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File(PATH));

		while (in.hasNextLine()) {

			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastDigit = fields[0].charAt(fields[0].length() - 1);

			switch (lastDigit) {

			case '0':
			case '1':
				books.add(new ChildrenBook(fields[0], fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '2':
			case '3':
				books.add(new CookBook(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				books.add(new Paperback(fields[0], fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], fields[6], fields[7].charAt(0)));
				break;
			case '8':
			case '9':
				books.add(new Periodicals(fields[0], fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
				break;
			}
		}
		in.close();

	}

	private void userOption() throws FileNotFoundException {
		try {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an option: ");
			int userOption = input.nextInt();

			switch (userOption) {
			case 1:
				checkOutBook();
				break;
			case 2:
				findByTitle();
				break;
			case 3:
				displayByType();
				break;
			case 4:
				randomList();
				break;
			case 5:
				saveAndExit();
				break;
			default:
				System.out.println("\nInvalid option please try again.");
				userOption();
			}
		} catch (Exception e) {
			System.out.println("\nInvalid option please try again.");
			userOption();
		}

	}

	private void saveAndExit() throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(PATH));
		for (Book b : books) {
			out.println(b);
		}
		out.close();
		System.exit(0);
	}

	private void randomList() throws FileNotFoundException {

		
		Scanner in = new Scanner(System.in);
        Collections.shuffle(books);
        Random ran = new Random();
        
        for (Book b : books) {
            System.out.print("Enter number of books: ");
            int numOfBooks = in.nextInt();
            for (int i = 0; i < numOfBooks; i++) {
            	int ranNumber = ran.nextInt(75);
            	Book book = books.get(ranNumber);
                System.out.print(book.toString() + "\n");
            }

            break;
        }
		displayMenu();
		userOption();

	}

	private void displayByType() {
		Scanner input = new Scanner(System.in);
		System.out.printf("%-8s %s %n", "#", "Type");
		System.out.println("---------------------------");
		System.out.printf("%-8d %s %n", 1, "Children's Books");
		System.out.printf("%-8d %s %n", 2, "Cookbooks");
		System.out.printf("%-8d %s %n", 3, "Paperbacks");
		System.out.printf("%-8d %s %n", 4, "Periodicals");
		System.out.println("");
		System.out.print("Enter Type of book: ");
		int type = input.nextInt();

		switch (type) {
		case 1:
			typeChildrenBooks();
			break;
		case 2:
			typeCookBooks();
			break;
		case 3:
			typePaperBacks();
			break;
		case 4:
			typePeriodicals();
			break;
		}

	}

	private void typePeriodicals() {
		System.out.println("");
		System.out.println("\nEnter \"r\" to go the main Menu.");
		System.out.print(
				"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
		Scanner input = new Scanner(System.in);
		char frequency = Character.toUpperCase(input.next().charAt(0));

		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);

			if (b instanceof Periodicals) {
				if (((Periodicals) b).getFrequency() == frequency) {
					System.out.println("Matching Books: ");
					System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
					System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
					System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
					System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
					System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
					System.out.printf("%-18s %s %n", "Frecuency:", ((Periodicals) b).getFrequency());

					System.out.println("");
				} else if (frequency == 'R') {
					displayByType();
				}
			}
		}
		System.out.println("\nThe system could't find any matches. Please try again");

		typePeriodicals();

	}

	private void typePaperBacks() {
		System.out.println("");
		System.out.println("\nEnter \"r\" to go the main Menu.");
		System.out.print(
				"Enter a Format (D for Detective and Mistery, A for Adventure, E for Engineers, S for Short stories, C for Classics or F for Fantasy): ");
		Scanner input = new Scanner(System.in);
		char genre = Character.toUpperCase(input.next().charAt(0));

		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);

			if (b instanceof Paperback) {
				if (((Paperback) b).getGenre() == genre) {
					System.out.println("Matching Books: ");
					System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
					System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
					System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
					System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
					System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
					System.out.printf("%-18s %s %n", "Authors:", ((Paperback) b).getAuthors());
					System.out.printf("%-18s %s %n", "Year:", ((Paperback) b).getYear());
					System.out.printf("%-18s %s %n", "Genre:", ((Paperback) b).getGenre());
					System.out.println("");
				} else if (genre == 'R') {
					displayByType();
				}
			}
		}
		System.out.println("\nThe system could't find any matches. Please try again");

		typePaperBacks();

	}

	private void typeCookBooks() {
		System.out.println("");
		System.out.println("\nEnter \"r\" to go the main Menu.");
		System.out.print(
				"Enter a Format (I for International, N for National, D for Diabetics, V for Vegetarian, G for Gluten-free ): ");
		Scanner input = new Scanner(System.in);
		char diet = Character.toUpperCase(input.next().charAt(0));

		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);

			if (b instanceof CookBook) {
				if (((CookBook) b).getDiet() == diet) {
					System.out.println("Matching Books: ");
					System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
					System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
					System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
					System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
					System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
					System.out.printf("%-18s %s %n", "Publisher:", ((CookBook) b).getPublisher());
					System.out.printf("%-18s %s %n", "Diet:", ((CookBook) b).getDiet());
					System.out.println("");
				} else if (diet == 'R') {
					displayByType();
				}
			}
		}

		System.out.println("\nThe system could't find any matches. Please try again");

		typeCookBooks();

	}

	private void typeChildrenBooks() {
		System.out.println("");
		System.out.println("\nEnter \"r\" to go the main Menu.");
		System.out.print("Enter a Format (C for Chapter Books, P for Picrure Books, E for Easy Readings ): ");
		Scanner input = new Scanner(System.in);
		char format = Character.toUpperCase(input.next().charAt(0));

		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);

			if (b instanceof ChildrenBook) {
				if (((ChildrenBook) b).getFormat() == format) {
					System.out.println("Matching Books: ");
					System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
					System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
					System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
					System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
					System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
					System.out.printf("%-18s %s %n", "Authors:", ((ChildrenBook) b).getAuthors());
					System.out.printf("%-18s %s %n", "Format:", ((ChildrenBook) b).getFormat());
					System.out.println("");
				} else if (format == 'R') {
					displayByType();
				}
			}
		}

		System.out.println("\nThe system could't find any matches. Please try again");

		typeChildrenBooks();

	}

	private void findByTitle() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter \"return\" to go the main Menu.");
		System.out.print("Enter Title of book:  ");
		String name = input.nextLine();
		name.toLowerCase();

		if (name.equals("return")) {
			displayMenu();
			userOption();
		} else {

			for (int i = 0; i < books.size(); i++) {

				Book b = books.get(i);
				if (b instanceof ChildrenBook) {
					if (books.get(i).getBookTitle().toLowerCase().contains(name)
							|| books.get(i).getBookTitle().equals(name)) {
						System.out.println("Matching Books: ");
						System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
						System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
						System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
						System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
						System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
						System.out.printf("%-18s %s %n", "Authors:", ((ChildrenBook) b).getAuthors());
						System.out.printf("%-18s %s %n", "Format:", ((ChildrenBook) b).getFormat());
						System.out.println("");
					}
				} else if (b instanceof Paperback) {
					if (books.get(i).getBookTitle().toLowerCase().contains(name)) {
						System.out.println("Matching Books: ");
						System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
						System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
						System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
						System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
						System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
						System.out.printf("%-18s %s %n", "Authors:", ((Paperback) b).getAuthors());
						System.out.printf("%-18s %s %n", "Year:", ((Paperback) b).getYear());
						System.out.printf("%-18s %s %n", "Genre:", ((Paperback) b).getGenre());
						System.out.println("");
					}
				} else if (b instanceof CookBook) {
					if (books.get(i).getBookTitle().toLowerCase().contains(name)) {
						System.out.println("Matching Books: ");
						System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
						System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
						System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
						System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
						System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
						System.out.printf("%-18s %s %n", "Publisher:", ((CookBook) b).getPublisher());
						System.out.printf("%-18s %s %n", "Diet:", ((CookBook) b).getDiet());
						System.out.println("");

					}
				} else if (b instanceof Periodicals) {
					if (books.get(i).getBookTitle().toLowerCase().contains(name)) {
						System.out.println("Matching Books: ");
						System.out.printf("%-18s %s %n", "ISBN:", books.get(i).getIsbn());
						System.out.printf("%-18s %s %n", "Call number:", books.get(i).getCallNumber());
						System.out.printf("%-18s %d %n", "Available:", books.get(i).getBooksAvailable());
						System.out.printf("%-18s %d %n", "Total:", books.get(i).getBooksTotal());
						System.out.printf("%-18s %s %n", "Title:", books.get(i).getBookTitle());
						System.out.printf("%-18s %s %n", "Frecuency:", ((Periodicals) b).getFrequency());
						System.out.println("");
					}
				} else {
					System.out.println("The system could't find any matches. Please try again");
					findByTitle();
				}
			}
			findByTitle();
		}

	}

	private void checkOutBook() throws FileNotFoundException {

		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter \"return\" to go the main Menu:");
		System.out.print("Enter ISBN of book: ");
		String isbnInput = input.next();

		if (isbnInput.equals("return")) {
			displayMenu();
			userOption();

		} else if (isbnInput.length() != 13) {
			checkOutBook();
		} else {

			for (int i = 0; i < books.size(); i++) {

				Book b = books.get(i);
				int newBooksAvailable = b.getBooksAvailable();

				if (b.getIsbn().equals(isbnInput)) {
					if (b.getBooksAvailable() > 0) {
						System.out.println("\nThe book " + "\"" + b.getBookTitle() + "\"" + " has been checked out.\n"
								+ "It can be located using a call number: " + b.getCallNumber() + "\n" + "");
						b.setBooksAvailable((newBooksAvailable - 1));
						System.out.println("Number available after the checkout: " + (newBooksAvailable));

					} else {
						System.out.println("\nUnfortunately we don't have " + "\"" + b.getBookTitle() + "\""
								+ " in stock. Please try with another one.\n");
						checkOutBook();
					}

				}

			}
			displayMenu();
			userOption();

		}
	}

}
