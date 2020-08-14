package L11_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _401_BinaryWatch {

	public static void main(String[] args) {

		System.out.println(readBinaryWatch(6));
	}

	public static List<String> readBinaryWatch(int num) {

		List<String> main = new ArrayList<String>();

		int[] arr = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
		readBinaryWatch(arr, 0, num, 0, 0, main);

		return main;
	}

	public static void readBinaryWatch(int[] arr, int vidx, int n, int hr, int min, List<String> main) {

		if (hr >= 12 || min >= 60)
			return;

		if (n == 0) {

			String fmin = min + "";

			if (fmin.length() == 1) {
				fmin = '0' + fmin;
			}

			main.add(hr + ":" + fmin);

			return;
		}

		if (vidx == arr.length) {
			return;
		}

		// yes
		if (vidx <= 3)
			readBinaryWatch(arr, vidx + 1, n - 1, hr + arr[vidx], min, main);
		else
			readBinaryWatch(arr, vidx + 1, n - 1, hr, min + arr[vidx], main);

		// no
		readBinaryWatch(arr, vidx + 1, n, hr, min, main);
	}
}
