package lib;

import config.AppConfig;
import lib.base.ISender;
import lib.base.SenderWapper;

public class VoiceBalance extends SenderWapper {
	protected AppConfig config = null;

	public VoiceBalance(AppConfig config) {
		this.config = config;
	}

	@Override
	public ISender getSender() {
		return new Voice(this.config);
	}

	public String balance() {
		return getSender().balance(requestData);
	}

}
