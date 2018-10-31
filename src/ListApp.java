
public class ListApp {

	public static void main(String[] args) {
		MyList list = new MyLinkedList();
		MyList otherList = new MyArrayList();

		/********************
		 * LinkedList Section*
		 *******************/

		list.addAtBeginning("B");
		list.addAtBeginning("A");
		list.addAtEnd("C");
		list.addAtEnd("D");
		System.out.println(list);
		list.removeAt(1);
		System.out.println(list);
		list.insertAt(2, "Z");
		System.out.println(list);
		System.out.println("Size is " + list.size());
		list.insertAt(4, "P"); // will print array out of bounds
		System.out.println(list); // print list again
		list.removeAll("C");
		System.out.println(list);

		System.out.println();

		/********************
		 * ArrayList Section*
		 *******************/
		otherList.addAtBeginning("A");
		otherList.addAtBeginning("B");
		otherList.addAtBeginning("C");
		otherList.addAtBeginning("D");
		System.out.println(otherList);
		otherList.removeAt(3);
		System.out.println(otherList);
		otherList.insertAt(3, "S"); // will print out of bounds
		System.out.println(otherList); // list after removal at 3 prints again
		otherList.insertAt(0, "F");
		System.out.println(otherList);
		otherList.insertAt(3, "Z");
		System.out.println(otherList);
		otherList.insertAt(2, "W");
		System.out.println(otherList);
		otherList.removeAll("D");
		System.out.println(otherList);

	}

}
