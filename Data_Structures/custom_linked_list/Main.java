package custom_linked_list;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		/* ***** Testing CustomLinkedList ***** */
		CustomLinkedList test = new CustomLinkedList();
		System.out.println(test);
		test.addToHead(1);
		test.addToTail(2);
		test.addToTail(3);
		test.addToTail(4);
		test.addToTail(5);
		test.addToTail(6);
		test.addToTail(7);
		System.out.println("Should return 4. Actual: " + test.getValue(3));
		System.out.println(test);
		System.out.println("Should return 5. Actual: " + test.getValue(4));
		System.out.println("Should return 7. Actual: " + test.getValue(6));
		
		
		
		/* ***** Testing JDK LinkedList ***** */
		LinkedList<Integer> listus = new LinkedList<Integer>();
		
		listus.add(1);
		listus.add(2);
		listus.add(3);
		System.out.println(listus);
	}

}
