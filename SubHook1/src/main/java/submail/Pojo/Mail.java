package submail.Pojo;

public class Mail{
	private String events ;
    private String email;
    private String app;
    private String send_id;
    private String tag;
    private String timestamp;
    private String token;
    private String signature;  
    private String message_id;
    private String reason;
    private String ip;
    private String agent;
    private String platform;
    private String device;
    private String country_code;
    private String country;
    private String province; 
    private String city;
    private String latitude;
    private String longitude;
    private String url;
    private String new_email;
	public String getEvents() {
		return events;
	}
	public void setEvents(String events) {
		this.events = events;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNew_email() {
		return new_email;
	}
	public void setNew_email(String new_email) {
		this.new_email = new_email;
	}
	@Override
	public String toString() {
		return "Mail [events=" + events + ", email=" + email + ", app=" + app + ", send_id=" + send_id + ", tag=" + tag
				+ ", timestamp=" + timestamp + ", token=" + token + ", signature=" + signature + ", message_id="
				+ message_id + ", reason=" + reason + ", ip=" + ip + ", agent=" + agent + ", platform=" + platform
				+ ", device=" + device + ", country_code=" + country_code + ", country=" + country + ", province="
				+ province + ", city=" + city + ", latitude=" + latitude + ", longitude=" + longitude + ", url=" + url
				+ ", new_email=" + new_email + "]";
	}
	

}
