package com.pib.util;

import java.io.IOException;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import com.pib.property.exception.ShortMessageException;
import com.pib.property.log.LogUtil;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortMessageUtil {

	@Value("${core.sms.apiKey:d9d0280d}")
	private String apiKey;

	@Value("${core.sms.apiSecret:J1FhfNKOB4GxqziC}")
	private String apiSecret ;

	@Value("${core.sms.from:13123400543}")
	private String from ;

	public  void sendByThread(String phone, String content) {
		ThreadUtil.run(() -> {
			try {
				boolean send = sendByNexmo(phone, content);
				if (!send) {
					throw new ShortMessageException("\t\t\t\t\t\t\t\t目标为：" + phone + ", 内容：" + content);
				}
			} catch (IOException | ShortMessageException |NexmoClientException| NullPointerException | IndexOutOfBoundsException e) {
				LogUtil.debug(e);
				LogUtil.error("\t\t\t\t\t\t\t\t目标为：" + phone + ", 内容：" + content);
			}
		});
	}
	
	public  boolean send(String phone, String content) throws ShortMessageException {
		try {
			return sendByNexmo(phone, content);
		} catch (NexmoClientException|IOException e) {
			LogUtil.debug(e);
			throw new ShortMessageException("\t\t\t\t\t\t\t\t目标为：" + phone + ", 内容：" + content);
		}
	}

	public  boolean sendByNexmo(String phone, String content) throws IOException, NexmoClientException {
		NexmoClient client = new NexmoClient.Builder()
				.apiKey(apiKey)
				.apiSecret(apiSecret)
				.build();
		TextMessage textMessage = new TextMessage(from,phone,content);
		SmsSubmissionResponse response = client.getSmsClient().submitMessage(textMessage);
		for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
			 if(responseMessage.getStatus()!= MessageStatus.OK){
			 	LogUtil.error("发送短信失败: "+responseMessage);
			 	return false;
			 }
		}
		return true;
	}
}