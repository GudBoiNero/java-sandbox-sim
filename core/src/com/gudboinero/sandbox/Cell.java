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
    // Determines difference in color between each cell

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
        return new Color(color.r, color.g, color.b, color.a);
    }

    public Color getRawColor() {
        return color;
    }

    public Color getLightValue(Grid grid, Vector2 curPos) {
        Cell cell = grid.getCell(curPos);
        Cell up = cell.up(grid, curPos);

        if (up != null && cell.getType() != CellType.NONE) {
            if (up.getType() == CellType.NONE) {
                return new Color().fromHsv(300, 0, 0.1f);
            }
        }
        return new Color();
    }
}

