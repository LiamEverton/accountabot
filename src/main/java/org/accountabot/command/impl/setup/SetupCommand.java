package org.accountabot.command.impl.setup;

import org.accountabot.command.args.impl.TimeArgument;
import org.accountabot.command.type.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.restaction.ChannelAction;

import java.util.ArrayList;
import java.util.Collection;

public class SetupCommand extends Command {

    public SetupCommand(String prefix, String command) {
        super(prefix, command);

        //duration.
        getArgs().add(new TimeArgument(this));

        //time period of assessment
        getArgs().add(new TimeArgument(this));
    }

    public boolean execute(Message message) {
        // Create a new channel, with it visible to everyone (for now, look at logs for new feature).
        ChannelAction<TextChannel> textChannel = message.getGuild().createTextChannel(message.getAuthor().getName() + "-org.accountabot.diary");
        MessageChannel messageChannel = message.getChannel();

        textChannel.setName(message.getAuthor().getName() + "'s Diary.");

        // Allow for only the author to speak in the channel.
        Member member = textChannel.getGuild().getMember(message.getAuthor());
        if (member != null) {
            Collection<Permission> allowPermissions = new ArrayList<Permission>();
            allowPermissions.add(Permission.MESSAGE_WRITE);

            Collection<Permission> denyPermissions = new ArrayList<Permission>();
            textChannel.addPermissionOverride(member, allowPermissions, denyPermissions);
        }

        //Send message to introduce the channel.
        messageChannel.sendMessage("Welcome to your org.accountabot.diary. Remind me to update dis xd.").queue();

        //Wait for messages in this channel thru org.accountabot.listener
        return true;
    }
}
