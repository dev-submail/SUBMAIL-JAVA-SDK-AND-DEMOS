package utils;

import java.io.IOException;
import java.util.Properties;

import config.AppConfig;
import config.InternationalsmsConfig;
import config.MailConfig;
import config.MessageConfig;
import config.MobiledataConfig;
import config.VoiceConfig;

/**
 * 这个类通过加载app_config.properties文件创建配置对象并获取值，包括创建
 * MailConfig，MessageConfig，VoiceConfig,InternationalsmsConfig,MobiledataConfig
 * @see AppConfig
 * @see MailConfig
 * @see MessageConfig
 * @see VoiceConfig
 * @see InternationalsmsConfig
 * @see MobiledataConfig
 * @author submail
 *
 */
public class ConfigLoader {

	private static Properties pros = null;
	/**
	 * 加载文件时，类载入，静态块内部的操作将被运行一次
	 * */
	static {
		pros = new Properties();
		try {
			pros.load(ConfigLoader.class
					.getResourceAsStream("/app_config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * enum define two kinds of configuration.
	 * */
	public static enum ConfigType {
		Mail, Message,Voice,Internationalsms,Mobiledata
	};

	/**
	 * 外部类的静态方法，可以通过加载文件创建配置。
	 * 
	 * @param type
	 *            ConfigType
	 * @return If the type is ConfigType#Mail,return the instance of
	 *         {@link MailConfig}. And,if the type is ConfigType#Message,return
	 *         the instance of {@link MessageConfig}.
	 * */
	public static AppConfig load(ConfigType type) {
		switch (type) {
		case Mail:
			return createMailConfig();
		case Message:
			return createMessageConfig();
		case Voice:
			return createVoiceConfig();
		case Internationalsms:
			return createInternationalsmsConfig();
		case Mobiledata:
			return createMobiledataConfig();
		default:
			return null;
		}
	}

	private static AppConfig createMailConfig() {
		AppConfig config = new MailConfig();
		config.setAppId(pros.getProperty(MailConfig.APP_ID));
		config.setAppKey(pros.getProperty(MailConfig.APP_KEY));
		config.setSignType(pros.getProperty(MailConfig.APP_SIGNTYPE));
		return config;
	}

	private static AppConfig createMessageConfig() {
		AppConfig config = new MessageConfig();
		config.setAppId(pros.getProperty(MessageConfig.APP_ID));
		config.setAppKey(pros.getProperty(MessageConfig.APP_KEY));
		config.setSignType(pros.getProperty(MessageConfig.APP_SIGNTYPE));
		return config;
	}
	
	private static AppConfig createVoiceConfig() {
		AppConfig config = new VoiceConfig();
		config.setAppId(pros.getProperty(VoiceConfig.APP_ID));
		config.setAppKey(pros.getProperty(VoiceConfig.APP_KEY));
		config.setSignType(pros.getProperty(VoiceConfig.APP_SIGNTYPE));
		return config;
	}
	
	private static AppConfig createInternationalsmsConfig() {
		AppConfig config = new InternationalsmsConfig();
		config.setAppId(pros.getProperty(InternationalsmsConfig.APP_ID));
		config.setAppKey(pros.getProperty(InternationalsmsConfig.APP_KEY));
		config.setSignType(pros.getProperty(InternationalsmsConfig.APP_SIGNTYPE));
		return config;
	}
	
	private static AppConfig createMobiledataConfig() {
		AppConfig config = new MobiledataConfig();
		config.setAppId(pros.getProperty(MobiledataConfig.APP_ID));
		config.setAppKey(pros.getProperty(MobiledataConfig.APP_KEY));
		config.setSignType(pros.getProperty(MobiledataConfig.APP_SIGNTYPE));
		return config;
	}

}
