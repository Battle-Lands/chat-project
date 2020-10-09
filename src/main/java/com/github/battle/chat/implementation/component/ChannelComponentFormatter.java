package com.github.battle.chat.implementation.component;

import com.github.battle.chat.component.ChatComponentFormatter;
import lombok.NonNull;
import org.bukkit.entity.Player;

public final class ChannelComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return "§7[§6local§7]";
    }
}
