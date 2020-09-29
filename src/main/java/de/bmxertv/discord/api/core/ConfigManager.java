package de.bmxertv.discord.api.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
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
}
