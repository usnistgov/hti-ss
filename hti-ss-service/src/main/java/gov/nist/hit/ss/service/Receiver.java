package gov.nist.hit.ss.service;

public interface Receiver {

	String echoBack(String request);

	String submitSingleMessage(String message);

}
