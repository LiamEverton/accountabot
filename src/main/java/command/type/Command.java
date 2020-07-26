package command.type;

import command.args.Argument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public abstract class Command {

    @Getter
    private final String prefix;

    @Getter
    private final String command;

    @Getter
    private final List<Argument> args = new ArrayList<Argument>();

    public abstract boolean execute(Message message);
}
