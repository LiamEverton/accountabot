package org.accountabot.scheduler.impl;

import org.accountabot.diary.DiaryChannel;
import lombok.Getter;
import org.accountabot.scheduler.comp.Schedule;
import org.accountabot.scheduler.comp.task.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler extends Thread implements Schedule {

    @Getter
    private volatile boolean isRunning = false;

    private final List<Task> tasks = new ArrayList<>();

    public synchronized void run() {
        while (isRunning) {
            for (Task task : tasks) {
                if (task.validate()) {
                    task.run();
                }
            }
        }
    }

    public synchronized void schedule(Task task) {
        this.tasks.remove(task);
    }

    public synchronized void cancel(Task task) {
        this.tasks.remove(task);
    }

    public synchronized List<Task> getTasks() {
        return this.tasks;
    }

    public synchronized void setRunning(boolean value) {
        this.isRunning = value;
    }
}
