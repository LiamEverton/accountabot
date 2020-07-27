package org.accountabot.command;

import org.accountabot.command.type.Command;
import org.accountabot.command.type.CommandError;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;

import java.util.List;

@RequiredArgsConstructor
public class CommandExecutor {

    private final List<Command> commands;

    public void execute(Message message) {
        for (Command command : commands) {

            if (this.validate(command, message)) {
                command.execute(message);
            }
        }
    }

    private boolean validate(Command command, Message message) {
        String[] values = message.getContentRaw().split(" ");

        //Check if we have enough for a prefix + org.accountabot.command.
        if (values.length >= 2) {
            if (values[0].equalsIgnoreCase(command.getPrefix())) {
                if (values[1].equalsIgnoreCase(command.getCommand())) {

                    //Check if we have enough for the arguments required.
                    if (command.getArgs().size() > 0) {

                        //Iterate through each arg and see if they are valid.
                        for (int index = 2; index < command.getArgs().size(); index++) {

                            //If any argument invalidates the org.accountabot.command contract, it is incorrectly entered.
                            CommandError error = command.getArgs().get(index - 2).validate(values[index]);

                            if (error != null) {

                                //Send error message.
                                message.getChannel().sendMessage(error.getMessage()).queue();

                                return false;
                            }
                        }
                    }

                    return true;
                }
            }
        }

        return false;
    }
}
