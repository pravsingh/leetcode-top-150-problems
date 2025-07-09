
/**
 * 141. Linked List Cycle
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 *
 * SOLUTION APPROACH:
 * - Use Floyd's Cycle Detection Algorithm (fast and slow pointers)
 * - Initialize slow and fast pointers at head
 * - Move slow pointer by 1 step, fast pointer by 2 steps
 * - If there's a cycle, fast and slow will eventually meet
 * - If fast reaches null, there's no cycle
 * - This works because fast pointer will catch up to slow in cycle
 *
 * TIME COMPLEXITY: O(n) - Linear time in worst case
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. HashSet: O(n) time, O(n) space - Track visited nodes
 * 2. Marking: O(n) time, O(1) space - Mark visited nodes (destructive)
 * 3. Recursive: O(n) time, O(n) space - Use recursion with visited set
 *
 * KEY INSIGHTS:
 * - Floyd's algorithm is optimal for space complexity
 * - Fast pointer moves twice as fast as slow pointer
 * - If there's a cycle, they will meet within one cycle
 * - Can be extended to find the start of the cycle
 */
public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
} 