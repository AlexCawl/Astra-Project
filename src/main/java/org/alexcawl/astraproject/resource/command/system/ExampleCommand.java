package org.alexcawl.astraproject.resource.command.system;

import lombok.extern.slf4j.Slf4j;
import org.alexcawl.astraproject.resource.utils.Command;
import org.alexcawl.astraproject.resource.utils.CommandContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ExampleCommand implements Command {
    @Override
    public String getName() {
        return "example";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public String getUsage() {
        return null;
    }

    @Override
    public String[] getAliases() {
        return new String[0];
    }

    @Override
    public boolean permission(CommandContext command) {
        return false;
    }

    @Override
    public void onCommand(CommandContext command) {
        System.out.println("Hello world!");
    }
}
