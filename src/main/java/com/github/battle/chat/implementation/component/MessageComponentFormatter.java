package com.github.battle.chat.implementation.component;

import com.github.battle.chat.component.ChatComponentFormatter;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;

public final class MessageComponentFormatter implements ChatComponentFormatter {

    private final String rawRegexMention = "@[a-zA-Z0-9-_]{1,16}\\w";
    private final Pattern compiledPatternMention = Pattern.compile(rawRegexMention);

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return compiledPatternMention
          .matcher(message)
          .replaceAll("§e$0§r");
    }
}
