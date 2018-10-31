
public class MyLinkedList implements MyList {

	// head is the first node in the list. if null, the list is empty.
	private Node head = null;
	// for convenience, keep track of how many items are in the list
	private int length = 0;

	@Override
	public void addAtBeginning(String data) {
		// add a new node and set it as the new head
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		length++;
	}

	@Override
	public void removeFromBeginning() {
		// find the second node and set it as the new head
		head = head.getNext();
		length--;
	}

	@Override
	public void addAtEnd(String data) {

		if (length < 1) {
			addAtBeginning(data);
		} else {
			Node node = new Node(data);
			Node lastNode = getNodeAt(size() - 1);
			lastNode.setNext(node);
			length++;
		}
	}

	@Override
	public void removeFromEnd() {
		if (length < 2) {
			// The beginning is the end.
			removeFromBeginning();
		} else {
			// find the node right before the end.
			Node beforeTail = getNodeAt(length - 2);
			// set its next to null. This ends the list here.
			beforeTail.setNext(null);
			length--;
		}
	}

	@Override
	public String get(int index) {
		// TODO #3
		return getNodeAt(index).getData();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// start at the head
		Node node = head;
		// follow the links between nodes until it reaches the end
		while (node != null) {
			// TODO #2
			sb.append(node.toString());
			node = node.getNext();
		}
		return sb.toString();
	}

	@Override
	public int size() {
		return length;
	}

	public Node getNodeAt(int index) {
		// start at the head
		Node node = head;
		// follow the links between nodes until it counts off the right number
		for (int i = 0; i < index; i++) {
			if (node == null) {
				// In case we run out of nodes before we get up to the desired index, return
				// null
				return null;
			}
			node = node.getNext();
		}
		return node;
	}

	@Override
	public void removeAt(int index) {

		if (index == 0) {
			head = head.getNext();
		} else if (index < 0 || index >= size()) {
			System.out.println("Out of bounds");
		} else {
			Node node = getNodeAt(index - 1);
			node.setNext(getNodeAt(index + 1));
		}
		length--;

	}

	@Override
	public void insertAt(int index, String data) {
		// TODO Auto-generated method stub
		Node node = new Node(data);

		if (index < 0 || index >= size()) {
			System.out.println("Out of bounds");
		} else if (index == 0) {
			addAtBeginning(data);
		} else if (index == size() - 1) {
			node.setNext(getNodeAt(index));
			getNodeAt(index - 1).setNext(node);
			length++;
		} else {
			node.setNext(getNodeAt(index));
			getNodeAt(index - 1).setNext(node);
			length++;
		}

	}

	@Override
	public void removeAll(String data) {

		for (int i = 0; i < size(); i++) {
			if (getNodeAt(i).getData().equals(data)) {
				removeAt(i);
			}
		}

	}

}
