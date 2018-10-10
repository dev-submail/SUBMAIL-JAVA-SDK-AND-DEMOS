package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * message/template 是 SUBMAIL 的短信模板 API
 * 使用 message/template 可以获取、创建、编辑或删除您的短信模板。
 * message/template API 使用 HTTP 规范中的 GET, POST, PUT, DELETE 方法对模板进行操作，
 * 使用 GET 方法获取单个或全部模板、POST 方法创建新的短信模板并提交至 SUBMAIL 人工审核、
 * PUT 方法更新或编辑一个短信模板，或使用 DELETE 方法删除一个模板。
 * 短信模板引擎支持 SUBHOOK 异步推送状态，短信模板在后台人工审核后，会使用 SUBHOOK 进行主动推送状态
 * @author submail
 *
 */
public class MessageTemplate extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String CONTENT = "content";
	public static final String GET= "get";
	public static final String POST = "post";
	public static final String PUT = "put";
	public static final String DELETE = "delete";
	public static final String TEMPLATE_ID="template_id";
	public static final String SMS_TITLE = "sms_title";
	public static final String SMS_SIGNATURE = "sms_signature";
	public static final String SMS_CONTENT = "sms_content";
	
	
    public MessageTemplate(AppConfig config) {
		
		this.config = config;
		
	}
	//get
	public void getTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID,templateId );
	}
	
	//post
	public void postSmsTitle(String smsTitle) {
		requestData.addWithComma(SMS_TITLE ,smsTitle );
	}
	
	public void postSmsSignature(String smsSignature) {
		requestData.addWithComma(SMS_SIGNATURE,smsSignature );
	}
	
	public void postSmsContent(String smsContent) {
		requestData.addWithComma(SMS_CONTENT,smsContent );
	}
	
	//put
	public void putTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID,templateId );
	}
	
	public void putSmsTitle(String smsTitle) {
		requestData.addWithComma(SMS_TITLE ,smsTitle );
	}
	
	public void putSmsSignature(String smsSignature) {
		requestData.addWithComma(SMS_SIGNATURE,smsSignature );
	}
	
	public void putSmsContent(String smsContent) {
		requestData.addWithComma(SMS_CONTENT,smsContent );
	}
	
	//delete
	public void delTemplateId(String templateId) {
		requestData.addWithComma(TEMPLATE_ID,templateId );
	}
	
	
	

	@Override
	public ISender getSender() {
		return new  Message(this.config);
	}

	public String getTemplate(){
		return getSender().get(requestData);
	}
	
	public String postTemplate(){
		return getSender().post(requestData);
	}
	
	public String putTemplate(){
		return getSender().put(requestData);
	}
	
	public String delTemplate(){
		return getSender().delete(requestData);
	}
}
	
	
	
	


