package demo;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
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
import lib.RequestEncoder;
import net.sf.json.JSONObject;

public class MailXsend {
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
	private static final String URL="https://api.mysubmail.com/mail/xsend";
	/**
	 * 备用接口
	 * @param args
	 * http://api.mysubmail.com/mail/xsend
	 * https://api.submail.cn/mail/xsend
	 * http://api.submail.cn/mail/xsend
	 */
	
	public static void main(String[] args) {
		TreeMap<String, Object> requestData = new TreeMap<String, Object>();
		JSONObject vars = new JSONObject();
		/**
		 * --------------------------------参数配置------------------------------------
		 * 请仔细阅读参数配置说明
		 * 
		 * 配置参数包括 appid, appkey ,to , signtype,from,subject
		 * 用户参数设置，其中 appid, appkey, from, to,subject，project 为必须参数
		 * 请访问 submail 官网创建并获取 appid 和 appkey，链接：https://www.mysubmail.com/chs/mail/apps
		 * 请访问 submail 官网创建获取邮件模板内容，链接：https://www.mysubmail.com/chs/mail/templates
		 * signtype 为可选参数: normal | md5 | sha1
		 * vars 使用文本变量动态控制邮件中的文本参阅
		 * links 使用超链接变量动态控制邮件中的超链接参阅
		 * headers 自定义 EMAIL 头文件指令，headers 是一个标准的 JSON 字符串，headers 参数可以让开发者在 EMAIL 的标头部分插入自定义指令。（500个字符以内）
          如： {"X-Accept-Language": "zh-cn", "X-Priority":"3","X-Mailer": "My Application"}
          请注意：
          Submail 保留 x-submail-smtp-api 指令，请务必不要在邮件标头中使用此指令
          自定义的 EMAIL headers 指令通常以字母 X- 开头，请将此规范应用到你的指令
          vars,  links 和 headers 参数要求严格的 JSON 格式，以下是将参数转换为 JSON 格式的注意事项
          json 字符串必须以双引号包含， json 字符串必须是 utf8 编码，不能有多余的逗号 如：[1,2,]，json 字符串首尾必须被大括号{}包含 
          PS:大多数的语言都有专属的JSON解析器（ ENCODING 和 DECODEING 方法）。
         *asynchronous 默认为false 异步选项，该值设为 true 时启用异步发送模式。
         *tag 自定义标签功能，该标签可用作SUBHOOK追踪（32 个字符以内）。
		 * 当 signtype 参数为空时，默认为 normal
		 * 多个联系人，请用 “,” 半角逗号区分  e.g. "leo <leo@submail.cn>, <retro@submail.cn>, service@submail.cn";
         SUBMAIL 支持完整的 RFC 822 收件人标准，请确保您的邮件地址的有效性。请参见 维基百科 EMAIL ADDRESS RFC822 文档
         请注意：当你的  TO 参数和地址簿中的联系人总和大于 50 个联系人时，将自动被转入推广邮件通道，且本次发送不计算为触发类邮件，
         to 参数单次请求上限为 5000 个联系人
		 * --------------------------------------------------------------------------
		 */
		String appid = "your_appiid";
		String appkey = "your_appkey";
		String to = "recipient_address";
		String project = "your_projectId";
		String subject="your_mail_title";
		String signtype = "";
		String from="sender_address";
		/**
		 *  ---------------------------------------------------------------------------
		 */
		
		
		
		/**
		 *  签名验证方式
		 *  详细说明可参考 SUBMAIL 官网，开发文档 → 开始 → API 授权与验证机制
		 */
		requestData.put("appid", appid);
		requestData.put("project", project);
		requestData.put("to", to);
		requestData.put("subject", subject);
		requestData.put("from",from);
		if(!vars.isEmpty()){
			requestData.put("vars",vars.toString());
		}
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
