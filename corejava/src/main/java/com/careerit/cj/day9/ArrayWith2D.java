package com.careerit.cj.day9;

public class ArrayWith2D {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {2, 3, 4},
                {4, 6, 6}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
