package org.alexcawl.astraproject.resource.utils;

import lombok.extern.slf4j.Slf4j;
import org.alexcawl.astraproject.resource.command.system.ExampleCommand;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CommandManager {
    @Resource
    private ExampleCommand exampleCommand;

    public static final String PREFIX = "!";

    private static final List<Command> commands = new ArrayList<>();

    /**
     * Runs a command based on the context. (Context contains the command to run, If command isn't valid it wont run a command)
     *
     * @param context This is the context in which to run the command
     */
    public static void runCommand(CommandContext context) {
        Command commandToRun = null;
        for (Command command: commands) {
            if (context.getLabel().equalsIgnoreCase(command.getName())) {
                commandToRun = command;
            }
            for (String alias : command.getAliases()) {
                if (context.getLabel().equalsIgnoreCase(alias)) {
                    commandToRun = command;
                }
            }
        }
        if (commandToRun == null) {
            return;
        }
        commandToRun.onCommand(context);
    }

    /**
     * Checks if a command with the same identifier is registered.
     * @param command Command to check.
     * @return Whether or not the given command is registered.
     */
    private static boolean commandExists(Command command) {
        for (Command existingCommand: commands) {
            if (command.equals(existingCommand)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Registers the command. (Checks with {@link #commandExists(Command)})
     * @param command The command to register
     */
    public static void registerCommand(Command command) {
        if (!commandExists(command)) {
            commands.add(command);
        }
    }

    /**
     * Attempts to unregister a command will unregister any command that is equal to it from {@link Command#equals(Command)}.
     * @param command Command to unregister
     */
    public static void unregisterCommand(Command command) {
        if (commandExists(command)) {
            for (int i = 0; i < commands.size(); i++) {
                if (commands.get(i).equals(command)) {
                    commands.remove(i);
                    return;
                }
            }
        }
    }

    /**
     * Gets the command prefix for all commandutils.
     * @return The prefix for all commandutils.
     */
    public static String getPrefix() {
        return PREFIX;
    }

    /**
     * Gets a list of all the registered commandutils
     * @return A list of all the registered commandutils.
     */
    public static List<Command> getCommands() {
        return commands;
    }

    @PostConstruct
    public void initialization() {
        CommandManager.registerCommand(exampleCommand);
    }
}
