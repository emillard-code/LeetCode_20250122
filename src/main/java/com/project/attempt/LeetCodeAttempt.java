package com.project.attempt;

import java.util.Arrays;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] isWater1 = new int[][]{{0,1},{0,0}};
        System.out.println(Arrays.deepToString(mapOfHighestPeak(isWater1)));

        int[][] isWater2 = new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(mapOfHighestPeak(isWater2)));

    }

    public static int[][] mapOfHighestPeak(int[][] isWater) {

        int[][] height = new int[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {

            for (int j = 0; j < isWater[i].length; j++) {

                height[i][j] = -1;

                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                }

            }

        }

        int maxHeight = 0;

        while (!isFilled(height)) {

            updateMap(height, maxHeight);
            maxHeight++;

        }

        return height;

    }

    private static int[][] updateMap(int[][] height, int update) {

        for (int i = 0; i < height.length; i++) {

            for (int j = 0; j < height[i].length; j++) {

                if (height[i][j] == update) {

                    if (i > 0 && height[i-1][j] == -1) { height[i-1][j] = update + 1; }
                    if (i < height.length - 1 && height[i+1][j] == -1) { height[i+1][j] = update + 1; }
                    if (j > 0 && height[i][j-1] == -1) { height[i][j-1] = update + 1; }
                    if (j < height[i].length - 1 && height[i][j+1] == -1) { height[i][j+1] = update + 1; }

                }

            }

        }

        return height;

    }

    private static boolean isFilled(int[][] height) {

        for (int i = 0; i < height.length; i++) {

            for (int j = 0; j < height[i].length; j++) {

                if (height[i][j] == -1) { return false; }

            }

        }

        return true;

    }

}
