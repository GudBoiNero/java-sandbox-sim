package com.gudboinero.sandbox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import org.omg.CORBA.Any;

import java.util.Dictionary;
import java.util.Enumeration;

public class Cell {
    private final CellType type;
    private final float density;
    private final Color color;

    public Cell(CellType type, float density, Color color) {
        this.type = type;
        this.color = color;
        this.density = density;
    }

    public Vector2 getMove(Grid grid, Vector2 curPos) {
        return curPos;
    }

    public boolean canMove(Grid grid, Vector2 curPos, Cell toCell) {
        Cell cell = grid.getCell(curPos);
        if (toCell != null) {
            return toCell.getDensity() < cell.getDensity();
        }
        return false;
    }

    public Cell up(Grid grid, Vector2 curPos) {
        return grid.getCell(new Vector2(curPos.x, curPos.y - 1));
    }

    public CellType getType() {
        return type;
    }

    public float getDensity() {
        return density;
    }

    public Color getColor(Grid grid, Vector2 curPos) {
        return this.color.add(getLightValue(grid, curPos));
    }

    public Color getLightValue(Grid grid, Vector2 curPos) {

        return new Color();
    }
}

