package L2_Loops;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int factors = 0;

		// System.out.println("Enter n :");
		
		int n = scn.nextInt();

		int div = 1;

		while (div <= n) {

			if (n % div == 0) {
				factors = factors + 1;
			}

			div = div + 1;
		}

		if (factors == 2) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}

}
