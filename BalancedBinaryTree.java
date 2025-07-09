
/**
 * 110. Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false

 *
 * SOLUTION APPROACH:
 * - Use tree traversal techniques (DFS/BFS)
 * - Consider recursive or iterative approaches
 * - Handle edge cases like null nodes or single nodes
 * - Use appropriate data structures for level-order traversal
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) where n is number of nodes
 * SPACE COMPLEXITY: Varies based on approach - typically O(h) to O(n) where h is height
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive DFS: O(n) time, O(h) space - Use recursion
 * 2. Iterative DFS: O(n) time, O(h) space - Use stack
 * 3. BFS: O(n) time, O(w) space - Use queue for level-order
 *
 * KEY INSIGHTS:
 * - Choose traversal order based on problem requirements
 * - Consider space complexity of recursion vs iteration
 * - Handle null nodes and edge cases carefully
 */
public class BalancedBinaryTree {
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
    
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
} 