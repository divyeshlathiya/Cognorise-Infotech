package com.mylibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {

	protected String title;
	protected String author;
	protected String status;
}

class LibraryCatalog extends Book {

	static ArrayList<Book> bookList = new ArrayList<Book>();

	static Scanner sc = new Scanner(System.in);


	public void addBook() {

		System.out.print("Enter Book title: ");
		title = sc.next();
		System.out.print("Enter Book author: ");
		author = sc.next();
		System.out.print("Enter Book status: ");
		status = sc.next();

		Book newBook = new Book();
		newBook.title = title;
		newBook.author = author;
		newBook.status = status;

		bookList.add(newBook);
		System.out.println("book add sucsessfully... ");

	}

	public void searchBook() {

		System.out.print("\nSearch by title or author: ");
		String srchInput = sc.next();

		for (Book book : bookList) {

			if (book.author.equals(srchInput) || book.title.equals(srchInput)) {
				System.out.println("Book is available");
				break;
			} else {
				System.out.println("book is not available.");
				break;
			}
		}
	}

	public void checkedOut() {
		System.out.println("\nChecked out book data: ");
		for (Book book : bookList) {
			if(book.status.equals("checkedout")){
				System.out.println("Book title: " + book.title + "\n" + "Book author name: " + book.author);
			}
		}
	}

	public void returnTheBook() {
		System.out.println("\nEnter book title or author to return book: ");
		String strInput = sc.next();

		for (Book book : bookList) {

			if (book.title.equals(strInput) || book.author.equals(strInput)) {

				if (book.status.equals("checkedout")) {
					book.status = "Availble";
					System.out.println("Status change successfully...");
				} else {
					System.out.println("Book status already Availble.");
				}
			}
		}
	}

	public static void main(String[] args) {

		LibraryCatalog lbctlg = new LibraryCatalog();

		try{
			boolean isTrue = true;
			while (isTrue) {
				System.out.println("\n-------Menu--------");
				System.out.println("1. Add book.");
				System.out.println("2. Search book.");
				System.out.println("3. Show data of checked out book list");
				System.out.println("4. Update status of book to return the book.");
				System.out.println("5. Exit\n");
	
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();
	
				switch (choice) {
					case 1:
						lbctlg.addBook();
						break;
					case 2:
						lbctlg.searchBook();
						break;
					case 3:
						lbctlg.checkedOut();
						break;
					case 4:
						lbctlg.returnTheBook();;
						break;
					case 5:
						System.out.println("Are you sure want to exit ?: (yes/no)");
						String exitInput = sc.next();
						exitInput = exitInput.toLowerCase();
						if(exitInput.equals("yes")){
							isTrue = false;
						}else if(exitInput.equals("no")){
							isTrue = true;
						}else{
							System.out.println("Invalid input..");
						}
						break;
					default:
						System.out.println("Invalid input...");
						break;
				}
			}
		}catch(Exception e){
			System.out.println("Oops! Error:)");
		}finally{
			sc.close();
		}

		// for (Book book : bookList) {
		// 	System.out.println(book.title+ " "+book.author+" "+book.status);
		// }

	}
}
