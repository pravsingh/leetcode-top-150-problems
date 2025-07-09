
/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * SOLUTION APPROACH:
 * - Use two pointers: fast and slow
 * - Move fast pointer n steps ahead of slow pointer
 * - Move both pointers until fast reaches the end
 * - Slow pointer will be at the node before the one to remove
 * - Use dummy head to handle edge case of removing first node
 * - Update slow.next to skip the nth node from end
 *
 * TIME COMPLEXITY: O(n) - Single pass through the linked list
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Two-pass: O(n) - First pass to count nodes, second to remove
 * 2. Stack: O(n) - Push all nodes, pop n times to find target
 * 3. Recursive: O(n) - Use recursion with counter
 *
 * KEY INSIGHTS:
 * - Two-pointer technique eliminates need for two passes
 * - Dummy head simplifies edge case handling
 * - Fast pointer creates the right gap for slow pointer
 * - Handle case where n equals list length (remove head)
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
} 