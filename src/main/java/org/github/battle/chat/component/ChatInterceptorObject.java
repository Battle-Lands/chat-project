package org.github.battle.chat.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
@RequiredArgsConstructor
public final class ChatInterceptorObject {

    private final Player player;
    private final String message;
    private final StringBuilder information;

    @Setter private String causeIntercept;
    @Setter private boolean isIntercepted;
}
