# discord-api
Meine Discord Bot Api


## Instalation
- Maven Dependency
- Es sind alle benötigten Libarys in der Api Implementiert einschließlich der JDA
```xml
    <dependency>
      <groupId>de.bmxertv</groupId>
      <artifactId>discord-api</artifactId>
      <version>VERSION</version>
    </dependency> 
```

## Libarys
- JDA
- Gson
- Jackson Core
- Jackson Databind

## JSON FORMATE
- Erstelle die Datei `configration.json`
- Füge das JSON Layout hinzu!
- Trage deine werte ein
```json
{
  "botOwnerMessage": {
    "author": {
      "name": "",
      "url": "",
      "icon_url": ""
    },
    "titel": "",
    "color": "",
    "description": "",
    "thumbnail": "",
    "fields": [
      {
        "name": "",
        "description": "",
        "inline": false
      }
    ]
  }
}
```
- Embed Messages können beliebig hinzugefügt werden in dem Layout

## So nutzt du die API
```java
    // BotBuilder initalizieren
    BotBuilder botBuilder = new BotBuilder("TOKEN");
    // Events hinzufügen
    botBuilder.addListener(LISTENER);
    
    // Command Manager initalizieren
    CommandManager commandManager = new CommandManager("BOT_OWNER_ID", "PREFIX");
    botBuilder.addListener(commandManager);
    commandManager.initCommands(botBuilder);

    // ConfigManager initalizieren
    File file = new File("./configration.json");
    HashMap configManager = ConfigManager.getJsonFromFile(file);
    
    // EmbedManager
    EmbedBuilder embedBuilder = EmbedManager.getEmbedFromJson(configManager, "JSON_NAME");    
```