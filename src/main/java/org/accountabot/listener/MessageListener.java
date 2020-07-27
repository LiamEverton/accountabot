package org.accountabot.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        Message message = event.getMessage();

        MessageChannel channel = message.getChannel();

        // Create a new accountability channel
        if (channel.getName().equals("accountabot")) {

            if (message.getContentRaw().contains("!challenge")) {

            }
        }
    }
}
