class Solution {
    public int getDecimalValue(ListNode head) {
        
        int ans = 0;
        while(head != null){
            ans = (ans*2) + head.val;
            head = head.next;
        }
        return ans;
    }
}


// Another one without any maths???

class Solution {
    public int getDecimalValue(ListNode head) {
        List<Integer> r = new ArrayList();
        
        while(head != null){
            r.add(head.val);
            head = head.next;
        }
        
        int n = 1;
        int ans = 0;
        
        for(int i = r.size() - 1; i >= 0; i--){
            ans += (n * r.get(i));
            n *= 2;
        }
        
        return ans;
    }
}
