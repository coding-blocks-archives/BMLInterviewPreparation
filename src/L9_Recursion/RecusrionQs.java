package L9_Recursion;

import java.util.ArrayList;

public class RecusrionQs {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		// validParenthesisPair(3, 0, 0, "", list);

		// System.out.println(list);

		palindromePartitioning("nitin", 0, "");

	}

	public static int count = 0;

	public static void validParenthesisPair(int n, int open, int close, String ans, ArrayList<String> list) {

		// negative bc
		if (open > n || close > n || close > open) {
			return;
		}

		// positive bc
		if (open == n && close == n) {
			// System.out.println(++count + ". " + ans);
			list.add(ans);
			return;
		}

		validParenthesisPair(n, open + 1, close, ans + "(", list);
		validParenthesisPair(n, open, close + 1, ans + ")", list);
	}

	public static void palindromePartitioning(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isPalindrome(part))
				palindromePartitioning(roq, ans + part + " ");

		}

	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	public static void palindromePartitioning(String ques, int vidx, String ans) {


		if (ques.length() == vidx) {
			System.out.println(ans);
			return;
		}

		for (int i = vidx + 1; i <= ques.length(); i++) {

			String part = ques.substring(vidx, i);

			if (isPalindrome(part))
				palindromePartitioning(ques, i, ans + part + " ");

		}

	}

}
