package com.bobo.leetcode.simple;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

@Slf4j
public class Page1 {

    
    @Test
    public void quest_1() {
        String str = "pwwkew";
        System.out.println("[两数之和]\n" + str + ":\n" + lengthOfLongestSubstring(str));
    }
    
    
    
    @Test
    public void quest_3() {
        String str = "pwwkew";
        System.out.println("[无重复字符的最长子串]\n" + str + ":\n" + lengthOfLongestSubstring(str));
    }


    @Test
    public void quest_9() {
        int x = 1410110141;
        boolean b = isPalindrome_x1(x);
        System.out.println("[回文数]\n" + x + ": " + b);
    }

    @Test
    public void quest_13() {
        String str = "MCMXCIV";
        System.out.println("[罗马数字转整数]\n" + str + ": " + romanToInt_2(str));
    }

    @Test
    public void quest_14() {
        String[] arr = new String[]{"f", "flower", "flow", "flight"};
        arr = new String[]{"flower", "flow", "flight"};
        arr = new String[]{"dog", "racecar", "car"};
        arr = new String[]{"ab", "a"};
        arr = new String[]{"a", "a", "b"};
        arr = new String[]{"caa", "", "a", "acb"};
        System.out.println("[编写一个函数来查找字符串数组中的最长公共前缀]\n" + Arrays.toString(arr) + ": " + longestCommonPrefix_x1(arr));
        
    }
    
    @Test
    public void quest_22() {
        
        int n = 3;
        List<String> list = generateParenthesis(n);
        log.info("[括号生成]  \nn={}, \nlist={}", n, list);
    }
    
    
    
    
    


    // 编写一个函数来查找字符串数组中的最长公共前缀
    public String longestCommonPrefix(String[] strs) {

        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }

        String prefix = "";
        for (int i = 1; i < length; i++) {
            String preStr = strs[i - 1];
            String thisStr = strs[i];

            if (preStr.isEmpty() || thisStr.isEmpty()) {
                strs[i - 1] = strs[i] = prefix;
                prefix = "";
                break;
            }

            for (int j = 0; j < preStr.length(); j++) {
                String s = preStr.substring(0, j + 1);
                if (preStr.startsWith(s) && thisStr.startsWith(s)) {
                    prefix = s;
                } else {
                    strs[i] = prefix;
                    if (i != length - 1) {
                        prefix = "";
                    }
                    break;
                }
                if (j == preStr.length() - 1 || j == thisStr.length() - 1) {
                    strs[i] = prefix;
                    if (i != length - 1) {
                        prefix = "";
                    }
                    break;
                }
            }
        }

        return prefix;
    }


    public String longestCommonPrefix_x1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];
        for (String ss : strs) {
            if (s.isEmpty()) {
                return "";
            }
            while (!ss.startsWith(s)) {
                // 公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }


    // 罗马数字转整数
    public int romanToInt(String s) {

        int target = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c1 = chars[i];
            if (i + 1 < chars.length && "IXC".indexOf(c1) >= 0) {
                String s2 = String.valueOf(c1) + chars[i + 1];
                int v2 = getValue2(s2);
                if (v2 > 0) {
                    target += v2;
                    i++;
                    continue;
                }
            }
            target += getValue1(c1);
        }
        return target;
    }


    public int romanToInt_2(String s) {

        int target = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int v1 = getValue1(chars[i]);
            if (i + 1 < chars.length) {
                int v2 = getValue1(chars[i + 1]);
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


    private int getValue1(char str) {
        int x = 0;
        switch (str) {
            case 'I':
                x = 1;
                break;
            case 'V':
                x = 5;
                break;
            case 'X':
                x = 10;
                break;
            case 'L':
                x = 50;
                break;
            case 'C':
                x = 100;
                break;
            case 'D':
                x = 500;
                break;
            case 'M':
                x = 1000;
                break;
        }
        return x;
    }

    private int getValue2(String str) {
        int x = 0;
        switch (str) {
            case "IV":
                x = 4;
                break;
            case "IX":
                x = 9;
                break;
            case "XL":
                x = 40;
                break;
            case "XC":
                x = 90;
                break;
            case "CD":
                x = 400;
                break;
            case "CM":
                x = 900;
                break;
        }
        return x;
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
            log.debug("x={},   y={}, temp={}", x, y, temp);
        }
        return y == x;
    }


    /*
     无重复字符的最长子串
        给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
        
        示例 1 :
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3 。
        示例 2 :
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1 。
        示例 3 :
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3 。
       
     */

    /**
     * 标签: 滑动窗口
     * 暴力解法的时间复杂度较高, 会达到 O(n^2), 故而采用滑动窗口的方法降低时间复杂度.
     * 
     * 步骤
     *  1. start不动，end向后移动
     *  2. 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     *  3. 怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的位置。
     * 时间复杂度 O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < length; end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                start = Math.max(map.get(element) + 1, start); //map.get()的地方进行+1操作
            }
            max = Math.max(max, end - start + 1);
            map.put(element, end);

            log.info("      element={}, start={}, end={}, ans={}, map={}", element, start, end, max, JSONUtil.toJsonStr(map));
        }
        return max;
    }




    /*
    两数之和
      
    
    
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




    // 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n, n, "");
        return list;
    }
    
    public void dfs(List<String> list, int left, int right, String curStr) {

        log.info("left={}, right={}", left, right);
        if (left == 0 && right == 0) {
            list.add(curStr);
            System.out.println();
            return;
        }

        if (left > 0) {
            dfs(list, left -1, right, curStr + "(");
        }

        if (right > left) {
            dfs(list, left, right - 1, curStr + ")");
        }
    }
    
    
    

}
