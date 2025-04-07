package seedu.internsprint.logic.command.internship;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import seedu.internsprint.logic.command.Command;
import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.Internship;
import seedu.internsprint.model.internship.InternshipList;
import seedu.internsprint.model.internship.interview.Interview;
import seedu.internsprint.model.internship.interview.InterviewEntry;
import seedu.internsprint.model.userprofile.UserProfile;
import seedu.internsprint.util.InternSprintLogger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.internsprint.util.InternSprintExceptionMessages.SORT_INTERVIEWS_INVALID_PARAMS;
import static seedu.internsprint.util.InternSprintMessages.NO_INTERVIEWS_SCHEDULED;
import static seedu.internsprint.util.InternSprintMessages.SORT_INTERVIEWS_MESSAGE_SUCCESS;

/**
 * Command that sorts all interviews across internships based on their date and time.
 * It displays the sorted interviews in an ASCII table, with each row representing an interview entry.
 */
public class SortInterviewCommand extends Command {
    public static final String COMMAND_WORD = "sort interviews";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the internship by the name of the interview " +
            "entry.\n "
            + " Parameters: None\n"
            + "Example: " + COMMAND_WORD;
    private static final Logger logger = InternSprintLogger.getLogger();

    // Extracted constants for table column widths
    private static final int COMPANY_WIDTH = 12;
    private static final int ROLE_WIDTH = 12;
    private static final int DATE_WIDTH = 12;
    private static final int START_WIDTH = 10;
    private static final int END_WIDTH = 10;
    private static final int TYPE_WIDTH = 10;
    private static final int EMAIL_WIDTH = 20;
    private static final int NOTES_MIN_WIDTH = 25;
    private static final int NOTES_MAX_WIDTH = 35;

    @Override
    public String getCommandType() {
        return "interview";
    }

    @Override
    protected boolean isValidParameters() {
        return parameters.isEmpty();
    }

    /**
     * Executes the sort interviews command.
     * It collects all interviews from the internship list, sorts them by date and time,
     * and then displays them in an ASCII table
     *
     * @param internships InternshipList
     * @param user        Userprofile object.
     * @return A CommandResult object containing feedback and success status.
     */
    @Override
    public CommandResult execute(InternshipList internships, UserProfile user) {
        logger.log(Level.INFO, "Executing sortInterviews command");
        assert internships != null : "Internship list cannot be null";
        assert user != null : "UserProfile cannot be null";

        List<String> feedback = new ArrayList<>();
        List<InterviewEntry> allEntries = collectAllInterviews(internships);
        CommandResult result;

        if (!isValidParameters()) {
            logger.log(Level.WARNING, "There are invalid parameters so error result is output to user.");
            feedback.add(SORT_INTERVIEWS_INVALID_PARAMS);
            feedback.add(MESSAGE_USAGE);
            result = new CommandResult(feedback);
            result.setSuccessful(false);
            return result;
        }

        sortInterviewEntries(allEntries);
        logger.log(Level.INFO, "Interview entries sorted successfully.");

        if (allEntries.isEmpty()) {
            feedback.add(NO_INTERVIEWS_SCHEDULED);
            result = new CommandResult(feedback);
            result.setSuccessful(true);
            return result;
        }

        feedback.add(SORT_INTERVIEWS_MESSAGE_SUCCESS);
        AsciiTable table = buildInterviewTable(allEntries);
        feedback.add("\n" + table.render());

        logger.log(Level.INFO, "sort interviews command executed successfully");
        result = new CommandResult(feedback);
        result.setSuccessful(true);
        return result;
    }

