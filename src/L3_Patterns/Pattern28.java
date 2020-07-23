package L3_Patterns;

public class Pattern28 {

	public static void main(String[] args) {

		int n = 7;

		int nst = 1;
		int nsp = n - 1;

		int row = 1;

		while (row <= n) {

			int val = row;

			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("\t");
			}

			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val + "\t");

				if (cst <= nst / 2)
					val++;
				else
					val--;
			}

			System.out.println();
			nsp--;
			nst += 2;
			row++;
		}
	}
}
