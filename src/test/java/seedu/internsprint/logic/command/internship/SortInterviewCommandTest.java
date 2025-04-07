package seedu.internsprint.logic.command.internship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.HardwareInternship;
import seedu.internsprint.model.internship.Internship;
import seedu.internsprint.model.internship.InternshipList;
import seedu.internsprint.model.internship.SoftwareInternship;
import seedu.internsprint.model.internship.interview.Interview;
import seedu.internsprint.model.userprofile.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.internsprint.util.InternSprintMessages.NO_INTERVIEWS_SCHEDULED;
import static seedu.internsprint.util.InternSprintMessages.SORT_INTERVIEWS_MESSAGE_SUCCESS;

class SortInterviewCommandTest {
    private SoftwareInternship internship1;
    private HardwareInternship internship2;
    private Interview interview1;
    private Interview interview2;
    private Interview interview3;

    private InternshipList internshipList;
    private UserProfile userProfile;

    //
    @BeforeEach
    void setUp() {
        internship1 = new SoftwareInternship("Facebook", "software Intern",
                "C++");
        internship2 = new HardwareInternship("Accenture", "hardware Intern",
                "baremetal");
        interview1 = new Interview("2025-04-12", "10:00", "11:00",
                "HR");
        interview2 = new Interview("2025-04-12", "08:00", "09:00",
                "Technical");
        interview3 = new Interview("2025-04-13", "09:00", "10:00",
                "Managerial");
        internshipList = new InternshipList();
        userProfile = new UserProfile();

        HashMap<String, ArrayList<Internship>> map = internshipList.getInternshipMap();
        map.put(internship1.getType(), new ArrayList<>());
        map.put(internship2.getType(), new ArrayList<>());
        map.get(internship1.getType()).add(internship1);
        map.get(internship2.getType()).add(internship2);
    }

    @Test
    void isValidParameters_provideNoParameters_returnsTrue() {
        SortInterviewCommand command = new SortInterviewCommand();
        assertTrue(command.isValidParameters());
    }

    @Test
    void isValidParameters_provideTwoExtraParameters_returnsFalse() {
        SortInterviewCommand command = new SortInterviewCommand();
        HashMap<String, String> parameters = command.getParameters();
        parameters.put("/index", "1");
        parameters.put("/c", "google");
        command.setParameters(parameters);
        assertFalse(command.isValidParameters());
    }

    @Test
    void isValidParameters_provideOneExtraParameter_returnsFalse() {
        SortInterviewCommand command = new SortInterviewCommand();
        HashMap<String, String> parameters = command.getParameters();
        parameters.put("/tech", "embedded");
        command.setParameters(parameters);
        assertFalse(command.isValidParameters());
    }

    @Test
    void testGetCommandType_returnsInterview() {
        SortInterviewCommand command = new SortInterviewCommand();
        assertEquals("interview", command.getCommandType());
    }

    @Test
    void testExecute_noInterviews_returnsNoInterviewsScheduledMessage() {
        InternshipList list = new InternshipList();
        UserProfile user = new UserProfile();
        SortInterviewCommand command = new SortInterviewCommand();
        CommandResult result = command.execute(list, user);
        String feedbackCombined = String.join("\n", result.getFeedbackToUser());
        assertTrue(feedbackCombined.contains(NO_INTERVIEWS_SCHEDULED));
    }

    @Test
    void testExecute_oneInterview_returnsTableWithInterviewData() {
        try {
            internship1.addInterview(interview1);
        } catch (Exception e) {
            fail("Unexpected exception when adding interview: " + e.getMessage());
        }
        SortInterviewCommand command = new SortInterviewCommand();
        CommandResult result = command.execute(internshipList, userProfile);
        String feedbackCombined = String.join("\n", result.getFeedbackToUser());
        assertTrue(feedbackCombined.contains(SORT_INTERVIEWS_MESSAGE_SUCCESS));
        assertTrue(feedbackCombined.contains("Facebook"));
        assertTrue(feedbackCombined.contains("2025-04-12"));
        assertTrue(feedbackCombined.contains("10:00"));
        assertTrue(feedbackCombined.contains("11:00"));
        assertTrue(feedbackCombined.contains("HR"));
    }

    @Test
    void testExecute_multipleInterviews_returnsSortedInterviewData() {
        try {
            internship1.addInterview(interview1);
            internship2.addInterview(interview2);
            internship2.addInterview(interview3);
        } catch (Exception e) {
            fail("Unexpected exception when adding interview: " + e.getMessage());
        }

        SortInterviewCommand command = new SortInterviewCommand();
        CommandResult result = command.execute(internshipList, userProfile);
        String feedbackCombined = String.join("\n", result.getFeedbackToUser());

        int technicalIndex = feedbackCombined.indexOf("Technical");
        int hrIndex = feedbackCombined.indexOf("HR");
        int managerIndex = feedbackCombined.indexOf("Managerial");
        assertTrue(technicalIndex < hrIndex,
                "Expected the Technical interview (08:00) to be listed before the HR interview (10:00).");
        assertTrue(hrIndex < managerIndex, " Expected the HR interview (2025-04-12) to be listed " +
                "before the Managerial interview (2025-04-13)).");
    }
}
