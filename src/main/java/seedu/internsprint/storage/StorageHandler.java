package seedu.internsprint.storage;

import seedu.internsprint.exceptions.DuplicateEntryException;
import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.GeneralInternship;
import seedu.internsprint.model.internship.HardwareInternship;
import seedu.internsprint.model.internship.SoftwareInternship;
import seedu.internsprint.model.internship.InternshipList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.internsprint.util.InternSprintExceptionMessages.FILE_ALREADY_EXISTS;
import static seedu.internsprint.util.InternSprintExceptionMessages.UNABLE_TO_CREATE_DIRECTORY;
import static seedu.internsprint.util.InternSprintExceptionMessages.UNABLE_TO_CREATE_FILE;
import static seedu.internsprint.util.InternSprintExceptionMessages.UNABLE_TO_WRITE_FILE;
import static seedu.internsprint.util.InternSprintExceptionMessages.UNABLE_TO_READ_FILE;

import static seedu.internsprint.util.InternSprintMessages.LOADING_DATA_SUCCESS;
import static seedu.internsprint.util.InternSprintMessages.LOADING_DATA_FIRST_TIME;

/**
 * Handles the reading and writing of data to the file.
 */
public class StorageHandler {
    private static final String FILE_PATH = Paths.get("data", "internships.txt").toString();
    private static File file;
    private static Logger logger = Logger.getLogger(StorageHandler.class.getName());

    public StorageHandler() {
        file = new File(FILE_PATH);
    }

    /**
     * Creates the file if it does not exist.
     */
    public static void createFile() {
        try {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    throw new RuntimeException(String.format(UNABLE_TO_CREATE_DIRECTORY,
                            file.getParentFile().getAbsolutePath()));
                }
                assert file.getParentFile().exists() : "Directory should exist at this point";

                if (!file.createNewFile()) {
                    throw new RuntimeException(String.format(FILE_ALREADY_EXISTS,
                            file.getAbsolutePath()));
                }
                assert file.exists() : "File should exist at this point";
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Unable to create file {0}", file.getAbsolutePath());
            throw new RuntimeException(String.format(UNABLE_TO_CREATE_FILE,
                    file.getAbsolutePath()));
        }
    }

    /**
     * Saves the internships to the file.
     *
     * @param internships List of internships to be saved.
     */
    public void saveInternships(InternshipList internships) {
        logger.log(Level.INFO, "Saving Internships to file ...");
        JSONArray jsonArray = new JSONArray();
        internships.getInternshipMap().forEach((type, list) -> {
            list.forEach(internship -> jsonArray.put(internship.toJson()));
        });

        if (!file.exists()) {
            createFile();
        }
        assert file.exists() : "File should exist at this point";

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonArray.toString(4));
            logger.log(Level.INFO, String.format("Successfully saved %s Internships to file %s",
                jsonArray.length(), file.getAbsolutePath()));
        } catch (IOException e) {
            logger.log(Level.SEVERE, String.format("Unable to save Internships to file %s", file.getAbsolutePath()));
            throw new RuntimeException(String.format(UNABLE_TO_WRITE_FILE,
                    file.getAbsolutePath()));
        }
    }

    /**
     * Loads the internships from the file.
     *
     * @param internships List of internships to be loaded.
     * @return CommandResult object indicating the success of the operation.
     */
    public static CommandResult loadInternships(InternshipList internships) {
        logger.log(Level.INFO, "Beginning process to load internships from file ...");
        CommandResult result;
        if (!file.exists() || file.length() == 0) {
            logger.log(Level.INFO, "Data file loaded is empty currently");
            result = new CommandResult(LOADING_DATA_FIRST_TIME);
            result.setSuccessful(true);
            return result;
        }
        assert file.length()!=0 : "File should not be an empty file at this point";

        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        } catch (IOException e) {
            result = errorReadingFile();
            logger.log(Level.SEVERE, "Error reading file");
            return result;
        }

        JSONArray jsonArray = new JSONArray(jsonData.toString());
        if (jsonArray.isEmpty()) {
            logger.log(Level.WARNING, "Error in formatting such that JSONArray could not be" +
                    "created successfully");
            result = errorReadingFile();
            return result;
        }
        assert !jsonArray.isEmpty(): "Array of JSON objects read from file should not be an empty at this point";
        logger.log(Level.INFO, "Successfully extracted internships as JSON objects from file");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject internshipJson = jsonArray.getJSONObject(i);
            addInternshipToList(internships, internshipJson);
        }
        logger.log(Level.INFO, "Successfully added internships from file to internship list in app");
        result = new CommandResult(LOADING_DATA_SUCCESS);
        result.setSuccessful(true);
        return result;
    }

    /**
     * Returns a CommandResult object indicating that there was an error reading the file.
     *
     * @return CommandResult object indicating the error.
     */
    private static CommandResult errorReadingFile() {
        CommandResult result;
        List<String> feedback = new ArrayList<>();
        feedback.add(UNABLE_TO_READ_FILE);
        result = new CommandResult(feedback);
        result.setSuccessful(false);
        return result;
    }

    /**
     * Adds the internship to the list of internships.
     *
     * @param internships List of internships.
     * @param internshipJson JSON object representing the internship.
     */
    private static void addInternshipToList(InternshipList internships, JSONObject internshipJson) {
        try {
            switch (internshipJson.getString("type")) {
            case "general":
                internships.addInternship(GeneralInternship.fromJson(internshipJson));
                break;
            case "software":
                internships.addInternship(SoftwareInternship.fromJson(internshipJson));
                break;
            case "hardware":
                internships.addInternship(HardwareInternship.fromJson(internshipJson));
                break;
            default:
                break;
            }
        } catch (DuplicateEntryException e) {
            throw new RuntimeException(e.getMessage() + "\n" + "Please check the file for duplicate entries");
        }
    }
}


