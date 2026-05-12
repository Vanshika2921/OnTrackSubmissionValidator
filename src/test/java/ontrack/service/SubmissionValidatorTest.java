package ontrack.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for SubmissionValidator.
 * 
 * @author Vanshika
 */
public class SubmissionValidatorTest {

    @Test
    public void testValidSubmissionShouldBeAccepted() {

        SubmissionValidator validator =
                new SubmissionValidator();

        String result =
                validator.validateSubmission(
                        "225159328",
                        "report.pdf",
                        5,
                        false,
                        false);

        Assert.assertEquals(
        "Wrong Output",
        result);
    }
}