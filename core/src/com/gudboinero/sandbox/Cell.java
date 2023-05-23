package com.gudboinero.sandbox;

public class Cell {
    enum Type {
        AIR, WATER, DIRT, GRASS, SAND
    }

    public final Type type;
    public int age = 0;

    public Cell(Type t) {
        type = t;
    }
}
