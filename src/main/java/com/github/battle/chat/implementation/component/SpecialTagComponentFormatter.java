package com.github.battle.chat.implementation.component;

import com.github.battle.chat.component.ChatComponentFormatter;
import lombok.NonNull;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class SpecialTagComponentFormatter implements ChatComponentFormatter {

    @Override
    public String buildComponentInformation(Player player, @NonNull String message) {
        return player.getItemInHand().getType() == Material.DIRT
          ? "§5[Killer]"
          : null;
    }
}
