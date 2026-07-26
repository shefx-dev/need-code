// Problem: Concatenation of Array
// Given an array nums of length n,
// create an array ans of length 2n where
// ans[i] = nums[i] and ans[i+n] = nums[i].
// Essentially, ans is nums concatenated with itself.

// Brute Force Approach:
// - Create a new array of size 2n.
// - First copy all elements of nums into ans.
// - Then copy all elements of nums again into ans starting at index n.
// - Time Complexity: O(n)
// - Space Complexity: O(2n)

// Better Approach:
// - Use a single loop instead of two.
// - For each index i, set ans[i] = nums[i] and ans[i+n] = nums[i].
// - Time Complexity: O(n)
// - Space Complexity: O(2n)

// Optimal Approach:
// - Same as Better (since O(n) is already optimal).
// - Just write concise code using modular arithmetic or direct assignment.
// - Time Complexity: O(n)
// - Space Complexity: O(2n)

import java.util.*;

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        // Copy first half
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }
        // Copy second half
        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[i];
        }
        return ans;
    }

    // Better
    public int[] better(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    // Optimal
    public int[] optimal(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }
        return ans;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,4,1,2};
        int[] arr2 = {22,21,20,1};

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr1)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr1)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr1)));

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr2)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr2)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr2)));
    }
}
