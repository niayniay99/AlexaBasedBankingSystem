package com.amazon.ask.helloworldservlet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.helloworld_dao.Database;
import com.amazon.ask.model.Response;

public class AreaIntentHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AreaIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::AreaIntent start::::::::::::");
		Database database = new Database();

		List ls7 = database.searchAreaname();
		
		String speech7 = "";
		String speechText = "", repromptText = "";
		if (ls7.size() > 0) {
			for (int i = 0; i < ls7.size(); i++) {
				speech7 = speech7 + " Area, " + (String) ls7.get(i);
			}
			speechText = String.format("Our Services are availabe at Various area available such as " + speech7 + " Area. "
					+ "You can ask me by saying," + "'Details About " + ls7.get(0) + "' Area.");

			repromptText = "You can ask me by saying,' Get me Details About " + ls7.get(0) + "' Area.";
		} else {
			speechText = "Sorry,You can ask me by saying," + "I want information about Account / Area /Forms / Loan";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();

	}

}
