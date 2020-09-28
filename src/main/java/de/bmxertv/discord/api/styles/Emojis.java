package de.bmxertv.discord.api.styles;

public enum Emojis {

    NUMBER_1("\u0031\u20E3"),
    NUMBER_2("\u0032\uFE0F\u20E3"),
    NUMBER_3("\u0033\uFE0F\u20E3"),
    NUMBER_4("\u0034\uFE0F\u20E3"),
    NUMBER_5("\u0035\uFE0F\u20E3"),
    NUMBER_6("\u0036\uFE0F\u20E3"),
    NUMBER_7("\u0037\uFE0F\u20E3"),
    NUMBER_8("\u0038\uFE0F\u20E3"),
    NUMBER_9("\u0039\uFE0F\u20E3"),
    NUMBER_10("\uD83D\uDD1F"),
    NUMBER_0("\u0030\uFE0F\u20E3"),


    LETTER_A("\uD83C\uDDE6"),
    LETTER_B("\uD83C\uDDE7"),
    LETTER_C("\uD83C\uDDE8"),
    LETTER_D("\uD83C\uDDE9"),
    LETTER_E("\uD83C\uDDEA"),
    LETTER_F("\uD83C\uDDEB"),
    LETTER_G("\uD83C\uDDEC"),
    LETTER_H("\uD83C\uDDED"),
    LETTER_I("\uD83C\uDDEE"),
    LETTER_J("\uD83C\uDDEF"),
    LETTER_K("\uD83C\uDDF0"),
    LETTER_L("\uD83C\uDDF1"),
    LETTER_M("\uD83C\uDDF2"),
    LETTER_N("\uD83C\uDDF3"),
    LETTER_O("\uD83C\uDDF4"),
    LETTER_P("\uD83C\uDDF5"),
    LETTER_Q("\uD83C\uDDF6"),
    LETTER_R("\uD83C\uDDF7"),
    LETTER_S("\uD83C\uDDF8"),
    LETTER_T("\uD83C\uDDF9"),
    LETTER_U("\uD83C\uDDFA"),
    LETTER_V("\uD83C\uDDFB"),
    LETTER_W("\uD83C\uDDFC"),
    LETTER_X("\uD83C\uDDFD"),
    LETTER_Y("\uD83C\uDDFE"),
    LETTER_Z("\uD83C\uDDFF"),

    DIAMOND_RED("\u2666"),

    SMALL_DIAMOND_BLUE("\uD83D\uDD39"),
    LARGE_DIAMOND_BLUE("\uD83D\uDD37"),

    SMALL_DIAMOND_ORANGE("\uD83D\uDD38"),
    LARGE_DIAMOND_ORANGE("\uD83D\uDD36"),

    SMALL_SQUARE_BLACK("\u25AA"),
    MEDIUM_SQUARE_BLACK("\u25FC"),
    LARGE_SQUARE_BLACK("\u2B1B"),

    SMALL_SQUARE_WHITE("\u25AB"),
    MEDIUM_SQUARE_WHITE("\u25FD"),
    LARGE_SQUARE_WHITE("\u2B1C"),

    SQUARE_WHITE("\u2B1C"),
    SQUARE_YELLOW("\uD83D\uDFE8"),
    SQUARE_BLUE("\uD83D\uDFE6"),
    SQUARE_RED("\uD83D\uDFE5"),
    SQUARE_BROWN("\uD83D\uDFEB"),
    SQUARE_MAGENTA("\uD83D\uDFEA"),
    SQUARE_GREEN("\uD83D\uDFE9"),
    SQUARE_ORANGE("\uD83D\uDFE7"),

    CHECKMARK("\u2705"),
    CANCEL("\u274C"),

    ROTATING_LIGHT("\uD83D\uDEA8"),
    WARNING("\u26A0"),
    ;

    private String value;
    Emojis(String value) {
        this.value = value;
    }
    public String toString() {return this.value;}
}
