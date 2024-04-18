package assg9_CERVENKAZ19;

/**
 * @author zachary cervenka
 * CustomerRoster class that allows you to create a customer roster and manage as well as save the roster
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class CustomerRoster {
	private BinarySearchTree<Customer, String> tree;

	/**
	 * Default constructor that creates the BinarySearchTree
	 */
	public CustomerRoster() {
		tree = new BinarySearchTree<Customer, String>();
	}

	/**
	 * Display method that sorts binary tree and prints it out
	 */
	public void Display() {
		TreeIterator<Customer> sorted = new TreeIterator<Customer>(tree);
		sorted.setInorder();
		while (sorted.hasNext()) {
			System.out.println(sorted.next());
		}
	}

	/**
	 * Add method that adds new customer to the binary tree
	 * 
	 * @param newCustomer
	 */
	public void Add(Customer newCustomer) {
		tree.insert(newCustomer);
	}

	/**
	 * Delete method that deletes a customer with the givenID from tree
	 */
	public void Delete(String givenID) {
		try {
			tree.delete(givenID);
		} catch (TreeException e) {
			System.out.println("ID Not Found.");
		}
	}

	/**
	 * Search method that returns the customer with the givenId or returns null if
	 * not found
	 * 
	 * @param givenId
	 * @return customer/null
	 */
	public Customer Search(String givenID) {
		if (tree.retrieve(givenID) != null) {
			return tree.retrieve(givenID);
		} else {
			return null;
		}
	}

	/**
	 * Update method that allows user to either change name or PhoneNumber of a
	 * customer
	 * 
	 * @param givenID
	 */
	public void Update(String givenID) {
		System.out.println("1. Update Name\n2. Update PhoneNumber");
		Scanner s = new Scanner(System.in);
		int user = s.nextInt();
		switch (user) {
		case 1:
			System.out.println("Enter Name: ");
			String newName = s.next();
			tree.retrieve(givenID).setName(newName);
			break;
		case 2:
			System.out.println("Enter PhoneNumber: ");
			String newPhone = s.next();
			tree.retrieve(givenID).setPhoneNumber(newPhone);
			break;
		}
		s.close();
	}

	/**
	 * Save method that returns true if save was successful and false if not
	 * 
	 * @return true/false
	 */
	public boolean Save() {
		PrintWriter output = null;
		File newFile = new File("assg9_CustomerRoster.txt");
		try {
			output = new PrintWriter(newFile);
			TreeIterator<Customer> sorted = new TreeIterator<Customer>(tree);
			sorted.setPreorder();
			while (sorted.hasNext()) {
				output.println(sorted.next());
			}
			output.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
