package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.List;

public class SubsetCase1UserRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		List<List<Integer>> main = new ArrayList<>();

		userRespect(arr, 0, main, new ArrayList<>());

		System.out.println(main);

	}

	public static void userRespect(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {
			userRespect(arr, i + 1, ans + arr[i]);
		}

	}

	public static void userRespect(int[] arr, int vidx, List<List<Integer>> main, List<Integer> temp) {

		main.add(new ArrayList<Integer>(temp));

		for (int i = vidx; i < arr.length; i++) {
			temp.add(arr[i]);
			userRespect(arr, i + 1, main, temp);
			temp.remove(temp.size() - 1);
		}

	}

}
