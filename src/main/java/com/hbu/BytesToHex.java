package com.hbu;

/**
 * 字符节转16进制
 * @author chenwei
 * @date 2018/8/6.
 * @email 13180208108@163.com
 */
public class BytesToHex {
	public static String fromBytesToHex(byte[] resultBytes){
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < resultBytes.length; i++){
			if(Integer.toHexString(0xFF & resultBytes[i]).length() == 1){
				builder.append("0").append(Integer.toHexString(0xFF & resultBytes[i]));
			}else{
				builder.append(Integer.toHexString(0xFF & resultBytes[i]));
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(Integer.toHexString(0xFF & 15));
	}
}
