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
    "fieldObjects" : [ ]
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

