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

public class AreadescIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AreadescIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Loan Type Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot areanameSlot = slots.get("areaname");
		String areaname = areanameSlot.getValue();

		System.out.println("Information about : " + areaname);

		Database database = new Database();
		String speechText = "", repromptText = "";

		if (areaname != null && !areaname.isEmpty()) {
			List ls8 = database.searchAreadescription(areaname);

			speechText = String.format(
					" The area you selected is " + areaname + " Area . Details of it is "
							+ ls8.get(0) + ". Okay, If you want to know about branch information in "+ areaname 
							+" then Continue by Saying, "
							+ "I want information about the branches in "+areaname);
			repromptText = " The area " + areaname + " Area . Details of it is "
					+ ls8.get(0) + ". Okay, If you want to know about branch information in "+ areaname 
					+" then Continue by Saying, "
					+ "I want information about the branch in "+areaname;
		}
		else {

			List ls7 = database.searchAreaname();
			String speech7 = "";
			for (int i = 0; i < ls7.size(); i++) {
				speech7 = speech7 + " Area, " + (String) ls7.get(i);
			}
			speechText = "Sorry we are not available in these type of area , Currently we are Operational in " 
						+ " area are " + speech7
						+ "Area , " + "You can ask me by saying,'Details About " + ls7.get(0) + "' Area.";

		}
		
		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();

}}
