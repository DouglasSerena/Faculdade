package com.ulbra.list.models;

public class Pokemon {
    String name;
    String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
