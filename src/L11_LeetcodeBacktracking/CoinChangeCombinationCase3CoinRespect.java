package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeCombinationCase3CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 2, 2, 3, 2, 3 };

		// coinRespect(denom, 0, 5, "", true);
		Arrays.sort(denom);
		List<List<Integer>> main = new ArrayList<>();
		coinRespect(denom, 0, 6, main, new ArrayList<>(), true);
		System.out.println(main);
	}

	public static void coinRespect(int[] denom, int vidx, int amount, String ans, boolean flag) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length) {
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount, ans, false);
		} else {
			coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx], true);
			coinRespect(denom, vidx + 1, amount, ans, false);
		}

	}

	public static void coinRespect(int[] denom, int vidx, int amount, List<List<Integer>> main, List<Integer> temp,
			boolean flag) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (amount < 0 || vidx == denom.length) {
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amount, main, temp, false);
		} else {
			temp.add(denom[vidx]);
			coinRespect(denom, vidx + 1, amount - denom[vidx], main, temp, true);
			temp.remove(temp.size() - 1);

			coinRespect(denom, vidx + 1, amount, main, temp, false);
		}

	}

}
