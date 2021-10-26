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

/*
Somewhat dirty code but works and is 100% faster than all other submissions... takes (65% less memory, though I'd take that with a grain of salt.)

So like approach here is, we know how to reverse a linkedlist. But have to implement this so we can reverse only a part of it.
This can be broke down to 3 smaller problems.

First, where we simply link non-reverse nodes
Second, get all nodes which needs to be reverse and reverse them
Third, iterate over modified linkedlist so far and at the end link head to it.

Time O(N) | Space O(1)
*/



class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        // PART 1
        // new node contains first part only
        ListNode newNode = new ListNode(-1);
        ListNode currF = newNode;
        for(int i=0; i < left-1; i++){
            currF.next = head;
            
            head = head.next;
            currF = currF.next;
            currF.next = null;
        }
        // ENDS
        
        // PART 2 - A
        // Find only part that needs to be reverse
        ListNode reverse = new ListNode(-1);
        ListNode currR = reverse;
        for(int i = 0; i <= (right-left); i++){
            currR.next = head;
            
            head = head.next;
            currR = currR.next;
            currR.next = null;
        }
        
        // ENDS
        // PART 2 - B (Reverse)
        ListNode prev = null;
        reverse = reverse.next;
        
        while(reverse != null){
            ListNode next = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = next;
        }
        currF.next = prev;
        // ENDS
        
        // PART 3 (Iteration and linking)
        // Iterate over modified list and at the end link head to it.
        while(currF.next != null)
            currF = currF.next;
        currF.next = head;
        
        return newNode.next;
    }
}
