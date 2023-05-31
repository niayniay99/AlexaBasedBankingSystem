package com.amazon.ask.helloworldservlet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.helloworld_dao.Database;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

public class LoginIntentHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("LoginIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::LoginIntent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest)request;
		Intent intent = intentRequest.getIntent();
		Map<String,Slot> slots =intent.getSlots();
	
		Slot pinSlot = slots.get("pin");
		String pin = pinSlot.getValue();
		
		System.out.println("PIN : "+pin);

		Database database = new Database();

		List ls1 = database.searchPin(pin);

		String speech1="";
		String speechText ="";
		for (int i = 0; i < ls1.size(); i++) {
			if(i==0){
				speech1 = (String)ls1.get(0);
				speechText = 
						String.format("Welcome "+ speech1 + " How may I help you Sir ?"
						+ ", You can ask me by saying,"
						+ "I want information about Account / Area /Forms / Loan");
			}else{
				speech1 = "Error Please try again by saying, My pin is 1234";
				speechText = speech1;
			}
		}
		System.out.println("Name: "+speech1);
		
		String repromptText = speechText;
		
		System.out.println(":::::::::RegistrationIntent end::::::::::::");
	
		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...",speechText)
				.build();
	}

}
