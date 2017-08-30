package lib.base;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lib.Mail;
import lib.Message;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import utils.HttpDeleteUtil;
import utils.RequestEncoder;
import config.AppConfig;


/**
 * 这个类实现了ISender，包含了在发送之前处理发生的事件的常用方法
 * 创建了一个签名并构建请求数据
 * @author submail
 *
 */
public class Sender implements ISender {

	protected AppConfig config = null;
	private static final String API_TIMESTAMP = "http://api.submail.cn/service/timestamp.json";
	public static final String APPID = "appid";
	public static final String TIMESTAMP = "timestamp";
	public static final String SIGN_TYPE = "sign_type";
	public static final String SIGNATURE = "signature";
	public static final String APPKEY = "appkey";
	private CloseableHttpClient closeableHttpClient = null;

	public Sender() {
		closeableHttpClient = HttpClientBuilder.create().build();
	}

	public boolean send(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean xsend(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean subscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean unsubscribe(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	public boolean multixsend(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verify(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public boolean log(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	public boolean get(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public boolean post(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public boolean put(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public boolean delete(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public boolean selMobiledata(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public boolean toService(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public boolean charge(Map<String, Object> data) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	/**
	 * 请求时间戳
	 * @return timestamp
	 * */
	protected String getTimestamp() {
		HttpGet httpget = new HttpGet(API_TIMESTAMP);
		HttpResponse response;
		try {
			response = closeableHttpClient.execute(httpget);
			HttpEntity httpEntity = response.getEntity();
			String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
			if (jsonStr != null) {
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

	protected String createSignature(String data) {
		if (AppConfig.TYPE_NORMAL.equals(config.getSignType())) {
			return config.getAppKey();
		} else {
			return buildSignature(data);
		}
	}

	/**
	 * 当 {@link AppConfig#setSignType(String)} 不正常时,创建
	 * 一个签名类型
	 * 
	 * @param data
	 *            请求数据
	 * @return signature
	 * */
	private String buildSignature(String data) {
		String app = config.getAppId();
		String appKey = config.getAppKey();
		// order is confirmed
		String jointData = app + appKey + data + app + appKey;
		if (AppConfig.TYPE_MD5.equals(config.getSignType())) {
			return RequestEncoder.encode(RequestEncoder.MD5, jointData);
		} else if (AppConfig.TYPE_SHA1.equals(config.getSignType())) {
			return RequestEncoder.encode(RequestEncoder.SHA1, jointData);
		}
		return null;
	}

	/**
	 * 请求数据 post提交
	 * 
	 * @param url
	 * @param data
	 * @return boolean
	 * */
	protected boolean request(String url, Map<String, Object> data) {
		HttpPost httppost = new HttpPost(url);
		httppost.addHeader("charset", "UTF-8");
		httppost.setEntity(build(data));

		try {
			HttpResponse response = closeableHttpClient.execute(httppost);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println(jsonStr);
				return jsonStr.contains("success");
			}
			closeableHttpClient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 短信模板：get请求方法
	 * @param url
	 * @param data
	 * @return
	 */
	protected boolean getMethodRequest(String url, Map<String, Object> data) {
		data.put(APPID, config.getAppId());
		data.put(TIMESTAMP, this.getTimestamp());
		data.put(SIGNATURE, config.getAppKey());
		String urlGet = url + "?";
    	for(Map.Entry<String, Object> entry: data.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof String){
				urlGet +=  key + "=" + String.valueOf(value) + "&";
			}
		}
    	urlGet = urlGet.substring(0, urlGet.length()-1);
    	HttpGet httpGet = new HttpGet(urlGet);
    	try{
			CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
			HttpResponse response = closeableHttpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			if(httpEntity != null){
				String jsonStr = EntityUtils.toString(httpEntity, "UTF-8"); 
				System.out.println(jsonStr);
				return jsonStr.contains("success");
			}
			closeableHttpClient.close();
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
    	return false;
}
	/**
	 * 短信模板：put方法
	 * @param url
	 * @param data
	 * @return
	 */
	protected boolean putMethodRequest(String url, Map<String, Object> data)  {
		HttpPut httpput = new HttpPut(url);
		httpput.addHeader("charset", "UTF-8");
		data.put(APPID, config.getAppId());
		data.put(TIMESTAMP, this.getTimestamp());
		data.put(SIGNATURE, config.getAppKey());
		List<NameValuePair> params=new ArrayList<NameValuePair>();
    	for(Map.Entry<String, Object> entry: data.entrySet()){
			String key = entry.getKey();
			String value = (String) entry.getValue();
			params.add(new BasicNameValuePair(key,value));	
		}
    	
		try {
			httpput.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			HttpResponse response = closeableHttpClient.execute(httpput);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println(jsonStr);
				return jsonStr.contains("success");
			}
			closeableHttpClient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 短信模板：Delete方法
	 * @param url
	 * @param data
	 * @return
	 */
	protected boolean deleteMethodRequest(String url, Map<String, Object> data) {
		data.put(APPID, config.getAppId());
		data.put(TIMESTAMP, this.getTimestamp());
		data.put(SIGNATURE, config.getAppKey());
		String urlDel="";
    	for(Map.Entry<String, Object> entry: data.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof String){
				urlDel +=  key + "=" + String.valueOf(value) + "&";
			}
			System.out.println(urlDel);
		}
    	urlDel = urlDel.substring(0, urlDel.length()-1);
    	HttpDeleteUtil httpDelete = new HttpDeleteUtil(url);
    	try{
    		HttpEntity httpEntity=new StringEntity(urlDel);
        	httpDelete.setEntity(httpEntity);
			CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
			HttpResponse response = closeableHttpClient.execute(httpDelete);
			HttpEntity httpEntity2 = response.getEntity();
			if(httpEntity2 != null){
				String jsonStr = EntityUtils.toString(httpEntity2, "UTF-8"); 
				System.out.println(jsonStr);
				return jsonStr.contains("success");
			}
			closeableHttpClient.close();
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
    	return false;
	}

	/**
	 *将请求数据转换为HttpEntity
	 * 
	 * @param data
	 * @return HttpEntity
	 * */
	protected HttpEntity build(Map<String, Object> data) {
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody(APPID, config.getAppId());
//		builder.setCharset(Charset.);
		builder.addTextBody(TIMESTAMP, this.getTimestamp());
		builder.addTextBody(SIGN_TYPE, config.getSignType());
		// set the properties below for signature
		data.put(APPID, config.getAppId());
		data.put(TIMESTAMP, this.getTimestamp());
		data.put(SIGN_TYPE, config.getSignType());
		ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8); 
		builder.addTextBody(SIGNATURE,
				createSignature(RequestEncoder.formatRequest(data)), contentType);
		for (Map.Entry<String, Object> entry : data.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String) {
				builder.addTextBody(key, String.valueOf(value), contentType);			
				System.out.println(builder.toString());
			} else if (value instanceof File) {
				builder.addBinaryBody(key, (File) value);
			}
		}
		return builder.build();
	}
	

}
