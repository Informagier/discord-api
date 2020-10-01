# discord-api
Meine Discord Bot Api


## Instalation
- Maven Dependency
- Es sind alle benötigten Libarys in der Api Implementiert einschließlich der JDA
```xml
    <dependency>
      <groupId>de.bmxertv</groupId>
      <artifactId>discord-api</artifactId>
      <version>1.3-RELEASE</version>
    </dependency> 
```

## Libarys
- JDA
- Gson
- Jackson Core
- Jackson Databind

## JSON FORMATE
- Erstelle eine Datei mit der Endung `.json`
- Configuriere die Json datei
```json
{
  "token" : "",
  "prefix" : "",
  "onlyOwnerMessage" : {
    "titel" : "",
    "color" : "",
    "description" : "",
    "author" : {
      "name" : "",
      "url" : "",
      "icon_url" : ""
    },
    "thumbnail" : "",
    "fieldObjects" : [
      {
        "titel": "",
        "description": "",
        "inline": false
      }
    ]
  },
  "noPermissionsMessage" : {
    "titel" : "",
    "color" : "",
    "description" : "",
    "author" : {
      "name" : "",
      "url" : "",
      "icon_url" : ""
    },
    "thumbnail" : "",
    "fieldObjects" : [ ]
  }
}
```
- Embed Messages können beliebig hinzugefügt werden in dem Layout

## Beispiele
### BotBuilder
```java
    BotBuilder botBuilder = new BotBuilder("TOKEN");
```
### Config Manager
```java
    File configFile = new File("./config.json");
    ConfigObject configObject = (ConfigObject) ConfigManager.getJsonFromFile(configFile, ConfigObject.class);
    
    // ERSTELLEN DER STANDRD CONFIG
    ConfigManager.createDefaultConfig(configFile);
    // PREFIX AUSGEBEN
    System.out.println(configObject.getPrefix());
```
### Command Manager
```java
    CommandManager commandManager = new CommandManager(
        "botOwnerId",
        // NUTZT DEN STRING AUS DER CONFIG DATEI
        configObject.getPrefix(),
        // NUTZ DAS ONLY_OWNER_MESSAGE OBJECT AUS DER CONFIG DATEI
        configObject.getOwnlyOwnerMessage()
    );
    // FÜGT DEN COMMAND MANAGER ZUM BOT HINZU
    botBuilder.addListener(commandManager);
    // FÜGT ALLE COMMANDS ZUM BOT HINZU
    commandManager.initCommand(botBuilder);
```
### COMMAND
```java
import de.bmxertv.discord.api.command.DiscordCommand;

public class Example extends DiscordCommand {
    
    public Example() {
        super("name", new String[]{"aliases"}, "Beschreibung", botOwnerOnly);
        addCommand(this);    
    }
    
    protected boolean execute(Command command) {
        command.getChannel().sendMessage("Hello World!").queue();
        return false;
    }
  
}
```
### EmbedObject
```java
    EmbedObject embedObject = new EmbedObject(
        "TITEL",
        "COLOR",
        "BESCHREIBUNG (OPTIONAL)",
        new EmbedObject.AuthorObject("NAME", "URL (OPTIONAL)" , "ICON_URL (OPTIONAL)") (OPTIONAL),
        "THUMBNAIL_URL (OPTIONAL)",
        new EmbedObject.FieldObject[]{
            new EmbedObject.FieldObject("TITEL", "BESCHREIBUNG", "INLINE")
        } (OPTIONAL) 
    );

    // KANN AUCH OHNE VARIABLE GENUTZ WERDEN BEI SENDEN EINER NACHRICHT
    EmbedBuilder embed = EmbedManager.getEmbedFromObject(embedObject);
```