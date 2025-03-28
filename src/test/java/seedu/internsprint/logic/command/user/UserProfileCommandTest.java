package seedu.internsprint.logic.command.user;

import org.junit.jupiter.api.Test;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.logic.command.user.UserProfileCommand;
import seedu.internsprint.userprofile.UserProfile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserProfileCommandTest {


    @Test
    void isValidParameters_provideCorrectFlags_returnsValid() {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        userProfileCommand.parameters.put("/name", "Nikita");
        userProfileCommand.parameters.put("/pay", "1000");
        userProfileCommand.parameters.put("/ind", "Tech");
        userProfileCommand.parameters.put("/mgoals", "Be rich");
        userProfileCommand.parameters.put("/ygoals", "Be richer");
        userProfileCommand.parameters.put("/c", "Google");
        assertTrue(userProfileCommand.isValidParameters());
    }
    @Test
    void isValidParameters_provideIncorrectFlags_returnsInvalid() {
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        userProfileCommand.parameters.put("/fullname", "Nikita");
        userProfileCommand.parameters.put("/pay", "1000");
        userProfileCommand.parameters.put("/ind", "Tech");
        userProfileCommand.parameters.put("/mgoals", "Be rich");
        userProfileCommand.parameters.put("/ygoals", "Be richer");
        userProfileCommand.parameters.put("/c", "Google");
        assertFalse(userProfileCommand.isValidParameters());
    }

    @Test
    void execute_updateField_updatesCorrectly() {
        UserProfile user = new UserProfile();
        UserProfileCommand userProfileCommand = new UserProfileCommand();
        userProfileCommand.parameters.put("/name", "Nikita");
        userProfileCommand.parameters.put("/pay", "1000");
        userProfileCommand.parameters.put("/ind", "Tech");
        userProfileCommand.parameters.put("/mgoals", "Be rich");
        userProfileCommand.parameters.put("/ygoals", "Be richer");
        userProfileCommand.parameters.put("/c", "Google");
        userProfileCommand.execute(new InternshipList(), user);
        assertEquals("Nikita", user.getName());
        assertEquals("Be rich", user.getMonthlyGoals());
        assertEquals("1000", user.getTargetStipendRange());
    }

}
