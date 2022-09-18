package org.alexcawl.astraproject.resource.utils;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * This class contains context about a command that is run.
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CommandContext {
    private MessageReceivedEvent context;

    private String label;

    private String[] args;

    public CommandContext(MessageReceivedEvent context) {
        String prefix = CommandManager.getPrefix();
        this.context = context;
        this.label = context.getMessage().getContentStripped().replace(prefix, "").split(" ")[0];
        String tmp = context.getMessage().getContentRaw().replace(prefix, "").replace(this.label, "").replaceAll("^ +| +$|( )+", "$1");
        if (tmp.isBlank()) {
            this.args = new String [] {};
        } else {
            this.args = tmp.split(" ");
        }
    }

    public CommandContext(MessageReceivedEvent context, String commandName) {
        this.context = context;
        this.label = commandName;
        this.args = new String [] {context.getMessage().getContentRaw()};
    }
}
