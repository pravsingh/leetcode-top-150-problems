
/**
 * 129. Sum Root to Leaf Numbers
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 *
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026

 *
 * SOLUTION APPROACH:
 * - Use appropriate array manipulation technique
 * - Consider sorting, two pointers, or sliding window
 * - Handle edge cases and boundary conditions
 * - Optimize for time and space complexity
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) or higher - Check all combinations
 * 2. Sorting: O(n log n) - Sort first, then process
 * 3. Hash-based: O(n) - Use HashMap/HashSet for lookups
 *
 * KEY INSIGHTS:
 * - Choose the right data structure for the problem
 * - Consider trade-offs between time and space complexity
 * - Look for patterns that can be optimized
 */
public class SumRootToLeafNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode node, int currentSum) {
        if (node == null) return 0;
        
        currentSum = currentSum * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        return sumNumbersHelper(node.left, currentSum) + 
               sumNumbersHelper(node.right, currentSum);
    }
} 