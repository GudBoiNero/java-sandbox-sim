package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;

public class EmptyCell extends Cell {
    public EmptyCell() {
        super(CellType.NONE, 0, 0, 0, new Color(1f,1f,1f,1f));
    }
}
