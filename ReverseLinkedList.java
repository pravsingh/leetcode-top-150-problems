
/**
 * 206. Reverse Linked List
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * SOLUTION APPROACH:
 * - Use three pointers: prev, current, and next
 * - Initialize prev as null, current as head
 * - For each node, save next pointer, reverse current's next to prev
 * - Move prev to current, current to next
 * - Continue until current becomes null
 * - Return prev as the new head
 *
 * TIME COMPLEXITY: O(n) - Single pass through the linked list
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(n) time, O(n) space - Use recursion with stack
 * 2. Stack: O(n) time, O(n) space - Push all nodes, pop to reverse
 * 3. Convert to array: O(n) time, O(n) space - Convert, reverse, convert back
 *
 * KEY INSIGHTS:
 * - Three-pointer technique is most efficient
 * - Save next pointer before changing current's next
 * - Handle edge cases: empty list, single node
 * - Recursive approach uses more space but is more elegant
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
} 