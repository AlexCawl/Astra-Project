package org.alexcawl.astraproject.resource.utils;

/**
 * This interface should be implemented into any command and you should register that command via the CommandManager.
 */
public interface Command {
    /**
     *
     * @return The identifier for the command
     */
    String getName();

    /**
     * This can be used with {@link #getUsage()} to create a help command
     * @return The description of the command
     */
    String getDescription();

    /**
     * This cn be used with {@link #getDescription()} to create a help command.
     * Note: when displaying the usage, You should add the command prefix at that point and not have this method return with the prefix.
     * @return the usage of the command
     */
    String getUsage();

    /**
     *
     * @return A list of aliases for the command
     */
    String[] getAliases();

    /**
     * Checks the permissions of the channel or the user
     * @param command The context in which to run the command
     * @return True if ok, false if not ok
     */
    boolean permission(CommandContext command);

    /**
     * Runs the command that this command represents
     * @param command The context in which to run the command
     */
    void onCommand(CommandContext command);

    /**
     * Checks another command for equality
     * @param command Command to check against
     * @return Whether the commands have the same identifier
     */
    default boolean equals(Command command) {
        return this.getName().equals(command.getName());
    }
}
