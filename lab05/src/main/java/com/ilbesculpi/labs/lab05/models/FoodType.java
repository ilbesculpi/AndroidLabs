package com.ilbesculpi.labs.lab05.models;

public enum FoodType {

    DESAYUNO("Desayuno", "#448aff"),
    ALMUERZO("Almuerzo", "#4caf50"),
    ENTRADA("Entrada", "#009688"),
    MERIENDA("Merienda", "#cfd8dc"),
    POSTRE("Postre", "#7c4dff"),
    CENA("Cena", "#c2185b"),
    NONE("", "#ffffff");

    private String value;
    private String background;

    private FoodType(String value, String background) {
        this.value = value;
        this.background = background;
    }

    public String getValue() {
        return value;
    }

    public static FoodType fromString(String s) {

        if( s.equals(DESAYUNO.getValue()) ) {
            return DESAYUNO;
        }

        if( s.equals(ALMUERZO.getValue()) ) {
            return ALMUERZO;
        }

        if( s.equals(ENTRADA.getValue()) ) {
            return ENTRADA;
        }

        if( s.equals(MERIENDA.getValue()) ) {
            return MERIENDA;
        }

        if( s.equals(POSTRE.getValue()) ) {
            return POSTRE;
        }

        if( s.equals(CENA.getValue()) ) {
            return CENA;
        }

        return NONE;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public String getBackground() {
        return background;
    }
}
