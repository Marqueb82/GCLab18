
import java.util.Arrays;

public class MyArrayList implements MyList {

	// The allocated array of memory. This might be bigger than the actual list.
	private String[] array = new String[4];
	// How many items are actually in the list. May be less than the length of the
	// array.
	private int length = 0;

	@Override
	public void addAtEnd(String data) {
		if (isFull()) {
			doubleLength();
		}
		array[length] = data;
		length++;
		// will add element at location and increase size
	}

	@Override
	public void removeFromEnd() {
		if (length != 0) {
			length--;
			array[length] = null;
		}

	}

	@Override
	public void addAtBeginning(String data) {
		if (isFull()) {
			doubleLength();
		}

		for (int i = length - 1; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = data;

		length++;

	}

	@Override
	public void removeFromBeginning() {

		if (length == 0) {
			return;
		}
		for (int i = 0; i < length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[length - 1] = null;
		length--;
	}

	@Override
	public String get(int index) {
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException();
		} else {
			return array[index];
		}
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");

		for (int i = 0; i < length; i++) {
			sb.append(array[i]);
			if (i != length - 1) {
				sb.append(", ");
			}
		}

		sb.append(" ]");
		return sb.toString();
	}

	private boolean isFull() {
		return length == array.length;
	}

	private void doubleLength() {
		// make a new copy of the array that is twice as long
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public void removeAt(int index) {

		if (index == 0) {
			removeFromBeginning();
		} else if (index < 0 || index >= array.length) {
			System.out.println("Out of bounds");
		} else {
			for (int i = index; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}

			length--;
		}

	}

	@Override
	public void insertAt(int index, String data) {

		if (index < 0 || index >= size()) {
			System.out.println("Out of bounds");
		} else if (index == 0) {
			addAtBeginning(data);
		} else if (index == size() - 1) {
			addAtEnd(data);
		} else {
			if (isFull()) {
				doubleLength();
			}
			for (int i = size() - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = data;

			length++;
		}
	}

	@Override
	public void removeAll(String data) {

		for (int i = 0; i < size(); i++) {
			if (array[i].equals(data)) {
				removeAt(i);
			}
		}

	}

}
