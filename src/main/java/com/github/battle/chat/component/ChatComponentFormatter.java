package com.github.battle.chat.component;

import lombok.NonNull;
import org.bukkit.entity.Player;

public interface ChatComponentFormatter {

    String buildComponentInformation(Player player, @NonNull String message);
}
