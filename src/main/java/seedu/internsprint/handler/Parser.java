package seedu.internsprint.handler;

import seedu.internsprint.command.*;
import seedu.internsprint.util.InternSprintExceptionMessages;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static Command parseCommand(String userInput) {
        String[] commandTypeAndParams = splitCommandTypeAndParams(userInput.trim());
        String commandType = commandTypeAndParams[0];
        String params = commandTypeAndParams.length > 1 ? commandTypeAndParams[1] : "";

        Command command;
        switch (commandType) {
        case "add software":
            command = new AddSoftwareCommand();
            break;
        case "add hardware":
            command = new AddHardwareCommand();
            break;
        case "add general":
            command = new AddGeneralCommand();
            break;
        case "bye":
            command = new ByeCommand();
            break;
        case "edit":
            command = new EditCommand();
            break;
        case "help":
            command = new HelpCommand();
            break;
            /*
        case "delete":
            String[] deleteArgs = params.split(" ", 2);
            if (deleteArgs.length < 2) {
                throw new IllegalArgumentException("Please specify both the category (software/hardware/general) and the index.");
            }

            String category = deleteArgs[0].toLowerCase();
            int index;
            try {
                index = Integer.parseInt(deleteArgs[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid index. Please enter a valid number for the index.");
            }
            command = new DeleteCommand(category, index);
            break;*/
        default:
            throw new IllegalArgumentException("Unknown command type: " + commandType);
        }
        parseKeyValuePairs(params, command);
        return command;
    }

    private static String[] splitCommandTypeAndParams(String userInput) {
        String[] multiWordCommands = {"add software", "add hardware", "add general", "edit"};
        for (String command : multiWordCommands) {
            if (userInput.startsWith(command)) {
                return new String[]{command, userInput.substring(command.length()).trim()};
            }
        }
        String[] commandTypeAndParams = userInput.split(" ", 2);
        String commandType = commandTypeAndParams[0];
        String params = commandTypeAndParams.length > 1 ? commandTypeAndParams[1] : "";

        return new String[]{commandType, params};
    }

    private static void parseKeyValuePairs(String params, Command command) {
        HashMap<String, String> keyValueMap = new HashMap<>();

        if (params.isEmpty()) {
            return;
        }

        String[] parts = params.trim().split("/", 2);
        String description = parts[0].trim();
        if (!description.isEmpty()) {
            keyValueMap.put("description", description);
        }
        if (parts.length == 1) {
            command.setParameters(keyValueMap);
            return;
        }

        String keyValuePart = "/" + parts[1];
        String regex = "(/\\w+)\\s+(.*?)(?=\\s+/|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(keyValuePart);

        while (matcher.find()) {
            String key = matcher.group(1).trim();
            String value = matcher.group(2).trim();
            if (value.contains("/")) {
                throw new IllegalArgumentException(InternSprintExceptionMessages.ILLEGAL_COMMAND_INPUT);
            }
            keyValueMap.put(key, value);
        }

        String unmatched = matcher.replaceAll("").trim();
        if (!unmatched.isEmpty()) {
            throw new IllegalArgumentException(
                    String.format(InternSprintExceptionMessages.MISSING_COMMAND_INPUT, unmatched));
        }

        command.setParameters(keyValueMap);
    }
}
