package lib;

import java.io.File;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;
/**
 * mobiledata/charge 是 SUBMAIL 的手机流量充值 API。
 * @author submail
 *
 */
public class MobiledataCharge extends SenderWapper{
	
	protected AppConfig config = null;
	public static final String TO = "to";
	public static final String ADDRESSBOOK = "addressbook";
	public static final String CM = "cm";
	public static final String CU = "cu";
	public static final String CT = "ct";
	
    public MobiledataCharge(AppConfig config) {
		
		this.config = config;
		
	}
	
	public void addTo(String to) {
		requestData.addWithComma(TO, to);;
	}
	
	public void addAddressbook(String addressbook){
		requestData.addWithComma(ADDRESSBOOK, addressbook);
	}

	public void addCm(String to) {
		requestData.addWithComma(CM, to);;
	}
	
	public void addCu(String to) {
		requestData.addWithComma(CU, to);;
	}
	
	public void addCt(String to) {
		requestData.addWithComma(CT, to);;
	}
	@Override
	public ISender getSender() {
		return new Mobiledata(this.config);
	}

	public String charge (){
		return getSender().charge(requestData);
	}
	
	
}
	
	
	
	


