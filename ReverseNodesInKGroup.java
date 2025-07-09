
/**
 * 25. Reverse Nodes in k-Group
 *
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]

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
public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count % k == 0) {
                prev = reverse(prev, current.next);
                current = prev.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode current = last.next;
        while (current != next) {
            last.next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = last.next;
        }
        return last;
    }
} 