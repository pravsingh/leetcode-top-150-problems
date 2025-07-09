
import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 *
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]

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
public class BinaryTreeLevelOrderTraversalII {
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                currentLevel.add(current.val);
                
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            result.add(0, currentLevel);
        }
        
        return result;
    }
} 