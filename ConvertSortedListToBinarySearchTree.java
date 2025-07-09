
/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * Example 1:
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 *
 * Example 2:
 * Input: head = []
 * Output: []

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
public class ConvertSortedListToBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
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
    
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);
        return buildBST(0, size - 1);
    }
    
    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
    
    private TreeNode buildBST(int left, int right) {
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        
        TreeNode leftChild = buildBST(left, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode rightChild = buildBST(mid + 1, right);
        
        root.left = leftChild;
        root.right = rightChild;
        
        return root;
    }
} 