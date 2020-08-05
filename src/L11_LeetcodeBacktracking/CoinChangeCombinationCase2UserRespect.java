package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCombinationCase2UserRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 3, 4, 5 };

		List<List<Integer>> main = new ArrayList<>();
		userRespect(denom, 0, 6, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	public static void userRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = vidx; i < denom.length; i++) {
			userRespect(denom, i + 1, amount - denom[i], ans + denom[i]);
		}

	}

	public static void userRespect(int[] denom, int vidx, int amount, List<List<Integer>> main, List<Integer> temp) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = vidx; i < denom.length; i++) {
			temp.add(denom[i]);
			userRespect(denom, i + 1, amount - denom[i], main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
