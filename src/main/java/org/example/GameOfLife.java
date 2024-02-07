package org.example;
import java.util.Scanner;

public class GameOfLife {

    public static void main(String[] args) throws Exception {


        UserInput userInput = new UserInput();
        Board board = userInput.getInput();
        board.initializeBoard();
        board.displayBoard();
        try{
            while (true ) {
                int n = userInput.getUserChoice();
                if (n == 1) {
                    board = board.nextGenerationBoard();
                    board.displayBoard();
                    System.out.println("===========================");
                }
                if (n == 2) {
                    break;
                }
                if (n != 1 && n != 2) {
                    System.out.println("Please enter valid option");
                    System.exit(0);
                }
            }
            System.out.println("Thank you for playing the game");
        }catch (GenerationNotPossible exception){
            System.out.println(exception.getMessage());
        }

    }

}
