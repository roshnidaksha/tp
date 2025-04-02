package seedu.internsprint.logic.command.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.internsprint.model.internship.GeneralInternship;
import seedu.internsprint.model.internship.SoftwareInternship;
import seedu.internsprint.model.userprofile.project.HardwareProject;
import seedu.internsprint.model.userprofile.project.Project;
import seedu.internsprint.model.userprofile.project.SoftwareProject;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectSoftwareCommandTest {
    ProjectSoftwareCommand projectSoftwareCommand;
    HashMap<String,String> parameters;

    @BeforeEach
    void setUp() {
        projectSoftwareCommand = new ProjectSoftwareCommand();
        parameters = projectSoftwareCommand.getParameters();
    }

    @Test
    void isValidParameters_provideCorrectMandatoryFlags_returnsValid() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/pro","C++");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        parameters.put("/dur","May-August");
        assertTrue(projectSoftwareCommand.isValidParameters());
    }
    @Test
    void isValidParameters_provideMissingMandatoryFlags_returnsInalid() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        assertFalse(projectSoftwareCommand.isValidParameters());
    }

    @Test
    void execute_provideAllFlags_createsProject() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/pro","C++");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        parameters.put("/dur","May-August");
        Project project = projectSoftwareCommand.createProject();
        assertEquals("Ui Developer", project.getRole());
        assertEquals("Team Project for EE2026", project.getProjectName());
        assertEquals(List.of("C++"), ((SoftwareProject) project).getProgrammingLanguages());
        assertEquals("To get an A+", project.getObjectives());
        assertEquals("Worked at creating pixel art for the UI", project.getDescription());
        assertEquals("May-August", project.getDuration());
    }
}