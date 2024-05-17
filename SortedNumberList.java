
public class SortedNumberList {
	public Node head;
	public Node tail;

	public SortedNumberList() {
		head = null;
		tail = null;
	}
	
   
   
   
   
	// Inserts the number into the list in the correct position such that the
	// list remains sorted in ascending order.
	public void insert(double number) {
		Node newNode = new Node(number);

	    if (head == null || head.data >= newNode.data) { //if the new node is to be inserted at the front of the list
	        newNode.next = head;
	        if (head != null) {
	            head.previous = newNode;
	        }
	        head = newNode;
	    } else {
	        Node current = head;
	        while (current.next != null && current.next.data < newNode.data) { //finds where to insert new node
	            current = current.next;
	        }
	        newNode.next = current.next;
	        if (current.next != null) {
	            current.next.previous = newNode;
	        }
	        current.next = newNode;
	        newNode.previous = current;
	    }
		}
		
		
		
	

	// Removes the node with the specified number value from the list. Returns
	// true if the node is found and removed, false otherwise.
	public boolean remove(double number) {
		if (head == null) {
	        return false; // List is empty
	    }

	    if (head.data == number) { // number to remove is first number in list
	        if (head.next != null) {
	            head.next.previous = null;
	        }
	        head = head.next;
	        return true;
	    }

	    Node currentNode = head.next;
	    while (currentNode != null) { //finds where the number is to remove
	        if (currentNode.data == number) {
	            currentNode.previous.next = currentNode.next;
	            if (currentNode.next != null) {
	                currentNode.next.previous = currentNode.previous;
	            }
	            return true;
	        }
	        currentNode = currentNode.next;
	    }

	    return false; // Number not found
}
	
}
