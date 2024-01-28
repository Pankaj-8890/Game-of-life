package org.example;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.floor;

public class Board {


    private int row;
    private int column;

    private int seedingLive;

    private int[][] board;
    public Board(int row, int column,int seedingLive){

        if (row <= 0 || column <= 0 || seedingLive < 0) {
            throw new IllegalArgumentException("values must be greater than 0");
        }

        this.row = row;
        this.column = column;
        this.seedingLive = seedingLive;
        getBoard();
    }


    private void getBoard(){
        int[][] newBoard = new int[row][column];
        Random random = new Random();

        double noOfseededLives = floor((row*column) * seedingLive * 0.01);
        int noOfseededLive = (int)noOfseededLives;
        if(noOfseededLive < 0)
        System.out.println(noOfseededLive);

        while (noOfseededLive > 0) {
            int i = random.nextInt(row);
            int j = random.nextInt(column);

            if (newBoard[i][j] == 0) {
                newBoard[i][j] = 1;
                noOfseededLive--;
            }
        }
        this.board =  newBoard;
    }

    public boolean checkAllDead() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public String startGame() {

        int generation = 0;
        while (!checkAllDead()) {
            int[][] currentBoard = Arrays.copyOf(board, board.length);
            System.out.println("Generation " + (generation + 1) + ":");
            generation++;
            displayBoard();
            updateBoard();
            if (Arrays.deepEquals(currentBoard, board)) {
                return "Can't generate next generation";
            }
        }
        return "All cells are dead. The game has ended.";
    }

    private void updateBoard() {
        int[][] nextGeneration = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGeneration[i][j] = 0;
                    }else{
                        nextGeneration[i][j] = 1;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGeneration[i][j] = 1;
                    }
                }
            }
        }
        board = nextGeneration;
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < row && newY >= 0 && newY < column) {
                count += board[newX][newY];
            }
        }

        return count;
    }

    private void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(board[i][j] == 1 ? "1" : "0");
            }
            System.out.println();
        }
        System.out.println();
    }

}