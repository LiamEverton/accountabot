package org.accountabot.command.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommandError {

    @Getter
    private final Command command;

    @Getter
    private final String message;
}
