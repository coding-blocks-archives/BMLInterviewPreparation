package L2_Loops;

import java.util.Scanner;

public class Prime2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int flag = 0;

		int n = scn.nextInt();

		int div = 2;

		while (div <= n - 1) {

			if (n % div == 0) {
				flag = 1;
				break;
			}

			div = div + 1;
		}

		if (flag == 1) {
			System.out.println("Not Prime");
		} else {
			System.out.println("Prime");
		}
	}

}
