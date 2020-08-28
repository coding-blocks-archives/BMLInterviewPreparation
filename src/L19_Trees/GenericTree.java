package L19_Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}

		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of children for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop
		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(root);
		System.out.println("---------------------");

	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		Collections.reverse(node.children);

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		// self work

		while (node.children.size() > 1) {

			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);

		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));
	}

	public void levelOrder() {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove();

			// print
			System.out.print(rn.data + " ");

			// children enqueue
			for (Node child : rn.children) {
				q.add(child);
			}

		}

		System.out.println();

	}

	public void levelOrderLW() {

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove();

			if (rn == null) {

				System.out.println();

				if (!q.isEmpty())
					q.add(null);

				continue;

			}

			// print
			System.out.print(rn.data + " ");

			// children enqueue
			for (Node child : rn.children) {
				q.add(child);
			}

		}

	}

	public void levelOrderLW2() {

		Queue<Node> q = new LinkedList<>();
		Queue<Node> h = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove();

			// print
			System.out.print(rn.data + " ");

			// children enqueue
			for (Node child : rn.children) {
				h.add(child);
			}

			if (q.isEmpty()) {
				System.out.println();
				q = h;
				h = new LinkedList<>();
			}

		}

	}

}
