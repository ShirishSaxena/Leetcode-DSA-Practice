class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {        
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> curr = new ArrayDeque();
        
        for(int i=0; i < nums.length; i++){
            // check if our dequeue first element is out of bound
            while(curr.size() > 0 && curr.peekFirst() <= i - k)
                curr.pollFirst();
            
            // now check if currElements in queue are smaller than currElement is so, keep removing
            while(curr.size() > 0 && nums[curr.peekLast()] < nums[i])
                curr.pollLast();
                       
            // offer/offerLast ~ does the same thing because deQueue inherits queue 
            curr.offer(i);
            
            // now simply get the first element in queue that would be the max in queue
            if(i >= k - 1)
                result[i - k + 1] = nums[curr.peekFirst()];
            
        }
        return result;
    }
}

/*
Optimum approach where we use deque, and 2 while loop inside for loop.

By simply changing 
    while(curr.size() > 0 && nums[curr.peekLast()] < nums[i]) -> while(curr.size() > 0 && nums[curr.peekLast()] > nums[i])
 
 We can make this a Sliding window minimum question.

*/
