package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {

	public static void main(String[] args) {

		System.out.println(combinationSum3(3, 9));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> main = new ArrayList<>();

		userRespect(1, n, k, main, new ArrayList<>());

		return main;
	}

	public static void userRespect(int value, int n, int k, List<List<Integer>> main, List<Integer> temp) {

		if (k == 0) {

			if (n == 0)
				main.add(new ArrayList<Integer>(temp));

			return;
		}

		for (int i = value; i <= 9; i++) {
			temp.add(i);
			userRespect(i + 1, n - i, k - 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
