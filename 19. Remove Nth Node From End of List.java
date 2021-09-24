/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) return null;
        
        ListNode newHead = new ListNode(0);
        
        ListNode slow = newHead, fast = newHead;
        newHead.next = head;
        
        // now we move fastNode (n times ahead of slow)
        for(int i=1; i <= n+1; i++)
            fast = fast.next;
        
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return newHead.next;      
    }
}

/*
Here, we'll be moving fast n+1 spaces and then loop slow & fast one step at a time until fast reaches null, so that when fast reaches null, our slow pointer will be 
at n-1. So we'll simply have to remove reference of slow.next to remove n node.
slow.next will become slow.next.next;

And finally, we will return our newHead.next;
*/
