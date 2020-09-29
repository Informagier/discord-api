package de.bmxertv.discord.api.object;

public class ConfiguarationObject {

    String token;
    String prefix;
    EmbedObject onlyOwnerMessage;
    EmbedObject noPermissionsMessage;

    public ConfiguarationObject() {
    }

    public ConfiguarationObject(String token, String prefix, EmbedObject onlyOwnerMessage, EmbedObject noPermissionsMessage) {
        this.token = token;
        this.prefix = prefix;
        this.onlyOwnerMessage = onlyOwnerMessage;
        this.noPermissionsMessage = noPermissionsMessage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public EmbedObject getOnlyOwnerMessage() {
        return onlyOwnerMessage;
    }

    public void setOnlyOwnerMessage(EmbedObject onlyOwnerMessage) {
        this.onlyOwnerMessage = onlyOwnerMessage;
    }

    public EmbedObject getNoPermissionsMessage() {
        return noPermissionsMessage;
    }

    public void setNoPermissionsMessage(EmbedObject noPermissionsMessage) {
        this.noPermissionsMessage = noPermissionsMessage;
    }
}
