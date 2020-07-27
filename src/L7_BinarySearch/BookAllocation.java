package L7_BinarySearch;

import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		while (tc > 0) {
			int nob = scn.nextInt();
			int nos = scn.nextInt();

			int[] pages = new int[nob];

			for (int i = 0; i < pages.length; i++) {
				pages[i] = scn.nextInt();
			}

			int finalAns = 0;

			int lo = 0;
			int hi = 0;

			for (int val : pages) {
				hi += val;
			}

			while (lo <= hi) {

				int mid = (lo + hi) / 2;

				if (isItPossible(pages, nos, mid)) {
					finalAns = mid;
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}

			}

			System.out.println(finalAns);
			tc--;
		}

	}

	public static boolean isItPossible(int[] pages, int nos, int mid) {

		int students = 1;
		int noPagesRead = 0;

		int i = 0; // keep a track of th book which is presently being read

		while (i < pages.length) {

			if (noPagesRead + pages[i] <= mid) {
				noPagesRead += pages[i];
				i++;
			} else {

				students++;
				noPagesRead = 0;

				if (students > nos)
					return false;

			}

		}

		return true;

	}

}
