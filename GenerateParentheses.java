
import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * SOLUTION APPROACH:
 * - Use backtracking/recursion to generate all valid combinations
 * - Keep track of open and close parentheses count
 * - Add '(' if open < n (can still add opening brackets)
 * - Add ')' if close < open (can close more than we've opened)
 * - Build the string character by character
 * - Add to result when string length equals 2*n
 *
 * TIME COMPLEXITY: O(4^n/√n) - Catalan number complexity
 * SPACE COMPLEXITY: O(4^n/√n) - Space for all valid combinations
 *
 * ALTERNATIVE APPROACHES:
 * 1. Iterative: O(4^n/√n) - Use stack to simulate recursion
 * 2. Dynamic Programming: O(n²) - Build from smaller subproblems
 * 3. Brute Force: O(2^(2n)) - Generate all strings and filter valid ones
 *
 * KEY INSIGHTS:
 * - Backtracking is natural for generating all combinations
 * - Key constraint: close <= open at any point
 * - Catalan numbers give the count of valid parentheses
 * - Each valid string must have equal number of '(' and ')'
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
} 