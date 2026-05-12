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
    public void testValidStudentIdShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testShortStudentIdShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "12345", "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testLongStudentIdShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "22515932899", "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testNullStudentIdShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                null, "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testEmptyStudentIdShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "", "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testStudentIdWithLettersShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225ABC328", "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testStudentIdWithSpecialCharactersShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "22515@328", "report.pdf", 5, false, false);

        Assert.assertEquals("Invalid Student ID", result);
    }

    @Test
    public void testPdfFileShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testDocxFileShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.docx", 5, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testEmptyFileNameShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "", 5, false, false);

        Assert.assertEquals("Invalid File", result);
    }

    @Test
    public void testNullFileNameShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", null, 5, false, false);

        Assert.assertEquals("Invalid File", result);
    }

    @Test
    public void testExeFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "program.exe", 5, false, false);

        Assert.assertEquals("Invalid File Type", result);
    }

    @Test
    public void testTxtFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "notes.txt", 5, false, false);

        Assert.assertEquals("Invalid File Type", result);
    }

    @Test
    public void testFileWithoutExtensionShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report", 5, false, false);

        Assert.assertEquals("Invalid File Type", result);
    }

        @Test
    public void testOneMbFileShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 1, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testTenMbFileShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 10, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testElevenMbFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 11, false, false);

        Assert.assertEquals("File Size Exceeded", result);
    }

    @Test
    public void testFifteenMbFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 15, false, false);

        Assert.assertEquals("File Size Exceeded", result);
    }

    @Test
    public void testZeroMbFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 0, false, false);

        Assert.assertEquals("File Size Exceeded", result);
    }

    @Test
    public void testNegativeFileSizeShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", -1, false, false);

        Assert.assertEquals("File Size Exceeded", result);
    }

        @Test
    public void testSubmissionBeforeDeadlineShouldBeAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, false, false);

        Assert.assertEquals("Submission Accepted", result);
    }

    @Test
    public void testSubmissionAfterDeadlineShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, true, false);

        Assert.assertEquals("Submission Closed", result);
    }

    @Test
    public void testDeadlinePassedWithDocxFileShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.docx", 5, true, false);

        Assert.assertEquals("Submission Closed", result);
    }

    @Test
    public void testDeadlinePassedWithMaximumFileSizeShouldBeRejected() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 10, true, false);

        Assert.assertEquals("Submission Closed", result);
    }

    @Test
    public void testDeadlinePassedShouldNotReturnSubmissionAccepted() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, true, false);

        Assert.assertFalse("Submission Accepted".equals(result));
    }

    @Test
    public void testDeadlineNotPassedShouldNotCloseSubmission() {
        SubmissionValidator validator = new SubmissionValidator();

        String result = validator.validateSubmission(
                "225159328", "report.pdf", 5, false, false);

        Assert.assertFalse("Submission Closed".equals(result));
    }
}