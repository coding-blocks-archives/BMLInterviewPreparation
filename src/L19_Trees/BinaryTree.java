package L19_Trees;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = takeInput(null, false);
	}

	private Node takeInput(Node parent, boolean ilc) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {

			if (ilc) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		// take input of data from user
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data of node
		nn.data = item;

		// ask user if the node has left child
		System.out.println(nn.data + " has left child ?");

		// take input either true or false
		boolean hlc = scn.nextBoolean();

		// if left child exists, then create it
		if (hlc) {
			nn.left = takeInput(nn, true);
		}

		// ask user if the node has right child
		System.out.println(nn.data + " has right child ?");

		// take input either true or false
		boolean hrc = scn.nextBoolean();

		// if right child exists, then create it
		if (hrc) {
			nn.right = takeInput(nn, false);
		}

		// node is ready, now return the node
		return nn;

	}

	public void display() {
		System.out.println("----------------");
		display(root);
		System.out.println("----------------");
	}

	private void display(Node node) {

		// base case
		if (node == null) {
			return;
		}

		// self work
		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		// smaller problems
		display(node.left);
		display(node.right);
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null) {
			return false;
		}

		if (node.data == item) {
			return true;
		}

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null) {
			return -1;
		}

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	public void traversal() {
		traversal(root);
	}

	private void traversal(Node node) {

		if (node == null) {
			return;
		}

		System.out.println("hii " + node.data);

		if (node.left != null) {
			System.out.println("going towards " + node.left.data);
			traversal(node.left);
			System.out.println("coming back from " + node.left.data);
		}

		if (node.right != null) {
			System.out.println("going towards " + node.right.data);
			traversal(node.right);
			System.out.println("coming back from " + node.right.data);
		}

		System.out.println("bye " + node.data);
	}

}
