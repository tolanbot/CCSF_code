import java.util.*;

public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	private int numberOfElements;
	private static final int DEFAULT_SIZE = 25;
	private int MAX_SIZE= 1000;
	private boolean initialized = false;

	public LinkedFrontBackCappedList() {
		this(DEFAULT_SIZE);
	}

	public LinkedFrontBackCappedList(int capacity) {
		initializeDataFields();
		if (capacityOK(capacity)) {
			MAX_SIZE = capacity;
		}

		initialized = true;
	}

	private void initializeDataFields() {
		head = null;
		tail = null;
		numberOfElements = 0;
	}

	private boolean capacityOK(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Initial capacity must be greater than 0 | You entered " + capacity);
		}
		if (capacity > MAX_SIZE) {
			capacity = MAX_SIZE;
			System.out.println(
					"The requested capcity you haved entered exceeds the allowed capacity for List.  List has been created with maximum capacity of: "
							+ MAX_SIZE);
			// throw new IllegalStateException(
			// "Maximum Size Exceeded: Cannot create requested List.");
		}
		return true;
	}

	public boolean addFront(T newEntry){
		Node newNode = new Node(newEntry);
		if(canAdd()){
		if(isEmpty()){
			head = newNode;
			tail = head;
			numberOfElements++;
			return true;
		}else{
			newNode.next = head;
			head = newNode;
			numberOfElements++;
			return true;
			}
		}else{
			return false;
		}
	}




	// public boolean addBack(T newEntry){
	// 	Node newNode = new Node(newEntry);
	// 	if(canAdd()){
	// 		if(isEmpty()){
	// 			tail = newNode;
	// 			numberOfElements++;
	// 			return true;
	// 		}else{
	// 			tail.next = newNode;
	// 			tail = newNode;
	// 			numberOfElements++;
	// 			return true;
	// 			}
	// 	}else{
	// 		return false;
	// 	}
	// }

	public boolean addBack(T newEntry) {
		Node newNode = new Node(newEntry);
		if (canAdd()) {
			if(tail == null){
				tail = newNode;
				head = tail;
				numberOfElements++;
				return true;
			}else{
				tail.next = newNode;
				tail = newNode;
				numberOfElements++;
				return true;
			}
		} else {
			return false;
		}
	}

	private boolean canAdd() {
		if (numberOfElements < MAX_SIZE) {
			return true;
		} else {
			return false;
		}
	}

	public T removeFront() {
		isInitialzied();
		T removed = null;
		if (head != null) {
			removed = head.getData();
			head = head.next;
			numberOfElements--;
		}
		return removed;
	}

	public T removeBack() {
		T removed = null;
		if (tail != null) {
			removed = tail.data;
			Node previousNode = getNodeAt(numberOfElements - 2);
			tail = previousNode;
			tail.next = null;
			numberOfElements--;
		}
		return removed;
	}

	public void clear() {
		initializeDataFields();
	}

	// public T getEntry(int givenIndex) {
    //     T entry = null;

    //     if(head == null) {
    //         //System.out.println("null");
    //         return entry;
    //     }
    //         if (givenIndex >= 0 && givenIndex < numberOfElements) {
    //             Node nodeAt = getNodeAt(givenIndex);
    //             entry = nodeAt.getData();
    //         }
    //     return entry;
    // }

	public T getEntry(int givenIndex) {
		T entry = null;
		if (!isEmpty()) {
			if (givenIndex >= 0 && givenIndex < numberOfElements) {
				Node nodeAt = getNodeAt(givenIndex);
				entry = nodeAt.getData();
			}
		}
		return entry;
	}

	public int indexOf(T anEntry) {
		int index = -1;
		if(numberOfElements ==0){
			return -1;
		}
		Node current = head;
		if(current.getData().equals(anEntry)){
			return 0;
		}
		while (current != null) {
			if (current.getData().equals(anEntry)) {
				index++;
				return index;
			} else {
				index++;
				current = current.next;
			}
		}
		return -1;
	}
	public int lastIndexOf(T anEntry){
		int index = numberOfElements-1;
		if(numberOfElements == 0){
			return -1;
		}

		while(index>=0){
			Node n = getNodeAt(index);
			T entry = n.getData();
			if(entry.equals(anEntry)){
				return index;
			}
		index--;
		}
		return -1;
	}

	public boolean isFull() {
		return numberOfElements >= MAX_SIZE;
	}

	public boolean isEmpty() {
		return numberOfElements == 0;
	}

	public boolean contains(T key) {
		boolean found = false;
		Node current = head;
		while (!found && current != null) {
			if (current.data.equals(key)) {
				found = true;
			} else {
				current = current.next;
			}
		}
		return found;
	}

	public int size() {
		return this.numberOfElements;
	}

	private void isInitialzied() {
		if (!initialized) {
			throw new SecurityException("ArrayBag object is corrupt.");
		}
	}

	public Node getNodeAt(int givenIndex) {
		Node currentNode = head;
		if (currentNode != null) {
			if (givenIndex >= 0 && givenIndex < numberOfElements) {
				for (int i = 0; i < givenIndex; i++) {
					currentNode = currentNode.next;
				}
			}
		}
		return currentNode;
	}
	
	public ArrayList nodeList(Node head) {
		Node currentNode = head;
		ArrayList<String> list = new ArrayList<>();
		while (currentNode != null) {
			String dataNode = currentNode.getData().toString();
			list.add(dataNode);
			currentNode = currentNode.next;
		}
		return list;
	}

	@Override
	public String toString() {
	String str = "";
	if(head == null || tail == null){
		str = "[]";
		}
		if(head!=null && tail!=null){
		String listString = nodeList(head).toString();
		 str = listString + "\tsize=" + numberOfElements + "\tcapacity=" + MAX_SIZE + "\thead="
				+ this.head.getData() + "\ttail=" + this.tail.getData();
			}
		return str;
	}

	public T[] toArray() {
		// The cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfElements]; // changed from Object[]

		int index = 0;
		Node currentNode = head;
		while ((index < numberOfElements) && (currentNode != null)) {
			result[index] = currentNode.data;
			currentNode = currentNode.next;
			index++;
		}

		return result;
	}

	public class Node {
		public T data;
		public Node next;

		private Node(T dataValue) {
			data = dataValue;
			next = null;
		}

		private Node(T dataValue, Node nextNode) {
			data = dataValue;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}
}
