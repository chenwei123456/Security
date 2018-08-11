package com.hbu;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author  chenwei
 * @date 2018/8/11.
 */
public class DESUtils {


	/**
	 * 生成密钥
	 * @return
	 * @throws Exception
	 */
	public static byte[] initKey() throws Exception{
		//密钥生成器
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		//初始化密钥生成器
		keyGen.init(56);
		//生成密钥
		SecretKey secretKey = keyGen.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptDES(byte[] data, byte[] key) throws Exception{
		//获得密钥
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		//Cipher完成加密
		Cipher cipher = Cipher.getInstance("DES");
		//初始化cipher
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		//加密
		byte[] encrypt = cipher.doFinal(data);

		return encrypt;
	}


	/**
	 * 解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptDES(byte[] data, byte[] key) throws Exception{
		//恢复密钥
		SecretKey secretKey = new SecretKeySpec(key, "DES");
		//Cipher完成解密
		Cipher cipher = Cipher.getInstance("DES");
		//初始化cipher
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		//解密
		byte[] plain = cipher.doFinal(data);

		return plain;
	}
}
