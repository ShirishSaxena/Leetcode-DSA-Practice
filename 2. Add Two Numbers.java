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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode newHead = new ListNode(0);
        ListNode currNode = newHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
            ListNode tempNode = new ListNode(sum % 10);
            carry = sum / 10;
            currNode.next = tempNode;
            currNode = currNode.next;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        
        return newHead.next;
    }
}

/*

Generic approach that iterate over l1 and l2
using ternary operator in sum var keep adding l1.val + l2.val + sum.
creates new node with modulus of sum, link it to newHead.next, change carry as sum/10.

Then necessary conditions to keep the loop going forward.
*/
