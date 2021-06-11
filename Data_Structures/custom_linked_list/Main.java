package custom_linked_list;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Node test = new Node(1);
		System.out.println(test);
		test.addToEnd(2);
		test.addToEnd(3);
		System.out.println(test);
		
		// Testing JDK LinkedList
		LinkedList<Integer> listus = new LinkedList<Integer>();
		
		listus.add(1);
		listus.add(2);
		listus.add(3);
		System.out.println(listus);
		

	}

}
