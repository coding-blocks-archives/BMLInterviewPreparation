package L19_Trees;

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 40, 50, 60, 70, 80, 100 };

		BST bst = new BST(in);
		bst.display();

		// System.out.println(bst.find(10));
		// System.out.println(bst.max());
		// bst.add(55);
		// bst.display();
		//
		// bst.remove(55);
		// bst.display();
		//
		// bst.remove(80);
		// bst.display();

		bst.replaceWithSumLarger();
		bst.display();

	}

}