// Problem: Pascal's Triangle
// Given an integer numRows, generate the first numRows of Pascal's triangle.
// Each number is the sum of the two numbers directly above it.

// Brute Force Approach:
// - Use recursion to compute binomial coefficients for each position.
// - Time Complexity: O(n^3) (due to repeated computations).
// - Space Complexity: O(1).

// Better Approach (DP Table):
// - Build triangle row by row using previous row values.
// - Time Complexity: O(n^2).
// - Space Complexity: O(n^2).

// Optimal Approach (Iterative):
// - Use iterative construction with only previous row reference.
// - Time Complexity: O(n^2).
// - Space Complexity: O(n^2).

import java.util.*;

class Solution {
    // Brute Force (recursive binomial coefficient)
    private int nCr(int n, int r) {
        if (r == 0 || r == n) return 1;
        return nCr(n-1, r-1) + nCr(n-1, r);
    }

    public List<List<Integer>> brute(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(nCr(i, j));
            }
            triangle.add(row);
        }
        return triangle;
    }

    // Optimal Iterative
    public List<List<Integer>> optimal(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            if (i > 0) row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.optimal(5));
    }
}
