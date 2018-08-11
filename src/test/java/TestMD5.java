import com.hbu.MD5Utils;

/**
 * @author  chenwei
 * @date 2018/8/7.
 */
public class TestMD5 {

	public static void main(String[] args) {
		MD5Utils md = new MD5Utils();

		// 原文
		String DATA = "chenwei";

		System.out.println("原始：" + DATA);
		System.out.println("普通MD5加密：" + MD5Utils.getStrMD5(DATA));

		// 获取加盐后的MD5值
		String ciphertext = MD5Utils.getSaltMD5(DATA);
		System.out.println("加盐后MD5：" + ciphertext);
		System.out.println("是否是同一字符串:" + MD5Utils.getSaltverifyMD5(DATA, ciphertext));
		/**
		 * 其中某次运行后的字符串的MD5值
		 */
		String[] tempSalt = { "f2603e43e56cc36387508710a7126e92076466607e188f2a" };

		for (String temp : tempSalt) {
			System.out.println("是否是同一字符串:" + MD5Utils.getSaltverifyMD5(DATA, temp));
		}

	}

}
