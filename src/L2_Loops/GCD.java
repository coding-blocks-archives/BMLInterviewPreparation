package L2_Loops;

import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int div = Math.min(n1, n2);

		while (div >= 1) {

			if (n1 % div == 0 && n2 % div == 0) {
				System.out.println("HCF is " + div);
				break;
			}
			div = div - 1;

		}

	}

}
