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
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class EmbedManager {

    public static EmbedBuilder getEmbedFromJson(HashMap<String, String> jsonHashMap, String jsonName) {
        try {
            String json = new ObjectMapper().writeValueAsString(jsonHashMap);
            JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class).get(jsonName).getAsJsonObject();

            EmbedBuilder embedBuilder = new EmbedBuilder();
            String author_name = jsonObject.get("name").getAsString();
            String author_url = jsonObject.get("url").getAsString();
            String author_icon_url = jsonObject.get("icon_url").getAsString();
            String titel = jsonObject.get("titel").getAsString();
            String color = jsonObject.get("color").getAsString();
            String description = jsonObject.get("description").getAsString();
            JsonArray fieldsArray = jsonObject.get("fields").getAsJsonArray();
            HashMap<Integer, MessageEmbed.Field> fields = new HashMap<>();
            AtomicInteger i = new AtomicInteger();
            fieldsArray.forEach(jsonElement -> {
                String name = jsonElement.getAsJsonObject().get("name").getAsString();
                String description_filed = jsonElement.getAsJsonObject().get("description").getAsString();
                boolean inline = jsonElement.getAsJsonObject().get("inline").getAsBoolean();
                embedBuilder.addField(name, description_filed, inline);
            });

            embedBuilder.setAuthor(author_name, author_url, author_icon_url);
            embedBuilder.setTitle(titel);
            embedBuilder.setColor(Color.decode(color));
            embedBuilder.setDescription(description);

            return embedBuilder;

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
