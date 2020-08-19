package L17_LinkedList;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// O(n)
	public void display() {

		System.out.println("-------------------");
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + ", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("-------------------");
	}

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	// O(1)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			this.tail.next = nn;
		}

		// summary object
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	// O(1)
	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size >= 1) {
			nn.next = head;
		}

		// summary object update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// summary update
			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return rv;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		int rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sizem2 = getNodeAt(this.size - 2);
			this.tail = sizem2;
			this.tail.next = null;
			this.size--;
		}

		return rv;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;

			return n.data;
		}
	}

	public void reverseData() throws Exception {

		int left = 0;
		int right = this.size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;

		}
	}

	public void reversePointers() {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		// swap
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		// this.tail.next = null;

	}

	public void reversePointersRec() {
		reversePointersRec(head);

		// swap
		Node t = this.head;
		this.head = this.tail;
		this.tail = t;

		tail.next = null;

	}

	private void reversePointersRec(Node prev, Node curr) {

		if (curr == null)
			return;

		Node ahead = curr.next;
		curr.next = prev;

		reversePointersRec(curr, ahead);

		// curr.next = prev;

	}

	private void reversePointersRec(Node curr) {

		if (curr.next == null) {
			return;
		}

		reversePointersRec(curr.next);
		curr.next.next = curr;
	}

	public int mid() {

		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

	public void fold() {

		// find out the mid node
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node sphead = slow.next;
		slow.next = null;

		// reverse the second part
		Node prev = null;
		Node curr = sphead;

		while (curr != null) {
			Node ahead = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		sphead = prev;

		// consume alternatively
		Node t1 = head;
		Node t2 = sphead;

		while (t2 != null) {

			Node a1 = t1.next;
			Node a2 = t2.next;

			t1.next = t2;
			t2.next = a1;

			t1 = a1;
			t2 = a2;
		}

	}

	public int kthfromlast(int k) {

		Node fast = head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		Node slow = head;

		while (fast != null) {

			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;

	}

	public void kReverse(int k) {
		head = kReverse(head, k);
	}

	private Node kReverse(Node node, int k) {

		if (node == null) {
			return null;
		}

		// samller problem : 5k
		Node temp = node; // you have to start from node not from head

		for (int i = 1; i <= k && temp != null; i++) {
			temp = temp.next;
		}

		Node prev = kReverse(temp, k); // store the rec result in prev so that you can set the links easily

		Node curr = node; // start curr from node not from head

		while (curr != temp) { // go till temp , not till null

			Node ahead = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		return prev;

	}

}
