package assg9_CERVENKAZ19;

/**
 * @author zachary cervenka
 * CustomerMIS class that has the main method that allows you to create a customer roster
 * and retrieve, and add/delete/modify customer information
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomerMIS {

	public static void main(String[] args) {
		CustomerRoster Roster = new CustomerRoster();
		Scanner s = null;

		try {
			s = new Scanner(new File("assg9_CustomerRoster.txt"));
		}

		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		while (s.hasNextLine()) {
			String split = s.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(split, "\t");
			while (tokenizer.hasMoreTokens()) {
				String iD = tokenizer.nextToken();
				String name = tokenizer.nextToken();
				String phoneNumber = tokenizer.nextToken();
				Roster.Add(new Customer(iD, name, phoneNumber));
			}
		}
		s.close();

		System.out.println("1. Display\n2. Add\n3. Delete\n4. Search\n5. Update\n6. Save and Exit");
		Scanner kyb = new Scanner(System.in);
		int user = kyb.nextInt();

		while (user != 6) {
			switch (user) {
			// Display
			case 1:
				System.out.println();
				Roster.Display();
				break;
			// Add
			case 2:
				Scanner case2 = new Scanner(System.in);
				System.out.println("\nEnter ID: ");
				String case2iD = case2.nextLine();
				if (Roster.Search(case2iD) == null) {
					System.out.println("Enter name: ");
					String case2Name = case2.nextLine();
					System.out.println("Enter PhoneNumber: ");
					String case2Phone = case2.nextLine();
					Roster.Add(new Customer(case2iD, case2Name, case2Phone));
				} else {
					System.out.println("\nID Already Exists");
				}
				break;
			// Delete
			case 3:
				Scanner case3 = new Scanner(System.in);
				System.out.println("\nEnter ID: ");
				String case3iD = case3.nextLine();
				Roster.Delete(case3iD);
				break;
			// Search
			case 4:
				Scanner case4 = new Scanner(System.in);
				System.out.println("\nEnter ID: ");
				String case4iD = case4.nextLine();
				if (Roster.Search(case4iD) != null) {
					System.out.println(
							"\n" + Roster.Search(case4iD).getName() + "\t" + Roster.Search(case4iD).getPhoneNumber());
				} else {
					System.out.println("\nID Not Found");
				}
				break;
			// Update
			case 5:
				Scanner case5 = new Scanner(System.in);
				System.out.println("\nEnter ID: ");
				String case5iD = case5.nextLine();
				if (Roster.Search(case5iD) != null) {
					Roster.Update(case5iD);
				} else {
					System.out.println("\nID Not Found");
				}
				break;
			}
			System.out.println("\n1. Display\n2. Add\n3. Delete\n4. Search\n5. Update\n6. Save and Exit");
			user = kyb.nextInt();
		}

		// Exit and Save
		kyb.close();
		if (Roster.Save()) {
			System.out.println("\nRoster Saved");
		}
		System.out.println("\nEnd of Program");
	}

}
