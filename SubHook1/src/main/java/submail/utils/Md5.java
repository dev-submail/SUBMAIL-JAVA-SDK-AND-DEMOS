package submail.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * md5加密
 * 传入token和可以，返回MD5加密后的字符串
 * MD5加密：32位小写
 * @author submail
 *
 */
public class Md5 {
     
	public static String getMd5(String token,String key) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		String str=token+key;
		MessageDigest md5 = MessageDigest.getInstance("MD5");  
		md5.update((str).getBytes("UTF-8"));  
		byte b[] = md5.digest();  
		  
		int i;  
		StringBuffer buf = new StringBuffer("");  
		  
		for(int offset=0; offset<b.length; offset++){  
		    i = b[offset];  
		    if(i<0){  
		        i+=256;  
		    }  
		    if(i<16){  
		        buf.append("0");  
		    }  
		    buf.append(Integer.toHexString(i));  
		}  
		  
		String result = buf.toString();  
		 
		return result; 
	}
         
	
	

}
