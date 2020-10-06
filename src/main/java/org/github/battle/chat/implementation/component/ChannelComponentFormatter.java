package org.github.battle.chat.implementation.component;

import lombok.NonNull;
import org.bukkit.entity.Player;
import org.github.battle.chat.component.ChatComponentFormatter;

public final class ChannelComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return "§7[§6local§7]";
    }
}
