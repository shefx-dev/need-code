// Problem: Count Valid Prefixes
// Given a binary string s, return the number of prefixes that can be rearranged
// to form an alternating string (no two adjacent characters are equal).

// Brute Force Approach:
// - For each prefix, check if it can be rearranged into alternating string.
// - Rearrangement possible if |count0 - count1| <= 1.
// - Time Complexity: O(n^2) (checking each prefix separately).
// - Space Complexity: O(1).

// Better Approach (Prefix Counts):
// - Maintain running counts of 0s and 1s.
// - For each prefix, check difference of counts.
// - Time Complexity: O(n).
// - Space Complexity: O(1).

// Optimal Approach (Same as Better):
// - Since rearrangement condition only depends on counts, 
//   we can solve in one pass with O(n) time and O(1) space.

class Solution {
    // Brute Force
    public int brute(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int count0 = 0, count1 = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') count0++;
                else count1++;
            }
            if (Math.abs(count0 - count1) <= 1) result++;
        }
        return result;
    }

    // Better Approach
    public int better(String s) {
        int count0 = 0, count1 = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count0++;
            else count1++;
            if (Math.abs(count0 - count1) <= 1) result++;
        }
        return result;
    }

    // Optimal Approach (same as better)
    public int optimal(String s) {
        int count0 = 0, count1 = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
            if (Math.abs(count0 - count1) <= 1) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.brute("00101"));   // Output: 3
        System.out.println(sol.better("00101"));  // Output: 3
        System.out.println(sol.optimal("101"));   // Output: 3
    }
}
