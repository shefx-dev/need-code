// Problem: Sort an Array
// Given an integer array nums, sort the array in ascending order and return it.
// Constraint: Must solve in O(n log n) time without built-in sort functions,
// and with smallest space complexity possible.

// Brute Force Approach:
// - Use simple sorting like Bubble Sort or Selection Sort.
// - Compare and swap elements repeatedly until sorted.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Use Merge Sort (divide and conquer).
// - Recursively split array into halves, sort each half, then merge.
// - Time Complexity: O(n log n)
// - Space Complexity: O(n) (due to temporary arrays)

// Optimal Approach:
// - Use Heap Sort or In-place Quick Sort.
// - Heap Sort builds a max-heap and extracts elements one by one.
// - Quick Sort partitions array in place.
// - Time Complexity: O(n log n) average
// - Space Complexity: O(1) for Heap Sort, O(log n) for Quick Sort recursion.

import java.util.*;

class Solution {

    // Brute Force: Bubble Sort
    public int[] brute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    // Better: Merge Sort
    public int[] better(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        for (int p = 0; p < temp.length; p++) nums[left + p] = temp[p];
    }

    // Optimal: Heap Sort
    public int[] optimal(int[] nums) {
        int n = nums.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
        return nums;
    }

    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2 * i + 1, right = 2 * i + 2;

        if (left < n && nums[left] > nums[largest]) largest = left;
        if (right < n && nums[right] > nums[largest]) largest = right;

        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums, n, largest);
        }
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {10,9,1,1,1,2,3,1};
        int[] arr2 = {5,10,2,1,3};

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr1.clone())));
        System.out.println("Better: " + Arrays.toString(sol.better(arr1.clone())));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr1.clone())));

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr2.clone())));
        System.out.println("Better: " + Arrays.toString(sol.better(arr2.clone())));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr2.clone())));
    }
}
