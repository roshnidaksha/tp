package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.util.InternSprintMessages;
import seedu.internsprint.util.InternSprintExceptionMessages;

import java.util.Set;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes an internship " +
            "based on its category and index.\n"
            + "    Parameters: " + "CATEGORY INDEX\n"
            + "    Example: " + COMMAND_WORD + " software 2";


    public static final Set<String> VALID_CATEGORIES = Set.of("software", "hardware", "general");
    private final String category;
    private final int index;

    public DeleteCommand(String category, int index) {
        this.category = category.toLowerCase();
        this.index = index;
    }

    @Override
    protected boolean isValidParameters() {
        return VALID_CATEGORIES.contains(category);
    }

    @Override
    public CommandResult execute(InternshipList internships) {
        String feedback;
        boolean isSuccess = false;

        if (!isValidParameters()) {
            feedback = InternSprintExceptionMessages.INVALID_CATEGORY_ERROR;
        } else {
            int adjustedIndex = index - 1;

            if (adjustedIndex < 0 || adjustedIndex >= internships.getInternshipMap().get(category).size()) {
                feedback = InternSprintExceptionMessages.INVALID_INDEX_ERROR;
            } else {
                Internship internshipToDelete = internships.getInternshipMap().get(category).get(adjustedIndex);
                internships.getInternshipMap().get(category).remove(adjustedIndex);
                internships.decrementInternshipCount();

                feedback = String.format(InternSprintMessages.SUCCESSFUL_DELETE, internshipToDelete);
                isSuccess = true;
            }
        }

        CommandResult result = new CommandResult(feedback);
        result.setSuccessful(isSuccess);

        return result;
    }
}


