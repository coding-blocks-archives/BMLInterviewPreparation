package L10_Backtracking;

public class WordSearch {

	public static void main(String[] args) {

		String word = "SEED";

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		// two loops are used to find out the starting point
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == word.charAt(0)) {
					boolean ans = wordSearch(board, i, j, word, 0, new boolean[board.length][board[0].length]);

					if (ans == true) {
						System.out.println("found");
					}
				}
			}
		}

	}

	public static boolean wordSearch(char[][] board, int row, int col, String word, int vidx, boolean[][] visited) {

		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(vidx)
				|| visited[row][col]) {
			return false;
		}

		if (vidx == word.length() - 1) {
			return true;
		}

		visited[row][col] = true;

		boolean t = wordSearch(board, row - 1, col, word, vidx + 1, visited); // up

		if (t)
			return true;

		boolean d = wordSearch(board, row + 1, col, word, vidx + 1, visited); // down

		if (d)
			return true;

		boolean l = wordSearch(board, row, col - 1, word, vidx + 1, visited); // left

		if (l)
			return true;

		boolean r = wordSearch(board, row, col + 1, word, vidx + 1, visited); // right

		if (r)
			return true;

		visited[row][col] = false;

		return false;

	}

}
