package L16_StackQueueQs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSumWindow {

	public static void main(String[] args) {

		int[] arr = { 12, 1, 7, 8, 15, 30, 16, 28 };
		int k = 3;

		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < k; i++) {

			while (!q.isEmpty() && arr[i] > arr[q.peekLast()]) {
				q.removeLast();
			}

			q.addLast(i);
		}

		for (int i = k; i < arr.length; i++) {

			// ans
			System.out.println(arr[q.peekFirst()]);

			// remove the element which are out of window : <= i-k
			if (!q.isEmpty() && q.peekFirst() <= i - k) {
				q.removeFirst();
			}

			// if a larger value comes then it will dominate
			while (!q.isEmpty() && arr[i] > arr[q.peekLast()]) {
				q.removeLast();
			}

			q.add(i);

		}

		// max for last window
		System.out.println(arr[q.peekFirst()]);

	}

}
