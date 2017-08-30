package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lib.HttpDeleteWithBody;
import lib.RequestEncoder;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
public class MessageTemplate {

	/**
	 * 时间戳接口配置
	 */
	public static final String TIMESTAMP = "https://api.mysubmail.com/service/timestamp";
	/**
	 * 备用接口
	 * http://api.mysubmail.com/service/timestamp
	 * https://api.submail.cn/service/timestamp
	 * http://api.submail.cn/service/timestamp
	 */
	
	public static final String TYPE_MD5 = "md5";
	public static final String TYPE_SHA1 = "sha1";
   /**
    * API 请求接口配置
    */
	private static final String URL="http://api.mysubmail.com/message/template";
	/**
	 * 备用接口
	 * @param args
	 * http://api.mysubmail.com/message/template
	 * https://api.submail.cn/message/template
	 * http://api.submail.cn/message/template
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IllegalStateException, IOException {
		TreeMap<String, Object> requestData = new TreeMap<String, Object>();
		/**
		 * --------------------------------参数配置------------------------------------
		 * 请仔细阅读参数配置说明
		 * MESSAGE GET （获取短信模板）方法***************************************************
		 * 配置参数：appid, appkey, signtype, template_id
		 * appid, appkey为必须参数
		 * template_id：要获取单个模板，请将在此参数中提交该模板ID。为空则获取最新的1000个短信模板
		 * MESSAGE POST （新增短信模板）方法***************************************************
		 * 配置参数：appid，appkey，sms_title，sms_signature，sms_content，signtype
		 * appid, appkey，sms_signature，sms_content为必须参数
		 *  sms_title：	模板标题（可选）
		 * sms_signature：请使用您的公司名或应用、APP、网站名作为您的短信签名，
		 *                请将签名字数控制在2-10个字符以内，并使用全角大括号“【”和“】”包括，如:“【SUBMAIL】”
		 * sms_content：提交短信模板正文，请将模板正文字数控制在256个字符以内。可使用文本变量 
		 * MESSAGE PUT （更新修改短信模板）方法*************************************************
		 * 配置参数：appid，appkey，template_id，sms_title，sms_signature，sms_content，signtype
		 * appid，appkey，template_id，sms_signature，sms_content为必须参数
		 * template_id：	需要更新的模板 ID
		 * sms_title：	模板标题（可选）
		 * sms_signature：短信模板签名
		 * sms_content：短信模板正文
		 * MESSAGE DELETE （删除短信模板）方法**************************************************
		 * 配置参数：appid，appkey，template_id，sign_type
		 * appid，appkey，template_id为必须参数
		 * signtype 为可选参数: normal | md5 | sha1
		 * 当 signtype 参数为空时，默认为 normal
		 *  --------------------------------------------------------------------------
		 */
		String method ="delete";       //  get | post | put | delete
		String appid = "15984";
		String appkey = "b0f6426e78f82032e88e74921d74ce";
		String signtype = "";         // normal | md5 | sha1
		//下列参数请按需使用
        requestData.put("template_id", "w0tLv1");
//        requestData.put("sms_title", "TEMPLATE接口测试");
//        requestData.put("sms_signature", "【SUBMAIL】");
//        requestData.put("sms_content", "您的验证码是@var(code)，请在十分钟之内输入，请勿告知别人");
		/**
		 *  ---------------------------------------------------------------------------
		 */
		
		
		
