// Problem: Score of a String
// Given a string s, the score is the sum of absolute differences between ASCII values of adjacent characters.

// Brute Force Approach:
// - Loop through string, compute abs difference for each adjacent pair.
// - Time Complexity: O(n).
// - Space Complexity: O(1).

// Optimal Approach:
// - Same as brute, since O(n) is best possible.

class Solution {
    public int score(String s) {
        int total = 0;
        for (int i = 0; i < s.length()-1; i++) {
            total += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.score("hello")); // Example
    }
}
