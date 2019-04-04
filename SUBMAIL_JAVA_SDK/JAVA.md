# SUBMAIL_JAVA_SDK
> ### 概览 
- jdk版本：jdk1.6及以上
- 代码编码格式：utf-8
- 需导入 json 包和 http 请求处理包

---
> ### 下载
[SUBMAIL_JAVA_SDK_AND_DEMOS](https://github.com/dev-submail/SUBMAIL-JAVA-SDK-AND-DEMOS)         [前往Github下载](https://github.com/dev-submail/SUBMAIL-JAVA-SDK-AND-DEMOS)

---

> ### 文件目录索引 

```
 Config包 --- 处理用户的配置信息 -----------------------------------------------------
     |
     |  --- AppConfig.java（所有配置类的父类） 
     |  --- MailConfig（邮件配置类）
     |  --- MessageConfig（短信配置类）
     |  --- VoiceConfig（语音配置类）
     |  --- InternationalsmsConfig（国际短信配置类）
     |  --- MMSConfig（彩信配置类）
  demo --- 示例代码 --------------------------------------------------
     |
     |  --- AddressbookMailSubscribeDemo.java
     |  --- AddressbookMailUnsubscribeDemo.java
     |  --- AddressbookMessageSubscribeDemo.java
     |  --- AddressbookMessageUnsubscribeDemo.java
     |  --- MessageSendDemo.java
     |  --- MessageXSendDemo.java
     |  --- MessageMultiXsendDemo.java
     |  --- MessageMultiSendDemo.java
     |  --- MessageTemplateDemo.java
     |  --- MessageLogDemo.java
     |  --- MessageBalanceDemo.java
     |  --- MailSendDemo.java
     |  --- MailXSendDemo.java
     |  --- MailBalanceDemo.java
     |  --- InternationalsmsSendDemo.java
     |  --- InternationalsmsXsendDemo.java
     |  --- InternationalsmsMultiXsendDemo.java
     |  --- VerifyphonenumberDemo.java
     |  --- VoiceSendDemo.java
     |  --- VoiceXSendDemo.java
     |  --- VoiceMultiXSendDemo.java
     |  --- VoiceVerifyDemo.java
     |  --- VoiceBalanceDemo.java
     |  --- MMSXSendDemo.java
     |  --- MMSMultiXSendDemo.java
  Entity 包 --- 实体类 --------------------------------------------------
     |  --- DataStore.java(封装请求数据)
  lib 包 --- SDK 资源目录 --------------------------------------------------
     |  --- ADDRESSBOOKMail.java
     |  --- ADDRESSBOOKMessage.java
     |  --- Message.java
     |  --- MessageSend.java
     |  --- MessageXSend.java
     |  --- MessageMultiXsend.java
     |  --- MessageMultiSend.java
     |  --- MessageTemplate.java
     |  --- MessageLog.java
     |  --- MessageBalance.java
     |  --- Mail.java
     |  --- MailSend.java
     |  --- MailXSend.java
     |  --- MailBalance.java
     |  --- Internationalsms.java
     |  --- InternationalsmsSend.java
     |  --- InternationalsmsXsend.java
     |  --- InternationalsmsMultiXsend.java
     |  --- Voice.java
     |  --- Verifyphonenumber.java
     |  --- VoiceSend.java
     |  --- VoiceXSend.java
     |  --- VoiceMultiXSend.java
     |  --- VoiceVerify.java
     |  --- VoiceBalance.java
     |  --- MMSXSend.java
     |  --- MMSMultiXSend.java
     base 包 --- 接口及 lib 父类包 --------------------------------------------------
       |  ---  Isender.java(接口，定义了 send,xsend,subscribe,unsubscribe等)
       |  ---  Sender.java(Mail 和 Message 等的父类)
       |  ---  SenderWapper.java(包装类，ADDRESSBOOKMail、ADDRESSBOOKMessage、MAILSend、MAILXSend、MESSAGEXsend等的父类)
       |  ----------------------------------------------------------
   Utils 包 --- 工具类 --------------------------------------------------    
      |  --- ConfigLoader.java(从配置文件中读取数据到配置对象)
      |  --- StringUtil.java(字符串的处理类)
      |  --- RequestEncoder.java(处理请求数据)
   配置文件 --------------------------------------------------    
      |  --- app_config.properties(邮件和短信配置数据)
   
       
```

---

> ### 类关系图
![image](https://www.mysubmail.com/libraries/zh_cn/images/eg/sdk-1.jpg)

---

>### 开始使用 
#### 引入jar包
	    
```
       commons-beanutils-1.7.0.jar
       commons-collections-3.2.1.jar
       commons-lang-2.3.jar
       commons-logging-1.1.1.jar
       ezmorph-1.0.3.jar
       json-lib-2.2.3-jdk15.jar
       org.apache.httpcomponents.httpclient_4.3.5.jar 
```

		

---
		
#### MailSend 类
##### 初始化: 
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
- MAILSend submail = new MAILSend(config);

**使用指引:**

方法 | 描述 
---|---
addTo | 添加邮件地址到 To 数组，第一个必选参数：邮件地址。第二个可选参数：收件人姓名
addAddressBook | 添加地址薄标识到 addressbook 数组
setSender | 设置发件人，第一个必选参数：邮件地址。第二个可选参数：显示名称
setReply | 设置回复地址
addCc | 添加抄送地址
addBcc | 添加密送地址
setSubject | 设置邮件标题
setText | 设置文本邮件内容
setHtml | 设置 HTML 邮件内容
addVar | 添加文本变量到 vars 数组
addLink | 添加超链接变量到 links 数组
addHeaders | 添加自定义邮件头指令到 headers 数组
addAttachment | 添加附件到 attachments 数组
addTag |  添加项目标记，此参数用于标记一次 API 请求（最大长度不超过 32 位）添加了 tag 参数的 API 请求，会在所有的 SUBHOOK 事件中携带此参数。
send | 发送邮件

**代码示列：**

```
使用 MailSend 类提交 mail/send 发送一封简单的邮件
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		MAILSend submail = new MAILSend(config);
//		submail.addTo("leo@submail.cn","leo");
		submail.addTo("leo@submail.cn","leo");
		submail.addCc("mailer@submail.cn", "");
		submail.addBcc("leo@drinkfans.com", "");
		submail.setSender("no-reply@submail.cn","SUBMAIL");
		submail.setReply("service@submail.cn");
		submail.setSubject("test SDK");
		submail.setText("test SDK text");
		submail.addAttachment("D:\\Program Files\\eclipse-php-luna-SR1-win32\\eclipse\\epl-v10.html");
		submail.setHtml("test SDK html @var(name),@var(age) <a href=\"var://@link(test)\">testLink</a> <a href=\"var://@link(test2)\">testLink2</a>");
		submail.addVar("name", "leo");
		submail.addVar("age", "32");
		submail.addLink("developer", "http://submail.cn/chs/developer");
		submail.addLink("store", "http://submail.cn/chs/store");
		submail.addHeaders("X-Accept", "zh-cn");
		submail.addHeaders("X-Mailer", "leo App");
		submail.send();

```

---

#### MailXSend
##### 初始化
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
- MAILXSend submail = new MAILXSend(config);

**使用指引:**

方法  | 描述 
---|---
addTo | 添加邮件地址到 To 数组，第一个必选参数：邮件地址。第二个可选参数：收件人姓名
setSender | 设置发件人，第一个必选参数：邮件地址。第二个可选参数：显示名称
setReply | 设置回复地址
addCc | 添加抄送地址
addBcc | 添加密送地址
setSubject | 设置邮件标题
setProject | 设置邮件项目标识
addVar | 添加文本变量到 vars 数组
addLink | 添加超链接变量到 links 数组
addHeaders | 添加自定义邮件头指令到 headers 数组
addAttachment | 添加附件到 attachments 数组
addTag |  添加项目标记，此参数用于标记一次 API 请求（最大长度不超过 32 位）添加了 tag 参数的 API 请求，会在所有的 SUBHOOK 事件中携带此参数。
getSender | 获取发送方式
xsend | 发送邮件

**代码示例:**

```
使用 MAILXsend 类提交 mail/xsend 发送一封邮件。

        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		MAILXSend submail = new MAILXSend(config);
		submail.addTo("leo@submail.cn","leo");
//		submail.setSender("no-reply@submail.cn","SUBMAIL");
		submail.setProject("uigGk1");
		submail.addVar("name", "leo");
		submail.addVar("age", "32");
		submail.addLink("developer", "http://submail.cn/chs/developer");
		submail.addLink("store", "http://submail.cn/chs/store");
		submail.addHeaders("X-Accept", "zh-cn");
		submail.addHeaders("X-Mailer", "leo App");
		submail.xsend();


```

---
#### MailBalance
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
- MessageBalance submail = new MessageBalance(config);

**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Mail);
		MailBalance submail = new MailBalance(config);
		System.out.println(submail.balance());
```

---

#### MessageSend 类
#### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
- MessageSend submail = new MessageSend(config);

**使用指引:**

方法  | 描述 
---|---
addTo | 添加手机联系人
addContent | 添加短信正文（传入的短信正文需要与模板匹配，匹配度为75%左右）
getSender | 获取发送方式
send | 发送短信

**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageSend submail = new MessageSend(config);
		submail.addTo("176****9");
		submail.addContent("【test2】你好，你的验证码是3373");
		submail.send();

```

---

#### MessageXSend 类
##### 初始化:
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
- MESSAGEXsend submail = new MESSAGEXsend(config);

**使用指引:**

方法  | 描述 
---|---
addTo | 添加手机联系人
setProject | 设置项目Id
addVar | 添加文本变量到 vars 数组
getSender | 获取发送方式
xsend | 发送短信

**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MESSAGEXsend submail = new MESSAGEXsend(config);
		submail.addTo("176XXXXXXX");
		submail.setProject("w3nla3");
		submail.addVar("code", "张三");
		submail.addVar("minue", "2289");
		String response=submail.xsend();
		System.out.println("接口返回数据："+response);
```

---

#### MessageMultiSend 类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
- MessageMultiSend submail = new MessageMultiSend(config);

**使用指引:**

方法  | 描述 
---|---
addContent | 添加群发文本，文本中可以设置动态变量。
addMulti| 设置多个发送对象信息
getSender	 | 获取发送方式
multiSend| 发送短信

**代码示列：**

```
      	AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageMultiSend submail = new MessageMultiSend(config);
		submail.addContent("【SUBMAIL】您好，您的验证码是@var(code),请在@var(time)分钟内输入");
		JSONObject json = new JSONObject();
		json.put("code", "1111");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("1760xxxx15149");

		JSONObject json2 = new JSONObject();
		json2.put("code", "2222");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("1822xxxx949");
		String response = submail.multixsend();
		System.out.println("接口返回消息:" + response);
```


---

#### MessageMultiXSend 类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
- MessageMultiSend submail = new MessageMultiSend(config);

**使用指引:**

方法  | 描述 
---|---
addProject | 设置项目Id
addMulti| 设置多个发送对象信息
getSender	 | 获取发送方式
multiXSend| 发送短信

**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageMultiSend submail = new MessageMultiSend(config);
		submail.addContent("【SUBMAIL】您好，您的验证码是@var(code),请在@var(time)分钟内输入");
		JSONObject json = new JSONObject();
		json.put("code", "1111");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("176xxxxx");

		JSONObject json2 = new JSONObject();
		json2.put("code", "2222");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("182xxxxx");
		String response = submail.multixsend();
		System.out.println("接口返回消息:" + response);
```


---

#### MessageTemplate 类

**使用指引:**

方法  | 描述 
---|---
getTemplateId | get方法获取模板信息时，传入模板id
putTemplateId| put请求，修改需要更新的模板id
putSmsTitle |  put请求，修改模板标题
putSmsSignature| put请求，修改短信模板签名
putSmsContent | put请求，修改短信模板正文
delTemplateId| Delete请求，传入需要删除的模板id
postSmsTitle | post请求，提交模板标题。
postSmSSignature| post请求，提交短信模板签名
postSmsContent| post请求，提交短信模板正文
getSender	 | 获取发送方式
getTemplate | 通过get获取短信模板信息
putTemplate	 | 通过put发送请求来修改已存在模板信息
delTemplate	 | 删除一个现有模板
postTemplate	 | 提交一个新的模板


**代码示列：**

```
   		//get方法
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageTemplate submail = new MessageTemplate(config);
//		submail.getTemplateId("w3nya3");
//		submail.getTemplate();

		//post方法
//		submail.postSmsTitle("张三");
//		submail.postSmsSignature("【测试短信】");
//		submail.postSmsContent("您好你的验证码是@var(code),请在1分钟之内完成输入");
//		submail.postTemplate();
		
		//put
		submail.putTemplateId("w3nya3");
		submail.putSmsTitle("张三");
		submail.putSmsSignature("【测试短信2】");
		submail.putSmsContent("您好你的验证码是@var(code),请在@var(minue)分钟之内完成输入");
		submail.putTemplate();
		
		//del
//		submail.delTemplateId("384hA1");
//		submail.delTemplate();
	

```

---

#### MessageLog类
##### 初始化：
MessageLog submail = new MessageLog(config);

**使用指引:**

方法  | 描述 
---|---
addRecipient | 添加联系人
addProject| 添加项目标识
addResult_status |  添加发送状态（delivered , dropped）
addStart_data| 添加日志查询的开始时间（使用 UNIX 时间戳格式）
addEnd_data | 添加日志查询的结束时间（使用 UNIX 时间戳格式）
addOrder_by| 添加返回数据时执行的升序或降序（asc or desc）
addRows | 添加单次返回数据的行数
addOffset| 添加数据偏移指针
getSender	 | 获取发送方式
log |发送请求获取短信日志


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
		MessageLog submail = new MessageLog(config);
		submail.setProject("project","w3nla3");
		submail.addStartDate("start_date",UnixStamp.date2TimeStamp("2017-08-12 00:00:00","yyyy-MM-dd HH:mm:ss"));
		submail.addEndDate("end_date",UnixStamp.date2TimeStamp("2017-11-13 00:00:00","yyyy-MM-dd HH:mm:ss"));
		String response=submail.log();
		System.out.println("接口返回数据："+response);

```

---

#### VoiceSend类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
- VoiceSend submail = new VoiceSend(config);


**使用指引:**

方法  | 描述 
---|---
addTo	 | 设值语音收件人手机号码
addContent| 设置语音发送正文
getSender	 | 获取发送方式
send| 发送语音


**代码示列：**

```
		AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceSend submail = new VoiceSend(config);
		submail.addTo("176****49");
		submail.addContent("欢迎来到中国，welcome to china");
		submail.send();
		System.out.println(submail.send());
```

---

#### VoiceXSend类
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
- VoiceXSend submail = new VoiceXSend(config);
**使用指引:**

方法  | 描述 
---|---
addTo	 | 设值语音收件人手机号码
addProject| 设置语音发送模板
addVar | 添加文本变量到 vars 数组
getSender	 | 获取发送方式
xsend| 发送语音


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceXSend submail = new VoiceXSend(config);
		submail.addTo("176*****49");
		submail.addProject("WZlIv3");
		submail.addVars("name","张三");
		submail.addVars("code","2244");
		submail.xsend();
```

---

#### VoiceMultiXSend类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
- VoiceMultiXSend submail = new VoiceMultiXSend(config);

**使用指引:**

方法  | 描述 
---|---
addProject| 设置语音发送模板
addMulti | 设置多个发送对象信息
getSender	 | 获取发送方式
multiXSend| 群发语音


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceMultiXSend submail = new VoiceMultiXSend(config);
		submail.addProject("g8crk1");
		JSONObject json=new JSONObject();
		json.put("name", "张三");
		json.put("code", "1123");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("+182XXXX040");
		
		JSONObject json2=new JSONObject();
		json2.put("name", "老江");
		json2.put("code", "11244");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("+1825XXXXX040");
		String response=submail.multixsend();
		System.out.println("接口返回消息:"+response);
```

---
#### VoiceVerify类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
- VoiceVerify submail = new VoiceVerify(config);

**使用指引:**

方法  | 描述 
---|---
addTo| 设置语音验证码接收用户的手机号码
addCode | 设置语音验证码内容
getSender	 | 获取发送方式
verify | 发送语音验证码


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Voice);
		VoiceVerify submail = new VoiceVerify(config);
		submail.addTo("176*****49");
		submail.addCode("3322");
		submail.verify();
```

---

#### InternationalSmsSend类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
- InternationalsmsSend submail = new InternationalsmsSend(config);

**使用指引:**

方法  | 描述 
---|---
addTo| 设置国际短信接收用户的手机号码
addContent | 设置国际短信正文内容
getSender	 | 获取发送方式
send | 发送短信


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsSend submail = new InternationalsmsSend(config);
		submail.addTo("+176*****49");
		submail.addContent("您的验证码是：3345");
		submail.send();
```
---

#### InternationalXSendSms类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
- InternationalsmsXSend submail = new InternationalsmsXSend(config);

**使用指引:**

方法  | 描述 
---|---
addTo| 设置国际短信接收用户的手机号码
addProject | 设置国际短信模板
addVar |   添加文本变量到 vars 数组
getSender	 | 获取发送方式
xsend | 发送短信


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsXSend submail = new InternationalsmsXSend(config);
		submail.addTo("+176****49");
		submail.addProject("w3nla3");
		submail.addVars("name","李四");
		submail.addVars("code","2299");
		submail.xsend();
```

---

#### InternationalSmsMultiXSend类
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
- InternationalsmsMultiXSend submail = new InternationalsmsMultiXSend(config);

**使用指引:**

方法  | 描述 
---|---
addProject | 设置国际短信模板
addMulti |   设置多个发送对象信息
getSender	 | 获取发送方式
multiXSend | 发送短信


**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Internationalsms);
		InternationalsmsMultiXSend submail = new InternationalsmsMultiXSend(config);
		submail.addProject("g8crk1");
		JSONObject json=new JSONObject();
		json.put("name", "张三");
		json.put("code", "1123");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("+1825xxxx2040");
		
		JSONObject json2=new JSONObject();
		json2.put("name", "老江");
		json2.put("code", "11244");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("+182xxxx12040");
		String response=submail.multixsend();
		System.out.println("接口返回消息:"+response);
