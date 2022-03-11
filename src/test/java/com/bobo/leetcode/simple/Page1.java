package com.bobo.leetcode.simple;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Page1 {

    @Test
    public void quest_7() {
        int x = 1410110141;
        boolean b = isPalindrome_2(x);
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
        }
        return y == x;
    }


}
