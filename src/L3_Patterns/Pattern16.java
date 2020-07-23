package L3_Patterns;

public class Pattern16 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = n;

		int row = 1;

		while (row <= 2 * n - 1) {

			// work
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();

			if (row <= n - 1) {
				nsp--;
				nst--;
			} else {
				nsp++;
				nst++;
			}

			row++;
		}
	}

}
