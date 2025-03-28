package seedu.internsprint.logic.command.internship;

import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.internship.SoftwareInternship;
import seedu.internsprint.logic.command.internship.AddInternshipCommand;
import seedu.internsprint.logic.command.internship.AddSoftwareInternshipCommand;
import seedu.internsprint.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintMessages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddInternshipCommandTest {

    @Test
    void execute_internshipListDoesNotContainInternship_internshipAdded() {
        AddInternshipCommand addCommand = new AddSoftwareInternshipCommand();
        addCommand.setParameters(new HashMap<>(Map.of(
            "/c", "Google",
            "/r", "Software Engineer",
            "/tech", "Java, Python")));

        InternshipList internships = new InternshipList();
        CommandResult result = addCommand.execute(internships,new UserProfile());

        assertTrue(result.isSuccessful());
        assertEquals(InternSprintMessages.ADD_MESSAGE_SUCCESS, result.getFeedbackToUser().get(0));
        assertEquals(1, internships.getInternshipCount());
    }

    @Test
    void execute_internshipListAlreadyContainsInternship_throwsException() {
        AddInternshipCommand addCommand = new AddSoftwareInternshipCommand();
        addCommand.setParameters(new HashMap<>(Map.of(
            "/c", "Google",
            "/r", "Software Engineer",
            "/tech", "Java, Python")));

        InternshipList internships = new InternshipList();
        UserProfile user = new UserProfile();
        Internship internship = new SoftwareInternship("Google", "Software Engineer", "Java, Python");
        internships.addInternship(internship);

        CommandResult result = addCommand.execute(internships, user);

        assertFalse(result.isSuccessful());
        assertEquals(List.of(InternSprintMessages.MESSAGE_DUPLICATE_INTERNSHIP), result.getFeedbackToUser());
    }
}
