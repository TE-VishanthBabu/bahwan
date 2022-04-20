package com.bahwan.clientconnect;

import java.lang.reflect.Type;

import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import com.bahwan.clientconnect.model.User;

public class ClientRegisterHandler extends StompSessionHandlerAdapter {

	@Override
	public Type getPayloadType(StompHeaders headers) {
		return User.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		System.out.println("The User Id is " + ((User) payload).getId());
	}
}
