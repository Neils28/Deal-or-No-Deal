package lists;

public class CircularLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself in a circular manner
        } else {
            Node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Make it circular
        }
    }

    public void delete(T data) {
        if (head == null) {
            return;
        }

        if (head.data.equals(data)) {
            if (head.next == head) {
                head = null; // If only one node, set head to null
            } else {
                Node<T> last = getLastNode();
                head = head.next;
                last.next = head; // Update the last node's next pointer
            }
            return;
        }

        Node<T> current = head;
        Node<T> prev = null;

        do {
            prev = current;
            current = current.next;
        } while (current != head && !current.data.equals(data));

        if (current != head) {
            prev.next = current.next;
        }
    }

    private Node<T> getLastNode() {
        if (head == null) {
            return null;
        }

        Node<T> current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (head != null) {
            Node<T> current = head;
            do {
                result.append(current.data).append(" -> ");
                current = current.next;
            } while (current != head);
        }
        result.append("(head)");
        return result.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> myList = new CircularLinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        System.out.println("Circular Linked List: " + myList.toString());

        myList.delete(2);

        System.out.println("After deleting 2: " + myList.toString());
    }
}

