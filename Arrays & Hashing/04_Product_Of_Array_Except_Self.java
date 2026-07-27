// Problem: Product of Array Except Self
// Given an integer array nums, return an array output where output[i] is the product
// of all the elements of nums except nums[i].
// Constraint: Must solve in O(n) time without using division.

// Brute Force Approach:
// - For each index i, loop through the array and multiply all elements except nums[i].
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (with division):
// - Compute total product of all elements.
// - For each index i, output[i] = totalProduct / nums[i].
// - Handle zeros carefully (if more than one zero, all outputs are zero).
// - Time Complexity: O(n)
// - Space Complexity: O(1)
// - Not valid for the follow-up (division not allowed).

// Optimal Approach (Prefix + Suffix):
// - Compute prefix products (product of all elements before i).
// - Compute suffix products (product of all elements after i).
// - For each index i, output[i] = prefix[i] * suffix[i].
// - Time Complexity: O(n)
// - Space Complexity: O(1) extra (excluding output array).

import java.util.*;

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    // Better (with division)
    public int[] better(int[] nums) {
        int n = nums.length;
        int totalProduct = 1;
        int zeroCount = 0;
        
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else totalProduct *= num;
        }
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (zeroCount > 1) {
                result[i] = 0;
            } else if (zeroCount == 1) {
                result[i] = (nums[i] == 0) ? totalProduct : 0;
            } else {
                result[i] = totalProduct / nums[i];
            }
        }
        return result;
    }

    // Optimal (Prefix + Suffix)
    public int[] optimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Prefix pass
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        
        // Suffix pass
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        
        return result;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,2,4,6};
        int[] arr2 = {-1,0,1,2,3};

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr1)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr1)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr1)));

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr2)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr2)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr2)));
    }
}
