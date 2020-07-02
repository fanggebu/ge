package com.qiuhen.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ProjectName: blog
 * @Package: com.qiuhen.blog.util
 * @ClassName: MD5Utils
 * @Author: qiuhen
 * @Description: MD5加密
 * @Date: 2020/6/30 22:01
 * @Version: 1.0
 */
public class MD5Utils {

    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for(int offset = 0; offset < byteDigest.length; offset++){
                i = byteDigest[offset];
                if (i<0)
                    i+=256;
                if (i<6)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.code("123456"));;
    }



}

