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

        if (fileName == null ||
                fileName.trim().isEmpty()) {

            return "Invalid File";
        }

        if (!isAllowedFileType(fileName)) {

            return "Invalid File Type";
        }

                 if (fileSizeInMb <= 0 ||
                fileSizeInMb > 10) {

            return "File Size Exceeded";
        }

                if (deadlinePassed) {

            return "Submission Closed";
        }
                if (duplicateSubmission) {

            return "Duplicate Submission";
        }
        return "Submission Accepted";
    }

    private boolean isAllowedFileType(String fileName) {

        String lowerCaseFileName =
                fileName.toLowerCase();

        return lowerCaseFileName.endsWith(".pdf") ||
                lowerCaseFileName.endsWith(".docx");
    }
}