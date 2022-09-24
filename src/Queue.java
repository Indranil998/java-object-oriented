public class Queue<Type extends Comparable<Type>> {
	public Node head, tail;
	
    /**
     * creates empty queue with head and tail nodes 
     * and enqueue, deque, is empty, size, to string, insert sort functionalities
     * have to mention Queue<Type> queue node will store Type value
     * Type class should be extends Comparable and override abstract method toCompare
     */
    Queue() {
        head = tail = null;
    }

    /**
     * adds element to queue at rear side of queue where tail is pointing 
     * add element by wrapping it with node 
     * node accepts element of Type
     * Type class should be extends Comparable and override abstract method toCompare
     * @param element
     */
	public void enqueue(Type element) {
		Node newNode = new Node(element);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = tail.next;
		}
	}
	
    /**
     * returns element in front of queue where head is pointing
     * and also remove that element from queue by moving head to the next element of head
     * @return element
     */
	public Type deque() {
		if (head == null) return null;
		Type element = (Type) head.element;
		head = head.next;
		return element;
	}

    /**
     * inserts element at it index position according to sorting order manner
     * insert element by wrapping it with node 
     * node accepts element of Type
     * Type class should be extends Comparable and override abstract method toCompare
     * @param element
     */
    public void insertSort(Type element) {
        Node newNode = new Node(element);
        // check queue is empty or not if empty then haed and tail both will point to new node
        if(isEmpty()) {
            head = tail = newNode;
            return;
        }
        // we have to make our current node before that node where we have to add new node
        if(head.element.compareTo(element) < 0) {
            // we have to add new node at first index position
            newNode.next = head;
            head = newNode;
            return;
        }
        // we have to check index position in somewhere middle of queue
        Node currentNode = head;
        // it will stop at tail node because tail nodes next will always be null
        while(currentNode.next != null) {
            // have to check current nodes next nodes element is greater than new element or not
            if(currentNode.next.element.compareTo(element) < 0) {
                // we have to add new node at first index position
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                return;
            }   
            // will make current node move forward
            currentNode = currentNode.next;
        }
        // we not got position in middle of so we here at the tail of queue
        // so add new node at the end of the queue
        tail.next = newNode;
        tail = newNode;
    }

    public boolean isEmpty(){
        // head is null means queue is empty
        if(head == null) return true;
        else return false;
    }
	
    public int size(){
        int count = 0;
        Node currentNode = head;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

	public String toString() {
		String result = "";
		Node current = head;
		while(current != null) {
			result += current.element.toString();
			current = current.next;
		}
		return result;
	}
}