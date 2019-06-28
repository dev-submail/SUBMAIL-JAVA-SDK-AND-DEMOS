package utils;

import java.io.File;
import java.io.FileInputStream;

import sun.misc.BASE64Encoder;

/**
 * 字符串的处理类
 * 
 * @author submail
 *
 */
public class StringUtil {

	public static boolean isNullOrEmpty(String text) {
		return text == null || text.trim().isEmpty();
	}

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		;
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);

	}

	public String replaceSpecialStr(String str) {
		str = str.replaceAll("\\\\", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\"", "");
		return str;
	}

}
