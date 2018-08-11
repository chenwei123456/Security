import com.hbu.BytesToHex;
import com.hbu.DHUtils;

import java.util.Map;

/**
 * Created by chenwei on 2018/8/6.
 */
public class TestDH {

	//待加密原文
	public static final String DATA = "hi,this is chenwei,from HBU-SE";

	public static void main(String[] args) throws Exception {
		//甲方公钥
		byte[] publicKey1;
		//甲方私钥
		byte[] privateKey1;
		//甲方本地密钥
		byte[] secretKey1;
		//乙方公钥
		byte[] publicKey2;
		//乙方私钥
		byte[] privateKey2;
		//乙方本地密钥
		byte[] secretKey2;

		//初始化密钥，并生成甲方密钥对
		Map<String, Object> keyMap1 = DHUtils.initKey();
		publicKey1 = DHUtils.getPublicKey(keyMap1);
		privateKey1 = DHUtils.getPrivateKey(keyMap1);
		System.out.println("DH 甲方公钥: " + BytesToHex.fromBytesToHex(publicKey1));
		System.out.println("DH 甲方私钥: " + BytesToHex.fromBytesToHex(privateKey1));

		//乙方根据甲方公钥产生乙方密钥对
		Map<String, Object> keyMap2 = DHUtils.initKey(publicKey1);
		publicKey2 = DHUtils.getPublicKey(keyMap2);
		privateKey2 = DHUtils.getPrivateKey(keyMap2);
		System.out.println("DH 乙方公钥: " + BytesToHex.fromBytesToHex(publicKey2));
		System.out.println("DH 乙方私钥: " + BytesToHex.fromBytesToHex(privateKey2));

		//对于甲方，根据其私钥和乙方发过来的公钥， 生成其本地密钥secretKey1
		secretKey1 = DHUtils.getSecretKey(publicKey2, privateKey1);
		System.out.println("DH 甲方 本地密钥: " + BytesToHex.fromBytesToHex(secretKey1));

		//对于乙方，根据其私钥和甲方发过来的公钥，生成其本地密钥secretKey2
		secretKey2 = DHUtils.getSecretKey(publicKey1, privateKey2);
		System.out.println("DH 乙方 本地密钥: " + BytesToHex.fromBytesToHex(secretKey2));

	}
}