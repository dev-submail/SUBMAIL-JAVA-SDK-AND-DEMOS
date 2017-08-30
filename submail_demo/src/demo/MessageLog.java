package demo;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import lib.RequestEncoder;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class MessageLog {
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
	private static final String URL="https://api.mysubmail.com/log/message";
	/**
	 * 备用接口
	 * @param args
	 * http://api.mysubmail.com/log/message
	 * https://api.submail.cn/log/message
	 * http://api.submail.cn/log/message
	 */
	
	public static void main(String[] args) {
		TreeMap<String, Object> requestData = new TreeMap<String, Object>();
		/**
		 * --------------------------------参数配置------------------------------------
		 * 请仔细阅读参数配置说明
		 * 
		 * 配置参数包括 appid（必须，appkey（必须），recipient（可选），project（可选），result_status（可选），start_date（可选）
		 * end_date（可选），order_by（可选），rows（可选），offset（可选），timestamp（可选），（可选）
		 * 参数说明
		 * 请访问 submail 官网创建并获取 appid 和 appkey，链接：https://www.mysubmail.com/chs/sms/apps
		 * 请访问 submail 官网创建获取项目标识 project_id，链接：https://www.mysubmail.com/chs/sms/templates
		 * 如何获取项目标识 project 参数，链接：https://www.mysubmail.com/chs/documents/developer/MmSw12
		 * recipient：默认返回全部联系人数据，要指定返回某个联系人的日志，请将该值设为 该联系人的11位手机号码
		 * project：默认返回全部项目数据，要指定短信项目标识返回某个项目（即短信模板）的日志，请将该值设为该模板的项目标识
		 * result_status：默认返回全部数据，要指定所有发送成功的日志，请将该值设为 delivered ，要查询发送失败的数据，请将该指 dropped
		 * start_date,end_date：日志查询的开始时间与结束时间（使用 UNIX 时间戳格式）
		 * order_by：若希望返回的数据按照发送时间升序排列，请将 order_by 参数设为 asc，反之则设为 desc
		 * rows：请将该值控制在10-1000之间，若指定了一个无效的 rows 参数，API 将默认返回 50 行数据
		 * offset：值可以指定返回数据的偏移指针，例：假如单次请求的开始至结束日期包含150条数据，rows参数采用默认的50行，
		 *        此时需要查询第51-100行的数据，请将 offset 参数设为1(即数据偏移50行)即可得到第51-100行的数据
		 *        ，offset=2时，将返回第101-150行数据，以此类推
		 * timestamp：UNIX时间戳
		 * signtype 为可选参数: normal | md5 | sha1 ，当 signtype 参数为空时，默认为 normal
		 *  --------------------------------------------------------------------------
		 */
		String appid = "15884";
		String appkey = "b07f646e78f82032e881e74921d74ce";
		String signtype = "";
		/*
		requestData.put("recipient", "");
		requestData.put("project", "");
		requestData.put("result_status", "delivered");
		requestData.put("start_date", "");
		requestData.put("end_date", "");
		requestData.put("order_by", "desc");
		requestData.put("rows", "50");
		requestData.put("offset", "");
		*/
		
		/**
		 *  ---------------------------------------------------------------------------
		 */
		
		
		
		/**
		 *  签名验证方式
		 *  详细说明可参考 SUBMAIL 官网，开发文档 → 开始 → API 授权与验证机制
		 */
		requestData.put("appid", appid);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		@SuppressWarnings("deprecation")
		ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE,HTTP.UTF_8);
		for(Map.Entry<String, Object> entry: requestData.entrySet()){
			String key = entry.getKey();
			Object value = entry.getValue();
			if(value instanceof String){
				builder.addTextBody(key, String.valueOf(value),contentType);
			}
		}	
		if(signtype.equals(TYPE_MD5) || signtype.equals(TYPE_SHA1)){
			String timestamp = getTimestamp();
			requestData.put("timestamp", timestamp);
			requestData.put("sign_type", signtype);
			String signStr = appid + appkey + RequestEncoder.formatRequest(requestData) + appid + appkey;
			builder.addTextBody("timestamp", timestamp);
			builder.addTextBody("sign_type", signtype);
			builder.addTextBody("signature", RequestEncoder.encode(signtype, signStr), contentType);
		}else{
			builder.addTextBody("signature", appkey, contentType);
		}
		/**
		 * http post 请求接口
		 * 成功返回 status: success,其中 fee 参数为短信费用 ，credits 参数为剩余短信余额
		 * 详细的 API 错误日志请访问 SUBMAIL 官网 → 开发文档 → DEBUG → API 错误代码
		 */
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
