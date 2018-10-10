package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;

/**
 * mobiledata/TOservice 是 SUBMAIL 的手机号码运营商分类 API，
 * 通过 API 请求可将传入的手机号码或地址薄中的号码按照运营商（移动，联通，电信）进行分类，
 * 并返回分类后的号码集合
 * @author submail
 *
 */
public class MobiledataTOservice extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String ADDRESSBOOK = "addressbook";
	
    public MobiledataTOservice(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String to) {
		requestData.addWithComma(TO, to);;
	}
	
	public void addAddressbook(String addressbook){
		requestData.addWithComma(ADDRESSBOOK, addressbook);
	}

	
	@Override
	public ISender getSender() {
		return new Mobiledata(this.config);
	}

	public String TOservice (){
		return getSender().toService(requestData);
	}
	
	
}
	
	
	
	


