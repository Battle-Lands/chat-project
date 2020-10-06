package org.github.battle.chat.listen;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.github.battle.chat.component.ChatInterceptorObject;
import org.github.battle.chat.entity.ChatEntityManager;

@RequiredArgsConstructor
public final class ChatTriggerEvent implements Listener {

    private final ChatEntityManager chatEntityManager;

    @EventHandler
    private void playerChatTrigger(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        final String message = event.getMessage().trim();
        final StringBuilder chatInformation = chatEntityManager.constructChatInformation(
          player,
          message
        );

        final ChatInterceptorObject interceptorObject = chatEntityManager.checkChatInterceptors(
          player,
          message,
          chatInformation
        );

        if(interceptorObject.isIntercepted()) {
            player.sendMessage(interceptorObject.getCauseIntercept());
            event.setCancelled(true);
            return;
        }

        event.setFormat(chatInformation.toString());
    }
}
