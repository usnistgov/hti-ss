package gov.nist.hit.ss.ws.server;

import gov.nist.hit.ss.ws.jaxb.ConnectivityTestRequestType;
import gov.nist.hit.ss.ws.jaxb.ConnectivityTestResponseType;
import gov.nist.hit.ss.ws.jaxb.SubmitSingleMessageRequestType;
import gov.nist.hit.ss.ws.jaxb.SubmitSingleMessageResponseType;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;

/**
 * 
 * @author Harold Affo
 * 
 */
public interface TransportServer {

	/**
	 * 
	 * @param request
	 * @return
	 */
	public ConnectivityTestResponseType handle(
			ConnectivityTestRequestType request);

	/**
	 * 
	 * @param request
	 * @return
	 */
	public SubmitSingleMessageResponseType handle(
			@RequestPayload SubmitSingleMessageRequestType request);

}
