package seedu.internsprint.logic.command.internship;

import org.junit.jupiter.api.Test;

import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.internship.SoftwareInternship;
import seedu.internsprint.logic.command.internship.ListCommand;
import seedu.internsprint.userprofile.UserProfile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.internsprint.util.InternSprintMessages.LIST_MESSAGE_SUCCESS;

public class ListCommandTest {
    @Test
    void isValidParameters_provideNoParameters_returnsTrue() {
        ListCommand listcommand = new ListCommand();
        assertTrue(listcommand.isValidParameters());
    }

    @Test
    void isValidParameters_provideExtraParameters_returnsFalse() {
        ListCommand listcommand = new ListCommand();
        listcommand.parameters.put("/c", "Shoppe");
        assertFalse(listcommand.isValidParameters());
    }

    @Test
    void execute_listTwoInternship_returnsCorrectCommand() {
        ListCommand listcommand = new ListCommand();
        SoftwareInternship internship1 = new SoftwareInternship("Facebook", "software Intern", "C++");
        SoftwareInternship internship2 = new SoftwareInternship("Google", "hardware Intern", "Java");
        InternshipList internshipList = new InternshipList();
        internshipList.addInternship(internship1);
        internshipList.addInternship(internship2);

        CommandResult result = listcommand.execute(internshipList, new UserProfile());
        assertTrue(result.isSuccessful());
        List<String> feedback = result.getFeedbackToUser();
        assertEquals(6, feedback.size());
        assertEquals(LIST_MESSAGE_SUCCESS, feedback.get(0));
    }
}
