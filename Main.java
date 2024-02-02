import java.util.*;

public class Main {
    public static void main(String args[]) {

        //matrix initialization
        char matrix[][] = new char[3][3];
        for(int row=0 ; row < matrix.length ; row++) {
            for(int col=0 ; col < matrix[row].length ; col++) {
                matrix[row][col] = ' ';
            }
        }

        //prerequisites
        char currentPlayer = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        //game initialization
        while(!gameOver) {
            printMatrix(matrix);
            System.out.println("Player " + currentPlayer + " enter : ");
            int player_row_input = sc.nextInt();
            int player_col_input = sc.nextInt();

            if(matrix[player_row_input][player_col_input] == ' ') {
                matrix[player_row_input][player_col_input] = currentPlayer; //place out the X/0
                gameOver = haveWon(matrix , currentPlayer);

                if(gameOver) {
                    System.out.println("Player " + currentPlayer + " has won!");
                } else {
                   currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Please make a valid move :(");
            }
        }

        //let's print our final matrix
        printMatrix(matrix);
    }

    //let's print out our matrix
    public static void printMatrix(char matrix[][]) {
        for(int row=0 ; row < matrix.length ; row++) {
            for(int col=0 ; col < matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + "|");
            }
            System.out.println();
        }
    }

    //winner algorithm
    public static boolean haveWon(char matrix[][] , char currentPlayer) {
        
        //let's check for rows 
        for(int row=0 ; row < matrix.length ; row++) {
            if(matrix[row][0] == currentPlayer && matrix[row][1] == currentPlayer && matrix[row][2] == currentPlayer) {
                return true;
            }
        }

        //let's check for cols
        for(int col=0 ; col < matrix[0].length ; col++) {
            if(matrix[0][col] == currentPlayer && matrix[1][col] == currentPlayer && matrix[2][col] == currentPlayer) {
                return true;
            }
        }

        //let's check for primary diagonal
        if(matrix[0][0] == currentPlayer && matrix[1][1] == currentPlayer && matrix[2][2] == currentPlayer) {
            return true;
        }

        //let's check for secondary diagonal
        if(matrix[0][2] == currentPlayer && matrix[1][1] == currentPlayer && matrix[2][0] == currentPlayer) {
            return true;
        }

        return false;
    }
}
