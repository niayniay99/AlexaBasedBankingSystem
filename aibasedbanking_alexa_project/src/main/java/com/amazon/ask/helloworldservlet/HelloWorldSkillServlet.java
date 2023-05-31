/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package com.amazon.ask.helloworldservlet;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.ask.helloworldservlet.handlers.AccountIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.AccounttypeIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.AreaIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.AreadescIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.BranchIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.BranchaddressIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.CancelandStopIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.HelpIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.LaunchRequestHandler;
import com.amazon.ask.helloworldservlet.handlers.LoanIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.LoantypeIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.LoginIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.RegistrationIntentHandler;
import com.amazon.ask.helloworldservlet.handlers.SessionEndedRequestHandler;

public class HelloWorldSkillServlet extends SkillStreamHandler {
	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(new LaunchRequestHandler(), 
						new CancelandStopIntentHandler(), 
						new SessionEndedRequestHandler(), 
						new HelpIntentHandler(),
						new RegistrationIntentHandler(),
						new LoginIntentHandler(),
						new AccountIntentHandler(),
						new AccounttypeIntentHandler(),
						new AreaIntentHandler(),
						new AreadescIntentHandler(),
						new BranchIntentHandler(),
						new BranchaddressIntentHandler(),
						new LoanIntentHandler(),
						new LoantypeIntentHandler())
				// Add your skill id below
				// .withSkillId("")
				.build();
	}

	public HelloWorldSkillServlet() {
		super(getSkill());
	}

}
