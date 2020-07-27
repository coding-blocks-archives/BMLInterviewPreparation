package L7_BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] stalls = new int[nos];

		for (int i = 0; i < stalls.length; i++) {
			stalls[i] = scn.nextInt();
		}

		Arrays.sort(stalls);

		int finalAns = 0;

		int lo = 0;
		int hi = stalls[stalls.length - 1] - stalls[0];

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(stalls, noc, mid)) {
				finalAns = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}

		}

		System.out.println(finalAns);

	}

	public static boolean isItPossible(int[] stalls, int noc, int mid) {

		int cows = 1;
		int pos = stalls[0]; // keep a track of the pos in which last cow was placed

		for (int i = 1; i < stalls.length; i++) {

			if (stalls[i] - pos >= mid) {

				cows++;
				pos = stalls[i];

				if (cows == noc) {
					return true;
				}
			}

		}

		return false;

	}

}
