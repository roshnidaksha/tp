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
        case "delete":
            command = parseDeleteCommand(params);
            break;
        default:
            throw new IllegalArgumentException("Unknown command type: " + commandType);
        }
        parseKeyValuePairs(params, command);
        return command;
    }

    private static Command parseDeleteCommand(String params) {
        String[] paramParts = params.split(" ");

        if (paramParts.length == 1) {
            return new DeleteCommand(paramParts[0], -1);
        }

        if (paramParts.length != 2) {
            return new DeleteCommand("", -1);
        }

        String category = paramParts[0];
        int index;

        if (!DeleteCommand.VALID_CATEGORIES.contains(category.toLowerCase())) {
            return new DeleteCommand("", -1);
        }

        try {
            index = Integer.parseInt(paramParts[1]);
        } catch (NumberFormatException e) {
            return new DeleteCommand("", -1);
        }

        return new DeleteCommand(category, index);
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
