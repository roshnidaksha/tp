package seedu.internsprint.command;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.userProfile.UserProfile;

public class ViewUserCommand extends Command{
    @Override
    protected boolean isValidParameters() {
        return true;
    }

    @Override
    public CommandResult execute(InternshipList internships, UserProfile user) {
        return null;
    }
}
