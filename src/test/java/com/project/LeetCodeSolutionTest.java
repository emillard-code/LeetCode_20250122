package com.project;

import com.project.solution.LeetCodeSolution;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LeetCodeSolutionTest {

    @Test
    public void mapOfHighestPeakTest() {

        int[][] isWater1 = new int[][]{{0,1},{0,0}};
        int[][] height1 = new int[][]{{1,0},{2,1}};
        assertArrayEquals(height1, LeetCodeSolution.highestPeak(isWater1));

        int[][] isWater2 = new int[][]{{0,0,1},{1,0,0},{0,0,0}};
        int[][] height2 = new int[][]{{1,1,0},{0,1,1},{1,2,2}};
        assertArrayEquals(height2, LeetCodeSolution.highestPeak(isWater2));

    }

}
