import java.util.ArrayList;

/**
 * Deals with interactions with the user.
 */
public class Ui {
    public static String tab = "     ";
    public static String line = "     ............................................................";

    public Ui() { }

    /**
     * Prints Elly logo and introduction message.
     */
    public void printIntro() {
        String logo =
                " _____   _   _\n"
                        + "| ____| | | | |\n"
                        + "| |___  | | | | __   __\n"
                        + "|  ___| | | | | \\ \\ / /\n"
                        + "| |___  | | | |  \\ v /\n"
                        + "|_____| |_| |_|  /  /\n"
                        + "                /__/\n";

        System.out.println("   C H A T   W I T H\n" + logo);

        System.out.println(line + "\n"
                + tab + "Hi there! I'm Elly.\n"
                + tab + "How can I help you today?\n"
                + line);
    }

    /**
     * Prints line for Elly's response display.
     */
    public void printLine() {
        System.out.println(line);
    }

    public void printList(ArrayList<Task> tasks, int numTasks) {
        if (numTasks <= 0) {
            System.out.println(tab + "Yay! There are no tasks in your list.");
        } else {
            System.out.println(tab + "Here are the tasks in your list:");
            for (int i = 0; i < numTasks; i++) {
                int num = i + 1;
                Task task = tasks.get(i);
                System.out.println(
                        tab + num + "." + task.toString());
            }
        }
    }

    /**
     * Prints to notify user which task is marked as done.
     * Identifies task by index and formats task to String.
     * @param tasks arraylist of tasks.
     * @param index task index.
     */
    public void printDone(ArrayList<Task> tasks, int index) {
        System.out.println(tab + "Nice! I've marked this task as done:");
        System.out.println(tab + tasks.get(index).toString());
    }

    /**
     * Prints to notify user which task is deleted.
     * @param string String format of deleted task
     */
    public void printDelete(String string) {
        System.out.println(tab + "Noted. I've removed this task:");
        System.out.println(tab + string);
    }

    /**
     * Prints to notify user which task is added.
     * Identifies task by index and formats task to String.
     * @param tasks arraylist of tasks.
     * @param index task index.
     */
    public void printAdd(ArrayList<Task> tasks, int index) {
        System.out.println(tab + "Got it. I've added this task:");
        System.out.println(tab + tasks.get(index).toString());
    }

    /**
     * Prints number of tasks in list.
     * @param numTasks number of tasks.
     */
    public void printNumTasks(int numTasks) {
        System.out.println(tab + "Now you have " + numTasks + " tasks in the list.");
    }

    /**
     * Prints goodbye message followed by a line.
     */
    public void printBye() {
        System.out.println(tab + "Goodbye, can't wait to see you again!");
        System.out.println(line);
    }

    /**
     * Prints error message that description cannot be empty.
     * @param task task type.
     */
    public void printEmptyDescError(String task) {
        System.out.println(tab + "Oops! Description of " + task + " cannot be empty.");
    }

    /**
     * Prints error message that command cannot be identified.
     */
    public void printIdkError() {
        System.out.println(tab + "I'm sorry, I'm not sure what that means.");
    }

    /**
     * Prints to notify user of formatting requirement for date.
     */
    public void printDateError() {
        System.out.println(tab + "Oops! Date should be in YYYY-MM-DD format.");
    }
}
