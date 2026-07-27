// Problem: Maximum Product Difference Between Two Pairs
// Given an integer array nums, choose four distinct indices w, x, y, z
// such that the product difference (nums[w] * nums[x]) - (nums[y] * nums[z]) is maximized.

// Brute Force Approach:
// - Try all possible pairs (a, b) and (c, d).
// - Compute product difference for each combination.
// - Keep track of the maximum.
// - Time Complexity: O(n^4) (checking all 4-element combinations).
// - Space Complexity: O(1).

// Better Approach:
// - Sort the array.
// - The maximum product difference will come from:
//   (largest two numbers) - (smallest two numbers).
// - Time Complexity: O(n log n) due to sorting.
// - Space Complexity: O(1).

// Optimal Approach:
// - Find the two largest and two smallest numbers in one pass.
// - Compute (max1 * max2) - (min1 * min2).
// - Time Complexity: O(n).
// - Space Complexity: O(1).

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        int maxDiff = Integer.MIN_VALUE;
        for (int w = 0; w < n; w++) {
            for (int x = w + 1; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int z = y + 1; z < n; z++) {
                        if (w != y && w != z && x != y && x != z) {
                            int diff = (nums[w] * nums[x]) - (nums[y] * nums[z]);
                            maxDiff = Math.max(maxDiff, diff);
                        }
                    }
                }
            }
        }
        return maxDiff;
    }

    // Better
    public int better(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n - 1], max2 = nums[n - 2];
        int min1 = nums[0], min2 = nums[1];
        return (max1 * max2) - (min1 * min2);
    }

    // Optimal
    public int optimal(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // Track max values
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }

            // Track min values
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return (max1 * max2) - (min1 * min2);
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {5,6,2,7,4};
        int[] arr2 = {4,2,5,9,7,4,8};

        System.out.println("Brute: " + sol.brute(arr1));
        System.out.println("Better: " + sol.better(arr1));
        System.out.println("Optimal: " + sol.optimal(arr1));

        System.out.println("Brute: " + sol.brute(arr2));
        System.out.println("Better: " + sol.better(arr2));
        System.out.println("Optimal: " + sol.optimal(arr2));
    }
}
