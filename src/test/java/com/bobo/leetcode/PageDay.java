package com.bobo.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class PageDay {


    @Test
    public void quest_1877() {
        int[] arr = new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        System.out.println("minPairSum: " + minPairSum(arr));
    }


    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int[] arr = new int[len / 2];
        int max = 0;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i] + nums[len - i - 1];
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    
    
    
    
    
    @Test
    public void offer_52() {
        
    }


    
    
}
