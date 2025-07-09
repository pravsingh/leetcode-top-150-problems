
/**
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top. Each time you can either climb 1 or 2 steps.
 *
 * Example 1:
 * Input: n = 2
 * Output: 2
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 *
 * SOLUTION APPROACH:
 * - Use dynamic programming with Fibonacci sequence
 * - Base cases: dp[0] = 1, dp[1] = 1
 * - For each step i, dp[i] = dp[i-1] + dp[i-2]
 * - Can reach step i from step i-1 (1 step) or step i-2 (2 steps)
 * - Use rolling array to optimize space complexity
 * - Return dp[n] as the number of ways to reach the top
 *
 * TIME COMPLEXITY: O(n) - Single pass to build the sequence
 * SPACE COMPLEXITY: O(1) - Only need to store last two values
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(2^n) - Without memoization
 * 2. Matrix Exponentiation: O(log n) - Use matrix power for large n
 * 3. Binet's Formula: O(1) - Direct formula for Fibonacci numbers
 *
 * KEY INSIGHTS:
 * - This is essentially the Fibonacci sequence
 * - Can optimize space by using only two variables
 * - Recursive approach is exponential without memoization
 * - Matrix exponentiation is optimal for very large n
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev = 1, curr = 2;
        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        return curr;
    }
} 