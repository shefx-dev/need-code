// Problem: Word Pattern
// Given a pattern and a string s, determine if s follows the same pattern.
// Example: pattern = "abba", s = "dog cat cat dog" → true

// Brute Force Approach:
// - Try all mappings of characters to words.
// - Time Complexity: Exponential.
// - Space Complexity: High.

// Optimal Approach (HashMap):
// - Use two maps: char→word and word→char.
// - Ensure bijection (one-to-one mapping).
// - Time Complexity: O(n).
// - Space Complexity: O(n).

import java.util.*;

class Solution {
    public boolean optimal(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverse = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (map.containsKey(c) && !map.get(c).equals(w)) return false;
            if (reverse.containsKey(w) && reverse.get(w) != c) return false;

            map.put(c, w);
            reverse.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.optimal("abba", "dog cat cat dog")); // true
        System.out.println(sol.optimal("abba", "dog cat cat fish")); // false
    }
}
