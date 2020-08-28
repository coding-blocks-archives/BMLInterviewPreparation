package L19_Trees;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
	// 10 true 20 true 40 true 70 true 90 true 110 false false false false false true 50 false true 80 false true 100 false true 120 false false true 30 false true 60 false false
	// 10 true 20 true 40 true 2 false false true 3 false false true -60 false false true -30 true 50 true 60 true 80 false false false true 70 false false true -100 false false
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(30));
		System.out.println(bt.ht());
		
		bt.traversal();

	}

}
