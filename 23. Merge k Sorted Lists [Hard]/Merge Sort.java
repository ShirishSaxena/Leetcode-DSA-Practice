class Solution {
    
    // Merge Sort approach seems viable here?
    // Hmm... although, there's multiple solutions for this question.
    // This one in particular is way worse than even the brute force :3
    public ListNode mergeKLists(ListNode[] lists) {
        // base cases
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        
        // merge first 2 list
        ListNode head = new ListNode(Integer.MIN_VALUE);
        for(int i = 0; i < lists.length; i++){
            head = mergeList(head, lists[i]);
        }
        return head.next;
    }
    
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;  
        }
        // left overs
        curr.next = (l1 != null) ? l1 : l2;
        return head.next;
    }
}
