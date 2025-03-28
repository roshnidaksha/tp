package seedu.internsprint.command;

import seedu.internsprint.internship.Internship;
import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.project.Project;
import seedu.internsprint.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.internsprint.util.InternSprintMessages.*;

/**
 * Represents a command to add an project.
 */
public abstract class ProjectCommand extends Command {
    protected static Logger logger = InternSprintLogger.getLogger();
    protected final Set<String> requiredParameters;

    public ProjectCommand(Set<String> requiredParameters) {
        this.requiredParameters = requiredParameters;
    }

    @Override
    public String getCommandType() {
        return "user";
    }

    /**
     * Checks if the parameters entered by the user are valid.
     *
     * @return True if the parameters are valid, false otherwise.
     */
    @Override
    protected boolean isValidParameters() {
        return parameters.keySet().containsAll(requiredParameters);
    }

    /**
     * Gets the usage message for the command.
     *
     * @return Usage message.
     */
    protected abstract String getUsageMessage();

    /**
     * Creates a Project object.
     *
     * @return Project object.
     */
    protected abstract Project createProject();

    /**
     * Executes the command to add an internship.
     *
     * @param internships InternshipList object and user UserProfile object.
     * @return CommandResult object.
     */
    @Override
    public CommandResult execute(InternshipList internships, UserProfile user) {
        logger.log(Level.INFO, "Executing add command");
        CommandResult result;
        if (!isValidParameters()) {
            logger.log(Level.WARNING, "Invalid parameters entered");
            result = new CommandResult(getUsageMessage());
            result.setSuccessful(false);
            return result;
        }

        Project toAdd;
        toAdd = createProject();

        if (user.projects.contains(toAdd)) {
            result = new CommandResult(MESSAGE_DUPLICATE_PROJECT);
            result.setSuccessful(false);
            return result;
        }
        assert !user.projects.contains(toAdd) : "Projects should not already be present in the list";

        List<String> feedback = new ArrayList<>();

        user.projects.addProject(toAdd);
        assert user.projects.contains(toAdd) : "Projects should be present in the list";

        feedback.add(PROJECT_ADD_MESSAGE_SUCCESS);
        feedback.add(toAdd.toString());
        feedback.add(String.format(PROJECT_LIST_COUNT_MESSAGE, user.projects.getProjectCount()));
        //to be implemented later on when projects are saved
        /*
        try {

            user.projects.saveProjects();
            //feedback.add(InternSprintMessages.SAVE_SUCCESS_MESSAGE);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error saving project after adding an internship");
            feedback.add(e.getMessage());
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }
        logger.log(Level.INFO, "Internship added successfully and saved to file");
         */
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;
    }
}
