package seedu.internsprint.command;

import seedu.internsprint.internship.InternshipList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class UserProfileCommand extends Command{

    public static final String[] OPTIONAL_PARAMETERS = {"/pay", "/ind", "/time", "/name",
            "/ygoals", "/mgoals", "/c", "/r"};
    @Override
    protected boolean isValidParameters() {
        for (String key : parameters.keySet()) {
            if (!Arrays.asList(OPTIONAL_PARAMETERS).contains(key)) {
                System.out.println("Invalid key found: " + key);
                return false;
            }
        }
        return true;
    }

    @Override
    public CommandResult execute(InternshipList internships) {
        return null;
    }
}
