package L11_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

	public static void main(String[] args) {

		System.out.println(restoreIpAddresses("255250035"));

	}

	public static List<String> restoreIpAddresses(String s) {

		List<String> main = new ArrayList<String>();

		if (s.length() >= 13) {
			return main;
		}

		restoreIpAddresses(s, "", 0, main);

		return main;

	}

	public static void restoreIpAddresses(String ques, String ans, int dots, List<String> main) {

		if (ques.length() == 0) {

			if (dots == 4)
				main.add(ans.substring(0, ans.length() - 1));

			return;
		}

		if (ques.length() > (4 - dots) * 3) {
			return;
		}

		for (int i = 1; i <= 3 && i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isValidPart(part) && noLeadingZeros(part))
				restoreIpAddresses(roq, ans + part + ".", dots + 1, main);
		}
	}

	// true : no leading zeros
	// false : leading zeros
	public static boolean noLeadingZeros(String part) {

		if (part.length() <= 1) {
			return true;
		}

		return part.charAt(0) != '0';
	}

	public static boolean isValidPart(String part) {

		return Integer.parseInt(part) <= 255;

	}

}
