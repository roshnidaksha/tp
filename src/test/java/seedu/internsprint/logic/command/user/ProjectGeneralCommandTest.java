package seedu.internsprint.logic.command.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.internsprint.model.userprofile.project.Project;
import seedu.internsprint.model.userprofile.project.GeneralProject;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectGeneralCommandTest {
    ProjectGeneralCommand projectGeneralCommand;
    HashMap<String,String> parameters;

    @BeforeEach
    void setUp() {
        projectGeneralCommand = new ProjectGeneralCommand();
        parameters = projectGeneralCommand.getParameters();
    }

    @Test
    void isValidParameters_provideCorrectMandatoryFlags_returnsValid() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/dept","Tech");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        parameters.put("/dur","May-August");
        assertTrue(projectGeneralCommand.isValidParameters());
    }
    @Test
    void isValidParameters_provideMissingMandatoryFlags_returnsInalid() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        assertFalse(projectGeneralCommand.isValidParameters());
    }

    @Test
    void execute_provideAllFlags_createsProject() {
        parameters.put("/n","Team Project for EE2026");
        parameters.put("/r","Ui Developer");
        parameters.put("/dept","Tech");
        parameters.put("/obj","To get an A+");
        parameters.put("/desc","Worked at creating pixel art for the UI");
        parameters.put("/dur","May-August");
        Project project = projectGeneralCommand.createProject();
        assertEquals("Ui Developer", project.getRole());
        assertEquals("Team Project for EE2026", project.getProjectName());
        assertEquals("Tech", ((GeneralProject) project).getDepartment());
        assertEquals("To get an A+", project.getObjectives());
        assertEquals("Worked at creating pixel art for the UI", project.getDescription());
        assertEquals("May-August", project.getDuration());
    }
}