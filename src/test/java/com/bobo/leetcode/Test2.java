package com.bobo.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Test2 {


    @Test
    public void quest_1() {
        int res = lengthOfLongestSubstring("12312345123456789");
        System.out.println(res);
    }

    @Test
    public void quest_2() {
        boolean res = isPalindrome(1234321);
        System.out.println(res);
    }

    @Test
    public void quest_3() {
        int res = hammingWeight(-3);
        System.out.println(res);
    }

    @Test
    public void quest_4() {
        int res = uniquePaths(3, 8);
        System.out.println(res);
    }


    @Test
    public void quest_5() {
        int res = romanToInt("XXIVII");
        System.out.println(res);
    }

    @Test
    public void quest_6() {
        int[] res = twoSum(new int[]{2 , 7 , 11 , 15}, 18);
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void quest_7() {
        String res = addBinary("1101", "10101");        // 100010
        System.out.println(res);
    }

    @Test
    public void quest_8() {
        int res = climbStairs(10);
        System.out.println(res);
    }


    @Test
    public void quest_9() {
        String res = convert("A", 1);
        System.out.println(res);
    }

    @Test
    public void quest_10() {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }





    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start);
            }

            max = Math.max(end - start + 1, max);
            map.put(element, end);

            System.out.println("start = " + start + ", end = " + end + ", max = " + max);
        }

        return max;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int temp = x;
        int target = 0;

        while (temp != 0) {
            target = target * 10 + temp % 10;
            temp /= 10;
        }

        return target == x;
    }


    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if ( ((n >> i) & 1) == 1 ) {
                count++;
            }
        }
        return count;
    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(target - val)) {
                return new int[] {map.get(target - val), i};
            }
            map.put(val, i);
        }
        return new int[] {0, 0};
    }



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


    public int romanToInt(String s) {
        int target = 0;
        for(int i = 0; i < s.length(); i++) {
            int v1 = getValue(s.charAt(i));
            if (i + 1 < s.length()) {
                int v2 = getValue(s.charAt(i + 1));
                if (v2 > v1) {    // 如果后一个字符比前一个字符大, 取两者的差值即可
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
        switch(c) {
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




    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());
        int temp = 0;

        for (int i = 1; i <= maxLen; i++) {
            int x = a.length() >= i ? (a.charAt(a.length() - i) == '1' ? 1 : 0) : 0;
            int y = b.length() >= i ? (b.charAt(b.length() - i) == '1' ? 1 : 0) : 0;

            int sum = x + y + temp;
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




    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2, temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }


    public String convert(String s, int numRows) {

        // 切记一定要处理1的情况
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();

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



    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        return list;
    }

    public void dfs(List<String> list, String curStr, int left, int right) {
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
