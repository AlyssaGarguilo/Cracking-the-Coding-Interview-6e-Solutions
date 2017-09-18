import java.util.Random;

public class Question2_3 {

	public static void main(String[] args) {
		Node head = populateList();
		
		// Select a random node in the middle to be removed
		Random randomizer = new Random(System.currentTimeMillis());
		Node removeMe = head.getNext();
		for (int i = 0; i < randomizer.nextInt(24); i++) {
			removeMe = removeMe.getNext();
		}
		
		System.out.println("Removing node " + removeMe.getValue());
		
		removeNode(head, removeMe);
		printList(head);
		
	}
	
	public static Node populateList() {
		// Populate the singly linked list with 25 unique values. Keep track of head.
		Node head = new Node(0);
		Node prev = head;
		for (int i = 1; i < 25; i++) {
			Node current = new Node(i);
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
	
	public static void removeNode(Node head, Node removeMe) {
		Node current = head;
		while (!current.getNext().equals(removeMe))
			current = current.getNext();
		current.setNext(current.getNext().getNext());
	}
}
