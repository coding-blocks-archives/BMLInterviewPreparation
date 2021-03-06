package L3_Patterns;

public class Pattern10 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = 0;
		int nst = 2 * n - 1;

		int row = 1;

		while (row <= n) {

			// work
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();
			nsp++;
			nst -= 2;
			row++;
		}

	}

}
