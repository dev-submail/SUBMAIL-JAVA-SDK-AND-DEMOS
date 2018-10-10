package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;

public class MailBalance extends SenderWapper {

	protected AppConfig config = null;

	public MailBalance(AppConfig config) {
		this.config = config;
	}

	@Override
	public ISender getSender() {
		return new Mail(this.config);
	}

	public String balance() {
		return getSender().balance(requestData);
	}

}
