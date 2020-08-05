package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

	public static void main(String[] args) {

		System.out.println(combine(4, 2));
	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> main = new ArrayList<>();

		userRespect(1, n, k, main, new ArrayList<>());

		return main;
	}

	public static void userRespect(int value, int n, int k, List<List<Integer>> main, List<Integer> temp) {

		if (k == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = value; i <= n; i++) {
			temp.add(i);
			userRespect(i + 1, n, k - 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
