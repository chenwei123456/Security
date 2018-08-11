import com.hbu.BytesToHex;
import com.hbu.DESUtils;

/**
 * @author chenwei
 * @date 2018/8/11.
 */
public class TestDES {

	public static final String DATA = "This is chenwei and from HBU-SE";

	public static void main(String[] args) throws Exception {
		byte[] desKey = DESUtils.initKey();
		System.out.println("DES 密钥 : " + BytesToHex.fromBytesToHex(desKey));
		byte[] desReult = DESUtils.encryptDES(DATA.getBytes(), desKey);
		System.out.println(DATA + "DES 加密  " + BytesToHex.fromBytesToHex(desReult));
		byte[] plain = DESUtils.decryptDES(desReult, desKey);
		System.out.println(DATA + "DES 解密  " + new String(plain));
	}
}
