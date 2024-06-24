/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author satya
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    int row;
    int col;

    public char[][] board = {{'?', '?', '?'}, {'?', '?', '?'}, {'?', '?', '?'}};

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void playerMove() {
        System.out.println("Place your X");
        Scanner input = new Scanner(System.in);
        while (true)
            try {
            System.out.print("Enter Row: ");
            row = input.nextInt();
            System.out.print("Enter Colomn: ");
            col = input.nextInt();
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid position, try again.");
                continue;
            }
            if (board[row][col] == '?') {
                board[row][col] = 'X';
                printBoard();
                //computerMove(); 
                break;
            } else {
                System.out.println("Pick another placement!");
            }
        } catch (Exception e) {
            System.out.println("Sorry, pick an integer placement");
            input.nextLine();
        }
        System.out.println();
    }

    public boolean checkHorizontalWin() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == 'X' && board[row][1] == 'X' && board[row][2] == 'X') {
                return true;
            }
        }
        return false;
    }

    public boolean checkVerticalWin() {
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == 'X' && board[1][col] == 'X' && board[2][col] == 'X') {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalWin() {
        // Check main diagonal
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') {
            return true;
        }
        // Check anti-diagonal
        if (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') {
            return true;
        }
        return false;
    }

    public void checkWin() {
        if (checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin()) {
            System.out.println('X' + " wins!");
            System.exit(0);
        }
        // Checking for 'O' wins is not implemented, assuming 'X' is the only player whose win is checked.
    }

//    public void computerMove() {
//        Random random = new Random();
//        int randomNumber = random.nextInt(9);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 'X') {       
//                    switch (randomNumber) {
//                        case 0:
//                            if (board[0][0] != 'X' && board[0][0] != 'O') {
//                                board[0][0] = 'O';
//                            }
//                            break;
//                        case 1:
//                            if (board[0][1] != 'X' && board[0][1] != 'O') {
//                                board[0][1] = 'O';
//                            }
//                            break;
//                        case 2:
//                            if (board[0][2] != 'X' && board[0][2] != 'O') {
//                                board[0][2] = 'O';
//                            }
//                            break;
//                        case 3:
//                            if (board[1][0] != 'X' && board[1][0] != 'O') {
//                                board[1][0] = 'O';
//                            }
//                            break;
//                        case 4:
//                            if (board[1][1] != 'X' && board[1][1] != 'O') {
//                                board[1][1] = 'O';
//                            }
//                            break;
//                        case 5:
//                            if (board[1][2] != 'X' && board[1][2] != 'O') {
//                                board[1][2] = 'O';
//                            }
//                            break;
//                        case 6:
//                            if (board[2][0] != 'X' && board[2][0] != 'O') {
//                                board[2][0] = 'O';
//                            }
//                            break;
//                        case 7:
//                            if (board[2][1] != 'X' && board[2][1] != 'O') {
//                                board[2][1] = 'O';
//                            }
//                            break;
//                        case 8:
//                            if (board[2][2] != 'X' && board[2][2] != 'O') {
//                                board[2][2] = 'O';
//                            }
//                            break;
//                        default:
//                            // Handle cases where randomNumber is not between 0 and 8
//                            break;
//
//                    }
//
//                }
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//
//        }
//    }
    public void computerMove() {
        Random random = new Random();
        int randomNumber;
        while (true) {
            randomNumber = random.nextInt(9);
            int row = randomNumber / 3;
            int col = randomNumber % 3;
            if (board[row][col] != 'X' && board[row][col] != 'O') {
                board[row][col] = 'O';
                break;
            }
        }
        System.out.println("Computer placed 'O'");
        printBoard();
    }

    public static void main(String[] args) {
//        TicTacToe game = new TicTacToe();
//        game.printBoard();
//        game.playerMove();
//        game.computerMove();
//        game.playerMove();
//        game.Won();
        //myBoard.printBoard(); when i call the printBoard method again, it prints the newly edited array. 

        //there are 9 moves in total. 
        TicTacToe game = new TicTacToe();
        game.printBoard();

        for (int moveCount = 0; moveCount < 9; moveCount++) {
            game.playerMove();
            game.checkWin();
            if (moveCount >= 8) {
                break; // Check if this is the last move
            }
            game.computerMove();
            game.checkWin();
        }
        System.out.println("It's a draw!");
    }
}
