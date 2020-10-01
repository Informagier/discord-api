package de.bmxertv.discord.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import de.bmxertv.discord.api.object.ConfigObject;
import de.bmxertv.discord.api.object.EmbedObject;
import de.bmxertv.discord.api.styles.Emojis;

import java.io.*;
import java.text.MessageFormat;
import java.util.HashMap;

public class ConfigManager {

    public static Object getJsonFromFile(File file, Class<?> toObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, toObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeToJson(File file, Object fromObject) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, fromObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getHashMapFromJsonFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
            Gson gson = new Gson();
            HashMap<String, String> json = gson.fromJson(bufferedReader, HashMap.class);
            return json;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getObjectFromFile(File file, String objectName, Class<?> toObject) {

        HashMap hashMap = getHashMapFromJsonFile(file);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(mapper.writeValueAsString(hashMap.get(objectName)), toObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void cretaeDefaultConfig(File file) {
        EmbedObject onlyBotOwnerMessage = new EmbedObject(
                MessageFormat.format("{0} | **WARNING** | {0}", Emojis.WARNING),
                "#ebcc34",
                "Der Befehl konnte nicht ausgeführt werden! \uD83D\uDE41\nDa du nicht der Bot eigentümer bist.",
                new EmbedObject.AuthorObject("Server", "https://bmxertv.de", "https://bmxertv.de/assets/img/favicon.png"),
                "https://media1.tenor.com/images/bbb1a23fcf766e5439b3546027f3c2b0/tenor.gif?itemid=10711703",
                new EmbedObject.FieldObject[]{});
        EmbedObject noPermissionsMessage = new EmbedObject(
                MessageFormat.format("{0} | **WARNING** | {0}", Emojis.WARNING),
                "#ebcc34",
                "Der Befehl konnte nicht ausgeführt werden da du keine Berechtigung dafür hast!",
                new EmbedObject.AuthorObject("Server", "https://bmxertv.de", "https://bmxertv.de/assets/img/favicon.png"),
                "https://media1.tenor.com/images/bbb1a23fcf766e5439b3546027f3c2b0/tenor.gif?itemid=10711703",
                new EmbedObject.FieldObject[]{});
        ConfigObject configObject = new ConfigObject(
                "",
                "!",
                onlyBotOwnerMessage,
                noPermissionsMessage
        );


        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, configObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
