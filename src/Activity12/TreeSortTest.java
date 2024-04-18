package Activity12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class TreeSortTest {
	
	public static void main(String [] args) {
		Scanner s = null;
		ArrayList<City> cities = new ArrayList<City>();
		
		try {
			s = new Scanner(new File("activity12_input.txt"));
			}
			
			catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			while (s.hasNextLine()){
				String split = s.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(split, ",");
				while(tokenizer.hasMoreTokens()) {
					String city = tokenizer.nextToken();
					String country = tokenizer.nextToken();
					cities.add(new City(city, country));
				}
			}
			s.close();
			
			treeSort(cities);
	}
	
	public static void treeSort(ArrayList<City> list) {
		BinarySearchTree<City, String> tree = new BinarySearchTree<City, String>();
		
		for(int i = 0; i < list.size(); i++) {
			tree.insert(list.get(i));
		}
		TreeIterator<City> sorted = new TreeIterator<City>(tree);
		sorted.setInorder();
		while(sorted.hasNext()) {
			System.out.println(sorted.next());
		}
		
	}

}
