package L5_Arrays;

public class ArrayOps {

	public static void main(String[] args) {

		int[] arr = { 10, -12, 3, -5, 11 };
		// int[] arr = { 7, 2, 5, 1, 3, 9 };

		// reverse(arr);
		// rotate1(arr, -25);
		// int[] na = inverse(arr);

		// for (int val : na) {
		// System.out.print(val + " ");
		// }
		// System.out.println();

		// barGraph(arr);

		// subarraySum2Loops(arr);

		// System.out.println(kadane(arr));

		System.out.println(maxCircularSum(arr));

	}

	public static void reverse(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			// swap the values at left and right index
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;

		}

	}

	public static void reverse(int[] arr, int si, int ei) {

		int left = si;
		int right = ei;

		while (left < right) {

			// swap the values at left and right index
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;

		}

	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0)
			rot = rot + arr.length;

		for (int r = 1; r <= rot; r++) {

			int temp = arr[arr.length - 1];

			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;

		}

	}

	public static void rotate1(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0)
			rot = rot + arr.length;

		reverse(arr, 0, arr.length - rot - 1);
		reverse(arr, arr.length - rot, arr.length - 1);
		reverse(arr);

	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		// logic ..
		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

	public static void barGraph(int[] arr) {

		int max = maximum(arr);
		int cols = arr.length;

		for (int row = 1; row <= max; row++) {

			for (int col = 0; col < cols; col++) {

				if (row <= max - arr[col]) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}

			}
			System.out.println();
		}

	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int val : arr) {
			if (val > max)
				max = val;
		}

		return max;
	}

	public static void subarray(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();

			}
		}

	}

	public static void subarraySum3Loops(int[] arr) {

		for (int si = 0; si < arr.length; si++) {

			for (int ei = si; ei < arr.length; ei++) {

				int sum = 0;
				for (int k = si; k <= ei; k++) {
					sum += arr[k];
				}
				System.out.println(sum);

			}
		}

	}

	public static void subarraySum2Loops(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int si = 0; si < arr.length; si++) {

			int sum = 0;

			for (int ei = si; ei < arr.length; ei++) {

				sum += arr[ei];

				if (sum > max) {
					max = sum;
				}

				System.out.println(si + "-" + ei + ": " + sum);

			}
		}

		System.out.println("Max: " + max);

	}

	public static int kadane(int[] arr) {

		int sum = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum = Math.max(sum + arr[i], arr[i]);

			if (sum > max)
				max = sum;
		}

		return max;

	}

	public static int maxCircularSum(int[] arr) {

		// case 1
		int sumNonwrapping = kadane(arr);

		// case 2
		int totalSum = 0;

		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
			arr[i] = -arr[i];
		}

		int sumNCE = kadane(arr);

		int sumWrapping = totalSum + sumNCE;

		int ans = Math.max(sumNonwrapping, sumWrapping);

		return ans;

	}

	public static int[][] matrixMultiplication(int[][] m1, int[][] m2) {

		int r1 = m1.length;
		int c1 = m1[0].length;

		int r2 = m2.length;
		int c2 = m2[0].length;

		int[][] ans = new int[r1][c2];

		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {

				int sum = 0;
				for (int k = 0; k < c1; k++) {
					sum += m1[i][k] * m2[k][j];
				}

				ans[i][j] = sum;

			}
		}

		return ans;

	}

}
