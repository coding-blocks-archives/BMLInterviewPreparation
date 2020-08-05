package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCombinationCase2CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 2 };

		List<List<Integer>> main = new ArrayList<>();
		coinRespect(denom, 0, 3, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	public static void coinRespect(int[] denom, int vidx, int amount, String ans) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length) {
			return;
		}

		coinRespect(denom, vidx + 1, amount - denom[vidx], ans + denom[vidx]);
		coinRespect(denom, vidx + 1, amount, ans);

	}

	public static void coinRespect(int[] denom, int vidx, int amount, List<List<Integer>> main, List<Integer> temp) {

		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (amount < 0 || vidx == denom.length) {
			return;
		}

		temp.add(denom[vidx]);
		coinRespect(denom, vidx + 1, amount - denom[vidx], main, temp);
		temp.remove(temp.size() - 1);

		coinRespect(denom, vidx + 1, amount, main, temp);

	}

}
