import com.hbu.BytesToHex;
import com.hbu.DESede;

/**
 * @author chenwei
 * @date 2018/8/11.
 */
public class TestDESede {

	public static final String DATA = "this is chenwei and from HBU-SE";

	public static void main(String[] args) throws Exception {
		//获取密钥
		byte[] key = DESede.initKey();
		System.out.println("DESede 密钥 : " + BytesToHex.fromBytesToHex(key));
		//加密
		byte[] encrypt = DESede.encrypt3DES(DATA.getBytes(), key);
		System.out.println(DATA + " DESede 加密 : " + BytesToHex.fromBytesToHex(encrypt));
		byte[] plain = DESede.decrypt3DES(encrypt, key);
		System.out.println(DATA + " DESede 解密: " + new String(plain));
	}
}
