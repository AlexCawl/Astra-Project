package org.alexcawl.astraproject.service;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.alexcawl.astraproject.resource.utils.CommandContext;
import org.alexcawl.astraproject.resource.utils.CommandManager;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {
    private boolean is_command(MessageReceivedEvent eventContext) {
        return eventContext.getMessage().getContentRaw().startsWith(CommandManager.getPrefix());
    }

    public void process(MessageReceivedEvent eventContext) {
        if (is_command(eventContext)) {
            CommandManager.runCommand(new CommandContext(eventContext));
        }
    }
}