    /**
     * Builds an ASCII table containing interview details.
     *
     * @param allEntries a list of InterviewEntry objects containing pairs of interviews and internships
     * @return an AsciiTable with columns for company name, role, interview date, start time,
     *     end time, interview type, interviewer email, and notes.
     */
    private AsciiTable buildInterviewTable(List<InterviewEntry> allEntries) {
        AsciiTable at = new AsciiTable();
        CWC_LongestLine cwc = getCwcLongestLine();
        at.getRenderer().setCWC(cwc);

        at.addRule();
        at.addRow("Company Name", "Role", "Interview Date", "Start Time", "End Time", "Interview Type",
                    "Interviewer Email", "Notes");
        at.addRule();
        for (int i = 0; i < allEntries.size(); i++) {
            InterviewEntry entry = allEntries.get(i);
            Interview interview = entry.getInterview();
            Internship internship = entry.getInternship();

            assert internship != null : "Internship cannot be null";
            assert interview != null : "Interview cannot be null";

            at.addRow(
                    internship.getCompanyName(),
                    internship.getRole(),
                    interview.getUnformattedInterviewDate(),
                    interview.getUnformattedInterviewStartTime(),
                    interview.getUnformattedInterviewEndTime(),
                    interview.getInterviewType(),
                    interview.getInterviewerEmail() == null ? "N/A" : interview.getInterviewerEmail(),
                    interview.getNotes() == null ? "N/A" : interview.getNotes()
            );
            at.addRule();
        }
        return at;
    }

    /**
     * Configures and returns a CWC_LongestLine object that sets the column widths for the ASCII table.
     *
     * @return a configured CWC_LongestLine object
     */
    private CWC_LongestLine getCwcLongestLine() {
        CWC_LongestLine cwc = new CWC_LongestLine();
        cwc.add(COMPANY_WIDTH, COMPANY_WIDTH); // Company Name
        cwc.add(ROLE_WIDTH, ROLE_WIDTH); // Role
        cwc.add(DATE_WIDTH, DATE_WIDTH); // Interview Date
        cwc.add(START_WIDTH, START_WIDTH); // Start Time
        cwc.add(END_WIDTH, END_WIDTH); // End Time
        cwc.add(TYPE_WIDTH, TYPE_WIDTH); // Interview Type
        cwc.add(EMAIL_WIDTH, EMAIL_WIDTH); // Interviewer Email
        cwc.add(NOTES_MAX_WIDTH, NOTES_MIN_WIDTH); // Notes
        return cwc;
    }

    /**
     * Sorts the given list of interview entries based on interview date and start time.
     *
     * @param allEntries the list of {@code InterviewEntry} objects to sort.
     */
    private void sortInterviewEntries(List<InterviewEntry> allEntries) {
        allEntries.sort(Comparator.comparing(entry -> LocalDateTime.of(
                        entry.getInterview().getUnformattedInterviewDate(),
                        entry.getInterview().getUnformattedInterviewStartTime()
                )
        ));
    }

    /**
     * Recursively collects all interviews from the internship list, including follow-up rounds.
     *
     * @param internshipList The InternshipList to collect interviews from.
     * @return A list of InterviewEntry objects each containing a pair of internship and one round of interview.
     */
    private List<InterviewEntry> collectAllInterviews(InternshipList internshipList) {
        logger.log(Level.INFO, "Collecting all interviews from internship list");
        List<InterviewEntry> allInterviews = new ArrayList<>();

        for (ArrayList<Internship> internships : internshipList.getInternshipMap().values()) {
            for (Internship internship : internships) {
                Interview interview = internship.getInterview();
                if (interview != null) {
                    allInterviews.add(new InterviewEntry(internship, interview));
                    collectNextRounds(internship, interview.getNextRounds(), allInterviews);
                }
            }
        }
        logger.log(Level.INFO, "Successfully collected a total of" + allInterviews.size() + " interview entries.");
        return allInterviews;
    }

    /**
     * Recursively collects next round interviews within the same interview adds them to the result list.
     *
     * @param internship The internship associated with the interviews.
     * @param rounds     A list of follow-up interview rounds.
     * @param result     The list to which the collected InterviewEntry objects are added.
     */
    private void collectNextRounds(Internship internship, List<Interview> rounds, List<InterviewEntry> result) {
        logger.log(Level.FINE, "Entering collectNextRounds with " + rounds.size() + "rounds");
        for (Interview round : rounds) {
            assert round != null : "Interview round cannot be null";
            result.add(new InterviewEntry(internship, round));
            collectNextRounds(internship, round.getNextRounds(), result);
        }
        logger.log(Level.FINE, "Exiting collectNextRounds");
    }
}
