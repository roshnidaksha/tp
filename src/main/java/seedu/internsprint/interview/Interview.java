package seedu.internsprint.interview;

import java.util.ArrayList;

import static seedu.internsprint.util.InternSprintExceptionMessages.MISSING_REQUIRED_PARAMETERS;

public class Interview {

    /* Mandatory required parameters to create an Interview */
    protected String interviewDate;
    protected String interviewStartTime;
    protected String interviewEndTime;
    protected String interviewerEmail;
    protected String roundName;

    protected ArrayList<Interview> interviewRounds = new ArrayList<Interview>();

    /*Optional Parameters to create an Interview */
    protected String interviewerName;
    protected int interviewerContactNumber;
    protected String notes;

    protected int roundCounter = 0;

    public Interview(String interviewDate, String interviewStartTime, String interviewEndTime, String interviewerEmail,
                     String roundName) {
        if (interviewDate == null || interviewStartTime == null || interviewEndTime == null || interviewerEmail == null
                || roundName == null) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/d, /str, /end or /em"));
        }

        if (interviewDate.isBlank() || interviewStartTime.isBlank() || interviewEndTime.isBlank() ||
                interviewerEmail.isBlank() || roundName.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/d, /str, /end or /em"));
        }

        this.interviewDate = interviewDate;
        this.interviewStartTime = interviewStartTime;
        this.interviewEndTime = interviewEndTime;
        this.interviewerEmail = interviewerEmail;
        this.roundName = roundName;

        setRoundCounter(this.roundCounter);
    }

    public Interview(String interviewDate, String interviewStartTime, String interviewEndTime,  String interviewerEmail,
                     String roundName, String interviewerName,int interviewerContactNumber, String notes) {
        if (interviewDate == null || interviewStartTime == null || interviewEndTime == null || interviewerEmail == null
                || roundName == null) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/d, /str, /end or /em"));
        }

        if (interviewDate.isBlank() || interviewStartTime.isBlank() || interviewEndTime.isBlank() ||
                interviewerEmail.isBlank() || roundName.isBlank()) {
            throw new IllegalArgumentException(String.format(MISSING_REQUIRED_PARAMETERS, "/d, /str, /end or /em"));
        }

        this.interviewDate = interviewDate;
        this.interviewStartTime = interviewStartTime;
        this.interviewEndTime = interviewEndTime;
        this.interviewerEmail = interviewerEmail;
        this.roundName = roundName;

        if (interviewerName != null && !interviewerName.isBlank()) {
            this.interviewerName = interviewerName;
        }

        if (String.valueOf(interviewerContactNumber).length() == 8) {
            this.interviewerContactNumber = interviewerContactNumber;
        }

        if (notes != null && !notes.isBlank()) {
            this.notes = notes;
        }

        setRoundCounter(this.roundCounter);
    }

    @Override
    public String toString() {
        return "Interview Date: " + interviewDate + ", Start Time: " + interviewStartTime + ", End Time: "
                + interviewEndTime + ", Interviewer Email: " + interviewerEmail + ", Round Name: " + roundName
                + ", Interviewer Name: ";
    }

    public void addInterviewRound(Interview round) {
        if (round != null) {
            this.interviewRounds.add(round);
        }
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewStartTime() {
        return interviewStartTime;
    }

    public void setInterviewStartTime(String interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }

    public String getInterviewEndTime() {
        return interviewEndTime;
    }

    public void setInterviewEndTime(String interviewEndTime) {
        this.interviewEndTime = interviewEndTime;
    }

    public String getInterviewerEmail() {
        return interviewerEmail;
    }

    public void setInterviewerEmail(String interviewerEmail) {
        this.interviewerEmail = interviewerEmail;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public int getInterviewerContactNumber() {
        return interviewerContactNumber;
    }

    public void setInterviewerContactNumber(int interviewerContactNumber) {
        this.interviewerContactNumber = interviewerContactNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter += roundCounter;
    }
}
