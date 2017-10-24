package demo;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class ServiceStatus {
	/**
	 * status接口配置
	 */
	public static final String STATUS = "https://api.mysubmail.com/service/status";
	/**
	 * 备用接口
	 * https://api.mysubmail.com/service/status
	 * https://api.submail.cn/service/status
	 */

    public static void main(String[] args) {
    	JSONObject status = getTimestamp();
    	System.out.println(status);
    }
	
	
	/**
	 * 获取SUBMAIL服务器状态和响应时间(单位：秒)。
	 */
	private static JSONObject getTimestamp(){
		CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(STATUS);
		try{
			HttpResponse response = closeableHttpClient.execute(httpget);
			HttpEntity httpEntity = response.getEntity();
			String jsonStr = EntityUtils.toString(httpEntity,"UTF-8");
			if(jsonStr != null){
				JSONObject json = JSONObject.fromObject(jsonStr);
				return json;
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
