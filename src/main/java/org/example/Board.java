package org.example;
import java.util.Random;

import static java.lang.Math.floor;

public class Board {


    private int rowIndex;
    private int columnIndex;

    private int seedingLive;

    private int[][] board;
    public Board(int rowIndex, int columnIndex,int seedingLive){

        if (rowIndex <= 0 || columnIndex <= 0 || seedingLive < 0) {
            throw new IllegalArgumentException("values must be greater than 0");
        }

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.seedingLive = seedingLive;
    }


    public int[][] getBoard(){
        board = new int[rowIndex][columnIndex];
        Random random = new Random();

        double noOfseededLives = floor((rowIndex*columnIndex) * seedingLive * 0.01);
        int noOfseededLive = (int)noOfseededLives;
        if(noOfseededLive < 0)
        System.out.println(noOfseededLive);

        while (noOfseededLive > 0) {
            int i = random.nextInt(rowIndex);
            int j = random.nextInt(columnIndex);

            if (board[i][j] == 0) {
                board[i][j] = 1;
                noOfseededLive--;
            }
        }
        return board;
    }

}