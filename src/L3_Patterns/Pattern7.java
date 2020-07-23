package L3_Patterns;

public class Pattern7 {

	public static void main(String[] args) {

		int n = 5;

		int row = 1;

		while (row <= n) {

			// work
			for (int col = 1; col <= n; col++) {

				if (row == 1 || row == n || col == 1 || col == n)
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
