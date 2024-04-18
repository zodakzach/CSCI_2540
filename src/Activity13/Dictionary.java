package Activity13;

import java.io.*;
import java.util.*;

import assg8_CERVENKAZ19.Event;

public class Dictionary {
	
	public static void main(String [] args) {
		File file = new File("actvity13_input.txt");
		Scanner s = null;
		Scanner user = null;
		Scanner s2 = null;
		Scanner s3 = null;
		int i= 0;
		String [] temp, temp1;
		HashMap<String, String> dict = new HashMap<String, String>();
		temp = new String[100];
		temp1 = new String[100];
		try {
			s = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		while(s.hasNextLine()) {
			StringTokenizer s1 = new StringTokenizer(s.nextLine(), "\t");
			
			if(s1.hasMoreTokens()) {
				temp[i] = s1.nextToken();
				temp1[i] = s1.nextToken();
				i++;
			}
		}
		
		for(int j = 0; j < temp.length; j++) {
			dict.put(temp[j], temp1[j]);
		}
		
		
		System.out.println("1. Display all the airports/cities\n2. Add a new airport\n3. Search for an airport\n4. Exit");
		user = new Scanner(System.in);
		int input = user.nextInt();
		
		while(input != 4) {
			switch(input) {
			case 1:
				Display(dict);
				break;
			case 2:
				s3 = new Scanner(System.in);
				System.out.println("Enter airport code: ");
				String code = s3.nextLine();
				System.out.println("Enter city: ");
				String city = s3.nextLine();
				add(dict, code, city);
				break;
			case 3:
				System.out.println("Enter airport code: ");
				s2 = new Scanner(System.in);
				String a = s2.nextLine();
				System.out.println(search(dict, a));
				break;
			}
			System.out.println("\n1. Display all the airports/cities\n2. Add a new airport\n3. Search for an airport\n4. Exit");
			input = user.nextInt();
		}
		
		user.close();
		System.out.println("End of program");
		
	}
	
	public static String search(HashMap<String, String> list, String airport){
		
		return list.get(airport);
		
	}
	
	public static void Display(HashMap<String, String> list) {
		Set<Map.Entry<String,String>> resultSet = list.entrySet();
	    Iterator<Map.Entry<String,String>> iter = resultSet.iterator();
	    Map.Entry<String, String> entry;
	    while (iter.hasNext()) {
	      entry = iter.next();
	      if(entry.getKey() != null)
	      System.out.println(entry.getKey() + "\t\t" + entry.getValue());
	    }
	}
	
	public static void add(HashMap<String, String> list, String airport, String city) {
		list.put(airport, city);
	}
	

}
