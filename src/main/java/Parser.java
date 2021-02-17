import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deals with making sense of the user command.
 */
public class Parser {

    public Parser() {}

    /**
     * Parses user input Strings into an arraylist of Strings for easier access.
     *
     * @param input user input.
     * @return an arraylist of Strings.
     * Elements of the arraylist are in the sequence:
     * command name, task index/description, date/error name (if applicable).
     */
    public ArrayList<String> parseInputToList(String input) {
        ArrayList<String> result = new ArrayList<>();

        String[] inputArr = input.split(" ", 2);
        String command = inputArr[0];
        result.add(command);

        switch (command) {
        case "bye":
        case "list":
            break;
        default:
            try {
                String details = inputArr[1];
                String description, date, taskIndex;

                switch (command) {
                case "done":
                case "delete":
                    taskIndex = Integer.toString(Integer.parseInt(details) - 1);
                    result.add(taskIndex);
                    break;
                case "edit":
                    String hasDescription = "0", hasDate = "0";
                    final String NO_CHANGE = "NO_CHANGE";
                    description = NO_CHANGE;
                    date = NO_CHANGE;

                    String[] arrOfEdit = details.split(" /", 3);
                    int taskIndexInt = Integer.parseInt(arrOfEdit[0]) - 1;
                    taskIndex = Integer.toString(taskIndexInt);
                    result.add(taskIndex);

                    for (int i = 1; i < arrOfEdit.length; i++) {
                        String partOfEdit = arrOfEdit[i];

                        String[] arrOfPartOfEdit = partOfEdit.split(" ", 2);
                        String attributeType = arrOfPartOfEdit[0];
                        String editedAttribute = arrOfPartOfEdit[1];

                        if (attributeType.equals("desc")) {
                            hasDescription = "1";
                            description = editedAttribute;
                        } else if (attributeType.equals("date")) {
                            hasDate = "1";
                            date = editedAttribute;
                        }
                    }
                    result.add(hasDescription);
                    result.add(description);
                    result.add(hasDate);
                    result.add(date);

                    break;
                case "todo":
                case "find":
                    description = details;
                    result.add(description);
                    break;
                case "deadline":
                    String[] arrOfInputD = details.split(" /by ");
                    description = arrOfInputD[0];
                    date = arrOfInputD[1];

                    result.add(description);
                    result.add(date);
                    break;
                case "event":
                    String[] arrOfInputE = details.split(" /at ");
                    description = arrOfInputE[0];
                    date = arrOfInputE[1];

                    result.add(description);
                    result.add(date);
                    break;
                default:
                    break;
                }
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                if (command.equals("todo") || command.equals("deadline") || command.equals("event")
                        || command.equals("done") || command.equals("delete") || command.equals("edit")) {
                    result.add("emptyDescError");
                } else {
                    result.add("idkError");
                }
            }
        }
        return result;
    }

}
