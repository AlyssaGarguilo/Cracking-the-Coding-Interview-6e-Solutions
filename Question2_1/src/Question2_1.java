import java.util.HashSet;
import java.util.Random;

public class Question2_1 {

	public static void main(String[] args) {
		removeDuplicates1(populateList());
		removeDuplicates2(populateList());
	}
	
	public static Node populateList() {
		// Populate the singly linked list with 25 random values within [0,9]. Keep track of head.
		Random randomizer = new Random(System.currentTimeMillis());
		Node head = new Node(randomizer.nextInt(10));
		Node prev = head;
		for (int i = 0; i < 24; i++) {
			Node current = new Node(randomizer.nextInt(10));
			prev.setNext(current);
			prev = current;
		}
		printList(head);
		return head;
	}
	
	public static void printList(Node current) {
		while (current != null) {
			System.out.print(current.getValue());
			if (current.getNext() != null)
				System.out.print(", ");
			else
				System.out.print("\n");
			current = current.getNext();
		}
	}
	
	// O(n) runtime and O(n) space complexity
	public static void removeDuplicates1(Node head) {
		HashSet<Integer> usedVals = new HashSet<Integer>();
		Node current = head;
		Node prev = null;
		while (current != null) {
			if (!usedVals.add(current.getValue())) {
				prev.setNext(current.getNext());
			} else {
				prev = current;
			}
			current = current.getNext();
		}
		printList(head);
	}
	
	// O(n^2) runtime and O(1) space complexity
	public static void removeDuplicates2(Node head) {
		Node current = head;
		while (current != null) {
			Node runner = current;
			while (runner.getNext() != null) {
				if (runner.getNext().getValue() == current.getValue())
					runner.setNext(runner.getNext().getNext());
				else
					runner = runner.getNext();
			}
			current = current.getNext();
		}
		printList(head);
	}
}

