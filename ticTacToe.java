import java.util.Scanner; // Import Scanner class for user input

// Main class
public class ticTacToe {
    public static void main(String[] args) {
        // Create a 3x3 board for the game
        char[][] board = new char[3][3];

        // Initialize the board with empty spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X'; // Start with player 'X'
        boolean gameOver = false; // Variable to check if the game is over
        Scanner sc = new Scanner(System.in); // Create a Scanner object to take input

        // Game loop
        while (!gameOver) {
            // Print the current state of the board
            printBoard(board);

            // Ask the current player for their move
            System.out.println("Player " + player + " enter row and column:");

            // Take row and column input from the player
            int row = sc.nextInt();
            int col = sc.nextInt();

            // Check if the chosen cell is empty
            if (board[row][col] == ' ') {
                // Place the player's symbol on the board
                board[row][col] = player;

                // Check if the current player has won
                gameOver = haveWon(board, player);

                // If the game is over, announce the winner
                if (gameOver) {
                    System.out.println("Player " + player + " has won!");
                } else {
                    // Switch to the other player
                    player = player == 'X' ? 'O' : 'X';
                }
            } else {
                // If the cell is already occupied, prompt for another move
                System.out.println("Invalid move. Try again.");
            }
        }

        // Print the final board state
        printBoard(board);
    }

    // Function to check if a player has won
    private static boolean haveWon(char[][] board, char player) {
        // Check all rows for a win
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Check all columns for a win
        for (int col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Check the main diagonal for a win
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // Check the opposite diagonal for a win
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        // If no winning condition is met, return false
        return false;
    }

    // Function to print the board
    private static void printBoard(char[][] board) {
        // Iterate through each row
        for (int row = 0; row < board.length; row++) {
            // Print each column in the row
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | "); // Print cell value with separator
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
