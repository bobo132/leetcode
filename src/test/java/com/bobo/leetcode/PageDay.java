package com.bobo.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class PageDay {


    @Test
    public void quest_1877() {
        int[] arr = new int[]{4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        System.out.println("minPairSum: " + minPairSum(arr));
    }

    @Test
    public void quest_1893() {

        int[][] ranges = new int[][] {{1, 10}, {10, 20}};
        boolean covered = isCovered(ranges, 20, 21);
        System.out.println("covered: " + covered);
    }
    
    @Test
    public void quest_551() {
        String s = "PPALLL";
        System.out.println("checkRecord(" + s + ") = " + checkRecord(s));
    }




    // 条件: A出现少于2次 & 没有3个及以上连续L
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) {
            return false;
        }
        int idx1 = s.indexOf('A');
        int idx2 = s.lastIndexOf('A');
        if (idx1 >= 0 && idx2 >= 0 && idx1 != idx2) {
            return false;
        }
        return true;
    }
    
    public boolean checkRecord_2(String s) {
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }
    
    
    

    
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flag = false;
            for (int[] range : ranges) {
                for (int b = 0; b < range.length; b++) {
                    if (range[0] <= i && i <= range[1]) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
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
