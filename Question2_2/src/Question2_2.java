import java.util.Random;

public class Question2_2 {

	public static void main(String[] args) {
		int k = 5;
		Node kthToLast = findKthToLastElement(k, populateList());
		System.out.println("Kth to last element's value is " + kthToLast.getValue());
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

	// O(n) runtime; O(1) space complexity
	public static Node findKthToLastElement(int k, Node current) {
		Node runner = current;
		// Put a runner k nodes in front of current
		for (int i = 0; i < k; i++) {
			if (runner != null)
				runner = runner.getNext();
			// In case K is larger than the list
			else
				return null;
		}
		
		// Move runner to end of list
		while (runner.getNext() != null) {
			runner = runner.getNext();
			current = current.getNext();
		}
		
		return current;
	}
}
