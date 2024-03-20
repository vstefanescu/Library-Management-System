package controller;

import model.Borrower;

import java.util.ArrayList;
import java.util.List;

public class BorrowerController {
	private List<Borrower> borrowers;
	
	public BorrowerController() {
		this.borrowers = new ArrayList<>();
	}
	
	public void addBorrower(Borrower borrower) {
		borrowers.add(borrower);
	}
	
	public void removeBorrower(Borrower borrower) {
		borrowers.remove(borrower);
	}
	
	public void updateBorrower(Borrower oldBorrower, Borrower newBorrower) {
		int index = borrowers.indexOf(oldBorrower);
		if(index != -1) {
			borrowers.set(index, newBorrower);
		}
	}
	
	public List<Borrower> getAllBorrowers() {
		return new ArrayList<>(borrowers);
	}
	
	public List<Borrower> searchBorrowersByName(String name) {
		List<Borrower> result = new ArrayList<>();
		for(Borrower borrower : borrowers) {
			if(borrower.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(borrower);
			}
		}
		return result;
	}
}
