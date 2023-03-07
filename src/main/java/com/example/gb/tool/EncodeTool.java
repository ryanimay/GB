package com.example.gb.tool;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncodeTool {
    public static int md5Hash = 1024;
    public static String md5Encode(String pwd, String salt){
        return new Md5Hash(pwd, salt, md5Hash).toHex();
    }
}
