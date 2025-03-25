package seedu.internsprint.command;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.userProfile.UserProfile;

import java.util.ArrayList;
import java.util.List;

import static seedu.internsprint.util.InternSprintMessages.USER_VIEW_SUCCESS_MESSAGE;

public class ViewUserCommand extends Command {
    @Override
    protected boolean isValidParameters() {
        return true;
    }

    @Override
    public String getCommandType() {
        return "user";
    }

    @Override
    public CommandResult execute(InternshipList internships, UserProfile user) {
        CommandResult result;
        List<String> feedback = new ArrayList<>();
        feedback.add(USER_VIEW_SUCCESS_MESSAGE);
        feedback.add(user.toExtendedString());
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;
    }
}
