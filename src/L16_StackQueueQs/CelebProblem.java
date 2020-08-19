package L16_StackQueueQs;

import java.util.Stack;

public class CelebProblem {

	public static void main(String[] args) {

		int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			s.push(i);
		}

		while (s.size() != 1) {

			int a = s.pop();
			int b = s.pop();

			// a knows b : a can't be celeb
			if (arr[a][b] == 1) {
				s.push(b);
			}
			// a doesn't know b : b can't be a celeb
			else {
				s.push(a);
			}
		}

		int candidate = s.pop();

		for (int i = 0; i < arr.length; i++) {

			if (i != candidate) {

				if (arr[i][candidate] == 0 || arr[candidate][i] == 1) {
					System.out.println("No Celeb");
					return;
				}
			}
		}

		System.out.println(candidate);

	}

}
