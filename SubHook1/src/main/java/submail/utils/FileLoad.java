package submail.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
/**
 * 
 * @author submail
 *将内容写到文件里
 */
public class FileLoad {
	
	public static void fileLoad(String url,String content){
		  FileOutputStream fop = null;
		    File file;
		    try {
		    	  String i=new Random().nextInt(9000)+1000+"";
		    	   file = new File(url+i+"json.text");
		    	   fop = new FileOutputStream(file);	    	  
		    	   // 如果文件不存在，创建文件
		    	   if (!file.exists()) {
		    	    file.createNewFile();
		    	   }	    	  
		    	   // 获取以字节为单位内容
		    	   byte[] contentInBytes = content.getBytes();  
		    	   fop.write(contentInBytes);
		    	   fop.flush();
		    	   fop.close();
		    	  
		    	  } catch (IOException e) {
		    	   e.printStackTrace();
		    	  } finally {
		    	   try {
		    	    if (fop != null) {
		    	     fop.close();
		    	    }
		    	   } catch (IOException e) {
		    	    e.printStackTrace();
		    	   }
		    	  }		    
		 }

}
