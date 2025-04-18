package seedu.internsprint.model.internship.interview;

import org.json.JSONObject;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import seedu.internsprint.exceptions.DuplicateEntryException;
import seedu.internsprint.logic.parser.DateTimeParser;
import seedu.internsprint.util.InternSprintLogger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import static seedu.internsprint.util.InternSprintExceptionMessages.DUPLICATE_INTERVIEW;
import static seedu.internsprint.util.InternSprintExceptionMessages.END_TIME_BEFORE_START_TIME;
import static seedu.internsprint.util.InternSprintExceptionMessages.MISSING_REQUIRED_PARAMETERS;

/**
 * Represents an interview for an internship.
 * An interview can have multiple rounds.
 * Each round has a date, start time, end time, type, interviewer email and notes.
 */
public class Interview {

    /* Mandatory required parameters to create an Interview */
    protected LocalDate interviewDate;
    protected LocalTime interviewStartTime;
    protected LocalTime interviewEndTime;
    protected String interviewType;

    protected ArrayList<Interview> nextRounds = new ArrayList<>();
    protected int roundCounter = 0;

    /*Optional Parameters to create an Interview */
    protected String interviewerEmail;
    protected String notes;

    private int internshipId = -1;
    private final Logger logger = InternSprintLogger.getLogger();

