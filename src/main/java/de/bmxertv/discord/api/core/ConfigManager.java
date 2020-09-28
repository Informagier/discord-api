package de.bmxertv.discord.api.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.HashMap;

public class ConfigManager {

    public static HashMap<String, String> getJsonFromFile(File file) {
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

}
