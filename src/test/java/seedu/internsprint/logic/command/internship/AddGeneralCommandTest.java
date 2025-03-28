package seedu.internsprint.logic.command.internship;

import seedu.internsprint.internship.GeneralInternship;
import seedu.internsprint.internship.Internship;
import seedu.internsprint.logic.command.internship.AddGeneralInternshipCommand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddGeneralCommandTest {

    @Test
    void createInternship_validParameters_correctlyConstructed() {
        AddGeneralInternshipCommand addGeneralCommand = new AddGeneralInternshipCommand();
        addGeneralCommand.parameters.put("/c", "Google");
        addGeneralCommand.parameters.put("/r", "Software Engineer");
        addGeneralCommand.parameters.put("/dept", "Engineering");
        Internship internship = addGeneralCommand.createInternship();
        assertEquals("Google", internship.getCompanyName());
        assertEquals("Software Engineer", internship.getRole());
        assertEquals("Engineering", ((GeneralInternship) internship).getDepartment());
        assertEquals("general", internship.getType());
    }

    @Test
    void createInternship_validOptionalParameters_correctlyConstructed() {
        AddGeneralInternshipCommand addGeneralCommand = new AddGeneralInternshipCommand();
        addGeneralCommand.parameters.put("/c", "Google");
        addGeneralCommand.parameters.put("/r", "Software Engineer");
        addGeneralCommand.parameters.put("/dept", "Engineering");
        addGeneralCommand.parameters.put("/eli", "NUS");
        addGeneralCommand.parameters.put("/desc", "Software Engineer Intern");
        addGeneralCommand.parameters.put("/status", "Open");
        addGeneralCommand.parameters.put("/ex", "Software Engineer Intern");
        Internship internship = addGeneralCommand.createInternship();
        assertEquals("Google", internship.getCompanyName());
        assertEquals("Software Engineer", internship.getRole());
        assertEquals("Engineering", ((GeneralInternship) internship).getDepartment());
        assertEquals("NUS", internship.getEligibility());
        assertEquals("Software Engineer Intern", internship.getDescription());
        assertEquals("Open", internship.getStatus());
        assertEquals("Software Engineer Intern", internship.getExpectations());
        assertEquals("general", internship.getType());
    }

    @Test
    void createInternship_invalidCompanyName_throwsException() {
        final String[] invalidCompanyNames = {null, "", " ", "  "};
        for (String companyName : invalidCompanyNames) {
            AddGeneralInternshipCommand addGeneralCommand = new AddGeneralInternshipCommand();
            addGeneralCommand.parameters.put("/c", companyName);
            addGeneralCommand.parameters.put("/r", "Software Engineer");
            addGeneralCommand.parameters.put("/dept", "Engineering");
            assertThrows(IllegalArgumentException.class, addGeneralCommand::createInternship);
        }
    }

    @Test
    void createInternship_invalidRole_throwsException() {
        final String[] invalidRoles = {null, "", " ", "  "};
        for (String role : invalidRoles) {
            AddGeneralInternshipCommand addGeneralCommand = new AddGeneralInternshipCommand();
            addGeneralCommand.parameters.put("/c", "Google");
            addGeneralCommand.parameters.put("/r", role);
            addGeneralCommand.parameters.put("/dept", "Engineering");
            assertThrows(IllegalArgumentException.class, addGeneralCommand::createInternship);
        }
    }

    @Test
    void createInternship_invalidDepartment_throwsException() {
        final String[] invalidDepartments = {null, "", " ", "  "};
        for (String department : invalidDepartments) {
            AddGeneralInternshipCommand addGeneralCommand = new AddGeneralInternshipCommand();
            addGeneralCommand.parameters.put("/c", "Google");
            addGeneralCommand.parameters.put("/r", "Software Engineer");
            addGeneralCommand.parameters.put("/dept", department);
            assertThrows(IllegalArgumentException.class, addGeneralCommand::createInternship);
        }
    }
}
