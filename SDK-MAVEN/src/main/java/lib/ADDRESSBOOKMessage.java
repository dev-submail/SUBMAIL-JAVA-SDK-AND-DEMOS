package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * 短信地址薄 API
 * @author submail
 *
 */
public class ADDRESSBOOKMessage extends SenderWapper {

	/**
	 *短信模式  {@link MessageConfig}
	 */
	protected AppConfig config = null;
	public static final String ADDRESS = "address";
	public static final String TARGET = "target";

	public ADDRESSBOOKMessage(AppConfig config) {
		this.config = config;
	}
	
	public void setAddress(String address){
		requestData.put(ADDRESS, address);
	}
	
	public void setAddressbook(String target){
		requestData.put(TARGET, target);
	}
	@Override
	public ISender getSender() {
		return new Message(this.config);
	}
	
	public String subscribe(){
		return getSender().subscribe(requestData);
	}
	
	public String unsubscribe(){
		return getSender().unsubscribe(requestData);
	}
}
