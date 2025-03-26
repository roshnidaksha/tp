package seedu.internsprint.command;

import org.junit.jupiter.api.Test;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintExceptionMessages;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class DeleteCommandTest {
    @Test
    void deleteCommand_provideCorrectIndex_returnsValid() {
        AddGeneralCommand addGeneralCommand1 = new AddGeneralCommand();
        addGeneralCommand1.parameters.put("/c", "Google");
        addGeneralCommand1.parameters.put("/r", "Software Engineer");
        addGeneralCommand1.parameters.put("/dept", "Engineering");
        AddGeneralCommand addGeneralCommand2 = new AddGeneralCommand();
        addGeneralCommand2.parameters.put("/c", "JP Morgan");
        addGeneralCommand2.parameters.put("/r", "Data Engineer");
        addGeneralCommand2.parameters.put("/dept", "Engineering");
        DeleteCommand deleteCommand = new DeleteCommand();
        deleteCommand.parameters.put("/index", "1");
        assertTrue(deleteCommand.isValidParameters());
    }

    @Test
    void deleteCommand_provideMissingIndex_returnsInvalid() {
        DeleteCommand deleteCommand = new DeleteCommand();
        CommandResult result = deleteCommand.execute(new InternshipList(),new UserProfile());
        assertFalse(deleteCommand.isValidParameters());
        assertFalse(result.isSuccessful());
    }

    @Test
    void deleteCommand_provideInvalidIndex_returnsInvalid() {
        DeleteCommand deleteCommand = new DeleteCommand();
        deleteCommand.parameters.put("/index", "-1");
        CommandResult result = deleteCommand.execute(new InternshipList(),new UserProfile());
        assertEquals(InternSprintExceptionMessages.INVALID_INDEX_RANGE, result.getFeedbackToUser().get(0));
        assertFalse(result.isSuccessful());
    }

    @Test
    void deleteCommand_provideOutOfBoundsIndex_returnsInvalid() {
        InternshipList internshipList = new InternshipList();
        UserProfile user = new UserProfile();
        AddHardwareCommand addHardwareCommand1 = new AddHardwareCommand();
        addHardwareCommand1.parameters.put("/c", "Google");
        addHardwareCommand1.parameters.put("/r", "Firmware Engineer");
        addHardwareCommand1.parameters.put("/tech", "Engineering");
        addHardwareCommand1.execute(internshipList, user);

        AddHardwareCommand addHardwareCommand2 = new AddHardwareCommand();
        addHardwareCommand2.parameters.put("/c", "Google");
        addHardwareCommand2.parameters.put("/r", "Software Engineer");
        addHardwareCommand2.parameters.put("/tech", "Engineering");
        addHardwareCommand2.execute(internshipList, user);

        DeleteCommand deleteCommand = new DeleteCommand();
        deleteCommand.parameters.put("/index", "3");
        CommandResult result = deleteCommand.execute(internshipList, user);
        assertEquals(InternSprintExceptionMessages.INVALID_INDEX_RANGE, result.getFeedbackToUser().get(0));
        assertFalse(result.isSuccessful());
    }

}

