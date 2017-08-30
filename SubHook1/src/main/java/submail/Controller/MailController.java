package submail.Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import net.sf.json.JSONObject;
import submail.Pojo.Mail;
import submail.Pojo.Message;
import submail.config.Config;
import submail.utils.FileLoad;
import submail.utils.Md5;
import sun.misc.BASE64Encoder;
/**
 * 拦截请求路径，将获取的数据以text文件格式保存到本地
 * @author submail
 *
 */
@Controller
public class MailController {
	 
	   @ResponseBody  
	   @RequestMapping(value="/mail",method = RequestMethod.POST)  
	   public String mailSubhook(MultipartHttpServletRequest MultiRequest){
		    DefaultMultipartHttpServletRequest defaultRequest = (DefaultMultipartHttpServletRequest) MultiRequest;
		     MultiValueMap fileMap = defaultRequest.getMultiFileMap();
		     Map<String, String[]> params = defaultRequest.getParameterMap();	     
		     JSONObject json = new JSONObject();
		     JSONObject result = new JSONObject(); 
		     //将jarams转换成json
		       for (Map.Entry<String, String[]> entry : params.entrySet()) {
		    		String key = entry.getKey();
					String value = entry.getValue()[0];
					json.put(key, value);
		       }
		        //保存文件的路径
			    String url=MultiRequest.getSession().getServletContext().getRealPath("/");
				try {	
				        //加密后的字符串
				     String newstr=Md5.getMd5(json.getString("token"),Config.mailConfig());
				     if(!json.get("signature").equals(newstr)){
				    	 FileLoad.fileLoad(url, "err:wrong signture");
				        	return "err:wrong signture";
				        }
				} catch (Exception e) {
					e.printStackTrace();
					 FileLoad.fileLoad(url, "abnormal data");
					return "abnormal data";
				}
				
				String event=(String) json.get("events");
				Mail mail = (Mail) JSONObject.toBean(json, Mail.class); 
				switch(event){
				case "request":
					 //返回请求结果  
		            result.put("status", "request");  
		            result.put("mail", mail); 
		            FileLoad.fileLoad(url, result.toString());
		            return result.toString(); 
				
				case "delivered":
			            //返回请求结果  
			            result.put("status", "send success");  
			            result.put("mail", mail);  
			            FileLoad.fileLoad(url, result.toString());
			            return result.toString(); 
				
				case "dropped":
			            //返回请求结果  
			            result.put("status", "send fail");  
			            result.put("mail", mail); 
			            FileLoad.fileLoad(url, result.toString());
			            return result.toString(); 
			            
				case "sending":
			            //返回请求结果  
			            result.put("status", "is sending");  
			            result.put("mail", mail); 
			            FileLoad.fileLoad(url, result.toString());
			            return result.toString(); 
			            
				case "mo":
			            //返回请求结果  
			            result.put("status", "mo");  
			            result.put("mail", mail); 
			            FileLoad.fileLoad(url, result.toString());
			            return result.toString(); 
			            
				case "unkown":
			            //返回请求结果  
			            result.put("status", "unkown");  
			            result.put("mail", mail);  
			            FileLoad.fileLoad(url, result.toString());
			            return result.toString();       
				}
				 FileLoad.fileLoad(url, "accept failure");
				return "accept failure";
			    }  
	


}
