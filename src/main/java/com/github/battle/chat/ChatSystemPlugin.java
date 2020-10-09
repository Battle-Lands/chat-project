package com.github.battle.chat;

import com.github.battle.chat.entity.ChatEntityManager;
import com.github.battle.chat.implementation.component.ChannelComponentFormatter;
import com.github.battle.chat.implementation.component.MessageComponentFormatter;
import com.github.battle.chat.implementation.component.PlayerComponentFormatter;
import com.github.battle.chat.implementation.component.SpecialTagComponentFormatter;
import com.github.battle.chat.implementation.intercept.DoubleSpaceInterceptor;
import com.github.battle.chat.listen.ChatTriggerEvent;
import com.github.battle.core.plugin.PluginCore;
import com.github.battle.chat.command.ProfileCommand;
import com.github.battle.chat.implementation.intercept.ChatDeactivatedInterceptor;

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
