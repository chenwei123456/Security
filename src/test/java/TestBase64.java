import com.hbu.Base64;

/**
 * Created by chenwei on 2018/8/5.
 */
public class TestBase64 {

	//待加密明文
	public static final String DATA = "hi, this is chenwei,from HBU-SE";

	public static void main(String[] args) throws Exception {
		String base64Result = Base64.base64Encrypt(DATA.getBytes());
		System.out.println("base64加密后的结果： " + base64Result);

		String base64Plain = Base64.base64Decrypt(base64Result);
		System.out.println("base64解密后的结果：" + base64Plain);
	}
}