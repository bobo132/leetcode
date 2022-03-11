package com.bobo.leetcode.simple;

import org.junit.jupiter.api.Test;

public class Page3 {


    @Test
    public void quest122() {

        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println("maxProfit(prices) = " + maxProfit(prices));

    }


    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;  
    }


    public int maxProfit_2(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }

}
