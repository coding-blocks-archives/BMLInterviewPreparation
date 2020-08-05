package L11_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetCase2UserRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2 };

		List<List<Integer>> main = new ArrayList<>();
		Arrays.sort(arr);
		userRespect(arr, 0, main, new ArrayList<Integer>());
		System.out.println(main);
	}

	public static void userRespect(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {

			if (i > vidx && arr[i] == arr[i - 1]) {
				continue;
			}

			userRespect(arr, i + 1, ans + arr[i]);
		}

	}

	public static void userRespect(int[] arr, int vidx, List<List<Integer>> main, List<Integer> temp) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = vidx; i < arr.length; i++) {

			if (i > vidx && arr[i] == arr[i - 1]) {
				continue;
			}

			temp.add(arr[i]);
			userRespect(arr, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
