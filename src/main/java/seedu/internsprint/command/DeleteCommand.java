package seedu.internsprint.command;

import seedu.internsprint.handler.Parser;
import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.util.InternSprintMessages;

import java.util.ArrayList;
import java.util.List;

import static seedu.internsprint.util.InternSprintExceptionMessages.MISSING_INDEX;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an internship " +
        "based on its category and index.\n"
        + "    Parameters: " + "/index INDEX_OF_INTERNSHIP \n"
        + "    Example: " + COMMAND_WORD + " /index 2";
    public static final String[] REQUIRED_PARAMETERS = {"/index"};

    @Override
    protected boolean isValidParameters() {
        return parameters.size() == REQUIRED_PARAMETERS.length
            && parameters.containsKey(REQUIRED_PARAMETERS[0]);
    }

    @Override
    public CommandResult execute(InternshipList internships) {
        CommandResult result;
        List<String> feedback = new ArrayList<>();

        if (!isValidParameters()) {
            feedback.add(MISSING_INDEX);
            feedback.add(MESSAGE_USAGE);
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }

        String[] validIndex;
        try {
            validIndex = Parser.validateIndex(parameters.get("/index"), internships);
        } catch (IllegalArgumentException e) {
            feedback.add(e.getMessage());
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }

        int index = Integer.parseInt(validIndex[1]);
        String type = validIndex[0];

        Internship internshipToDelete = internships.getInternshipMap().get(type).get(index);
        internships.deleteInternship(type, index);

        try {
            internships.saveInternships();
            feedback.add(InternSprintMessages.SAVE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            feedback.add(e.getMessage());
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }

        feedback.add(String.format(InternSprintMessages.SUCCESSFUL_DELETE, internshipToDelete));
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;
    }
}


