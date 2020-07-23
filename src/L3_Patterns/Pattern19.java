package L3_Patterns;

public class Pattern19 {

	public static void main(String[] args) {

		int n = 7;

		int nst = n / 2 + 1;
		int nsp = -1;

		int row = 1;

		while (row <= n) {

			// work
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			int cst = 1;

			if (row == 1 || row == n)
				cst = 2;

			for (; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();

			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}

			row++;
		}

	}

}
