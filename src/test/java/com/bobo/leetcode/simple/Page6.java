package com.bobo.leetcode.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Page6 {

    
    
    @Test
    public void quest283() {
        int[] arr = new int[]{3, 1, 12, 0, 26, 2, 0, 67};
        // moveZeroes(arr);
        System.out.println("moveZeroes    arr: " + Arrays.toString(arr));
        
        // moveZeroes_1(arr);
        System.out.println("moveZeroes_1  arr: " + Arrays.toString(arr));
        
        // moveZeroes_2(arr);
        System.out.println("moveZeroes_2  arr: " + Arrays.toString(arr));

        arr = new int[]{0, 0, 0, 2, 5, 0, 0, 0, 0, 1};
        moveZeroes_2(arr);
        System.out.println("moveZeroes_2  arr: " + Arrays.toString(arr));
        
        
        
    }
    

    public void moveZeroes(int[] nums) {
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // 执行用时: 1 ms, 在所有 Java 提交中击败了 100%的用户
    // 内存消耗: 42.7 MB, 在所有 Java 提交中击败了 24.22%的用户
    public void moveZeroes_1(int[] nums) {
        // 通过中间数组实现赋值
        int[] temp = new int[nums.length];
        int j = 0;      // 非零值索引
        int k = 0;      // 0值个数
        for (int num : nums) {
            if (num != 0) {
                temp[j++] = num;
            } else {
                temp[temp.length - 1 - k] = 0;
            }
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
    
    
    // 执行用时: 53 ms, 在所有 Java 提交中击败了6.67%的用户
    // 内存消耗: 42.4 MB, 在所有 Java 提交中击败了41.62%的用户
    public void moveZeroes_2(int[] nums) {
        // 递归        
        int zeroCount = 0;
        for (int i = 0; i < nums.length - zeroCount; i++) {
            if (nums[i] == 0) {
                front(nums, i, nums.length - zeroCount);
                zeroCount++;
            }
            if (nums[i] == 0) {
                i--;
            }
        }
    }


    private void front(int[] nums, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[end - 1] = 0;
    }
    
    
    @Test
    public void f1() {
        int[] nums = new int[]{3, 1, 12, 0, 26, 2, 0, 67};
        front(nums, 3, nums.length);
        front(nums, 5, nums.length - 1);
        System.out.println("nums: " + Arrays.toString(nums));
    }
}
