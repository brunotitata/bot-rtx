package com.kabum.application;

import com.amazonaws.services.sns.model.PublishResult;

public interface AwsServicePort {

	public PublishResult notificar(String number, String messageBody);

}
