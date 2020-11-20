package de.bmxertv.discord.api.command;

import de.bmxertv.discord.api.core.BotBuilder;
import de.bmxertv.discord.api.core.ConfigManager;
import de.bmxertv.discord.api.object.EmbedObject;
import de.bmxertv.discord.api.styles.EmbedManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class CommandManager extends ListenerAdapter {

    HashMap<String, Object> commands = DiscordCommand.commands;
    private final String botOwnerId;
    private final String prefix;
    private final EmbedObject botOwnerMessage;

    public CommandManager(String botOwnerId, String prefix, EmbedObject botOwnerMessage) {
        this.botOwnerId = botOwnerId;
        this.prefix = prefix;
        this.botOwnerMessage = botOwnerMessage;
    }

    public void initCommands(BotBuilder botBuilder) {
        commands.forEach((s, discordCommand) -> {
            botBuilder.addListener(discordCommand);
        });
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        try {
            String message = event.getMessage().getContentRaw().trim();
            if (message.startsWith(this.prefix) && !event.getAuthor().isBot()) {
                String invoke = message.split(" ")[0].substring(prefix.length());
                String[] args = Arrays.stream(message.split(" ")).skip(1).toArray(String[]::new);
                DiscordCommand command = (DiscordCommand) commands.get(invoke);
                if (command.botOwnerOnly && !event.getMember().getId().equals(this.botOwnerId)) {
                    EmbedBuilder embedBuilder = EmbedManager.getEmbedFromObject(this.botOwnerMessage);
                    event.getChannel().sendMessage(embedBuilder.build()).queue();
                    return;
                }
                command.execute(new DiscordCommand.Command(event, args));
            }
        } catch (Exception e) {
        }
    }
}
