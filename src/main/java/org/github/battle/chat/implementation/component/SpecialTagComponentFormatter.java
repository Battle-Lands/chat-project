package org.github.battle.chat.implementation.component;

import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.github.battle.chat.component.ChatComponentFormatter;

public final class SpecialTagComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return player.getItemInHand().getType() == Material.DIRT
          ? "§5[Killer]"
          : null;
    }
}
