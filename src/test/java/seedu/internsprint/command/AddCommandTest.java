package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.internship.SoftwareInternship;
import seedu.internsprint.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintMessages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class AddCommandTest {

    @Test
    void execute_internshipListAlreadyContainsInternship_throwsException() {
        AddCommand addCommand = new AddSoftwareCommand();
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
