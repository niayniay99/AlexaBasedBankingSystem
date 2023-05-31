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

public class BranchIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("BranchIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput arg0) {
		System.out.println(":::::::::Branch Intent start::::::::::::");
		Request request = arg0.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot areanameSlot = slots.get("areaname");
		String areaname = areanameSlot.getValue();

		System.out.println("Information about : " + areaname);
		String speechText = "", repromptText = "";
		Database database = new Database();
		if (areaname != null && !areaname.isEmpty()) {
			List ls9 = database.searchAreaid(areaname);
			System.out.println(ls9.size());
			String areaid = (String) ls9.get(0);
			int AreaID = Integer.parseInt(areaid);
			System.out.println(areaid);
			List ls10 = database.searchBranch(AreaID);
			
			String speech10 = "";
			
			if (ls10.size() > 0) {
				for (int i = 0; i < ls10.size(); i++) {
					speech10 = speech10 + " Branch, " + (String) ls10.get(i);
				}
			speechText = String.format("Our banks are available in "+areaname
					+"area. Branches at various loactions are  "+speech10+" Branch."
					+"Okay, If you want to know specific branch address, You can continue by saying"
					+"Give me perfect address for SBI "+ls10.get(0)+" Branch");
			
			repromptText = "Our Administration  available in "+areaname
					+"area. Branches at various loactions are  "+speech10+" Branch."
					+"Okay, If you want to know specific branch address, You can continue by saying"
					+"Give me perfect address for SBI "+ls10.get(0)+" Branch";
			}
			else
			{
					speechText = "We don't have any branch currently in this area.You can ask me again by saying.." + "I want information about the branch in "+areaname;
			}
			
			
		}
		else
		{
			speechText = "We are not operational in this area.You can ask me again by saying.." + "I want information about the branch in "+areaname;
		}
		return arg0.getResponseBuilder()
				.withSpeech(speechText)
				.withReprompt(repromptText)
				.withSimpleCard("AIBB", speechText)
				.withShouldEndSession(false)
				.build();

	}

}
