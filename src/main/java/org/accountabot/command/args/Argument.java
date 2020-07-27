package org.accountabot.command.args;

import org.accountabot.command.type.Command;
import org.accountabot.command.type.CommandError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Argument {

    @Getter
    private final Command command;

    public abstract CommandError validate(String value);
}
