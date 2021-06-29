package com.kabum.adapter.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.kabum.application.NotificationServicePort;

@Component
public class AwsServiceAdapter implements NotificationServicePort{

	private final AmazonSNS amazonSNS;

	public AwsServiceAdapter(AmazonSNS amazonSNS) {
		this.amazonSNS = amazonSNS;
	}

	@Override
	public void notificar(String number, String messageBody) {

		Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
		smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue().withStringValue("Promotional").withDataType("String"));

		PublishRequest request = new PublishRequest();
		request.withMessage(messageBody).withPhoneNumber("+55".concat(number)).withMessageAttributes(smsAttributes);

		amazonSNS.publish(request);
	}

}
