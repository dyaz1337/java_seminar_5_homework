public class eightqueens {
    private static final int board_size = 8;
    private static final int empty = 0;

    public static void main(String[] args) {
        int[][] board = new int[board_size][board_size];
        if (solve(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean solve(int[][] board, int col) {
        if (col == board_size) {
            return true;
        }
        for (int row = 0; row < board_size; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (solve(board, col + 1)) {
                    return true;
                }
                board[row][col] = empty;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < board_size && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q" : ".");
            }
            System.out.println();
        }
    }
}