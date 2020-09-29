package de.bmxertv.discord.api.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.HashMap;

public abstract class DiscordCommand extends ListenerAdapter {

    protected String name;
    protected String[] aliases;
    protected String description;
    protected boolean botOwnerOnly;
    public static HashMap<String, Object> commands = new HashMap<>();

    public DiscordCommand(String name, String[] aliases, String description, boolean botOwnerOnly) {
        this.name = name;
        this.aliases = aliases;
        this.description = description;
        this.botOwnerOnly = botOwnerOnly;
    }

    protected abstract boolean execute(Command command);

    public void addCommand(Object object) {
        commands.put(name, object);
        Arrays.stream(aliases).forEach(s -> {
            commands.put(s, object);
        });
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAliases() {
        return aliases;
    }

    public static class Command extends ListenerAdapter {
        public GuildMessageReceivedEvent event;
        public String[] args;

        public Command(GuildMessageReceivedEvent event, String[] args) {
            this.event = event;
            this.args = args;
        }

        public TextChannel getChannel() {
            return this.event.getChannel();
        }

        public Member getMember() {
            return this.event.getMember();
        }

    }
}
