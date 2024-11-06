import java.util.Scanner;
import java.util.Arrays;

public class NQueens {

    // Function to check if it's safe to place a queen at board[r][c]
    static boolean isSafe(int[][] board, int r, int c, int n) {
        // Check the column for any queen
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 1) {
                return false;
            }
        }
        
        // Check upper left diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve N-Queens
    static boolean solve(int[][] board, int r, int n) {
        if (r == n) {
            return true;
        }

        for (int c = 0; c < n; c++) {
            if (isSafe(board, r, c, n)) {
                board[r][c] = 1;
                if (solve(board, r + 1, n)) {
                    return true;
                }
                board[r][c] = 0; // Backtrack
            }
        }
        
        return false;
    }

    // Function to print the board
    static void print(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    // Main function to solve N-Queens
    static void nQueens(int n) {
        int[][] board = new int[n][n];
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        if (!solve(board, 0, n)) {
            System.out.println("No solution");
            return;
        }
        
        print(board, n);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        scanner.close();
        
        nQueens(n);
    }
}
