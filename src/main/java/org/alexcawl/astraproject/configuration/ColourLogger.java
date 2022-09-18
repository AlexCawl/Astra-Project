package org.alexcawl.astraproject.configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Getter
public class ColourLogger {
    private final String ANSI_RESET = "\u001b[0m";

    private final String ANSI_BLACK = "\u001b[30m";
    private final String ANSI_RED = "\u001b[31m";
    private final String ANSI_GREEN = "\u001b[32m";
    private final String ANSI_YELLOW = "\u001b[33m";
    private final String ANSI_BLUE = "\u001b[34m";
    private final String ANSI_MAGENTA = "\u001b[35m";
    private final String ANSI_CYAN = "\u001b[36m";
    private final String ANSI_WHITE = "\u001b[37m";

    private final String ANSI_BACKGROUND_BLACK = "\u001b[40m";
    private final String ANSI_BACKGROUND_RED = "\u001b[41m";
    private final String ANSI_BACKGROUND_GREEN = "\u001b[42m";
    private final String ANSI_BACKGROUND_YELLOW = "\u001b[43m";
    private final String ANSI_BACKGROUND_BLUE = "\u001b[44m";
    private final String ANSI_BACKGROUND_MAGENTA = "\u001b[45m";
    private final String ANSI_BACKGROUND_CYAN = "\u001b[46m";
    private final String ANSI_BACKGROUND_WHITE = "\u001b[47m";

    public String standart(String message) {
        return message;
    }

    public String inversion(String message) {
        return ANSI_BACKGROUND_WHITE + ANSI_BLACK + message + ANSI_RESET;
    }

    public String start(String message) {
        return ANSI_GREEN + message + ANSI_RESET;
    }

    public String warning(String message) {
        return ANSI_YELLOW + message + ANSI_RESET;
    }

    public String error(String message) {
        return ANSI_RED + message + ANSI_RESET;
    }
}
