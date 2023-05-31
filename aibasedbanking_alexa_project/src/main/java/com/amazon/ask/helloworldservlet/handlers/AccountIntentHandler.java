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

public class AccountIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AccountIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::AccountIntent start::::::::::::");
		Database database = new Database();

		List ls2 = database.searchAccounttype();
		
		String speech2 = "";
		String speechText = "", repromptText = "";
		if (ls2.size() > 0) {
			for (int i = 0; i < ls2.size(); i++) {
				speech2 = speech2 + " Account, " + (String) ls2.get(i);
			}
			speechText = String.format("There Are Various account available such as " + speech2 + " Account. "
					+ "You can ask me by saying," + "'Details About " + ls2.get(0) + "' Account.");

			repromptText = "You can ask me by saying,' Get me Details About " + ls2.get(0) + "'.";
		} else {
			speechText = "Sorry,You can ask me by saying," + "I want information about Account / Area /Forms / Loan";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
