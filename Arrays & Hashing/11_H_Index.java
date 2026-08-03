// Problem: Special Array With X Elements Greater Than or Equal X
// Given an array nums, find a number x such that exactly x elements
// in nums are greater than or equal to x.
// If such x exists, return it. Otherwise, return -1.
// It is guaranteed that if x exists, it is unique.

// Brute Force Approach:
// - Try every possible x from 0 to n.
// - For each x, count how many numbers are >= x.
// - If count == x, return x.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Sorting):
// - Sort the array.
// - For each index i, compute x = n - i.
// - Check if nums[i] >= x AND nums[i-1] < x (boundary check).
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Optimal Approach (Counting Sort / Frequency):
// - Build a frequency array for values 0..1000.
// - Build suffix counts: count_ge[x] = numbers >= x.
// - Check if count_ge[x] == x.
// - Time Complexity: O(n + max(nums))
// - Space Complexity: O(max(nums))

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int count = 0;

            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }

            if (count == x) {
                return x;
            }
        }
        return -1;
    }

    // Better (Sorting)
    public int better(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = n - i; // numbers from i to end

            if (nums[i] >= x) {
                // boundary check: previous element must be < x
                if (i == 0 || nums[i - 1] < x) {
                    return x;
                }
            }
        }
        return -1;
    }

    // Optimal (Counting Sort / Frequency)
    public int optimal(int[] nums) {
        int n = nums.length;

        // max value in nums (constraint says <= 1000)
        int maxVal = 1000;
        int[] freq = new int[maxVal + 1];

        // frequency count
        for (int num : nums) {
            freq[num]++;
        }

        // suffix count: count_ge[x] = how many numbers >= x
        int[] count_ge = new int[maxVal + 2];
        for (int x = maxVal; x >= 0; x--) {
            count_ge[x] = freq[x] + count_ge[x + 1];
        }

        // x can only be 0..n
        for (int x = 0; x <= n; x++) {
            if (count_ge[x] == x) {
                return x;
            }
        }

        return -1;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {3, 5};
        int[] arr2 = {0, 0};
        int[] arr3 = {0, 4, 3, 0, 4};
        int[] arr4 = {4, 4, 4, 4, 4, 4, 4};

        System.out.println("Brute: " + sol.brute(arr1));
        System.out.println("Better: " + sol.better(arr1));
        System.out.println("Optimal: " + sol.optimal(arr1));

        System.out.println("Brute: " + sol.brute(arr2));
        System.out.println("Better: " + sol.better(arr2));
        System.out.println("Optimal: " + sol.optimal(arr2));

        System.out.println("Brute: " + sol.brute(arr3));
        System.out.println("Better: " + sol.better(arr3));
        System.out.println("Optimal: " + sol.optimal(arr3));

        System.out.println("Brute: " + sol.brute(arr4));
        System.out.println("Better: " + sol.better(arr4));
        System.out.println("Optimal: " + sol.optimal(arr4));
    }
}
