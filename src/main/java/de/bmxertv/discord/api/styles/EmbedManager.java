package de.bmxertv.discord.api.styles;

import de.bmxertv.discord.api.object.EmbedObject;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class EmbedManager {

    public static EmbedBuilder getEmbedFromObject(EmbedObject embedObject) {
        String titel = embedObject.getTitel();
        String color = embedObject.getColor();
        String description = embedObject.getDescription();

        EmbedObject.AuthorObject author = embedObject.getAuthor();
        String author_name = author.getName();
        String author_url = author.getUrl();
        String author_icon_url = author.getIcon_url();

        String thumbnail = embedObject.getThumbnail();
        System.out.println(thumbnail);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(titel)
                .setColor(Color.decode(color))
                .setDescription(description)
                .setAuthor(author_name);

        if (!author_url.isEmpty()) {
            embed.setAuthor(author_name, author_url);
        }
        if (!author_icon_url.isEmpty()) {
            embed.setAuthor(author_name, author_url, author_icon_url);
        }

        if (!thumbnail.isEmpty()) {
            embed.setThumbnail(thumbnail);
        }

        EmbedObject.FieldObject[] fieldObjects = embedObject.getFieldObjects();
        for (EmbedObject.FieldObject fieldObject : fieldObjects) {
            String field_titel = fieldObject.getTitel();
            String field_description = fieldObject.getDescription();
            Boolean field_inline = fieldObject.getInline();
            embed.addField(field_titel, field_description, field_inline);
        }
        return embed;
    }

}
