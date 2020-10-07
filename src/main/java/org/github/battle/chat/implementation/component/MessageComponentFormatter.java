package org.github.battle.chat.implementation.component;

import lombok.NonNull;
import org.bukkit.entity.Player;
import org.github.battle.chat.component.ChatComponentFormatter;

import java.util.regex.Matcher;
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
