package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static seedu.internsprint.util.InternSprintExceptionMessages.DESC_INVALID_PARAMS;
import static seedu.internsprint.util.InternSprintExceptionMessages.DESC_UNABLE_TO_FIND_INTERNSHIP;
import static seedu.internsprint.util.InternSprintMessages.DESC_MESSAGE_SUCCESS;

public class DescriptionCommand extends Command {
    public static final String COMMAND_WORD = "desc";
    public static final String PARAMETER = "/index";
    private static final String MESSAGE_USAGE = COMMAND_WORD
            + "Shows the description of a particular internship.\n"
            + "Parameter: " + "index of internship in list.\n"
            + "Example: " + COMMAND_WORD + " 1 ";

    @Override
    protected boolean isValidParameters() {
        if (!parameters.containsKey("/index")) {
            return false;
        }
        return true;
    }

    @Override
    public CommandResult execute(InternshipList internships) {
        CommandResult result;
        List<String> feedback = new ArrayList<>();
        if (!isValidParameters()) {
            feedback.add(DESC_INVALID_PARAMS);
            feedback.add(MESSAGE_USAGE);
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }

        Internship foundInternship = null;
        HashMap<String, ArrayList<Internship>> internshipMap = internships.getInternshipMap();
        int index = Integer.parseInt(parameters.get("/index")) - 1;
        boolean checkWrongTypeOfInternship = false;

        for (Map.Entry<String, ArrayList<Internship>> entry : internshipMap.entrySet()) {
            ArrayList<Internship> oneTypeOfInternship = entry.getValue();
            if (index >= 0 && index < oneTypeOfInternship.size()) {
                foundInternship = oneTypeOfInternship.get(index);
                System.out.println(foundInternship);
            }
            index -= oneTypeOfInternship.size();
        }

        if (foundInternship == null) {
            result = new CommandResult(DESC_UNABLE_TO_FIND_INTERNSHIP);
            result.setSuccessful(false);
            return result;
        }

        feedback.add(DESC_MESSAGE_SUCCESS);
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;

    }
}
