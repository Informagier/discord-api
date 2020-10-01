package de.bmxertv.discord.api.styles;

import de.bmxertv.discord.api.object.EmbedObject;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class EmbedManager {

    public static EmbedBuilder getEmbedFromObject(EmbedObject embedObject) {
        EmbedBuilder embed = new EmbedBuilder();

        if (embedObject.getTitel() != null)
            embed.setTitle(embedObject.getTitel());

        if (embedObject.getColor() != null)
            embed.setColor(Color.decode(embedObject.getColor()));

        if (embedObject.getDescription() != null)
            embed.setDescription(embedObject.getDescription());

        if (embedObject.getAuthor() != null) {
            if (embedObject.getAuthor().getName() != null)
                embed.setAuthor(embedObject.getAuthor().getName());
            else if (embedObject.getAuthor().getUrl() != null)
                embed.setAuthor(embedObject.getAuthor().getName(), embedObject.getAuthor().getUrl());
            else
                embed.setAuthor(
                        embedObject.getAuthor().getName(),
                        embedObject.getAuthor().getUrl(),
                        embedObject.getAuthor().getIcon_url()
                );
        }

        if (embedObject.getThumbnail() != null)
            embed.setThumbnail(embedObject.getThumbnail());

        if (embedObject.getFieldObjects() != null) {
            for (EmbedObject.FieldObject fieldObject : embedObject.getFieldObjects()) {
                embed.addField(fieldObject.getTitel(), fieldObject.getDescription(), fieldObject.getInline());
            }
        }
        return embed;
    }

}
