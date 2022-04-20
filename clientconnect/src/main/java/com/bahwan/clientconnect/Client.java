package com.bahwan.clientconnect;

import java.lang.reflect.Type;
import java.util.Random;
import java.util.Scanner;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.bahwan.clientconnect.model.IncomingMessage;
import com.bahwan.clientconnect.model.OutgoingMessage;

public class Client {
	static int userId;

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			WebSocketClient standardWebSocketClient = new StandardWebSocketClient();
			WebSocketStompClient webSocketStompClient = new WebSocketStompClient(standardWebSocketClient);
			//A STOMP over WebSocket client that connects using an implementation of WebSocketClient including SockJsClient
			
			webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());

			ClientMessgeHandler client1MessgeHandler = new ClientMessgeHandler();
			ClientRegisterHandler clientRegisterHandler = new ClientRegisterHandler();
			
			ListenableFuture<StompSession> sessionAsync = webSocketStompClient.connect("ws://localhost:8080/server",
					client1MessgeHandler);
			StompSession session = sessionAsync.get();
			
			session.subscribe("/main/messages", client1MessgeHandler);
			session.subscribe("/main/register", clientRegisterHandler);
			OutgoingMessage outgoingMessge = new OutgoingMessage();
			Thread.sleep(2000);
			Random random = new Random();
			int nextInt = random.nextInt(20);
			Client client1 = new Client();
			client1.userId = nextInt;
			session.send("/application/register", nextInt);
			outgoingMessge.setId(1);
			Thread.sleep(3000);
			while (outgoingMessge.getId() != 0) {
				System.out.println("Enter the Id");
				int id = scanner.nextInt();
				outgoingMessge.setId(id);
				System.out.println("Enter the message");
				// http call
				outgoingMessge.setContent(scanner.next());
				session.send("/application/process-messages", new IncomingMessage(id, outgoingMessge.getContent()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ClientMessgeHandler extends StompSessionHandlerAdapter {

	@Override
	public Type getPayloadType(StompHeaders headers) {
		// TODO Auto-generated method stub
		return OutgoingMessage.class;
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		// TODO Auto-generated method stub
		if (((OutgoingMessage) payload).getId() == Client.userId) {
			System.out.println("received message" + ((OutgoingMessage) payload).getContent());
		}
	}
}
