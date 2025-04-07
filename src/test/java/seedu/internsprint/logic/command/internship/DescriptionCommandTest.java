package seedu.internsprint.logic.command.internship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.GeneralInternship;
import seedu.internsprint.model.internship.HardwareInternship;
import seedu.internsprint.model.internship.InternshipList;
import seedu.internsprint.model.internship.SoftwareInternship;
import seedu.internsprint.model.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintExceptionMessages;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internsprint.util.InternSprintExceptionMessages.INVALID_INDEX;
import static seedu.internsprint.util.InternSprintExceptionMessages.INVALID_INDEX_RANGE;
import static seedu.internsprint.util.InternSprintMessages.DESC_MESSAGE_SUCCESS;

public class DescriptionCommandTest {
    private HardwareInternship internship1;
    private GeneralInternship internship2;
    private SoftwareInternship internship3;
    private InternshipList internshipList;
    private static final int EXPECTED_FEEDBACK_LINES = 4;

    @BeforeEach
    void setUp() {
        internship1 = new HardwareInternship("HP", "Manufacturing Engineer",
                "Embedded circuit design");
        internship2 = new GeneralInternship("LG", "Project Manager",
                "Resource Department");
        internship3 = new SoftwareInternship("Google", "Software Engineer",
                "Java");
        internshipList = new InternshipList();
    }

    @Test
    void isValidParameters_provideValidIndex_returnsTrue() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "1");
        descriptioncommand.setParameters(parameters);
        assertTrue(descriptioncommand.isValidParameters());
    }

    @Test
    void isValidParameters_provideInvalidIndex_returnsFalse() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "-1");
        descriptioncommand.setParameters(parameters);
        CommandResult commandResult = descriptioncommand.execute(new InternshipList(), new UserProfile());
        assertEquals(InternSprintExceptionMessages.INVALID_INDEX_RANGE,
                commandResult.getFeedbackToUser().get(0));
        assertFalse(commandResult.isSuccessful());
    }

    @Test
    void execute_validateIndex2Internship_returnsCorrectCommand() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "2");
        descriptioncommand.setParameters(parameters);

        assertDoesNotThrow(() -> internshipList.addInternship(internship1));
        assertDoesNotThrow(() -> internshipList.addInternship(internship2));
        assertDoesNotThrow(() -> internshipList.addInternship(internship3));

        CommandResult commandResult = descriptioncommand.execute(internshipList, new UserProfile());
        assertTrue(commandResult.isSuccessful());
        List<String> feedback = commandResult.getFeedbackToUser();
        assertEquals(EXPECTED_FEEDBACK_LINES, feedback.size());
        assertEquals(DESC_MESSAGE_SUCCESS, feedback.get(0));
    }

    @Test
    void execute_withInvalidNonNumericParameters_returnsErrorMessage() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "abc");
        descriptioncommand.setParameters(parameters);
        CommandResult commandResult = descriptioncommand.execute(internshipList, new UserProfile());
        assertFalse(commandResult.isSuccessful());
        assertTrue(commandResult.getFeedbackToUser().stream().anyMatch(line ->
                line.contains(INVALID_INDEX)), "Expected error message not found in feedback.");
    }

    @Test
    void execute_withOutOfRangeIndex_returnsErrorMessage() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "2"); // Out-of-range if only index 1 exists
        descriptioncommand.setParameters(parameters);
        assertDoesNotThrow(() -> internshipList.addInternship(internship2));
        CommandResult commandResult = descriptioncommand.execute(internshipList, new UserProfile());
        assertFalse(commandResult.isSuccessful(), "Expected unsuccessful execution for out-of-range index.");
        assertTrue(commandResult.getFeedbackToUser().stream().anyMatch(line -> line.contains(INVALID_INDEX_RANGE))
                , "Expected error message to indicate an out-of-range index.");
    }

    @Test
    void execute_withNoInternship_returnsErrorMessage() {
        DescriptionCommand descriptioncommand = new DescriptionCommand();
        HashMap<String, String> parameters = descriptioncommand.getParameters();
        parameters.put("/index", "1");
        descriptioncommand.setParameters(parameters);
        InternshipList internshipList = new InternshipList();
        CommandResult commandResult = descriptioncommand.execute(internshipList, new UserProfile());
        assertFalse(commandResult.isSuccessful(), "Expected unsuccessful execution for missing Internship.");
        assertTrue(commandResult.getFeedbackToUser().stream().anyMatch(line ->
                line.contains(INVALID_INDEX_RANGE)), "Expected error message indicating the internship could " +
                "not be found");
    }
}
