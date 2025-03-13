package seedu.internsprint.command;

import org.junit.jupiter.api.Test;
import seedu.internsprint.internship.SoftwareInternship;
import seedu.internsprint.internship.GeneralInternship;
import seedu.internsprint.internship.HardwareInternship;
import seedu.internsprint.internship.InternshipList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class EditCommandTest {

    @Test
    void isValidParameters_provideCorrectIndexAndFlags_returnsValid() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/index", "1");
        editCommand.parameters.put("/c", "Java");
        editCommand.parameters.put("/eli", "Y3 students");
        editCommand.parameters.put("/r","/Automation Testing Intern");
        editCommand.parameters.put("/tech", "Java, C, C++");
        editCommand.parameters.put("/dept","Quality Assurance");
        assertTrue(editCommand.isValidParameters());
    }
    @Test
    void isValidParameters_provideNoIndex_returnsInvalid() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/c", "Java");
        editCommand.parameters.put("/eli", "Y3 students");
        editCommand.parameters.put("/r","/Automation Testing Intern");
        editCommand.parameters.put("/tech", "Java, C, C++");
        editCommand.parameters.put("/dept","Quality Assurance");
        assertFalse(editCommand.isValidParameters());
    }
    @Test
    void isValidParameters_provideInvalidFlag_returnsInvalid() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/c", "Java");
        editCommand.parameters.put("/eli", "Y3 students");
        editCommand.parameters.put("/r","/Automation Testing Intern");
        editCommand.parameters.put("/tech", "Java, C, C++");
        editCommand.parameters.put("/deadline","27th January");
        assertFalse(editCommand.isValidParameters());
    }


    @Test
    void execute_editCompanyAndRoleForSoftwareInternships_editsCorrectly() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/index", "1");
        editCommand.parameters.put("/c", "Java");
        editCommand.parameters.put("/r","Automation Testing Intern");
        SoftwareInternship internship = new SoftwareInternship("Facebook","Software Engineering", "SWE");
        InternshipList internshipList = new InternshipList();
        internshipList.addInternship(internship);
        editCommand.execute(internshipList);
        assertEquals("Java", internship.getCompanyName());
        assertEquals("Automation Testing Intern", internship.getRole());
        assertEquals("software", internship.getType());

    }
    @Test
    void execute_editCompanyAndRoleForGeneralInternships_editsCorrectly() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/index", "1");
        editCommand.parameters.put("/c", "UBS");
        editCommand.parameters.put("/r","IT Intern");
        GeneralInternship internship = new GeneralInternship("Facebook","Tech Support", "IT");
        InternshipList internshipList = new InternshipList();
        internshipList.addInternship(internship);
        editCommand.execute(internshipList);
        assertEquals("UBS", internship.getCompanyName());
        assertEquals("IT Intern", internship.getRole());
        assertEquals("general", internship.getType());
    }
    @Test
    void execute_editCompanyAndRoleForHarwareInternships_editsCorrectly() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/index", "1");
        editCommand.parameters.put("/c", "Xilinx");
        editCommand.parameters.put("/r","Engineering Intern");
        HardwareInternship internship = new HardwareInternship("Facebook","Automation Expert", "C");
        InternshipList internshipList = new InternshipList();
        internshipList.addInternship(internship);
        editCommand.execute(internshipList);
        assertEquals("Xilinx", internship.getCompanyName());
        assertEquals("Engineering Intern", internship.getRole());
        assertEquals("hardware", internship.getType());
    }

    @Test
    void execute_invalidFieldForSoftware_throwsError() {
        EditCommand editCommand = new EditCommand();
        editCommand.parameters.put("/index", "1");
        editCommand.parameters.put("/c", "Java");
        editCommand.parameters.put("/dept","SWE Intern");
        SoftwareInternship internship = new SoftwareInternship("Facebook","Automation Intern", "C");
        InternshipList internshipList = new InternshipList();
        internshipList.addInternship(internship);
        editCommand.execute(internshipList);
        assertEquals("Java", internship.getCompanyName());
        assertEquals("Automation Intern", internship.getRole());
        assertEquals("C", internship.getTechStack());
        assertEquals("software", internship.getType());
    }
}
