package command.args;

import command.type.Command;
import command.type.CommandError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Argument {

    @Getter
    private final Command command;

    public abstract CommandError validate(String value);
}
