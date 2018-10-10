package config;

/**
 * MailConfig 与 MessageConfig 的父类
 * @author submail
 *
 */
public class AppConfig {
	/**
	 * 由用户提供的appId作为签名的一部分
	 * */
	protected String appId = null;
	/**
	 * 由用户提供的appKey作为签名的一部分
	 * */
	protected String appKey = null;
	/**
	 * Assign the type for encryption. md5:by md5 algorithm.If by this
	 * algorithm,the format of signature is md5({@link #appId}{@link #appKey}
	 * <variable>RequestData</variable>{@link #appId}{@link #appKey}); sha1:by
	 * sha1 algorithm. normal:use the the value of {@link #appKey} without no
	 * algorithm.It also the default value.
	 * */
	protected String signType = null;
	/**
	 * Three kind of value of {@link #signType}
	 * */
	public static final String TYPE_NORMAL = "normal";
	public static final String TYPE_MD5 = "md5";
	public static final String TYPE_SHA1 = "sha1";

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * The method to get the {@link #signType}.It the value from the properties
	 * file is not valid,return normal.Otherwise,return the current value.
	 * 
	 * @return signType that is valid.
	 * */
	public String getSignType() {
		if (this.checkType(this.signType)) {
			return this.signType;
		}
		return TYPE_NORMAL;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	/**
	 * Judge the value of {@link #signType} is valid or not.
	 * 
	 * @param signType
	 * @return If the value is inside of {@value #TYPE_MD5},{@value #TYPE_SHA1}
	 *         and {@value #TYPE_NORMAL}, return true,otherwise return false;
	 * */
	private boolean checkType(String signType) {
		return TYPE_NORMAL.equals(signType) || TYPE_MD5.equals(signType)
				|| TYPE_SHA1.equals(signType);
	}
}
