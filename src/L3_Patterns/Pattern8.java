package L3_Patterns;

public class Pattern8 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		while (row <= n) {

			// work
			for (int col = 1; col <= n; col++) {

				if (row == col || row + col == n + 1)
					System.out.print("*");
				else
					System.out.print(" ");

			}

			// prep
			System.out.println();
			row++;
		}
	}

}
