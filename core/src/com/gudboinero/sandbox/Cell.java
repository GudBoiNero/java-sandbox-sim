package com.gudboinero.sandbox;

import com.badlogic.gdx.math.Vector2;

public abstract class Cell {
    public final CellType type = CellType.NONE;
    public int age = 0;

    public void move(Vector2 pos, Grid map) {

    }
}
