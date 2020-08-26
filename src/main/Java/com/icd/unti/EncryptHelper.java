package com.icd.unti;

import java.math.BigInteger;
import java.security.MessageDigest;


/**
 * @author 李耀华
 * @since 2020年7月8日
 * 字符串加密工具类
 */

public class EncryptHelper {
	private static final String KEY_SHA = "SHA";
	private static final String KEY_MD5 = "MD5"; 
	
	private static byte[] EncryptSHA(byte[] data) throws Exception
	{
		MessageDigest sha=MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}
    
    private static byte[] EncryptMD5(byte[] data) throws Exception
	{
		MessageDigest md5=MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}
    
    public static String SHA(String data){
    	byte[] encryptdata = data.getBytes();
    	BigInteger sha;
		try {
			sha = new BigInteger(EncryptSHA(encryptdata));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}		
    	return sha.toString();
    }
}
