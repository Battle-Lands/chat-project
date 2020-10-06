package org.github.battle.chat.implementation.intercept;

import org.bukkit.entity.Player;
import org.github.battle.chat.component.ChatInterceptor;
import org.github.battle.chat.component.ChatInterceptorObject;

public final class DoubleSpaceInterceptor implements ChatInterceptor {

    @Override
    public boolean checkInterceptor(ChatInterceptorObject interceptorObject) {
        final Player player = interceptorObject.getPlayer();
        if(player.hasPermission("battle.lands.space")) {
            final StringBuilder information = interceptorObject.getInformation();

            //Set spaces
            information.insert(0, " \n");
            information.insert(information.length(), " \n ");
        }

        return false;
    }
}
