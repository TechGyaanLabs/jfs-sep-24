package com.careerit.cj.day9;

import java.util.Arrays;

public class ArrayExample2D {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8}
        };
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(Arrays.toString(sumOfEachColumns(arr)));
        System.out.println(Arrays.toString(sumOfEachRows(arr)));
    }

    public static int[] sumOfEachColumns(int[][] arr) {
        int nuwRows = arr.length;
        int numCols = arr[0].length;
        int[] colsSum = new int[numCols];

        for (int col = 0; col < numCols; col++) {
            int sum = 0;
            for (int row = 0; row < nuwRows; row++) {
                sum += arr[row][col];
            }
            colsSum[col] = sum;
        }
        return colsSum;

    }

    public static int maxValue(int[][] arr) {
        int max = arr[0][0];
        for (int[] ar : arr) {
            for (int ele : ar) {
                if (max < ele) {
                    max = ele;
                }
            }
        }
        return max;
    }

    public static int[] sumOfEachRows(int[][] arr) {
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[] rowSum = new int[numRows];
        for (int row = 0; row < numRows; row++) {
            int sum = 0;
            for (int col = 0; col < numCols; col++) {
                sum += arr[row][col];
            }
            rowSum[row] = sum;
        }
        return rowSum;
    }
}
