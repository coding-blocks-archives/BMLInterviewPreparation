package L11_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _1239MaximumLengthConcatenatedStringUniqueCharacters {

	public static void main(String[] args) {

		List<String> arr = new ArrayList<String>();

		arr.add("un");
		arr.add("iq");
		arr.add("ue");

		System.out.println(maxLength(arr));
	}

	static int max;

	public static int maxLength(List<String> arr) {

		max = 0;

		maxLength(arr, 0, "");

		return max;
	}

	public static void maxLength(List<String> arr, int vidx, String ans) {

		if (isDistinct(ans)) {
			// System.out.println(ans);

			if (ans.length() > max)
				max = ans.length();

		}else
			return ;

		for (int i = vidx; i < arr.size(); i++) {
			maxLength(arr, i + 1, ans + arr.get(i));
		}
	}

	public static boolean isDistinct(String str) {

		int[] freq = new int[26];

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (freq[ch - 'a'] > 0) {
				return false;
			}

			freq[ch - 'a']++;

		}

		return true;
	}

}
