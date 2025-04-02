package seedu.internsprint.storage;

import seedu.internsprint.logic.command.CommandResult;
import seedu.internsprint.model.internship.InternshipList;

import java.io.IOException;

/**
 * Manages the storage of data in the application.
 * <p>
 * This class is a singleton, meaning that there is only one instance of it in the application.
 * It is responsible for creating and managing the storage handlers for different types of data.
 */
public class StorageManager {

    private static StorageManager storageManager;
    private static boolean isConfigured = false;

    private final InternshipStorageHandler internshipStorageHandler;

    private StorageManager() {
        this.internshipStorageHandler = new InternshipStorageHandler();
        isConfigured = true;
    }

    public static StorageManager getInstance() {
        if (!isConfigured) {
            storageManager = new StorageManager();
        }
        return storageManager;
    }

    // ================= Internship methods =================

    public void saveInternshipData(InternshipList internships) throws IOException {
        internshipStorageHandler.save(internships);
    }

    public CommandResult loadInternshipData(InternshipList internships) {
        return internshipStorageHandler.load(internships);
    }

    // ================= Interview methods =================

    // ================== UserProfile methods =================

    // ================== Project methods =================
}
