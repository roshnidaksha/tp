package seedu.internsprint.command;

import seedu.internsprint.internship.HardwareInternship;
import seedu.internsprint.internship.Internship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddHardwareCommandTest {

    @Test
    void createInternship_validParameters_correctlyConstructed() {
        AddHardwareInternshipCommand addHardwareCommand = new AddHardwareInternshipCommand();
        addHardwareCommand.parameters.put("/c", "Google");
        addHardwareCommand.parameters.put("/r", "Hardware Engineer");
        addHardwareCommand.parameters.put("/hardtech", "C, C++");
        Internship internship = addHardwareCommand.createInternship();
        assertEquals("Google", internship.getCompanyName());
        assertEquals("Hardware Engineer", internship.getRole());
        assertEquals("C, C++", ((HardwareInternship) internship).getEmbeddedSystems());
        assertEquals("hardware", internship.getType());
    }

    @Test
    void createInternship_validOptionalParameters_correctlyConstructed() {
        AddHardwareInternshipCommand addHardwareCommand = new AddHardwareInternshipCommand();
        addHardwareCommand.parameters.put("/c", "Google");
        addHardwareCommand.parameters.put("/r", "Hardware Engineer");
        addHardwareCommand.parameters.put("/hardtech", "C, C++");
        addHardwareCommand.parameters.put("/eli", "Eligibility");
        addHardwareCommand.parameters.put("/desc", "Description");
        addHardwareCommand.parameters.put("/status", "Status");
        addHardwareCommand.parameters.put("/ex", "Expectations");
        Internship internship = addHardwareCommand.createInternship();
        assertEquals("Google", internship.getCompanyName());
        assertEquals("Hardware Engineer", internship.getRole());
        assertEquals("C, C++", ((HardwareInternship) internship).getEmbeddedSystems());
        assertEquals("Eligibility", internship.getEligibility());
        assertEquals("Description", internship.getDescription());
        assertEquals("Status", internship.getStatus());
        assertEquals("Expectations", internship.getExpectations());
    }

    @Test
    void createInternship_invalidEmbeddedSystems_throwsException() {
        final String[] invalidEmbeddedSystems = {null, "", " ", "  "};
        for (String embeddedSystems : invalidEmbeddedSystems) {
            AddHardwareInternshipCommand addHardwareCommand = new AddHardwareInternshipCommand();
            addHardwareCommand.parameters.put("/c", "Google");
            addHardwareCommand.parameters.put("/r", "Hardware Engineer");
            addHardwareCommand.parameters.put("/tech", embeddedSystems);
            assertThrows(IllegalArgumentException.class, addHardwareCommand::createInternship);
        }
    }
}
