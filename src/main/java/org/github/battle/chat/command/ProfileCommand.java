package org.github.battle.chat.command;

import lombok.RequiredArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.entity.Player;
import org.github.battle.chat.entity.ChatEntityManager;

@RequiredArgsConstructor
public final class ProfileCommand {

    private final ChatEntityManager chatEntityManager;

    @Command(
      name = "profile",
      target = CommandTarget.PLAYER
    )
    public void helpProfileCommand(Context<Player> playerContext) {
    }
}
