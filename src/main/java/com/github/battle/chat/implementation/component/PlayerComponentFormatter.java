package com.github.battle.chat.implementation.component;

import com.github.battle.chat.component.ChatComponentFormatter;
import lombok.NonNull;
import org.bukkit.entity.Player;

public final class PlayerComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return String.format(
          "§b[Dev] §7%s:",
          player.getName()
        );
    }
}
