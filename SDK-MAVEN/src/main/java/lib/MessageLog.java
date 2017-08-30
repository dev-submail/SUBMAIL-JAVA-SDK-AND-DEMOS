package lib;

import lib.base.ISender;
import lib.base.SenderWapper;
import config.AppConfig;
import config.MailConfig;
import config.MessageConfig;

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

	public void addRecipient(String jKey,String jValue) {
		requestData.addWithJson(RECIPIENT, jKey, jValue);
	}

	public void setProject(String jKey,String jValue) {
		requestData.addWithJson(PROJECT, jKey, jValue);
	}
	
	public void addResultStatus(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addStartDate(String key, String val) {
		requestData.addWithComma(key, val);
	}
	
	public void addEndDate(String key, String val) {
		requestData.addWithJson(END_DATA, key, val);
	}
	
	public void addOrdeBy(String key, String val) {
		requestData.addWithJson(ORDER_BY, key, val);
	}
	
	public void addRows(String key, String val) {
		requestData.addWithJson(ROWS, key, val);
	}
	
	public void addOffset(String key, String val) {
		requestData.addWithJson(OFFSET, key, val);
	}
	
	@Override
	public ISender getSender() {
		return new Message(this.config);
	}

	public void log(){
		getSender().log(requestData);
	}
}
