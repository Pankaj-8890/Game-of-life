package org.example;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput(){
        scanner = new Scanner(System.in);
    }

    public Board getInput() throws InvalidArguments {
        System.out.println("Enter the dimension for row");
        int row = scanner.nextInt();

        System.out.println("Enter the dimension for column");
        int column = scanner.nextInt();

        System.out.println("Enter the seeding Percentage for live cells");
        int seedingLive = scanner.nextInt();

        return new Board(row,column,seedingLive);
    }

    public int getUserChoice(){
        System.out.println("Enter 1 to print nextLife");
        System.out.println("Enter 2 to exit");
        int choice = scanner.nextInt();
        return choice;
    }

}
