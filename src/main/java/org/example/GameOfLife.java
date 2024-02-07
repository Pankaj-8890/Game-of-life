package org.example;
import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension for row");
        int row = scanner.nextInt();

        System.out.println("Enter the dimension for column");
        int column = scanner.nextInt();

        System.out.println("Enter the seeding Percentage for live cells");
        int seedingLive = scanner.nextInt();

        Board board = new Board(row,column,seedingLive);
        board.displayBoard();
        System.out.println("===========================");

        while (true) {
            System.out.println("Enter 1 to populate");
            System.out.println("Enter 2 to print nextLife");
            System.out.println("Enter 3 to exit");
            int n = scanner.nextInt();
            if (n == 1) {
                board.initializeBoard();
                board.displayBoard();
                System.out.println("===========================");
            }
            if (n == 2) {
                board = board.nextGenerationBoard();
                board.displayBoard();
                System.out.println("===========================");
            }
            if (board.checkAllDead() || n == 3) {
                break;
            }
            if (n != 1 && n != 2) {
                System.out.println("Please enter valid option");
                System.exit(0);
            }
        }
        System.out.println("Thank you for playing the game");
    }




}
