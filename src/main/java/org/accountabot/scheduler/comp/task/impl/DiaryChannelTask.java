package org.accountabot.scheduler.comp.task.impl;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.restaction.AuditableRestAction;
import org.accountabot.Bot;
import org.accountabot.diary.DiaryChannel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.accountabot.scheduler.comp.task.Task;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class DiaryChannelTask implements Task {

    @Getter
    private final DiaryChannel diaryChannel;

    @Override
    public boolean validate() {
        if (LocalDateTime.now().isAfter(diaryChannel.getExpiry())) {
            return true;
        }

        return false;
    }

    @Override
    public void run() {
        TextChannel diaryChannel = Bot.getInstance().getTextChannelById(this.diaryChannel.getChannelId());

        AuditableRestAction<Void> delete = diaryChannel.delete();
        delete.reason("Expired.");
    }
}
