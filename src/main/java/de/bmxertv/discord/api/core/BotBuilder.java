package de.bmxertv.discord.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.EventListener;

public class BotBuilder {

    private JDA jda;

    public BotBuilder(String token) throws LoginException {
        this.jda = JDABuilder.createDefault(token).build();
    }

    public BotBuilder addListener(Object eventListener) {
        this.jda.addEventListener(eventListener);
        return this;
    }

    public BotBuilder addListener(Object[] eventListeners) {
        for (Object eventListener : eventListeners) {
            this.jda.addEventListener(eventListener);
        }
        return this;
    }

    public BotBuilder addListener(ArrayList<Object> eventListeners) {
        eventListeners.forEach(this.jda::addEventListener);
        return this;
    }

    public BotBuilder setPresence(OnlineStatus onlineStatus, Activity activity) {
        this.jda.getPresence().setPresence(onlineStatus, activity);
        return this;
    }

    public BotBuilder setStatus(OnlineStatus onlineStatus) {
        this.jda.getPresence().setStatus(onlineStatus);
        return this;
    }

    public JDA getJDA() {
        return jda;
    }
}
