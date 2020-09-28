package de.bmxertv.discord.api.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.HashMap;

public abstract class DiscordCommand {

    protected String name;
    protected String[] aliases;
    protected String description;
    protected boolean botOwnerOnly;
    private HashMap<String, DiscordCommand> commands = new HashMap<>();

    protected abstract boolean execute(Command command);

    public void addCommand(Object object) {
        commands.put(name, (DiscordCommand) object);
        Arrays.stream(aliases).forEach(this::addCommand);
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

    private class Command extends ListenerAdapter {
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
