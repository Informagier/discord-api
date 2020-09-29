package de.bmxertv.discord.api.object;

public class EmbedObject {

    String titel;
    String color;
    String description;

    AuthorObject author;

    String thumbnail;

    FieldObject[] fieldObjects;

    public EmbedObject() {
    }

    public EmbedObject(String titel, String color, String description, AuthorObject author, String thumbnail, FieldObject[] fieldObjects) {
        this.titel = titel;
        this.color = color;
        this.description = description;
        this.author = author;
        this.thumbnail = thumbnail;
        this.fieldObjects = fieldObjects;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorObject getAuthor() {
        return author;
    }

    public void setAuthor(AuthorObject author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public FieldObject[] getFieldObjects() {
        return fieldObjects;
    }

    public void setFieldObjects(FieldObject[] fieldObjects) {
        this.fieldObjects = fieldObjects;
    }

    public static class AuthorObject {
        String name;
        String url;
        String icon_url;

        public AuthorObject() {
        }

        public AuthorObject(String name, String url, String icon_url) {
            this.name = name;
            this.url = url;
            this.icon_url = icon_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }
    }

    public static class FieldObject {
        String titel;
        String description;
        Boolean inline;

        public FieldObject() {
        }

        public FieldObject(String titel, String description, Boolean inline) {
            this.titel = titel;
            this.description = description;
            this.inline = inline;
        }

        public String getTitel() {
            return titel;
        }

        public void setTitel(String titel) {
            this.titel = titel;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getInline() {
            return inline;
        }

        public void setInline(Boolean inline) {
            this.inline = inline;
        }
    }
}
