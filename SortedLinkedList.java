package deal.Game;

public class SortedLinkedList<T extends Comparable<T>> {

	private ListNode<T> head; // head node
	private int size; // size of the linked list
	private int total; // total of the data
	
	public int getSize() {
		return size;
	}
	
	public ListNode<T> getHead(){
		return head;
	}
	
	public int getTotal() {
		return total;
	}
	
	// Constructor
	public SortedLinkedList() {
		// node with no data
		head = new ListNode<>(null);
		head.next = null;
		head.prev = null;
		size = 0; // size will be zero
	}

	/**
	 * method to add an item
	 * 
	 * @param data
	 * @return nothing
	 */
	public void addItem(T data) {
		ListNode<T> newNode = new ListNode<>(data);
		ListNode<T> current = head.next;
		if (head.next == null) { // if list is empty, put at the beginning
			head.next = newNode;
			newNode.prev = head;
			size++;
			total = (int) data;
			return;
		} else {
			for (int i = 0; i < size; i++) {
				if (data.compareTo(current.data) >= 0) { // Data is >= to current node
					if (i < size - 1) {
						current = current.next;
					}
				} else { // put new node before the current node
					newNode.next = current;
					newNode.prev = current.prev;
					current.prev.next = newNode;
					current.prev = newNode;
					size++;
					total = total + (int) data;
					return;
				}
			}
		}
		// if it's greater than all other nodes, put at the end
		newNode.prev = current;
		current.next = newNode;
		newNode.next = null;
		size++;
		total = total + (int)data;
	}

	/**
	 * delete a node containing the data we want
	 * 
	 * @param data
	 * @return nothing
	 */
	public void deleteItem(T data) {
		if (head.next == null) {
			throw new IllegalArgumentException("The list is empty.");
		}

		ListNode<T> current = head.next;
		while (current != null) {
			if (data.equals(current.data)) {
				// found the node with our data, delete it
				current.prev.next = current.next;
				if (current.next != null) {
					current.next.prev = current.prev;
				}
				size--;
				total = total - (int)data;
				return;
			}
			current = current.next;
		}
	}

	/**
	 * toString that prints out the size of the list and everything on it
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Size: ").append(size).append("\n");
		int index = 0;
		ListNode<T> current = head.next;
		while (current != null) {
			result.append("Index ").append(index).append(": ").append(current.data.toString()).append("\n");
			current = current.next;
			index++;
		}

		return result.toString();
	}

	public static class ListNode<T> {
		private T data;
		public T getData() {
			return data;
		}
		
		ListNode<T> prev;
		public ListNode<T> getPrev() {
			return prev;
		}
		
		ListNode<T> next;
		public ListNode<T> getNext() {
			return next;
		}

		public ListNode(T data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		SortedLinkedList<Integer> newList = new SortedLinkedList<>();


		newList.addItem(1);
		newList.addItem(15);
		newList.addItem(2);
		newList.addItem(3);
		newList.addItem(8);
		newList.addItem(12);
		newList.deleteItem(1);
		newList.addItem(4);

		System.out.println("Linked List: " + newList.toString());
	}
}
