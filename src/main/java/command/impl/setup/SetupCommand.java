package command.impl.setup;

import command.args.Argument;
import command.type.Command;
import command.type.CommandError;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetupCommand extends Command {

    public SetupCommand(String prefix, String command) {
        super(prefix, command);

        //duration.
        getArgs().add(new Argument(this) {
            @Override
            public CommandError validate(String value) {
                Pattern pattern = Pattern.compile("([1-9]+[dwm])");
                Matcher matcher = pattern.matcher(value);

                if (matcher.matches()) {
                    return null;
                }

                return new CommandError(this.getCommand(), "setup command wrong bro");
            }
        });

        //time period of assessment
    }

    public boolean execute(Message message) {
        return false;
    }
}
