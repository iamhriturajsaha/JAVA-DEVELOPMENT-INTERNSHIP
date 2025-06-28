import java.util.Scanner;

class Main {
    static char[][] board = new char[3][3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            initializeBoard();
            char currentPlayer = 'X';
            boolean gameEnded = false;

            while (!gameEnded) {
                printBoard();
                System.out.println("Player " + currentPlayer + "'s turn.");

                int row, col;

                while (true) {
                    System.out.print("Enter row (0-2): ");
                    row = scanner.nextInt();
                    System.out.print("Enter column (0-2): ");
                    col = scanner.nextInt();

                    if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                        if (board[row][col] == ' ') {
                            board[row][col] = currentPlayer;
                            break;
                        } else {
                            System.out.println("Cell already taken. Try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Try again.");
                    }
                }

                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (checkDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    // Initialize the board with empty spaces
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print the current game board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Check if the current player has won
    static boolean checkWin(char player) {
        // Check rows, columns and diagonals
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // row
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))   // column
                return true;

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||     // main diagonal
            (board[0][2] == player && board[1][1] == player && board[2][0] == player))       // anti-diagonal
            return true;

        return false;
    }

    // Check if the board is full (draw)
    static boolean checkDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}