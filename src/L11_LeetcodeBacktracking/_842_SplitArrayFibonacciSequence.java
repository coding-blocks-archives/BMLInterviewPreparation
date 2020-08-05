package L11_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _842_SplitArrayFibonacciSequence {

	public static void main(String[] args) {

		System.out.println(splitIntoFibonacci("551181659723"));
	}

	public static List<Integer> splitIntoFibonacci(String s) {

		List<Integer> main = new ArrayList<>();

		splitIntoFibonacci(s, main, new ArrayList<>());

		return main;
	}

	public static void splitIntoFibonacci(String ques, List<Integer> main, List<Integer> temp) {

		if (ques.length() == 0) {

			if (temp.size() >= 3 && main.size() == 0)
				// System.out.println(temp);
				main.addAll(temp);

			return;
		}

		for (int i = 1; i <= ques.length() && i <= 10; i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (inRange(part)) {

				int num = Integer.parseInt(part);

				if (isFibSeq(temp, num) && noLeadingZeros(part)) {
					temp.add(num);
					splitIntoFibonacci(roq, main, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}

	}

	public static boolean inRange(String part) {

		if (part.length() >= 11) {
			return false;
		}

		return Long.parseLong(part) <= Math.pow(2, 31) - 1;

	}

	public static boolean isFibSeq(List<Integer> temp, int num) {

		if (temp.size() <= 1) {
			return true;
		}

		int lastNo = temp.get(temp.size() - 1);
		int lastSecondNo = temp.get(temp.size() - 2);

		return lastNo + lastSecondNo == num;

	}

	// true : no leading zeros
	// false : leading zeros
	public static boolean noLeadingZeros(String part) {

		if (part.length() <= 1) {
			return true;
		}

		return part.charAt(0) != '0';
	}

}
