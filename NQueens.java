import java.util.Scanner;

public class NQueens {

    static int x[]; // Stores queen positions

    // Check whether queen can be placed
    static boolean safe(int row, int col) {

        for (int i = 1; i < row; i++) {

            // Same column or diagonal check
            if (x[i] == col ||
                Math.abs(x[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }

        return true;
    }

    // Backtracking Function
    static void queen(int row, int n) {

        for (int col = 1; col <= n; col++) {

            if (safe(row, col)) {

                x[row] = col;

                // If all queens placed
                if (row == n) {
                    print(n);
                }
                else {
                    queen(row + 1, n);
                }
            }
        }
    }

    // Print Solution
    static void print(int n) {

        System.out.println("\nSolution:");

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (x[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Queens: ");
        int n = sc.nextInt();

        x = new int[n + 1];

        queen(1, n);

        sc.close();
    }
}

//Backtracking Flow
//Place queen row by row
//Check safe position
//If safe -> place queen
//Move to next row
//If not possible -> backtrack
