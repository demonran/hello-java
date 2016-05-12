package com.tcl.helloworld.mqs;

import com.aliyun.mqs.client.CloudQueue;
import com.aliyun.mqs.client.DefaultMQSClient;
import com.aliyun.mqs.client.MQSClient;
import com.aliyun.mqs.model.Message;

public class MqsHello
{
	public static void main(String[] args)
	{
		MQSClient mqsClient = new DefaultMQSClient("", "", "");
		
		CloudQueue queueRef = mqsClient.getQueueRef("");
		
		Message popMessage = queueRef.popMessage();
	}
}
