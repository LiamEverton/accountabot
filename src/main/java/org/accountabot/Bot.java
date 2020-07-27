package org.accountabot;

import org.accountabot.listener.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {

    private static JDA INSTANCE = null;

    public static void main(String[] args)
            throws LoginException, InterruptedException {
        // Note: It is important to register your ReadyListener before building
        JDA jda = JDABuilder.createDefault("token")
                .addEventListeners(new MessageListener())
                .build();

        // optionally block until JDA is ready
        jda.awaitReady();

        INSTANCE = jda;
    }

    public static JDA getInstance() {
        return INSTANCE;
    }
}
