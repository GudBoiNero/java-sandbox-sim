package com.gudboinero.sandbox;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Grid {
    private final Cell[][] _grid;

    public Grid(Cell[][] grid) {
        _grid = grid;
    }

    public Cell getCell(Vector2 pos) {
        return _grid[(int) pos.y][(int) pos.x];
    }
}
