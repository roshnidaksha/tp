package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;

import java.util.ArrayList;
import java.util.List;

import static seedu.internsprint.util.InternSprintMessages.LIST_MESSAGE_SUCCESS;

public class ListCommand extends Command {
    public static final String COMMAND_WORD = "bye";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists\n"
            + "Parameters: None\n"
            + "Example: " + COMMAND_WORD;

    @Override
    protected boolean isValidParameters() {
        return parameters.isEmpty();
    }

    @Override
    public CommandResult execute(InternshipList internshipList) {
        CommandResult result;
        List<String> feedback = new ArrayList<>();

        for (Internship everyInternship : internshipList.getInternshipMap().get("software")) {
            System.out.println("Company: " + everyInternship.getCompanyName() + ", Role: " +
                    everyInternship.getRole());
        }

        for (Internship everyInternship : internshipList.getInternshipMap().get("hardware")) {
            System.out.println("Company: " + everyInternship.getCompanyName() + ", Role: " +
                    everyInternship.getRole());
        }

        for (Internship everyInternship : internshipList.getInternshipMap().get("general")) {
            System.out.println("Company: " + everyInternship.getCompanyName() + ", Role: " +
                    everyInternship.getRole());
        }

        feedback.add(LIST_MESSAGE_SUCCESS);
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;

    }
}

