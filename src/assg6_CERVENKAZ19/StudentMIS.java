package assg6_CERVENKAZ19;
/**
 * @author zachary cervenka
 * StudentMIS class that includes the main method which loads a roster of students in from a file
 * And gives the user a few options to change the roster and saves all the changes at the end
 */

import java.util.*;

public class StudentMIS {
	public static void main(String[] args) {
		//creates list and loads file into the list
		StudentList list = new StudentList();
		list.loadData("assg6_data.txt");
		
		
		//save boolean that determines if the program needs to be saved at the end
		boolean save = false;
		int option = 0;
		String enter = null, iD = null, name = null, standing = null, major = null;
		Scanner s =  new Scanner(System.in);
		Scanner userInput = new Scanner(System.in);
		
		//while loop that keeps program running until the user selects Exit
		while(option != 8) {
			System.out.println("1. Display the roster \n2. Search for a student by id \n"
					+ "3. Add a new student \n4. Remove a student \n5. Search for students by major \n"
					+ "6. Sort and save to file \n7. Save to file \n8. Exit");
			
			option = userInput.nextInt();
			
			//switch statement that lays out all the options the user has
			switch(option) {
			//displays the roster
			case 1:
				list.displayRoster();
				//Tells the user to press enter to continue and wont break until they do.
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//searches the list for a given Id
			case 2:
				System.out.print("\nEnter ID: ");
				iD = userInput.next();
				if(list.searchForStudent(iD) != null) {
					System.out.println("\n" + list.searchForStudent(iD));
				}
				else {
					System.out.println("\nStudent not found.");
				}
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//adds new student to list 
			case 3:
				System.out.print("\nEnter ID: ");
				iD = userInput.next();
				if(list.searchForStudent(iD) == null) {
					System.out.print("Enter name: ");
					name = userInput.next();
					System.out.print("Enter standing: ");
					standing = userInput.next();
					System.out.print("Enter major: ");
					major = userInput.next();
					list.addStudent(iD, name, standing, major);
					//sets save equal true since a change was made to the list
					save = true;
				}
				else {
					System.out.println("\nStudent already exists.");
				}
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//Removes a student with the given id from the list 
			case 4:
				System.out.print("\nEnter ID: ");
				iD = userInput.next();
				if(list.removeStudent(iD) == false) {
					System.out.println("Student doesn't exist.");
				}
				else {
					save = true;
				}
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//Creates a list of students who have a given major
			case 5:
				System.out.print("\nEnter major: ");
				major = userInput.next();
				if(list.getStudentsByMajor(major).size() > 0) {
					for(int i = 0; i < list.getStudentsByMajor(major).size(); i++) {
						System.out.println(list.getStudentsByMajor(major).get(i));
					}
				}
				else {
					System.out.println("No students in that major");
				}
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//Sorts and Saves the list
			case 6:
				list.Sort();
				list.Save();
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			//Saves the list if any changes
			case 7:
				if(save == true) {
					list.Save();
				}
				System.out.println("\nPress Enter to continue");
				enter = s.nextLine();
				if (enter == "")
				break;
			}
		}
		//if any changes have been made to the list the list will save before program ends
		if(save == true) {
			System.out.println("Saving changes...");
			list.Save();
		}
		System.out.println("End of Program.");
	}
}
