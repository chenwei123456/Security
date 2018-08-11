import com.hbu.AESUtils;
import com.hbu.BytesToHex;

/**
 * @author chenwei
 * @date 2018/8/11.
 */
public class TestAES {

	public static final String DATA = "this is chenwei and from HBU-SE";


	public static void main(String[] args) throws Exception {
		//获得密钥
		byte[] aesKey = AESUtils.initKey();
		System.out.println("AES 密钥 : " + BytesToHex.fromBytesToHex(aesKey));
		//加密
		byte[] encrypt = AESUtils.encryptAES(DATA.getBytes(), aesKey);
		System.out.println(DATA + " AES 加密 : " + BytesToHex.fromBytesToHex(encrypt));

		//解密
		byte[] plain = AESUtils.decryptAES(encrypt, aesKey);
		System.out.println(DATA + " AES 解密 : " + new String(plain));
	}
}