		/**
		 *  签名验证方式
		 *  详细说明可参考 SUBMAIL 官网，开发文档 → 开始 → API 授权与验证机制
		 */
        requestData.put("appid", appid);
		if(signtype.equals(TYPE_MD5) || signtype.equals(TYPE_SHA1)){
			String timestamp = getTimestamp();
			requestData.put("timestamp", timestamp);
			requestData.put("sign_type", signtype);
			String signStr = appid + appkey + RequestEncoder.formatRequest(requestData) + appid + appkey;
			requestData.put("signature", signStr);
			System.out.println(requestData);
		}else{
			requestData.put("signature", appkey);
		}
		/**
		 * http post 请求接口
		 * 成功返回 status: success,其中 fee 参数为短信费用 ，credits 参数为剩余短信余额
		 * 详细的 API 错误日志请访问 SUBMAIL 官网 → 开发文档 → DEBUG → API 错误代码
		 */
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE,HTTP.UTF_8);
		switch(method){
		    case "post":
		    	
				for(Map.Entry<String, Object> entry: requestData.entrySet()){
					String key = entry.getKey();
					Object value = entry.getValue();
					if(value instanceof String){
						//builder.addTextBody(key, String.valueOf(value),contentType);
						//builder.addPart(key,String.valueOf(value),contentType);
					}
				}	
		    	
		    	HttpPost httpPost = new HttpPost(URL);
		    	httpPost.addHeader("charset", "UTF-8");
				httpPost.setEntity(builder.build());
				try{
					CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
					HttpResponse response = closeableHttpClient.execute(httpPost);
					HttpEntity httpEntity = response.getEntity();
					if(httpEntity != null){
						String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
						System.out.println(jsonStr);
					}
				}catch(ClientProtocolException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
				break;
		    case "get":
		    	String urlGet = URL + "?";
		    	for(Map.Entry<String, Object> entry: requestData.entrySet()){
					String key = entry.getKey();
					Object value = entry.getValue();
					if(value instanceof String){
						urlGet +=  key + "=" + String.valueOf(value) + "&";
					}
				}
		    	urlGet = urlGet.substring(0, urlGet.length()-1);
		    	System.out.println(urlGet);
		    	HttpGet httpGet = new HttpGet(urlGet);
		    	try{
					CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
					HttpResponse response = closeableHttpClient.execute(httpGet);
					HttpEntity httpEntity = response.getEntity();
					if(httpEntity != null){
						String jsonStr = EntityUtils.toString(httpEntity, "UTF-8"); 
						System.out.println(jsonStr);
					}
				}catch(ClientProtocolException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
		    	break;
		    case "put":
		    	HttpPut httpput = new HttpPut(URL);
		    	httpput.addHeader("charset", "UTF-8");
		        List<NameValuePair> params=new ArrayList<NameValuePair>();
				for(Map.Entry<String, Object> entry: requestData.entrySet()){
					String key = entry.getKey();
					String value = entry.getValue().toString();
					params.add(new BasicNameValuePair(key,value));	
				}
				httpput.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
		    	try{
					CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
					HttpResponse response = closeableHttpClient.execute(httpput);
					HttpEntity httpEntity = response.getEntity();
					if(httpEntity != null){
						String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
						System.out.println(jsonStr);
					}
				}catch(ClientProtocolException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
		    	break;
		    	
		    case "delete":
		    	String urlDelete="";
		    	for(Map.Entry<String, Object> entry: requestData.entrySet()){
					String key = entry.getKey();
					Object value = entry.getValue();
					if(value instanceof String){
						urlDelete +=  key + "=" + String.valueOf(value) + "&";
					}
					System.out.println(urlDelete);
						}
				    	HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(URL);
				    	HttpEntity setEntity=new StringEntity(urlDelete);
				    	httpDelete.setEntity(setEntity);
				    	try{
							CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
							HttpResponse response = closeableHttpClient.execute(httpDelete);
							HttpEntity httpEntity = response.getEntity();
							if(httpEntity != null){
								String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
								System.out.println(jsonStr);
							}
						}catch(ClientProtocolException e){
							e.printStackTrace();
						}catch(IOException e){
							e.printStackTrace();
						}


		  
		}
		
	}
	/**
	 * 获取时间戳
	 * @return
	 */
	private static String getTimestamp(){
		CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(TIMESTAMP);
		try{
			HttpResponse response = closeableHttpClient.execute(httpget);
			HttpEntity httpEntity = response.getEntity();
			String jsonStr = EntityUtils.toString(httpEntity,"UTF-8");
			if(jsonStr != null){
				JSONObject json = JSONObject.fromObject(jsonStr);
				return json.getString("timestamp");
			}
			closeableHttpClient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
