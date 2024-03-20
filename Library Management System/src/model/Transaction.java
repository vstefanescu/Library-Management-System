package model;

import java.util.Date;

public class Transaction {
	private Book book;
	private Borrower borrower;
	private Date borrowDate;
	private Date returnDate;
	
	public Transaction(Book book, Borrower borrower, Date borrowDate) {
		this.book = book;
		this.borrower = borrower;
		this.borrowDate = borrowDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Transaction{" +
                "book=" + book +
                ", borrower=" + borrower +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
	}
}
