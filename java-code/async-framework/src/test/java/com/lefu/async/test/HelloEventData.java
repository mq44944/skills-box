package com.lefu.async.test;

import com.lefu.async.AbstractEventData;
import com.lefu.async.Flow;

public class HelloEventData extends AbstractEventData {
	private String message;
	
	public HelloEventData() {
		
	}
	
	public HelloEventData(Flow flow) {
		setFlow(flow);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
