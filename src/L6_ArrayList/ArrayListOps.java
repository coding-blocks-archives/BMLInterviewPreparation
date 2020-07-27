package L6_ArrayList;

import java.util.ArrayList;

public class ArrayListOps {

	public static void main(String[] args) {

		// int[] one = { 1, 2, 3, 4, 5, 6, 6, 6, 7, 8 };
		// int[] two = { 5, 6, 6, 8, 8, 8, 10 };
		//
		// //System.out.println(sum2Arrays(one, two));
		// System.out.println(intersection(one, two));

		int[] arr;
		arr = new int[5];
		System.out.println(arr[0]);

	}

	public static ArrayList<Integer> sum2Arrays(int[] one, int[] two) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0)
				sum += one[i];

			if (j >= 0)
				sum += two[j];

			int ld = sum % 10;
			carry = sum / 10;

			list.add(0, ld);

			i--;
			j--;

		}

		if (carry != 0)
			list.add(0, carry);

		return list;

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] > two[j]) {
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else {
				list.add(one[i]);
				i++;
				j++;

			}

		}

		return list;

	}

}
