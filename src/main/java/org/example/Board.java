package org.example;
import java.util.Random;

import static java.lang.Math.floor;

public class Board {


    private int rowIndex;
    private int columnIndex;

    private int seedingLive;

    private int[][] board;
    public Board(int rowIndex, int columnIndex,int seedingLive){

        if (rowIndex <= 0 || columnIndex <= 0) {
            throw new IllegalArgumentException("Board dimension must be greater than 0");
        }

        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.seedingLive = seedingLive;
    }


    public int[][] getBoard(){
        board = new int[rowIndex][columnIndex];
        Random random = new Random();

        double noOfseededLives = floor((rowIndex*columnIndex) * seedingLive * 0.01);

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                int x = random.nextInt(2);
                if(x == 1 && noOfseededLives > 0) {
                    board[i][j] = 1;
                    noOfseededLives--;
                }
                else board[i][j] = 0;
            }
        }

        return board;
    }

}