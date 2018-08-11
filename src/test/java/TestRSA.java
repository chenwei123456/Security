import com.hbu.BytesToHex;
import com.hbu.RSAUtils;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author  chenwei
 * @date 2018/8/6.
 * @email 13180208208@163.com
 */
public class TestRSA {

	public static final String DATA = "hi, this is chenwei,from HBU-SE";

	public static void main(String[] args) throws Exception{
		Map<String, Object> keyMap = RSAUtils.initKey();
		RSAPublicKey rsaPublicKey = RSAUtils.getpublicKey(keyMap);
		RSAPrivateKey rsaPrivateKey = RSAUtils.getPrivateKey(keyMap);
		System.out.println("RSA PublicKey: " + rsaPublicKey);
		System.out.println("RSA PrivateKey: " + rsaPrivateKey);

		byte[] rsaResult = RSAUtils.encrypt(DATA.getBytes(), rsaPublicKey);
		System.out.println("原文  "+DATA + "  经过RSA非对称算法加密后的结果：" + BytesToHex.fromBytesToHex(rsaResult));

		byte[] plainResult = RSAUtils.decrypt(rsaResult, rsaPrivateKey);
		System.out.println("原文 "+DATA + "   经过RSA非对称算法解密后的结果：" + BytesToHex.fromBytesToHex(plainResult));

	}

}
