package com.amazon.ask.helloworldservlet.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.List;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.helloworld_dao.Database;
import com.amazon.ask.model.Response;

public class LoanIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("LoanIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::LoanIntent start::::::::::::");
		Database database = new Database();
		
		List ls4 = database.searchLoantype();
		
		String speech4 = "";
		String speechText = "", repromptText = "";
		if (ls4.size() > 0) {
			for (int i = 0; i < ls4.size(); i++) {
				speech4 = speech4 + " Loan, " + (String) ls4.get(i);
			}
			speechText = String.format("There Are Various loan available such as " + speech4 + " Loan. "
					+ "You can ask me by saying," + "' Get me Details About " + ls4.get(0) + "' Loan.");

			repromptText = "You can ask me by saying,' Get me Details About " + ls4.get(0) + "' Loan.";
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
