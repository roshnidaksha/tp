package seedu.internsprint.interview;

import seedu.internsprint.exceptions.DuplicateEntryException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTest {

    @Test
    void testEquals_provideMatchingMainInterview_returnsTrue() {
        Interview interview1 = new Interview("2023-10-01", "10:00", "11:00", "Technical");
        Interview interview2 = new Interview("2023-10-01", "10:00", "11:00", "Verbal");
        assertTrue(interview1.equals(interview2));
    }

    @Test
    void testEquals_provideDifferentMainInterview_returnsFalse() {
        Interview interview1 = new Interview("2023-10-01", "10:00", "11:00", "Technical");
        Interview interview2 = new Interview("2023-10-02", "10:00", "11:00", "Technical");
        assertFalse(interview1.equals(interview2));
    }

    @Test
    void addInterviewRound_provideNewInterview_addToRounds() {
        Interview mainInterview = new Interview("2023-10-01", "10:00", "11:00", "Technical");
        Interview newRound = new Interview("2023-10-01", "12:00", "13:00", "Verbal");

        assertDoesNotThrow(() -> mainInterview.addInterviewRound(newRound));
        assertTrue(mainInterview.getNextRounds().contains(newRound));
    }

    @Test
    void addInterviewRound_provideDuplicateInterview_throwsDuplicateEntryException() {
        Interview mainInterview = new Interview("2023-10-01", "10:00", "11:00", "Technical");
        Interview duplicateRound = new Interview("2023-10-01", "10:00", "11:00", "Verbal");

        assertThrows(DuplicateEntryException.class, () -> mainInterview.addInterviewRound(duplicateRound));
    }

    @Test
    void addInterviewRound_provideDuplicateRound_throwsDuplicateEntryException() {
        Interview mainInterview = new Interview("2023-10-01", "10:00", "11:00", "Technical");
        Interview firstRound = new Interview("2023-10-01", "12:00", "13:00", "Verbal");
        Interview duplicateRound = new Interview("2023-10-01", "12:00", "13:00", "Verbal");
        assertDoesNotThrow(() -> mainInterview.addInterviewRound(firstRound));
        assertThrows(DuplicateEntryException.class, () -> mainInterview.addInterviewRound(duplicateRound));
    }
}