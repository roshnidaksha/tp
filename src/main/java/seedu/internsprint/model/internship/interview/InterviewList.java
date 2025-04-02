package seedu.internsprint.model.internship.interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewList {
    private List<Interview> interviewList;

    public InterviewList() {
        this.interviewList = new ArrayList<>();
    }

    public void addInterview(Interview interview) {
        this.interviewList.add(interview);
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }
}
