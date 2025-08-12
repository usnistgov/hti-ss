package gov.nist.healthcare.hl7.v2.ss.tool.test.unit;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import gov.nist.hit.ss.domain.IZValidationPhase;
import gov.nist.hit.ss.service.exception.SoapValidationException;
import gov.nist.hit.ss.service.soap.SOAPMessageValidatorImpl;
import gov.nist.hit.ss.service.soap.SOAPValidationResult;

public class SOAPMessageValidatorImplTest {

	SOAPMessageValidatorImpl validator = new SOAPMessageValidatorImpl();

	@Test
	public void testValid() throws IOException, SoapValidationException {
		String content = IOUtils
				.toString(SOAPMessageValidatorImplTest.class.getResourceAsStream("/soap/validSubmitSingleMessage.xml"));
		SOAPValidationResult result = (SOAPValidationResult) validator.validate(content, "Testing",
				IZValidationPhase.submitSingleMessage_Request.toString());
		assertNotNull(result.getXml());
	} 

	@Test
	public void testInValid() throws IOException, SoapValidationException {
		String content = IOUtils.toString(
				SOAPMessageValidatorImplTest.class.getResourceAsStream("/soap/invalidSubmitSingleMessage.xml"));
		SOAPValidationResult result = (SOAPValidationResult) validator.validate(content, "Testing",
				IZValidationPhase.submitSingleMessage_Request.toString());
		assertNotNull(result.getXml());
	}

}
