package ontrack.service;

/**
 * Assignment submission validation service for a simplified OnTrack system.
 * 
 * @author Vanshika
 */
public class SubmissionValidator {

    public String validateSubmission(
            String studentId,
            String fileName,
            int fileSizeInMb,
            boolean deadlinePassed,
            boolean duplicateSubmission) {

        if (studentId == null ||
                !studentId.matches("\\d{9}")) {

            return "Invalid Student ID";
        }

        return "Submission Accepted";
    }
}