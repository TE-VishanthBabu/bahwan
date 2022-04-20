package com.bahwan.serversocket.client;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.bahwan.serversocket.model.User;

public class ClientRegisterHandler extends StompSessionHandlerAdapter {

	@Override
	public Type getPayloadType(StompHeaders headers) {  /*payloadtype specifies type of messsage
			 											which is handled by the handler*/
		return User.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) { 
		// TODO Auto-generated method stub
		System.out.println("The User Id is " + ((User) payload).getId());
	}
}

