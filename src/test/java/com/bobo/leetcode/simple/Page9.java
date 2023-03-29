package com.bobo.leetcode.simple;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Page9 {
    
    
    
    /*
    汉明距离
      两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
      给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     */
    @Test
    public void quest461() {

        int x = 1;
        int y = 4;
        int distance = hammingDistance(x, y);
        log.info("汉明距离  [{},{}]   => {}", x, y, distance);
        
        
        int num = -3;
        log.info("汉明重量  [{}]   => {}", num, hammingWeight(num));

    }












    // 461. 汉明距离  
    public static int hammingDistance(int x, int y) {

        String str1 = getBinaryStr(x);
        String str2 = getBinaryStr(y);

        int min = Math.min(str1.length(), str2.length());
        
        int count = 0;
        
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }

        String bigger = str1.length() == min ? str2 : str1;
        for (int i = min; i < bigger.length(); i++) {
            if (bigger.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    
    // 转成二进制
    public static String getBinaryStr(int x) {

        String str = "";
        
        while (x > 1) {
            int y = x % 2;
            str = str + y;
            x = x / 2;
        }
        
        if (x == 1) {
            str = str + "1";
        }

        log.debug("十进制:{},   二进制:{}", x, str);
        return str;
    }






    public static int hammingDistance_2(int x, int y) {
        int tmp = x ^ y;
        return Integer.bitCount(tmp);
    }



    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    
    public int hammingWeight(long n) {
        return Long.bitCount(n);
    }
    
    
}
