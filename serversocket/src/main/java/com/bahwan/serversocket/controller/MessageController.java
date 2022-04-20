package com.bahwan.serversocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.bahwan.serversocket.model.IncomingMessage;
import com.bahwan.serversocket.model.OutgoingMessage;

@RestController
public class MessageController {

	@MessageMapping("/register") // /application/register
	@SendTo("/main/register")
	public int register(int id) {
		return id;
	}

	@MessageMapping("/process-messages") // /application/process-message
	@SendTo("/main/messages")
	public OutgoingMessage getContent(IncomingMessage incomingMessage) {
		System.out.println(incomingMessage.getId());
		return new OutgoingMessage(incomingMessage.getId(), " " + incomingMessage.getName());
	}

}

