package L11_LeetcodeBacktracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _306_AdditiveNumber {

	public static void main(String[] args) {

		isAdditiveNumber("199100199");
	}

	static boolean flag;

	public static boolean isAdditiveNumber(String num) {

		flag = false;

		isAdditiveNumber(num, new ArrayList<BigInteger>());

		return flag;
	}

	public static void isAdditiveNumber(String ques, List<BigInteger> temp) {

		if (ques.length() == 0) {

			if (temp.size() >= 3)
				// System.out.println(temp);
				flag = true;

			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			BigInteger num = new BigInteger(part);

			if (isAdditiveSeq(temp, num) && noLeadingZeros(part)) {
				temp.add(num);
				isAdditiveNumber(roq, temp);
				temp.remove(temp.size() - 1);
			}
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

	public static boolean isAdditiveSeq(List<BigInteger> temp, BigInteger num) {

		if (temp.size() <= 1) {
			return true;
		}

		BigInteger lastNo = temp.get(temp.size() - 1);
		BigInteger lastSecondNo = temp.get(temp.size() - 2);

		BigInteger sum = lastNo.add(lastSecondNo);

		return sum.compareTo(num) == 0;

	}
}
