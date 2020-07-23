package L3_Patterns;

public class Pattern20 {

	public static void main(String[] args) {

		int n = 7;

		int nsp = n / 2;
		int nst = 1;

		int row = 1;

		while (row <= n) {

			// work
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}

			for (int cst = 1; cst <= nst; cst++) {
				if (cst == 1 || cst == nst)
					System.out.print("*");
				else
					System.out.print(" ");
			}

			// prep
			System.out.println();

			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}

			row++;
		}
	}

}
