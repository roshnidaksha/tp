package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.internship.SoftwareInternship;
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
        CommandResult result = addCommand.execute(internships);

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
        Internship internship = new SoftwareInternship("Google", "Software Engineer", "Java, Python");
        internships.addInternship(internship);

        CommandResult result = addCommand.execute(internships);

        assertFalse(result.isSuccessful());
        assertEquals(List.of(InternSprintMessages.MESSAGE_DUPLICATE_INTERNSHIP), result.getFeedbackToUser());
    }
}
