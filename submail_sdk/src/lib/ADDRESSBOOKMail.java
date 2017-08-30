package lib;

import lib.base.ISender;
import lib.base.SenderWapper;
import config.AppConfig;
import config.MailConfig;
import config.MessageConfig;

/**
 * 邮件地址薄 API
 * @author submail
 *
 */
public class ADDRESSBOOKMail extends SenderWapper {

	/**
	 * mail模式{@link MailConfig}
	 */
	protected AppConfig config = null;
	public static final String ADDRESS = "address";
	public static final String TARGET = "target";

	public ADDRESSBOOKMail(AppConfig config) {
		this.config = config;
	}
	
	public void setAddress(String address, String name){
		requestData.put(ADDRESS, name + "<" + address + ">");
	}
	
	public void setAddressbook(String target){
		requestData.put(TARGET, target);
	}
	@Override
	public ISender getSender() {
		return new Mail(this.config);
	}
	
	public void subscribe(){
		getSender().subscribe(requestData);
	}
	
	public void unsubscribe(){
		getSender().unsubscribe(requestData);
	}
}
