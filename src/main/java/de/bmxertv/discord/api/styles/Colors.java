package de.bmxertv.discord.api.styles;

import java.awt.*;

public enum Colors {

    WHITE(new Color(255,255,255)),
    BLACK(new Color(0,0,0)),
    GRAY(new Color(160,160,160)),
    BROWN(new Color(153,76,0)),
    BLUE(new Color(0,0,255)),
    RED(new Color(255,0,0)),
    GREEN(new Color(0,255,0)),
    PINK(new Color(255, 0, 251)),
    YELLOW(new Color(255, 225, 0)),
    ORANGE(new Color(255, 121, 0)),
    MAGENTA(new Color(166, 0, 255)),

    DARK_GREY(new Color(64,64,64)),
    DARK_BROWN(new Color(102,51,0)),
    DARK_BLUE(new Color(0,0,153)),
    DARK_RED(new Color(153,0,0)),
    DARK_GREEN(new Color(0,153,0)),
    DARK_MAGENTA(new Color(153,0,153)),

    LIGHT_GREY(new Color(200, 199, 199)),
    LIGHT_BROWN(new Color(255, 153, 51)),
    LIGHT_BLUE(new Color(70, 191, 234)),
    LIGHT_RED(new Color(238, 75, 75)),
    LIGHT_GREEN(new Color(160, 246, 82)),
    LIGHT_PINK(new Color(209, 78, 231)),
    LIGHT_YELLOW(new Color(239, 217, 90)),
    LIGHT_ORANGE(new Color(248, 144, 61)),
    LIGHT_MAGENTA(new Color(194, 117, 248)),
    ;

    private final Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color toColor() {
        return color;
    }


}
