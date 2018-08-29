package com.artqiyi.dahuashai.common.util;

import org.springframework.util.Assert;

import java.util.Random;

public class GameUtil {
    private static char[] nums = {'1','2','3','4','5','6'};
    /**
     *  计算输赢
     * @param a 玩家a骰子数
     * @param b 玩家b骰子数
     * @param m 叫骰个数
     * @param n 叫骰点数
     * @param oneCalled 是否叫过1
     * @return
     */
    public static boolean compute(String a, String b, int m, int n, boolean oneCalled){
        //点数不能小于0或大于6,瞎传直接返回false
        if(n<1 || n>6) {
            return false;
        }
        //累计双方玩家所有点数的数量
        int[] all = new int[6];
        char[] chars = (a+b).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            all[chars[i]-49]++;
        }
        //如果叫过1或叫的点数为1
        if (oneCalled || n==1){
            return all[n-1] < m;
        }
        //如果没有叫过1
        return all[n-1]+all[0] < m;
    }

    /**
     * 骰子点数生成器
     * @param n 骰子的g个数
     * @return
     */
    public static String getNum(int n){
        Assert.isTrue(n>0, "n必须大于0");
        char[] newNums = new char[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            newNums[i] = nums[r.nextInt(nums.length)];
        }
        return String.valueOf(newNums);
    }

    public static Integer getIntNum(int n){
        return Integer.valueOf(getNum(n));
    }


    public static void main(String[] args) {
        String a =  getNum(5);
        String b =  getNum(5);
        System.out.println(a);
        System.out.println(b);
        System.out.println(compute(a, b, 2, 2, false));
    }
}
