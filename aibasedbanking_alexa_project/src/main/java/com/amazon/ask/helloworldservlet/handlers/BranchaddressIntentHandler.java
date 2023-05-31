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

public class BranchaddressIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("BranchaddressIntent"));	
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Branch Address Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot branchnameSlot = slots.get("branchname");
		String branchname = branchnameSlot.getValue();

		System.out.println("Information about : " + branchname);

		Database database = new Database();
		String speechText = "", repromptText = "";
		
		
		if (branchname != null && !branchname.isEmpty()) {
			List ls11 = database.searchBranchAddress(branchname);
			System.out.println(ls11.size());
			speechText = String.format(
					"Our Bank SBI - " + branchname + " Branch . Address of it is "
							+ ls11.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
							+ "I want information about Account / Area /Forms / Loan");
			repromptText = "Our Bank SBI - " + branchname + " Branch . Address of it is "
					+ ls11.get(0) + ". Okay, If you want to know other information then Continue by Saying, "
					+ "I want information about Account / Area /Forms / Loan";
		} else {

			speechText = "Sorry we don't have these type of Branch ,"
					+ ",You can ask me by saying," 
					+ "I want information about Account / Area /Forms / Loan ";
		}

		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("Success...", speechText)
				.withShouldEndSession(false)
				.build();

	}

}
