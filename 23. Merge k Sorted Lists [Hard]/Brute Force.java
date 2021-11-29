/*
  My smol brain can only think of brute force for now... :/
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> tempList = new ArrayList();
        
        for(ListNode n : lists){
            while(n != null){
                tempList.add(n.val);
                n = n.next;
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        
        Collections.sort(tempList);
        for(int num : tempList){
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        
        return head.next;
    }
}
