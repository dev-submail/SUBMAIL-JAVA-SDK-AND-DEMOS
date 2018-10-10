package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * log/message 是 SUBMAIL 的短信发送日志查询 API
 * @author submail
 *
 */
public class MessageLog extends SenderWapper {

	protected AppConfig config = null;
	public static final String  RECIPIENT= "recipient";
	public static final String PROJECT = "project";
	public static final String RESULT_STATUS = "result_status";
	public static final String START_DATA = "start_date";
	public static final String END_DATA = "end_date";
	public static final String ORDER_BY = "order_by";
	public static final String ROWS = "rows";
	public static final String OFFSET = "offset";

	public MessageLog(AppConfig config) {
		this.config = config;
	}

	public void addRecipient(String key,String val) {
		requestData.addWithComma(key, val);
	}

	public void setProject(String key,String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addResultStatus(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addStartDate(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addEndDate(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addOrdeBy(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addRows(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addOffset(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	@Override
	public ISender getSender() {
		return new Message(this.config);
	}

	public String log(){
		return getSender().log(requestData);
	}
}
