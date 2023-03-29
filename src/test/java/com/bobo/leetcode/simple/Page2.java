package com.bobo.leetcode.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
public class Page2 {
    
    
    
    @Test
    public void quest_67() {
        String a = "11";
        String b = "1";
        String target = addBinary_3(a, b);
        log.info("二进制求和:  \na={}, \nb={}, \nt={}", a, b, target);
    }
    
    
    
    @Test
    public void quest_70() {
        int n = 30;
        int target = climbStairs(n);
        log.info("爬楼梯: 总共{}阶, 有{}种方法", n, target);
    }






    /*
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
        1 <= n <= 45
        
    第n个台阶只能从第 n-1 或 n-2个台阶上来, 到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法.
    已经知道了第1个和第2个台阶的走法, 一路加上去
        
     */
    public int climbStairs(int n) {

        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        
        int a = 1, b = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = a;
            a = b;
            b = temp + b;
        }
        return b;
    }



    /*
    67. 二进制求和
      给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     */
    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
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
                sb.insert(0, (sum - 2));
                temp = 1;
            } else {
                sb.insert(0, sum);
                temp = 0;
            }
        }

        if (temp == 1) {
            sb.insert(0, "1");
        }

        return sb.toString();
    }
    
    
    public String addBinary_3(String a, String b) {

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
    
    
    
    
}
