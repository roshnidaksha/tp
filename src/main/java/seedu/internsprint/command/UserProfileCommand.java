package seedu.internsprint.command;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.userProfile.UserProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static seedu.internsprint.util.InternSprintExceptionMessages.USERPROFILE_INVALID_PARAMS;
import static seedu.internsprint.util.InternSprintMessages.USER_UPDATE_SUCCESS_MESSAGE;

public class UserProfileCommand extends Command{
    public static final String COMMAND_WORD = "my";
    public static final String MESSAGE_USAGE = "    " + COMMAND_WORD + ": Edits your user profile to save details about"
            + "yourself.\n"+ "     Parameters: " + "/c COMPANIES_YOU_PREFER /r ROLES_YOU_PREFER /ygoals YEARLY_GOALS"
            + " /mgoals MONTHLY_GOALS\n" + "     /pay PAY_RANGE /ind INDUSTRIES_YOU_PREFER /time TIME_RANGE " +
            "/name YOUR_NAME\n"
            + "     Example: " + COMMAND_WORD + " /name John Doe /c Google,Java /r Hardware Engineer, Automation Intern"
            + " /pay 2000-3000";
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
        CommandResult result;
        List<String> feedback = new ArrayList<>();
        if (!isValidParameters()) {
            feedback.add(USERPROFILE_INVALID_PARAMS);
            feedback.add(MESSAGE_USAGE);
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }
        setUserProfileAttributes();
        feedback.add(USER_UPDATE_SUCCESS_MESSAGE);
       // feedback.add(UserProfile.toString());
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;
    }

    private void setUserProfileAttributes() {
        if(parameters.containsKey("/name")){
            UserProfile.setName(parameters.get("/name"));
        }
        if(parameters.containsKey("/pay")){
            UserProfile.setTargetStipendRange(parameters.get("/pay"));
        }
        if(parameters.containsKey("/ind")){
           // UserProfile.setPreferredIndustries(parameters.get("/ind"));
        }
        if(parameters.containsKey("/time")){
            //to be edited to work with date time parser
           // UserProfile.setInternshipDateRange(parameters.get("/time"));
        }
        if(parameters.containsKey("/ygoals")){
            UserProfile.setYearlyGoals(parameters.get("/ygoals"));
        }
        if(parameters.containsKey("/mgoals")){
            UserProfile.setYearlyGoals(parameters.get("/mgoals"));
        }
        if(parameters.containsKey("/c")){
         //   UserProfile.setPreferredCompanies(parameters.get("/c"));
        }
        if(parameters.containsKey("/r")){
           // UserProfile.setPreferredRoles(parameters.get("/r"));
        }
    }
}
