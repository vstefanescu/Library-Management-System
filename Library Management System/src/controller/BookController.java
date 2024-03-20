package controller;

import model.Book;
import model.Borrower;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	private List<Book> books;
	private List<Transaction> transactions;
	
	public BookController() {
		this.books = new ArrayList<>();
		this.transactions = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void updateBook(Book oldBook, Book newBook) {
		int index = books.indexOf(oldBook);
		if(index != -1) {
			books.set(index, newBook);
		}
	}
	
	public List<Book> getAllBooks() {
		return new ArrayList<>(books);
	}
	
	public List<Book> searchBooksByTitle(String title) {
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				result.add(book);
			}
		}
		return result;
	}
	
	public void borrowBook(Book book, Borrower borrower) {
		if(isBookAvailable(book)) {
			Transaction transaction = new Transaction(book, borrower, new java.util.Date());
			transactions.add(transaction);
		}else{
			System.out.println("Sorry, the book is currently unavailable.");
		}
	}
	
	public void returnBook(Book book) {
		for(Transaction transaction : transactions) {
			if(transaction.getBook().equals(book)) {
				transaction.setReturnDate(new java.util.Date());
				return;
			}
		}
		System.out.println("No transaction found for this book");
	}
	
	private boolean isBookAvailable(Book book) {
		for(Transaction transaction : transactions) {
			if(transaction.getBook().equals(book) && transaction.getReturnDate() == null) {
				return false;
			}
		}
		return true;
	}
}
