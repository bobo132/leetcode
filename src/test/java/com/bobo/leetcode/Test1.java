package com.bobo.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 代码练习
 */
public class Test1 {

    @Test
    public void quest_1() {
        int res = lengthOfLongestSubstring("pwwkew");
        System.out.println(res);
    }

    @Test
    public void quest_2() {
        boolean res = isPalindrome(123454321);
        System.out.println(res);
    }

    @Test
    public void quest_3() {
        int res = hammingWeight(-3);
        System.out.println(res);
    }

    @Test
    public void quest_4() {
        int res = uniquePaths(3, 7);
        System.out.println(res);
    }

    @Test
    public void quest_5() {
        int res = romanToInt("XXVII");
        System.out.println(res);
    }

    @Test
    public void quest_6() {
        int[] arr1 = twoSum(new int[]{2, 7, 11, 15}, 26);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void quest_7() {
        String res = addBinary("1010", "1011");
        System.out.println(res);
        
        String res2 = addBinary_2("1010", "1011");
        System.out.println(res2);
    }

    @Test
    public void quest_8() {
        int res = climbStairs(10);
        System.out.println(res);
    }


    @Test
    public void quest_9() {
        String convert = convert("0123456789", 4);
        System.out.println(convert);
    }
    
    
    @Test
    public void quest_10() {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    
    
    
    
    
    
    
    // 第1题 无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);
        }

        return max;
    }

    
    // 第2题 回文数 
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int temp = x;
        int y = 0;
        
        while (temp != 0) {
            y = y * 10 + temp % 10;
            temp = temp / 10;
        }

        return y == x;
    }
    
    
    // 第3题 计算汉明重量 
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
    
    
    

    // 第4题 不同路径 
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
    
    
    
    
    
    // 第6题 罗马数字转整 
    public int romanToInt(String s) {
        int target = 0;
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int v1 = getValue(chars[i]);
            if (i + 1 < chars.length) {
                int v2 = getValue(chars[i + 1]);
                if (v2 > v1) {
                    target += (v2 - v1);
                    i++;
                    continue;
                }
            }
            target += v1;
        }
        return target;
    }
    
    
    private int getValue(char c) {
        int val = 0;
        switch (c) {
            case 'I': val = 1; break;
            case 'V': val = 5; break;
            case 'X': val = 10; break;
            case 'L': val = 50; break;
            case 'C': val = 100; break;
            case 'D': val = 500; break;
            case 'M': val = 1000; break;
        }
        
        return val;
    }
    
    
    
    
    
    
    // 第6题 两数之和 
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(target - val)) {
                return new int[] {map.get(target - val), i};
            }
            map.put(val, i);
        }
        return new int[]{0, 0};
    }


    // 第7题 二进制求和
    public String addBinary(String a, String b) {
        return new java.math.BigInteger(a, 2).add(new java.math.BigInteger(b, 2)).toString(2);
    }
    
    public String addBinary_2(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());
        int temp = 0;

        for (int i = 1; i <= maxLen; i++) {
            int c1 = a.length() >= i ? (a.charAt(a.length() - i) == '1' ? 1 : 0) : 0;
            int c2 = b.length() >= i ? (b.charAt(b.length() - i) == '1' ? 1 : 0) : 0;

            int sum = c1 + c2 + temp;
            if (sum >= 2) {
                sb.append(sum - 2);
                temp = 1;
            } else {
                sb.append(sum);
                temp = 0;
            }
        }

        if (temp == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
    


    // 第8题  爬楼梯
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;    
        }
        if (n == 2) {
            return 2;
        }

        int a = 1, b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }

        return b;
    }
    
    
    
    // 第9题  Z 字形变换
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += 2 * (numRows - 1)) {
                sb.append(s.charAt(j));
                if (i > 0 && i < numRows - 1) {
                    int res = j + 2 * (numRows - i - 1);
                    if (res < n) {
                        sb.append(s.charAt(res));
                    }
                }
            }
        }

        return sb.toString();
    }
    
    
    
    
    
    
    

    // 第10题  括号生成
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        return list;
    }
    
    private void dfs(List<String> list, String curStr, int left, int right) {

        if (left == 0 && right == 0) {
            list.add(curStr);
            return;
        }

        if (left > 0) {
            dfs(list, curStr + "(", left - 1, right);
        }
        
        if (right > left) {
            dfs(list, curStr + ")", left, right - 1);
        }
        
    }
    
    
    
    
    
}
