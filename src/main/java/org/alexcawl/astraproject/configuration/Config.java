package org.alexcawl.astraproject.configuration;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;
import java.util.Random;

@Slf4j
@Configuration
public class Config {
    @Resource
    private ApplicationArguments args;
    @Resource
    private Handler handler;

    @Bean
    public JDA jda() throws LoginException, IllegalArgumentException {
        if (args.getNonOptionArgs().size() > 0) {
            return JDABuilder.create(args.getNonOptionArgs().get(0), GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                    .addEventListeners(handler)
                    .setActivity(Activity.playing("with your mom"))
                    .build();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Bean
    public Random randomizer() {
        return new Random();
    }
}

