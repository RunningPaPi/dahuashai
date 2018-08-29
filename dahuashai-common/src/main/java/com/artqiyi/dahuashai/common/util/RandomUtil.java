package com.artqiyi.dahuashai.common.util;

/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: dahuashai
 * Author: chencunjun  <1078027943@qq.com>
 * Create On: 2018/5/9
 * Modify On: 2018/5/9 by chencunjun
 */

import java.util.HashSet;

/**
 * 随机数生成工具类
 */
public class RandomUtil {

    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     * @param set 随机数结果集
     */
    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        while(set.size()<n){
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
    }

    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     */
    public static int randomNum(int min, int max, int n) {
        String result="";
        for(int i=0;i<n;i++){
            result+=(int) (Math.random() * (max - min)) + min;
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args){
//        HashSet<Integer> set=new HashSet<>();
//        RandomUtil.randomSet(0,50,5,set);
//        for(Integer i:set){
//            System.out.println(i);
//        }

        for(int i=0;i<100;i++){
            System.out.println( RandomUtil.randomNum(1,7,5));
        }

    }

}
