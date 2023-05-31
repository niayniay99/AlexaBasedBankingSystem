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

public class LoantypeIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("LoantypeIntent"));	
		
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Loan Type Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot loantypeSlot = slots.get("loantype");
		String loantype = loantypeSlot.getValue();

		System.out.println("Information about : " + loantype);

		Database database = new Database();
		String speechText = "", repromptText = "";

		if (loantype != null && !loantype.isEmpty()) {
			List loantypels = database.searchLoanid(loantype);
			int loantypeid = (int) loantypels.get(0);

			System.out.println("loantypeid: "+loantypeid);
			List ls6 = database.searchLoantypedescription(loantypeid);
			
			speechText = String.format(
					" It's Great our Bank offer's the Best facility on " + loantype + " Loan. Details of it is "
							+ ls6.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
							+ "I want information about Account / Area /Forms / Loan");
			repromptText = " It's Great our Bank offer's the Best facility on " + loantype + " Loan. Details of it is "
					+ ls6.get(0) + ". Okay, If you want to know other information then Continue bye Saying, "
					+ "I want information about Account / Area /Forms / Loan";

		}
		
		else {

			List ls5 = database.searchLoantype();
			String speech5 = "";
			for (int i = 0; i < ls5.size(); i++) {
				speech5 = speech5 + " Loan, " + (String) ls5.get(i);
			}

			speechText = "Sorry we don't have these type of Loan , Currently Oprational" + " Loans are " + speech5
					+ " Loan, " + "You can ask me by saying,'Details About " + ls5.get(0) + "'.";
		}

		return arg0.getResponseBuilder().withSpeech(speechText).withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();
	}

}
