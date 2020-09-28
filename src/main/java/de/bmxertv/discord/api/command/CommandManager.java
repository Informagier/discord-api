package de.bmxertv.discord.api.command;

import de.bmxertv.discord.api.core.BotBuilder;
import de.bmxertv.discord.api.core.ConfigManager;
import de.bmxertv.discord.api.styles.EmbedManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class CommandManager extends ListenerAdapter {

    HashMap<String, DiscordCommand> commands = DiscordCommand.commands;
    private final String botOwnerId;
    private final String prefix;

    public CommandManager(String botOwnerId, String prefix) {
        this.botOwnerId = botOwnerId;
        this.prefix = prefix;
    }

    public void initCommands(BotBuilder botBuilder) {
//        botBuilder.addListener(this);
        botBuilder.addListener(commands.values());
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw().trim();
        if (message.startsWith(this.prefix) && !event.getAuthor().isBot()) {
            String invoke = message.split(" ")[0].substring(prefix.length());
            String[] args = Arrays.stream(message.split(" ")).skip(1).toArray(String[]::new);
            DiscordCommand command = commands.get(invoke);
            if (command.botOwnerOnly && !event.getMember().getId().equals(this.botOwnerId)) {
                EmbedBuilder embed = EmbedManager.getEmbedFromJson(
                        ConfigManager.getJsonFromFile(new File("./configration.json")), "botOwnerMessage");
                event.getChannel().sendMessage(embed.build()).queue();
                return;
            }
            command.execute(new DiscordCommand.Command(event, args));
        }
    }
}
