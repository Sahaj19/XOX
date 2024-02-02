import java.util.*;

public class Main {
    public static void main(String args[]) {

        // Matrix initialization
        char matrix[][] = new char[3][3];
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = ' ';
            }
        }

        // Prerequisites
        char currentPlayer = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        // Game initialization
        while(!gameOver) {
            printMatrix(matrix);
            System.out.print("Player " + currentPlayer + " enter : ");
            int player_row_input = sc.nextInt();
            int player_col_input = sc.nextInt();

            if(matrix[player_row_input][player_col_input] == ' ') {
                matrix[player_row_input][player_col_input] = currentPlayer; // Place X or O
                gameOver = haveWon(matrix, currentPlayer);

                if(gameOver) {
                    System.out.println("Player " + currentPlayer + " has won!");
                } else {
                    // Check for draw condition
                    if(isDraw(matrix)) {
                        System.out.println("The game ends in a draw!");
                        break;
                    }
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Please make a valid move :(");
            }
        }

        // Let's print our final matrix
        printMatrix(matrix);
    }

    // Print the matrix
    public static void printMatrix(char matrix[][]) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "|");
            }
            System.out.println();
        }
    }

    // Winner algorithm
    public static boolean haveWon(char matrix[][], char currentPlayer) {
        // Check for rows 
        for(int row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == currentPlayer && matrix[row][1] == currentPlayer && matrix[row][2] == currentPlayer) {
                return true;
            }
        }

        // Check for columns
        for(int col = 0; col < matrix[0].length; col++) {
            if(matrix[0][col] == currentPlayer && matrix[1][col] == currentPlayer && matrix[2][col] == currentPlayer) {
                return true;
            }
        }

        // Check for primary diagonal
        if(matrix[0][0] == currentPlayer && matrix[1][1] == currentPlayer && matrix[2][2] == currentPlayer) {
            return true;
        }

        // Check for secondary diagonal
        if(matrix[0][2] == currentPlayer && matrix[1][1] == currentPlayer && matrix[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }

    // Check for draw condition
    public static boolean isDraw(char matrix[][]) {
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == ' ') {
                    return false; // If any cell is empty, the game is not a draw
                }
            }
        }
        return true; // If all cells are filled, the game is a draw
    }
}
