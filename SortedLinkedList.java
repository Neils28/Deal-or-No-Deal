package lists;

public class SortedLinkedList<T extends Comparable<T>> { 

    private ListNode<T> head; //head node
    private int size; //size of the linked list
   
    //Constructor 
    public SortedLinkedList() {
        //node with no data
        head = new ListNode<>(null);
        head.next = null;
        head.prev = null;
        size = 0; // size will be zero
    }
/**
 * method to add an item
 * @param data
 * @return nothing
 */
    public void addItem(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (head.next == null) { //if list is empty, put at the beginning
            head.next = newNode;
            newNode.prev = head;
            size++;
            return;
        }
        ListNode<T> current = head.next;
        while (current != null) {
            if (data.compareTo(current.data) >= 0) { // Data is >= to current node
                current = current.next;
            } else { //put new node before the current node
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                size++;
                return;
            }}
        //if it's greater than all other nodes, put at the end
        newNode.prev = head.prev;
        head.prev.next = newNode;
        newNode.next = null;
        head.prev = newNode;
        size++;
    }
    /**
     * delete a node containing the data we want
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
                //found the node with our data, delete it
                current.prev.next = current.next;
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                size--;
                return; 
            }
            current = current.next;
        }}
   
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
    
    private static class ListNode<T> {
        T data;
        ListNode<T> prev;
        ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    public static void main(String args) {
    	
    	SortedLinkedList<Integer> newList = new SortedLinkedList<>();
    	
    	newList.addItem(1);
    	newList.addItem(2);
    	newList.addItem(3);
    	newList.deleteItem(1);
    	
    	System.out.println("Linked List: " + newList.toString());
    	
    }
}

