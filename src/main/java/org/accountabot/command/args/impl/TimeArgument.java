package org.accountabot.command.args.impl;

import org.accountabot.command.args.Argument;
import org.accountabot.command.type.Command;
import org.accountabot.command.type.CommandError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeArgument extends Argument {

    public TimeArgument(Command command) {
        super(command);
    }

    @Override
    public CommandError validate(String value) {
        Pattern pattern = Pattern.compile("([1-9]+[dwm])");
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            return null;
        }

        return new CommandError(this.getCommand(), "argument wrong bro.");
    }
}
