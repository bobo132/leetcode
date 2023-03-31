package com.bobo.leetcode.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

@Slf4j
public class Page2 {



    @Test
    public void quest_62() {

        int m = 59;
        int n = 5;
//        int target = uniquePaths(m, n);
//        int target = uniquePaths_2(m, n);
        int target = uniquePaths_3(m, n);
//        int target = uniquePaths_4(m, n);
        log.info("不同路径: \nm={}, \nn={}, \nt:{}", m, n, target);

    }



    @Test
    public void quest_67() {
        String a = "11";
        String b = "1";
        String target = addBinary_3(a, b);
        log.info("二进制求和:  \na={}, \nb={}, \nt={}", a, b, target);
    }



    @Test
    public void quest_70() {
        int n = 10;
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




    /*
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {

        // 机器人一定会走 m+n-2 步, 即从 m+n-2 中挑出 m-1 步向下走不就行了吗,  即 C( (m+n-2), (m-1) )
        // 3 * 7  =>  C(8,2) = A8^2 / A2^2 = 8*7 / 2*1 = 28

        int a = m + n - 2;
        int b = m - 1;

        long target = 1;

        for (int i = 0; i < b; i++) {
            target *= a - i;
            target /= i + 1;
        }

        return (int) target;
    }


    public int uniquePaths_4(int m, int n) {

        long ans = 1;
        n--;
        m--;

        for (int i = m + n, j = 1; i > 0; i--, j++) {
            ans *= i;
            ans /= j;
        }

        return (int) ans;
    }



    // 动态规划
    public int uniquePaths_2(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }


    // 动态规划
    public int uniquePaths_3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
