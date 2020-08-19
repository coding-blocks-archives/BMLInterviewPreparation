package L16_StackQueueQs;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {

		int[] arr = { 80, 50, 70, 30, 20, 40, 90, 10, 5, 35 };

		int[] ans = new int[arr.length];

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {

			// building shadow cross -> pop
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}

			// ans decide
			if (s.isEmpty()) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - s.peek();
			}

			// push
			s.push(i);

		}

		System.out.println(Arrays.toString(ans));

	}

}
