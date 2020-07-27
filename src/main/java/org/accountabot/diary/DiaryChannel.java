package org.accountabot.diary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class DiaryChannel {

    @Getter
    private final String user;

    @Getter
    private final String channelId;

    @Getter
    private final LocalDateTime expiry;
}
