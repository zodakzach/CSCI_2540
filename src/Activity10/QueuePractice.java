package Activity10;

import java.util.*;

public class QueuePractice {
	public static void queueTest(Node list) {
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
	
		while (list != null) {
			list.item = list.item * 2;
			que.add(list.item);
			list = list.next;
		}
		
		Iterator<Integer> value = que.iterator();
		
		while(value.hasNext()) {
			System.out.print(value.next() + "\t");
		}
	}
	
	public static Node listGenerator(int size) {

		Random rand = new Random();   

		
		Node list = new Node(rand.nextInt(50));
		while (size > 1) {
			list.next = new Node(rand.nextInt(50), list.next);
			size--;
		}
		return list;
	}
	
	public static void main(String [] args) {
		System.out.print("Enter the number of item in list: ");
		Scanner kyb = new Scanner(System.in);
		int size = kyb.nextInt();
		Node list = listGenerator(size);
		Node temp = list;
		while (temp != null) {
			System.out.print(temp.item + "\t");
			temp = temp.next;
		}
		System.out.println();
		queueTest(list);
	}

}
