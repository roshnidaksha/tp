package seedu.internsprint.command;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.userProfile.UserProfile;

public class ViewUserCommand extends Command<UserProfile>{
    @Override
    protected boolean isValidParameters() {
        return true;
    }
    @Override
    public String getCommandType(){
        return "user";
    }
    @Override
    public CommandResult execute(UserProfile user) {
        return null;
    }
}
