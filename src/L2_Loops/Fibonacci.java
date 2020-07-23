package L2_Loops;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int a = 0;
		int b = 1;

		int count = 1;

		while (count <= n - 1) {

			int sum = a + b;
			a = b;
			b = sum;

			count++;
		}

		System.out.println(b);

	}

}
