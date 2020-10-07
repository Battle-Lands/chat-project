package org.github.battle.chat;

import com.github.battle.core.plugin.PluginCore;
import org.github.battle.chat.command.ProfileCommand;
import org.github.battle.chat.entity.ChatEntityManager;
import org.github.battle.chat.implementation.component.ChannelComponentFormatter;
import org.github.battle.chat.implementation.component.MessageComponentFormatter;
import org.github.battle.chat.implementation.component.PlayerComponentFormatter;
import org.github.battle.chat.implementation.component.SpecialTagComponentFormatter;
import org.github.battle.chat.implementation.intercept.ChatDeactivatedInterceptor;
import org.github.battle.chat.implementation.intercept.DoubleSpaceInterceptor;
import org.github.battle.chat.listen.ChatTriggerEvent;

public final class ChatSystemPlugin extends PluginCore {

    @Override
    public void onPluginEnable() {
        final ChatEntityManager chatEntityManager = new ChatEntityManager()
          .addChatInterceptors(
            new ChatDeactivatedInterceptor(),
            new DoubleSpaceInterceptor()
          )
          .addChatComponentFormatters(
            new ChannelComponentFormatter(),
            new SpecialTagComponentFormatter(),
            new PlayerComponentFormatter(),
            new MessageComponentFormatter()
          );

        registerCommands(new ProfileCommand(chatEntityManager));
        registerListeners(new ChatTriggerEvent(chatEntityManager));
    }
}
