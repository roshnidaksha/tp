package seedu.internsprint.command;

import seedu.internsprint.internship.HardwareInternship;
import seedu.internsprint.internship.Internship;

import java.util.Set;

public class AddHardwareCommand extends AddCommand {
    public static final String COMMAND_WORD = "add hardware";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a hardware internship to the internship list.\n"
            + "    Parameters: " + "/c COMPANY_NAME " + "/r ROLE " + "/tech TECHNOLOGIES\n"
            + "    Example: " + COMMAND_WORD + " /c Google " + "/r Hardware Engineer " + "/tech C, C++";
    public static final String[] REQUIRED_PARAMETERS = {"/c", "/r", "/tech"};

    public AddHardwareCommand() {
        super(Set.of(REQUIRED_PARAMETERS));
    }

    @Override
    protected String getUsageMessage() {
        return MESSAGE_USAGE;
    }

    @Override
    protected Internship createInternship() {
        return new HardwareInternship(parameters.get("/c"), parameters.get("/r"), parameters.get("/tech"));
    }
}
