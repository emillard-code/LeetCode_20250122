package com.project.attempt;

import java.util.Arrays;

public class LeetCodeAttempt {

    public static void main(String[] args) {

        int[][] isWater1 = new int[][]{{0,1},{0,0}};
        System.out.println(Arrays.deepToString(mapOfHighestPeak(isWater1)));

        int[][] isWater2 = new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(mapOfHighestPeak(isWater2)));

    }

    // This method returns an array height[][] that contains the highest peaks
    // that can be obtained from isWater[][] as per challenge specifications.
    public static int[][] mapOfHighestPeak(int[][] isWater) {

        // We create the array height[][] with the same size as isWater[][].
        int[][] height = new int[isWater.length][isWater[0].length];

        // The first order of business is to initialize every index in height[][]
        // with some kind of null value. We'll use -1 as our null value for this
        // challenge. For the indexes in isWater[][] that are marked as having water,
        // we set their corresponding indexes in height[][] as 0 to indicate water cells.
        for (int i = 0; i < isWater.length; i++) {

            for (int j = 0; j < isWater[i].length; j++) {

                height[i][j] = -1;

                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                }

            }

        }

        // Now that we have filled the array with null values and the water cells,
        // we must begin to initialize all the null value indexes with their
        // appropriate height values. As per challenge specifications, we must also
        // be careful not to allow adjacent cells to have height differences greater
        // than 1. The way we achieve this is to initialize the height sequentially.
        // For example, we will initialize all cells meant to have a height of 1 at
        // the same time. Then we will initialize all cells meant to have a height of
        // 2 at the same time. And so forth. By slowly spreading out from each water
        // cell at the same time, we can be sure we won't make any mistakes because
        // we know the position of each water cell and all the cells that are growing
        // in height around it. Should a clash occur between these growing cells that
        // originated from different water cells, there should be little issue as both
        // have been growing equally and for the same 'distance', so by the time they
        // clash the difference between should automatically be 0 or 1. We simply
        // repeat this process until the entire height[][] array has been filled.
        int maxHeight = 0;

        while (!isFilled(height)) {

            updateMap(height, maxHeight);
            maxHeight++;

        }

        return height;

    }

    // A helper method to help us update the height[][] array. We will -only- update cells that
    // are meant to have the same value as int update plus one in each call of this method.
    private static int[][] updateMap(int[][] height, int update) {

        for (int i = 0; i < height.length; i++) {

            for (int j = 0; j < height[i].length; j++) {

                // In each index of the height[][] array that has a value equal to int update,
                // we will check if there exists a valid index to the 'north', 'south', 'west',
                // and 'east' of the current index. For each valid direction that exists, if
                // the index in that direction has a value of -1 (the null value), we update
                // it with +1 of int update. If there is a valid index in that direction and it
                // already has a value other than -1, it means we've already traversed it before
                // and we will -not- override its value.
                if (height[i][j] == update) {

                    if (i > 0 && height[i-1][j] == -1) { height[i-1][j] = update + 1; }
                    if (i < height.length - 1 && height[i+1][j] == -1) { height[i+1][j] = update + 1; }
                    if (j > 0 && height[i][j-1] == -1) { height[i][j-1] = update + 1; }
                    if (j < height[i].length - 1 && height[i][j+1] == -1) { height[i][j+1] = update + 1; }

                }

            }

        }

        // Once we've traversed the whole array and made updates to all appropriate cells,
        // we return the updated height[][] array.
        return height;

    }

    // A helper method to make sure the height[][] array is filled completely
    // with non-null values. If any -1 values are found, return false.
    private static boolean isFilled(int[][] height) {

        for (int i = 0; i < height.length; i++) {

            for (int j = 0; j < height[i].length; j++) {

                if (height[i][j] == -1) { return false; }

            }

        }

        return true;

    }

}
