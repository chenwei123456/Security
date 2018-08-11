package com.hbu;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Base64
 *
 * @author chenwei
 * @date 2018/8/5.
 * @email 13180208208@163.com
 */
public class Base64 {

	/**
	 * base64算法加密
	 * @param data
	 * @return
	 */
	public static String base64Encrypt(byte[] data){
		String result = new BASE64Encoder().encode(data);
		return result;
	}

	/**
	 * base64算法解密
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String base64Decrypt(String data) throws Exception{
		byte[] resultBytes = new BASE64Decoder().decodeBuffer(data);
		return new String(resultBytes);
	}
}
