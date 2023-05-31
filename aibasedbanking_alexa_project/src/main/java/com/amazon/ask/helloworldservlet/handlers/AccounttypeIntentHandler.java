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

public class AccounttypeIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AccounttypeIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Account Type Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot accounttypeSlot = slots.get("accounttype");
		String accounttype = accounttypeSlot.getValue();

		System.out.println("Information about : " + accounttype);

		Database database = new Database();
		String speechText = "", repromptText = "";

		if (accounttype != null && !accounttype.isEmpty()) {
			List ls3 = database.searchAccountdescription(accounttype);

			speechText = String.format(
					" It's Great our Bank offer's the Best facility on " + accounttype + " Account. Details of it is "
							+ ls3.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
							+ "I want information about Account / Area /Forms / Loan");
			repromptText = " It's Great our Bank offer's the Best facility on " + accounttype + " Account. Details of it is "
					+ ls3.get(0) + ". Okay, If you want to know other information then Continue bye Saying, "
					+ "I want information about Account / Area /Forms / Loan";
		} else {

			List ls2 = database.searchAccounttype();
			String speech2 = "";
			for (int i = 0; i < ls2.size(); i++) {
				speech2 = speech2 + " Account, " + (String) ls2.get(i);
			}

			speechText = "Sorry we don't have these type of Account , Currently Operational" + " accounts are " + speech2
					+ ", " + "You can ask me by saying,'Details About " + ls2.get(0) + "'.";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
