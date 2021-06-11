package custom_linked_list;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		CustomLinkedList test = new CustomLinkedList();
		System.out.println(test);
		test.addToTail(2);
		test.addToTail(3);
		System.out.println(test);
		
		// Testing JDK LinkedList
		LinkedList<Integer> listus = new LinkedList<Integer>();
		
		listus.add(1);
		listus.add(2);
		listus.add(3);
		System.out.println(listus);
		

	}

}
