package org.accountabot.scheduler.comp.task;

public interface Task {
    boolean validate();

    void run();
}
