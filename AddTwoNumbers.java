
/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * SOLUTION APPROACH:
 * - Simulate manual addition process digit by digit
 * - Use a dummy head to simplify the linked list construction
 * - Maintain a carry variable for overflow
 * - Process both lists simultaneously, handling different lengths
 * - Create new nodes for the result as we go
 *
 * TIME COMPLEXITY: O(max(M, N)) where M and N are the lengths of the input lists
 * SPACE COMPLEXITY: O(max(M, N)) for the result list
 *
 * KEY INSIGHTS:
 * - Process digits from least significant to most significant (reverse order helps)
 * - Handle carry properly and create new nodes for result
 * - Don't forget to handle the final carry if it exists
 */
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            int sum = x + y + carry;
            carry = sum / 10;
            
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummyHead.next;
    }
} 