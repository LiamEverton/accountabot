package org.accountabot.scheduler.comp;


import org.accountabot.scheduler.comp.task.Task;

public interface Schedule {

    void run();

    void schedule(Task task);

    void cancel(Task task);
}
