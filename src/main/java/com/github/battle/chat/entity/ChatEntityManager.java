package com.github.battle.chat.entity;

import com.github.battle.chat.component.ChatComponentFormatter;
import com.github.battle.chat.component.ChatInterceptor;
import com.github.battle.chat.component.ChatInterceptorObject;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public final class ChatEntityManager {

    private final List<ChatComponentFormatter> chatComponentFormatters;
    private final List<ChatInterceptor> chatInterceptors;

    public ChatEntityManager() {
        this.chatComponentFormatters = new ArrayList<>();
        this.chatInterceptors = new ArrayList<>();
    }

    public ChatEntityManager addChatComponentFormatters(ChatComponentFormatter... componentFormatters) {
        Collections.addAll(chatComponentFormatters, componentFormatters);
        return this;
    }

    public ChatEntityManager addChatInterceptors(ChatInterceptor... interceptors) {
        Collections.addAll(chatInterceptors, interceptors);
        return this;
    }

    public ChatInterceptorObject checkChatInterceptors(Player player, String message, StringBuilder information) {
        final ChatInterceptorObject interceptorObject = new ChatInterceptorObject(
          player,
          message,
          information
        );

        for (ChatInterceptor chatInterceptor : chatInterceptors) {
            final boolean interceptor = chatInterceptor.checkInterceptor(interceptorObject);
            interceptorObject.setIntercepted(interceptor);

            if (interceptor) return interceptorObject;
        }

        return interceptorObject;
    }

    public StringBuilder constructChatInformation(Player player, String message) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (ChatComponentFormatter chatComponentFormatter : chatComponentFormatters) {
            final String componentInformation = chatComponentFormatter.buildComponentInformation(player, message);
            if (componentInformation == null || componentInformation.isEmpty()) continue;

            stringBuilder.append(componentInformation).append("§r ");
        }

        return stringBuilder;
    }
}
