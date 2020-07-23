package L3_Patterns;

public class Pattern6 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = 0;
		int nst = n;

		int row = 1;

		while (row <= n) {

			// work
			// first work : spaces
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			// second work : stars
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			// prep
			System.out.println();
			nsp += 2;
			nst--;

			row++;
		}

	}

}
