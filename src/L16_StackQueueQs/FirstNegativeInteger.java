package L16_StackQueueQs;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInteger {

	public static void main(String[] args) {

		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int k = 3;

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0) {
				q.add(i);
			}
		}

		for (int i = k; i < arr.length; i++) {

			// ans
			if (q.isEmpty()) {
				System.out.println(0);
			} else {
				System.out.println(arr[q.peek()]);
			}

			// remove the element which are out of window : <= i-k
			if (!q.isEmpty() && q.peek() <= i - k) {
				q.remove();
			}

			// add the new element only if it is -ve
			if (arr[i] < 0) {
				q.add(i);
			}

		}

		// first negative for last window
		if (q.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arr[q.peek()]);
		}

	}

}
