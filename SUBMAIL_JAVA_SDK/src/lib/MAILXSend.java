package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 *mail/xsend 提供强大的邮件发送功能，区别于 mail/send API，mail/xsend 无需提交 html 源码或邮件文本内容，
 *甚至无需提交邮件标题或发件人，仅需提交你在 SUBMAIL MAIL 应用程序中创建的邮件项目的标记（ID），
 *并可以使用变量动态的控制每封邮件的内容。 了解如何使用文本变量和超链接变量。
 * @author submail
 *
 */
public class MAILXSend extends SenderWapper {

	/**
	 * mail模式{@link MailConfig}
	 */
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String ADDRESSBOOK = "addressbook";
	public static final String FROM = "from";
	public static final String FROM_NAME = "from_name";
	public static final String REPLY = "reply";
	public static final String CC = "cc";
	public static final String BCC = "bcc";
	public static final String SUBJECT = "subject";
	public static final String PROJECT = "project";
	public static final String VARS = "vars";
	public static final String LINKS = "links";
	public static final String HEADERS = "headers";

	public MAILXSend(AppConfig config) {
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

	public void setProject(String project) {
		requestData.put(PROJECT, project);
	}

	public void addVar(String key, String val) {
		requestData.addWithJson(VARS, key, val);
	}
	
	public void addLink(String key, String val) {
		requestData.addWithJson(LINKS, key, val);
	}
	
	public void addHeaders(String key, String val) {
		requestData.addWithJson(HEADERS, key, val);
	}
	@Override
	public ISender getSender() {
		return new Mail(this.config);
	}

	public String xsend(){
		return getSender().xsend(requestData);
	}
}
