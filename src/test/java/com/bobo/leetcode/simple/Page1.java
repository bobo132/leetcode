package com.bobo.leetcode.simple;

import org.junit.jupiter.api.Test;

public class Page1 {

    @Test
    public void quest_7() {
        int x = 1410110141;
        boolean b = isPalindrome_2(x);
        System.out.println("[回文数]  " + x + ": " + b);
    }

    @Test
    public void quest_13() {
        String str = "";
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // 回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int size = String.valueOf(x).length();
        if (size == 1) {
            return true;
        }

        int[] arr1 = new int[size / 2];

        int div = 10;
        for (int i = 0; i < size / 2; i++) {
            int a = x % div;
            arr1[i] = a;
            x /= 10;
        }
        if (size % 2 == 1) {
            x /= 10;
        }

        int sum = 0;
        int mul = 1;

        for (int i = arr1.length; i > 0; i--) {
            sum += arr1[i - 1] * mul;
            mul *= 10;
        }
        return sum == x;
    }

    public boolean isPalindrome_2(int x) {
        if (x < 0) {
            return false;
        }

        int size = String.valueOf(x).length();
        if (size == 1) {
            return true;
        }

        int temp = x;
        int target = 0;

        for (int i = 0; i < size; i++) {
            int a = temp % 10;
            target = target * 10 + a;
            temp /= 10;
        }

        return target == x;
    }

    public boolean isPalindrome_3(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int temp = x;
        int target = 0;

        while (temp != 0) {
            target = target * 10 + temp % 10;
            temp /= 10;
        }

        return target == x;
    }

    // 回文数
    public boolean isPalindrome_x1(int x) {
        if (x < 0)
            return false;

        int temp = x;
        int y = 0;

        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp = temp / 10;
        }
        return y == x;
    }




}
