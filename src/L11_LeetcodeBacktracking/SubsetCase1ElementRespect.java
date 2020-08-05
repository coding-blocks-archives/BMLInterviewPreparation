package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class SubsetCase1ElementRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };

		List<List<Integer>> main = new ArrayList<>();

		elementRespect(arr, 0, main, new ArrayList<>());

		System.out.println(main);

	}

	public static void elementRespect(int[] arr, int vidx, String ans) {

		if (vidx == arr.length) {
			System.out.println(ans);
			return;
		}

		elementRespect(arr, vidx + 1, ans + arr[vidx]);
		elementRespect(arr, vidx + 1, ans);

	}

	public static void elementRespect(int[] arr, int vidx, List<List<Integer>> main, List<Integer> temp) {

		if (vidx == arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}

		temp.add(arr[vidx]);
		elementRespect(arr, vidx + 1, main, temp);
		temp.remove(temp.size() - 1);

		elementRespect(arr, vidx + 1, main, temp);

	}

}
