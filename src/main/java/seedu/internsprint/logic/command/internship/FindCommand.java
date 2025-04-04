package seedu.internsprint.logic.command.internship;

import seedu.internsprint.logic.command.Command;
import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.Internship;
import seedu.internsprint.model.internship.InternshipList;
import seedu.internsprint.model.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintLogger;

import java.util.ArrayList;
import java.util.logging.Logger;

import static seedu.internsprint.util.InternSprintExceptionMessages.MISSING_REQUIRED_PARAMETERS;
import static seedu.internsprint.util.InternSprintMessages.NO_INTERNSHIPS_FOUND;
import static seedu.internsprint.util.InternSprintMessages.NUMBER_OF_INTERNSHIPS_FOUND;

/**
 * Represents a command to find internships based on type, company name, or role.
 */
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all internships of a particular type, "
        + "company name or role \n"
        + "    Parameters: [TYPE] [/c COMPANY_NAME] [/r ROLE] \n"
        + "    Example: " + COMMAND_WORD + " software";
    public static final String[] PARAMETERS = {"/description", "/c", "/r"};
    private static final Logger logger = InternSprintLogger.getLogger();

    /**
     * Checks if the parameters entered by the user are valid.
     *
     * @return True if the parameters are valid, false otherwise.
     */
    @Override
    protected boolean isValidParameters() {
        return !parameters.isEmpty();
    }

    /**
     * Executes the FindCommand.
     *
     * @param internships InternshipList or UserProfile user.
     * @param user UserProfile object.
     * @return CommandResult object.
     */
    @Override
    public CommandResult execute(InternshipList internships, UserProfile user) {
        CommandResult result;
        logger.info("Starting Find Command processing");
        logger.info("Parameters in FindCommand: " + parameters.toString());

        if (!isValidParameters()) {
            result = new CommandResult(String.format(MISSING_REQUIRED_PARAMETERS, "at least one parameter required"));
            result.setSuccessful(false);
            logger.warning("Missing value processing error");
            return result;
        }

        assert !parameters.isEmpty() : "parameters should not be empty";

        String type = parameters.getOrDefault("description", "").trim().toLowerCase();
        String companyName = parameters.getOrDefault("/c", "").trim().toLowerCase();
        String role = parameters.getOrDefault("/r", "").trim().toLowerCase();

        if (type.isBlank() && companyName.isBlank() && role.isBlank()) {
            result = new CommandResult(String.format(MISSING_REQUIRED_PARAMETERS, "at least one parameter required"));
            result.setSuccessful(false);
            logger.warning("Missing value processing error");
            return result;
        }

        ArrayList<Internship> foundInternships = new ArrayList<>();
        internships.getInternshipMap().values().forEach(internshipList -> {
            foundInternships.addAll(internshipList.stream()
                .filter(internship -> (type.isEmpty() || internship.getType().toLowerCase().contains(type))
                    && (companyName.isEmpty() || internship.getCompanyName().toLowerCase().contains(companyName))
                    && (role.isEmpty() || internship.getRole().toLowerCase().contains(role)))
                .toList());
        });

        if (foundInternships.isEmpty()) {
            result = new CommandResult(NO_INTERNSHIPS_FOUND);
            result.setSuccessful(true);
            logger.info("No internships found satisfying the criteria");
            return result;
        }

        result = new CommandResult(String.format(NUMBER_OF_INTERNSHIPS_FOUND, foundInternships.size()),
            foundInternships);
        result.setSuccessful(true);
        logger.info("Internships found successfully");
        return result;
    }

    @Override
    public String getCommandType() {
        return "internship";
    }
}
