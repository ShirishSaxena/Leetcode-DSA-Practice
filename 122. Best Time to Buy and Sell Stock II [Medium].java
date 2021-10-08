class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, i=0, len = prices.length - 1;
        
        while(i < len){
            // find the first smallest
            while(i < len && prices[i+1] <= prices[i]) i++;
            int buy = prices[i];
            
            // find first max
            while(i < len && prices[i+1] > prices[i]) i++;
            int sell = prices[i];
            
            maxProfit += sell - buy;
        }

        return maxProfit;
    }
    
    /*
    // Simple Approach although bit tricky to get to? 
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        for(int i=1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i-1];
        }       
        
        return maxProfit;
    }
    
    */
}
