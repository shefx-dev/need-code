// Problem: Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice.

// Brute Force Approach:
// - Compare each pair of elements.
// - Time Complexity: O(n^2).
// - Space Complexity: O(1).

// Better Approach (Sorting):
// - Sort array, check adjacent elements.
// - Time Complexity: O(n log n).
// - Space Complexity: O(1).

// Optimal Approach (HashSet):
// - Use a set to track seen elements.
// - Time Complexity: O(n).
// - Space Complexity: O(n).

import java.util.*;

class Solution {
    public boolean brute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public boolean better(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    public boolean optimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,1};
        System.out.println(sol.optimal(arr)); // true
    }
}
