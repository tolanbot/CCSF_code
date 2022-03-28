import java.util.*;

public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	private int numberOfElements;
	private static final int DEFAULT_SIZE = 25;
	private int MAX_SIZE;
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
					"The requested capcity you haved entered exceedes the allowed capacity for List.  List has been created with maximum capacity of: "
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

	// public boolean addFront(T newEntry){
	// 	Node newNode = new Node(newEntry);
	// 	if(canAdd()){
	// 	if(isEmpty()){
	// 		head = newNode;
	// 		tail = newNode;
	// 		numberOfElements++;
	// 		return true;
	// 	}else{
	// 		tail = head;
	// 		newNode.next = head.next;
	// 		head = newNode;
	// 		numberOfElements++;
	// 		return true;
	// 		}
	// 	}else{
	// 		return false;
	// 	}
	// }

	// public boolean addFront(T newEntry) {
	// 	Node newNode = new Node(newEntry);
	// 	if (canAdd()) {
	// 		if(head == null){
	// 			head = newNode;
	// 			numberOfElements++;
	// 			return true;
	// 		}else{
	// 			newNode.next = head.next;
	// 			head = newNode;
	// 			numberOfElements++;
	// 			return true;
	// 		}
	// 	} else {
	// 		return false;
	// 	}
	// }


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
			Node previousNode = getNodeAt(numberOfElements - 1);
			tail = previousNode;
			numberOfElements--;
		}
		return removed;
	}

	public void clear() {
		initializeDataFields();
	}

	public T getEntry(int givenIndex) {
		T entry = null;
		if (head != null) {
			if (givenIndex > 0 && givenIndex < numberOfElements) {
				Node nodeAt = getNodeAt(givenIndex);
				entry = nodeAt.getData();
			}
		}
		return entry;
	}

	public int indexOf(T anEntry) {
		int index = -1;
		Node current = head;
		while (head != null) {
			index++;
			if (current.getData().equals(anEntry)) {
				return index;
			} else {
				current = current.next;
			}
		}
		return index;
	}

	public int lastIndexOf(T anEntry) {
		int index = -1;
		if (head != null) {
			for (int i = numberOfElements; i < 0; i--) {
				if (getNodeAt(i).equals(anEntry)) {
					index = i;
					return index;
				}
			}
		}
		return index;
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
			if (current.equals(key)) {
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

	private Node getNodeAt(int givenIndex) {
		Node currentNode = head;
		if (currentNode != null) {
			if (givenIndex > 0 && givenIndex < numberOfElements - 1) {

				for (int i = 1; i < givenIndex; i++) {
					currentNode = currentNode.next;
				}
			}
		}
		return currentNode;
	}

	// @SuppressWarnings("unchecked")
	// public String printNode(Node head) {
	// 	Node printNode = head;
	// 	String nodeString = "";
	// 	while (printNode != null) {
	// 		T dataNode = printNode.getData();
	// 		nodeString = nodeString + dataNode + ", ";
	// 		printNode = printNode.next;
	// 	}
	// 	return nodeString;
	// }

	// public String printNode(Node head) {
	//     if (head == null)
    //          return "";
	// 	Node printNode = head;
	// 	String nodeString = printNode.data.toString();
	// 	printNode = printNode.next;
	// 	while (printNode != null) {
	// 		nodeString += ", "+printNode.data ;
	// 		printNode = printNode.next;
	// 	}
	// 	return nodeString;
	// }

	@SuppressWarnings("unchecked")
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

	//one i was using
	// @SuppressWarnings("unchecked")
	// private String printNode(Node head) {
	// 	Node printNode = head;
	// 	StringBuilder nodeString = new StringBuilder();
	// 	while (printNode != null) {
	// 		T dataNode = printNode.getData();
	// 		nodeString.append(dataNode);
	// 		nodeString.append(", ");
	// 		printNode = printNode.next;	
	// 	}
	// 	String strNode = nodeString.toString();
	// 	return strNode;
	// }


	// private String displayNode(){
	// 	String s = "";
	// 	Iterator<T> iterator = head.iterator();
	// 	while(iterator.hasNext()){
	// 		s = s + iterator.next() + ", ";
	// 	}
	// 	return s;
	// }

	// @Override
	// public String toString(){
	// 	String s ="";
	// 	T tailData = tail.data;
    //     T headData = head.data;
	// 	String nodePrint = printNode(head);
	// 	if(head != null) {
    //         s =  String.join(", ", nodePrint) + " size=" + numberOfElements + " capacity=" + MAX_SIZE + "\thead=" + headData+ " tail=" + tailData;
    //     }
	// 	return s;
	// }

	//was the closest
	@Override
	public String toString() {
	String str = "";
	if(head == null || tail == null){
		str = "[]";
		}
		if(head!=null && tail!=null){
		String testString = nodeList(head).toString();
		 str = testString + "size= " + numberOfElements + "capacity=" + MAX_SIZE + "head="
				+ this.head.getData() + "\ttail=" + this.tail.getData();
			}
		return str;
	}

	// @Override
    // public String toString()
    // {
    //   ArrayList<T> list = new ArrayList<T>(); 
    //   Node current = head;

    //   while(current != null) {
    //       list.add(current.data);
    //       current = current.next;
    //   }

    //   String  aString = list.toString() +"     size="+numberOfElements+"  capacity="+MAX_SIZE;

    //   if(head == null) {
    //       return aString;
    //   } else {
    //       return  aString  +" head="+head.data +" tail="+tail.data;
    //   }
    // }

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
