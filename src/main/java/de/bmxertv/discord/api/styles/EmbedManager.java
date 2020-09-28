package de.bmxertv.discord.api.styles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.bmxertv.discord.api.core.BotBuilder;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class EmbedManager {


    public static EmbedBuilder getEmbedFromJson(HashMap<String, String> jsonHashMap, String jsonName) {
        try {
            String json = new ObjectMapper().writeValueAsString(jsonHashMap);
            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class).get(jsonName).getAsJsonObject();

            String titel = jsonObject.get("titel").getAsString();
            String color = jsonObject.get("color").getAsString();
            String description = jsonObject.get("description").getAsString();

            JsonObject author = jsonObject.get("author").getAsJsonObject();
            String author_name = author.get("name").getAsString();
            String author_url = author.get("url").getAsString();
            String author_icon_url = author.get("icon_url").getAsString();

            String thumbnail = jsonObject.get("thumbnail").getAsString();

            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle(titel)
                    .setColor(Color.decode(color))
                    .setDescription(description)
                    .setAuthor(author_name, author_url, author_icon_url)
                    .setThumbnail(thumbnail);

            JsonArray fields = jsonObject.get("fields").getAsJsonArray();
            fields.forEach(jsonElement -> {
                JsonObject element = jsonElement.getAsJsonObject();
                String field_titel = element.get("titel").getAsString();
                String field_description = element.get("description").getAsString();
                Boolean field_inline = element.get("inline").getAsBoolean();
                embed.addField(field_titel, field_description, field_inline);
            });

            return embed;


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
