package Activity11;
import java.util.*;

public class Sort {
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
		ArrayList<Integer> half1 = new ArrayList<Integer>();
		ArrayList<Integer> half2 = new ArrayList<Integer>();
	
		if (list.size() == 1) {
			return list;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(i <= (list.size()-1)/2) {
				half1.add(list.get(i));
			}else
			{
				half2.add(list.get(i));
			}
		}

		return merge(mergeSort(half1), mergeSort(half2));
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> list1,ArrayList<Integer> list2){
		ArrayList<Integer> merged = new ArrayList<Integer>();
		int i = 0, j=0;
		
		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i) <= list2.get(j)) {
				merged.add(list1.get(i++));
			}
			else {
				merged.add(list2.get(j++));
			}
		}
		while(i < list1.size()) {
			merged.add(list1.get(i++));
		}
		
		while(j < list2.size()) {
			merged.add(list2.get(j++));
		}
		return merged;
	}
	
	public static void main(String [] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.print("Enter total number of Integers: ");
		Scanner kyb = new Scanner(System.in);
		Scanner kyb1 = new Scanner(System.in);

		int size = kyb.nextInt();
		System.out.println("Enter Integers seperated by space:");
		String s = kyb1.nextLine();
		
		StringTokenizer s1 = new StringTokenizer(s, " ");
		
		while(s1.hasMoreTokens()) {
			
			try {
				list.add(Integer.valueOf(s1.nextToken()));
			}
			catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println(list);
		System.out.println(mergeSort(list));
		
		kyb.close();
		kyb1.close();
	}

}
