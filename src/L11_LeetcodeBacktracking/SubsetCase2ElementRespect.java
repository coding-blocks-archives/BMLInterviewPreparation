package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetCase2ElementRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };
		Arrays.sort(arr);

		// elementRespect(arr, 0, "", true);
		List<List<Integer>> main = new ArrayList<>();
		elementRespect(arr, 0, main, new ArrayList<>(), true);
		System.out.println(main);
	}

	public static void elementRespect(int[] denom, int vidx, String ans, boolean flag) {

		if (vidx == denom.length) {
			System.out.println(ans);
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			elementRespect(denom, vidx + 1, ans, false);
		} else {
			elementRespect(denom, vidx + 1, ans + denom[vidx], true);
			elementRespect(denom, vidx + 1, ans, false);
		}

	}

	public static void elementRespect(int[] denom, int vidx, List<List<Integer>> main, List<Integer> temp,
			boolean flag) {

		if (vidx == denom.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			elementRespect(denom, vidx + 1, main, temp, false);
		} else {
			temp.add(denom[vidx]);
			elementRespect(denom, vidx + 1, main, temp, true);
			temp.remove(temp.size() - 1);

			elementRespect(denom, vidx + 1, main, temp, false);
		}

	}

}
