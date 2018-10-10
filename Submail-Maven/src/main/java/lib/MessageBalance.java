package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;

public class MessageBalance extends SenderWapper {

	protected AppConfig config = null;

	public MessageBalance(AppConfig config) {
		this.config = config;
	}

	@Override
	public ISender getSender() {
		return new Message(this.config);
	}

	public String balance() {
		return getSender().balance(requestData);
	}

}
