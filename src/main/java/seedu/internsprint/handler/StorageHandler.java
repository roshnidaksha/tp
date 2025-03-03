package seedu.internsprint.handler;

import seedu.internsprint.internship.InternshipList;
import seedu.internsprint.util.InternSprintExceptionMessages;

import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class StorageHandler {
    private static final String FILE_PATH = Paths.get("data", "internships.txt").toString();
    private File file;

    public StorageHandler() {
        file = new File(FILE_PATH);
    }

    public void createFile() {
        try {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (!file.getParentFile().mkdirs()) {
                    throw new RuntimeException(String.format(InternSprintExceptionMessages.UNABLE_TO_CREATE_DIRECTORY,
                            file.getParentFile().getAbsolutePath()));
                }
                if (!file.createNewFile()) {
                    throw new RuntimeException(String.format(InternSprintExceptionMessages.FILE_ALREADY_EXISTS,
                            file.getAbsolutePath()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format(InternSprintExceptionMessages.UNABLE_TO_CREATE_FILE,
                    file.getAbsolutePath()));
        }
    }

    public void saveInternships(InternshipList internships) {
        JSONArray jsonArray = new JSONArray();
        internships.getInternshipMap().forEach((type, list) -> {
            list.forEach(internship -> jsonArray.put(internship.toJson()));
        });

        if (!file.exists()) {
            createFile();
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonArray.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(String.format(InternSprintExceptionMessages.UNABLE_TO_WRITE_FILE,
                    file.getAbsolutePath()));
        }
    }
}
