// Problem: Find Missing Elements
// You are given an integer array nums consisting of unique integers.
// Originally, nums contained every integer within a certain range.
// The smallest and largest integers of the original range are still present.
// Return a sorted list of all the missing integers in this range.

// Brute Force Approach:
// - Find smallest and largest values.
// - For each number in the range [min..max], check if it exists in nums using a loop.
// - Add missing numbers to the result list.
// - Time Complexity: O(n * r) where r = range size.
// - Space Complexity: O(1) (apart from output).

// Better Approach:
// - Sort the array.
// - Traverse consecutive pairs; if gap > 1, add the missing numbers between them.
// - Time Complexity: O(n log n + m), where m = missing count.
// - Space Complexity: O(1) (apart from output).

// Optimal Approach:
// - Find smallest and largest values in one pass.
// - Store all elements in a HashSet for O(1) lookup.
// - Traverse [min..max], add numbers not in the set.
// - Time Complexity: O(n + r).
// - Space Complexity: O(n).

import java.util.*;

class Solution {

    // Brute Force
    public List<Integer> brute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        // Find min and max
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Check each number in range
        for (int i = min; i <= max; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) result.add(i);
        }
        return result;
    }

    // Better
    public List<Integer> better(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            int curr = nums[i];
            for (int j = prev + 1; j < curr; j++) {
                result.add(j);
            }
        }
        return result;
    }

    // Optimal
    public List<Integer> optimal(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        
        // Build set and find min/max
        for (int num : nums) {
            set.add(num);
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        // Check missing numbers
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,4,2,5};
        int[] arr2 = {7,8,6,9};
        int[] arr3 = {5,1};

        System.out.println("Brute: " + sol.brute(arr1));
        System.out.println("Better: " + sol.better(arr1));
        System.out.println("Optimal: " + sol.optimal(arr1));

        System.out.println("Brute: " + sol.brute(arr2));
        System.out.println("Better: " + sol.better(arr2));
        System.out.println("Optimal: " + sol.optimal(arr2));

        System.out.println("Brute: " + sol.brute(arr3));
        System.out.println("Better: " + sol.better(arr3));
        System.out.println("Optimal: " + sol.optimal(arr3));
    }
}
