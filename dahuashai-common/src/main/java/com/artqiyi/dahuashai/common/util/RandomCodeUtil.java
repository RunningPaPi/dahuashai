package com.artqiyi.dahuashai.common.util;

import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class RandomCodeUtil {

    public static int generateUserNo(int len){
        Assert.isTrue(len > 1, "长度要大于1");
        int r0 = (int)Math.pow(10,len-1);
        Random r = new Random();
        return r.nextInt(9*r0)+r0;
    }

    public static String generateInviteCode(int len) {
        Assert.isTrue(len > 1, "长度要大于1");

        char[] chars = {'Q', 'W', 'E', '8', 'S', '2', 'D', 'Z',
                'X', '9', 'C', '7', 'P', '5', 'K', '3',
                'M', 'J', 'U', 'F', 'R', '4', 'V', 'Y',
                'T', 'N', '6', 'B', 'G', 'H', 'A', 'L'};
        Random random = new Random();
        char[] inviteChars = new char[len];
        for (int i = 0; i < len; i++) {
            inviteChars[i] = chars[random.nextInt(chars.length)];
        }
        return String.valueOf(inviteChars);
    }

    public static void main(String[] args) {

        System.out.println(RandomCodeUtil.generateUserNo(5));

//        long start = System.currentTimeMillis();
//        Set set = new HashSet();
//        for (int i = 0; i < 1000000; i++) {
//            set.add(generateInviteCode(6));
//        }
//        Iterator iterator = set.iterator();
//        for (int i =0;i<10;i++){
//            System.out.println(iterator.next());
//        }
//        System.out.println();
//        System.out.println(set.size());
    }
}
