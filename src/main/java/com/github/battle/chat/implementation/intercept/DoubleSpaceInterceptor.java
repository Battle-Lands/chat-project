package com.github.battle.chat.implementation.intercept;

import com.github.battle.chat.component.ChatInterceptor;
import com.github.battle.chat.component.ChatInterceptorObject;
import org.bukkit.entity.Player;

public final class DoubleSpaceInterceptor implements ChatInterceptor {

    @Override
    public boolean checkInterceptor(ChatInterceptorObject interceptorObject) {
        final Player player = interceptorObject.getPlayer();
        if (player.hasPermission("battle.lands.space")) {
            final StringBuilder information = interceptorObject.getInformation();

            //Set spaces
            information.insert(0, " \n");
            information.insert(information.length(), " \n ");
        }

        return false;
    }
}