    public Interview(String interviewDate, String interviewStartTime, String interviewEndTime,
                     String interviewType) {
        if (interviewDate == null || interviewStartTime == null || interviewEndTime == null || interviewType == null) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS,
                    "/date, /start, /end or /type"));
        }

        if (interviewDate.isBlank() || interviewStartTime.isBlank() || interviewEndTime.isBlank() ||
                interviewType.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS,
                    "/date, /start, /end or /type"));
        }

        this.interviewDate = DateTimeParser.parseDateInput(interviewDate);
        this.interviewStartTime = DateTimeParser.parseTimeInput(interviewStartTime);
        this.interviewEndTime = DateTimeParser.parseTimeInput(interviewEndTime);
        this.interviewType = interviewType;

        checkDateAndTime(this.interviewDate, this.interviewStartTime, this.interviewEndTime);

        setRoundCounter(this.roundCounter);
    }

    public Interview(String interviewDate, String interviewStartTime, String interviewEndTime, String interviewType,
                     String interviewerEmail, String notes) {
        if (interviewDate == null || interviewStartTime == null || interviewEndTime == null || interviewType == null) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS,
                    "/date, /start, /end or /type"));
        }

        if (interviewDate.isBlank() || interviewStartTime.isBlank() || interviewEndTime.isBlank() ||
                interviewType.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS,
                    "/date, /start, /end or /type"));
        }

        this.interviewDate = DateTimeParser.parseDateInput(interviewDate);
        this.interviewStartTime = DateTimeParser.parseTimeInput(interviewStartTime);
        this.interviewEndTime = DateTimeParser.parseTimeInput(interviewEndTime);
        this.interviewType = interviewType;

        checkDateAndTime(this.interviewDate, this.interviewStartTime, this.interviewEndTime);

        if (interviewerEmail != null && !interviewerEmail.isBlank()) {
            this.interviewerEmail = interviewerEmail;
        }

        if (notes != null && !notes.isBlank()) {
            this.notes = notes;
        }

        this.roundCounter = 0;
    }

    /**
     * Checks if the start time is before the end time.
     *
     * @param interviewDate The date of the interview
     * @param startTime     The start time of the interview
     * @param endTime       The end time of the interview
     */
    private void checkDateAndTime(LocalDate interviewDate, LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            logger.warning("Interview start time cannot be after end time.");
            throw new IllegalArgumentException(END_TIME_BEFORE_START_TIME);
        }
    }

    /**
     * Returns a string representation of the interview.
     * The details of that interview excluding the next rounds are included.
     *
     * @return A string containing the interview details.
     */
    @Override
    public String toString() {
        String interviewString = "    Interview Date: " + interviewDate +
                ", Start Time: " + interviewStartTime +
                ", End Time: " + interviewEndTime +
                ", Round Name: " + interviewType;
        if (interviewerEmail != null) {
            interviewString += ", Interviewer Email: " + interviewerEmail;
        }
        if (notes != null) {
            interviewString += ", Notes: " + notes;
        }
        return interviewString;
    }

    /**
     * Converts the Interview object to a detailed string representation.
     * It includes details about all the rounds of the interview.
     * The details are formatted in a table format.
     *
     * @return An ArrayList of strings representing the interview details.
     */
    public ArrayList<String> toDescription() {
        ArrayList<String> interviewString = new ArrayList<>();
        interviewString.add("Interview details:");

        AsciiTable at = new AsciiTable();

        CWC_LongestLine cwc = new CWC_LongestLine();
        cwc.add(7, 7);   // Round No.
        cwc.add(12, 12); // Interview Date
        cwc.add(10, 10); // Start Time
        cwc.add(10, 10); // End Time
        cwc.add(10, 10); // Interview Type
        cwc.add(25, 25); // Interviewer Email
        cwc.add(30, 30); // Notes
        at.getRenderer().setCWC(cwc);

        at.addRule();
        at.addRow("Round No.", "Interview Date", "Start Time", "End Time",
            "Interview Type", "Interviewer Email", "Notes");
        at.addRule();

        at.addRow(
            "1",
            getUnformattedInterviewDate(),
            getUnformattedInterviewStartTime(),
            getUnformattedInterviewEndTime(),
            getInterviewType(),
            getInterviewerEmail() == null ? "N/A" : getInterviewerEmail(),
            getNotes() == null ? "N/A" : getNotes()
        );
        at.addRule();

        if (roundCounter != 0) {
            for (int i = 0; i < nextRounds.size(); i++) {
                at.addRow(
                    String.valueOf(i + 2),
                    nextRounds.get(i).getUnformattedInterviewDate(),
                    nextRounds.get(i).getUnformattedInterviewStartTime(),
                    nextRounds.get(i).getUnformattedInterviewEndTime(),
                    nextRounds.get(i).getInterviewType(),
                    nextRounds.get(i).getInterviewerEmail() == null ? "N/A" : nextRounds.get(i).getInterviewerEmail(),
                    nextRounds.get(i).getNotes() == null ? "N/A" : nextRounds.get(i).getNotes()
                );
                at.addRule();
            }
        }
        interviewString.addAll(Arrays.asList(at.renderAsArray()));

        return interviewString;
    }

    /**
     * Checks if this interview is equal to another interview.
     * Two interviews are considered equal if their date, start time and end time are equal.
     *
     * @param interview The interview to compare with.
     * @return true if the interviews are equal, false otherwise.
     */
    public boolean equals(Interview interview) {
        if (interview == null) {
            return false;
        }
        return interviewDate.equals(interview.interviewDate)
            && interviewStartTime.equals(interview.interviewStartTime)
            && interviewEndTime.equals(interview.interviewEndTime);
    }

    /**
     * Adds an interview round to the current interview.
     * If the round is the same as the current round, it throws a DuplicateEntryException.
     *
     * @param round The interview round to be added.
     * @throws DuplicateEntryException If the round is the same as the current round.
     */
    public void addInterviewRound(Interview round) throws DuplicateEntryException {
        if (this.equals(round)) {
            logger.warning("Interview round cannot be the same as the current round.");
            throw new DuplicateEntryException(DUPLICATE_INTERVIEW);
        }
        for (Interview nextRound : nextRounds) {
            if (nextRound.equals(round)) {
                logger.warning("Interview round cannot be the same as the current round.");
                throw new DuplicateEntryException(DUPLICATE_INTERVIEW);
            }
        }
        if (round != null) {
            this.nextRounds.add(round);
            roundCounter++;
        }
    }

    public String getInterviewDate() {
        return DateTimeParser.formatLocalDate(interviewDate);
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewStartTime() {
        return DateTimeParser.formatLocalTime(interviewStartTime);
    }

    public void setInterviewStartTime(LocalTime interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }

    public String getInterviewEndTime() {
        return DateTimeParser.formatLocalTime(interviewEndTime);
    }

    public void setInterviewEndTime(LocalTime interviewEndTime) {
        this.interviewEndTime = interviewEndTime;
    }

    public String getInterviewerEmail() {
        return interviewerEmail;
    }

    public void setInterviewerEmail(String interviewerEmail) {
        this.interviewerEmail = interviewerEmail;
    }

    public String getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(String interviewType) {
        this.interviewType = interviewType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ArrayList<Interview> getNextRounds() {
        return nextRounds;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter += roundCounter;
    }

    public void setNextRounds(ArrayList<Interview> nextRounds) {
        this.nextRounds = nextRounds;
    }

    public LocalDate getUnformattedInterviewDate() {
        return interviewDate;
    }

    public LocalTime getUnformattedInterviewStartTime() {
        return interviewStartTime;
    }

    public LocalTime getUnformattedInterviewEndTime() {
        return interviewEndTime;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    /**
     * Converts the Interview object to a JSON object.
     *
     * @return JSON object representing the interview.
     */
    public JSONObject toJson() {
        JSONObject interviewJson = new JSONObject();
        if (internshipId != -1) {
            interviewJson.put("internshipId", internshipId);
        }
        interviewJson.put("date", interviewDate);
        interviewJson.put("startTime", interviewStartTime);
        interviewJson.put("endTime", interviewEndTime);
        interviewJson.put("type", interviewType);
        interviewJson.put("roundCounter", roundCounter);
        if (interviewerEmail != null) {
            interviewJson.put("interviewerEmail", interviewerEmail);
        }
        if (notes != null) {
            interviewJson.put("notes", notes);
        }

        if (roundCounter != 0) {
            interviewJson.put("nextRounds", new ArrayList<>());
        }
        for (Interview nextRound : nextRounds) {
            interviewJson.append("nextRounds", nextRound.toJson());
        }
        return interviewJson;
    }

    /**
     * Returns an Interview object from a JSON object.
     *
     * @param json JSON object representing the interview.
     * @return Interview object.
     */
    private static Interview getOneInterviewFromJson(JSONObject json) {
        Interview interview = new Interview(
                json.getString("date"),
                json.getString("startTime"),
                json.getString("endTime"),
                json.getString("type"),
                json.optString("interviewerEmail"),
                json.optString("notes")
        );
        interview.setInternshipId(json.optInt("internshipId", -1));
        interview.setRoundCounter(json.getInt("roundCounter"));
        return interview;
    }

    /**
     * Creates an Interview object from a JSON object.
     * If the Interview has next rounds, it will also create the next rounds.
     *
     * @param json JSON object representing the interview.
     * @return Interview object.
     */
    public static Interview fromJson(JSONObject json) {
        Interview interview = getOneInterviewFromJson(json);
        if (interview.roundCounter != 0) {
            ArrayList<Interview> nextRounds = new ArrayList<>();
            for (int i = 0; i < interview.roundCounter; i++) {
                JSONObject nextRoundJson = json.getJSONArray("nextRounds").getJSONObject(i);
                Interview nextRound = getOneInterviewFromJson(nextRoundJson);
                nextRounds.add(nextRound);
            }
            interview.setNextRounds(nextRounds);
        }
        return interview;
    }
}
