package com.nttdata.casestudy;

import java.util.Scanner;

public class BookController {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BookDao operations = new BookDao();
		BookPojo book = new BookPojo();

		int status = 0;
		do {
			System.out.println("Select Your Choice");
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update ");
			System.out.println("4.Delete ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Insert the Book details");
				System.out.println("Enter the Book name");
				book.setBookName(sc.next());
				System.out.println("Enter the Author name");
				book.setAuthorName(sc.next());
				System.out.println("Enter the Edition");
				book.setEdition(sc.nextInt());

				int result = operations.createBook();
				if (result != 0) {
					System.out.println("Book details are inserted \n");
				} else {
					System.out.println("Book details insertion failed \n");
				}
				break;
			case 2:
				System.out.println("Enter the ISBN number \n");
				book.setIsbnNumber(sc.nextInt());
				operations.readBook(book);
				break;
			case 3:
				System.out.println("Update the Book details");
				System.out.println("Enter the ISBN number of the book to be updated");
				book.setIsbnNumber(sc.nextInt());
				System.out.println("Enter the Book name to be updated:\n");
				book.setBookName(sc.next());
				System.out.println("Enter the Authorname to be updated: \n");
				book.setAuthorName(sc.next());
				System.out.println("Enter the Editionto be updated:\n");
				book.setEdition(sc.nextInt());

				int result1 = operations.updateBook(book);
				if (result1 != 0) {
					System.out.println("Book details updated \n");
				} else {
					System.out.println("Book details updation failed\n");
				}
				break;
			case 4:
				System.out.println("Enter the ISBN_number to delete book details");
				book.setIsbnNumber(sc.nextInt());
				int result2 = operations.deleteBook();
				if (result2 != 0) {
					System.out.println("Book details deleted successfuly");
				} else {
					System.out.println("Book details deletion failed\n");
				}
			}
			System.out.println("To continue press any number other than 0\n");
			status = sc.nextInt();
		} while (!(status == 0));

	}

}
