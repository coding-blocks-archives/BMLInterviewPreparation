package L17_LinkedList;

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(70);
		list.addLast(80);
		list.addLast(90);
		list.addLast(100);
		list.addLast(110);
		// list.addLast(120);

		list.display();
		list.kReverse(4);
		list.display();
	}

}
