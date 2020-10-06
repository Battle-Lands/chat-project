package org.github.battle.chat.implementation.component;

import lombok.NonNull;
import org.bukkit.entity.Player;
import org.github.battle.chat.component.ChatComponentFormatter;

public final class PlayerComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return String.format(
          "§b[Dev] §7%s:",
          player.getName()
        );
    }
}
