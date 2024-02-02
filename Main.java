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
        char gameOver = false
        Scanner sc = new Scanner(System.in);

        //game initialization
        while(!gameOver) {
            printMatrix(matrix);
            System.out.println("Player " + player + " enter : ");
            int player_row_input = sc.nextInt();
            int player_col_input = sc.nextInt();

            if(matrix[player_row_input][player_col_input] == " ") {
                matrix[player_row_input][player_col_input] = player; //place out the X/0
                gameOver = haveWon(matrix , player);

                if(gameOver) {
                    System.out.println("Player " + player + " has won!");
                }else {
                   player = (player == 'X') ? 'O' : 'X';
                }
            }else {
                System.out.println("Please make a valid move :(")
            }
        }

        //let's print our final matrix
        printMatrix(matrix);


        //let's print out our matrix
        public static void printMatrix(char matrix[][]) {
            for(int row=0 ; row < matrix.length ; row++) {
                for(int col=0 ; col < matrix[row].length ; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }

        //winner algorithm
        public static boolean haveWon(char matrix[][] , char player) {
            
            //let's check for rows 
            for(int row=0 ; row < matrix.length ; row++) {
                if(matrix[row][0] == player && matrix[row][1] == player && matrix[row][2] == player) {
                    return true;
                }
            }

            //let's check for cols
            for(int col=0 ; col < matrix[0].length ; col++) {
                if(matrix[0][col] == player && matrix[1][col] == player && matrix[2][col] == player) {
                    return true;
                }
            }

            //let's check for primary diagonal
            for(int row=0 ; row < matrix.length ; row++) {
                if(matrix[row][row] == player) {
                    return true;
                }else if(matrix[i][matrix.length-i-1] == player) {
                    return true;
                }else {
                    return false;
                }
            }
        }
    }
}