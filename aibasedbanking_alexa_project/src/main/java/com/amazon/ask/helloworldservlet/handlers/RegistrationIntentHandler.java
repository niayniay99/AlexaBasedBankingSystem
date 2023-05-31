package com.amazon.ask.helloworldservlet.handlers;

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

import static com.amazon.ask.request.Predicates.intentName;
public class RegistrationIntentHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {		
		return input.matches(intentName("RegistrationIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		
		System.out.println(":::::::::RegistrationIntent start::::::::::::");
			Request request = arg0.getRequestEnvelope().getRequest();
			IntentRequest intentRequest = (IntentRequest)request;
			Intent intent = intentRequest.getIntent();
			Map<String,Slot> slots =intent.getSlots();
			
			Slot firstNameSlot = slots.get("firstname");
			Slot lastNameSlot = slots.get("lastname");
			
			String firstName = firstNameSlot.getValue();
			String lastName = lastNameSlot.getValue();
			
			System.out.println("firstName : "+firstName);
			System.out.println("lastName : "+lastName);
			Database database = new Database();
			database.insert(firstName,lastName);
			
			List ls = database.search(firstName);
			
			String speech="";
			for (int i = 0; i < ls.size(); i++) {
				if(i==0){
					speech = (String)ls.get(0);
				}else{
					speech = speech+", "+(String)ls.get(i);
				}
			}
			System.out.println("Data: "+speech);
			String speechText = 
					String.format("You have registered successfully details are "+ speech +" You can Login by saying me, My pin is 1234 ");
			String repromptText = 
					"You have registered successfully";
		
			System.out.println(":::::::::RegistrationIntent end::::::::::::");
			
		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...",speechText)
				.build();
	}

}