```

---

#### MMSXSend 类
##### 初始化:
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
- MMSXSend submail = new MMSXSend(config);
**使用指引:**

方法  | 描述 
---|---
addTo | 添加手机联系人
setProject | 设置项目Id
addVar | 添加文本变量到 vars 数组
getSender | 获取发送方式
xsend | 发送短信

**代码示列：**

```
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
		MMSXSend submail = new MMSXSend(config);
		submail.addTo("176XXXXX");
		submail.setProject("XXX");
		submail.addVar("code", "张三");
		submail.addVar("minue", "2289");
		String response=submail.xsend();
		System.out.println("接口返回数据："+response);
```
---

#### MMSMutilXSend 类
##### 初始化：
- AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
- MMSMultiSend submail = new MMSMultiSend(config);

**使用指引:**

方法  | 描述 
---|---
setProject | 设置群发短信模板。
addMulti| 设置多个发送对象信息
getSender	 | 获取发送方式
multiSend| 发送短信

**代码示列：**

```
      	AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.MMS);
		MMSMultiSend submail = new MMSMultiSend(config);
		submail.setProject(xxx);
		JSONObject json = new JSONObject();
		json.put("code", "1111");
		json.put("time", "1分钟");
		submail.addVars(json);
		submail.addMulti("1760xxxx15149");

		JSONObject json2 = new JSONObject();
		json2.put("code", "2222");
		json2.put("time", "1分钟");
		submail.addVars(json2);
		submail.addMulti("1822xxxx949");
		String response = submail.multixsend();
		System.out.println("接口返回消息:" + response);
```


---



具体参数参数传入请参考我们的开发文档：[点击跳转](https://www.mysubmail.com/chs/documents/developer/index)

