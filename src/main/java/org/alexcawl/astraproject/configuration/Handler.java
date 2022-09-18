package org.alexcawl.astraproject.configuration;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.alexcawl.astraproject.service.MessageService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class Handler extends ListenerAdapter {
    @Resource
    private MessageService messageService;

    public void onMessageReceived(@NotNull MessageReceivedEvent eventContext) {
        messageService.process(eventContext);
    }
}
