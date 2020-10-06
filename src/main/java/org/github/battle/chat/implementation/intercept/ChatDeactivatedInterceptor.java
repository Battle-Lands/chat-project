package org.github.battle.chat.implementation.intercept;

import org.github.battle.chat.component.ChatInterceptor;
import org.github.battle.chat.component.ChatInterceptorObject;

public final class ChatDeactivatedInterceptor implements ChatInterceptor {

    @Override
    public boolean checkInterceptor(ChatInterceptorObject interceptorObject) {
        interceptorObject.setCauseIntercept("§cO chat está desabilitado no momento, vai se fude!");
        return false;
    }
}
