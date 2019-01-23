Question #141: Linked List Cycle
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}

/* Used a slow pointer which steps once while a fast pointer steps twice.
 * If the fast ever catches the slow, you know theres a cycle. 
 */
