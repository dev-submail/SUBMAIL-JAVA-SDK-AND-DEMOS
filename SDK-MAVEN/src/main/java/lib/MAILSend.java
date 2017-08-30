package lib;

import java.io.File;

import lib.base.ISender;
import lib.base.SenderWapper;
import config.AppConfig;
import config.MailConfig;
import config.MessageConfig;

/**
 * mail/send 是 SUBMAIL 的邮件 API。 mail/send API 不仅提供强大的邮件发送功能, 
 * 并在 API 中集成了地址簿发送功能。你可以通过设定一些参数来确定 API 以哪种模式发送。 
 * @author submail
 *
 */
public class MAILSend extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String ADDRESSBOOK = "addressbook";
	public static final String FROM = "from";
	public static final String FROM_NAME = "from_name";
	public static final String REPLY = "reply";
	public static final String CC = "cc";
	public static final String BCC = "bcc";
	public static final String SUBJECT = "subject";
	public static final String TEXT = "text";
	public static final String HTML = "html";
	public static final String VARS = "vars";
	public static final String LINKS = "links";
	public static final String ATTACHMENTS = "attachments";
	public static final String HEADERS = "headers";

	public MAILSend(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String address, String name) {
		requestData.addWithBracket(TO, name, address);
	}

	public void addAddressBook(String addressbook) {
		requestData.addWithComma(ADDRESSBOOK, addressbook);
	}

	public void setSender(String sender, String name) {
		requestData.put("from", sender);
		requestData.put("from_name", name);
	}

	public void setReply(String reply) {
		requestData.put("reply", reply);
	}

	public void addCc(String address, String name) {
		requestData.addWithBracket(CC, name, address);
	}

	public void addBcc(String address, String name) {
		requestData.addWithBracket(BCC, name, address);
	}

	public void setSubject(String subject) {
		requestData.put(SUBJECT, subject);
	}

	public void setText(String text) {
		requestData.put(TEXT, text);
	}
	
	public void setHtml(String html) {
		requestData.put(HTML, html);
	}
	
	public void addVar(String key, String val) {
		requestData.addWithJson(VARS, key, val);
	}
	
	public void addLink(String key, String val) {
		requestData.addWithJson(LINKS, key, val);
	}
	
	public void addAttachment(String file){
		requestData.addWithIncrease(ATTACHMENTS, new File(file));
	}
	
	public void addHeaders(String key, String val) {
		requestData.addWithJson(HEADERS, key, val);
	}
	
	@Override
	public ISender getSender() {
		return new Mail(this.config);
	}

	public void send(){
		getSender().send(requestData);
	}
}
