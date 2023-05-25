package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;

public class DirtCell extends Cell {
    public DirtCell() {
        super(CellType.DIRT, 0, 10, 0, new Color(.6f,.5f,.5f,1f));
    }
}
