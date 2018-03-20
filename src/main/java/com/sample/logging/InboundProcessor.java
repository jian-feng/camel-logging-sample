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

import com.sample.reportincident.InputReportIncident;

/**
 * @author jianfeng
 *
 */
public class InboundProcessor implements Processor {

	private static final Logger log = LoggerFactory.getLogger(InboundProcessor.class);

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("This is inboundProcessor");
		InputReportIncident body = exchange.getIn().getBody(InputReportIncident.class);
		log.info("exchange.in.body={}", body);

		Map<String, String> outBody = new HashMap<String, String>();
		outBody.put("code", "Accepted");
		exchange.getOut().setBody(outBody);
	}

}
