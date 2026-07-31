// Problem: Largest Substring Between Two Equal Characters
// Given a string s, return the length of the longest substring between two equal characters.
// If no such substring exists, return -1.

// Brute Force Approach:
// - Check all pairs of equal characters and compute substring length.
// - Time Complexity: O(n^2).
// - Space Complexity: O(1).

// Optimal Approach (HashMap):
// - Store first occurrence of each character.
// - For each later occurrence, compute distance.
// - Time Complexity: O(n).
// - Space Complexity: O(26) ~ O(1).

import java.util.*;

class Solution {
    public int brute(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    max = Math.max(max, j - i - 1);
                }
            }
        }
        return max;
    }

    public int optimal(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex.containsKey(c)) {
                max = Math.max(max, i - firstIndex.get(c) - 1);
            } else {
                firstIndex.put(c, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.optimal("abca")); // 2
        System.out.println(sol.optimal("cbzxy")); // -1
    }
}
