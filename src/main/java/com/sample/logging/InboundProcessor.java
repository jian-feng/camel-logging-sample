/**
 *
 */
package com.sample.logging;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jianfeng
 *
 */
public class InboundProcessor implements Processor {

	private static final Logger audit_log = LoggerFactory.getLogger("rest-request-audit");

	
	public void init() {
		audit_log.info(InboundProcessor.class + " is initialized.");
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		audit_log.info("This is inboundProcessor");
		
		Map<String, String> outBody = new HashMap<String, String>();
		outBody.put("code", "Accepted");
		exchange.getOut().setBody(outBody);
	}

}
