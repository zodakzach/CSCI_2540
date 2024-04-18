package Activity8;

public class LinkedListTest {
	
	public static void evenElementsIterative(Node list) {
		while(list != null) {
			if(list.item % 2 == 0) {
				System.out.println(list.item);
			}
			list = list.next;
		}
	}
	
	public static void evenElementsRecursive(Node list) {
		if(list != null) 
		if(list.item % 2 == 0) {
			System.out.println(list.item);
		}
		if(list.next != null)
		evenElementsRecursive(list.next);
	}
	
	public static void oddElementsIterative(Node list) {
		while(list != null) {
			if(list.item % 2 != 0) {
				System.out.println(list.item);
			}
			list = list.next;
		}
	}
	
	public static void oddElementsRecursive(Node list) {
		if(list != null)
		if(list.item % 2 != 0) {
			System.out.println(list.item);
		}
		if(list.next != null)
		oddElementsRecursive(list.next);
	}
	
	public static void main(String [] args) {
		Node listHead = new Node(1);
		for(int i = 10; i > 1; i--) {
			listHead.next = new Node(i, listHead.next);
		}
	
		evenElementsRecursive(listHead);
		System.out.println();
		oddElementsRecursive(listHead);
		System.out.println();
		
		evenElementsIterative(listHead);
		System.out.println();
		oddElementsIterative(listHead);
	}

}
