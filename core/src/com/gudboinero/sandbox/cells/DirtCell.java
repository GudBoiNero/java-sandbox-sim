package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;
import com.gudboinero.sandbox.Grid;

public class DirtCell extends Cell {
    private float growth = 0.0f;
    private float GROWTH_RATE = 0.05f;

    public DirtCell() {
        super(CellType.SOLID, 10, new Color(.6f,.5f,.5f,1f));
    }

    @Override
    public Vector2 getMove(Grid grid, Vector2 curPos) {
        if (hasSunlight(grid, curPos)) {
            growth = Math.min(1.0f, growth + GROWTH_RATE);
        } else {
            growth = 0f;
        }

        return super.getMove(grid, curPos);
    }

    @Override
    public Color getColor(Grid grid, Vector2 curPos) {
        Color color = super.getRawColor();

        if (hasGrass(grid, curPos)) {
            color = new Color().fromHsv(2, 0.5f, 1f);
        }

        return new Color(color.r, color.g, color.b, color.a);
    }

    public boolean hasSunlight(Grid grid, Vector2 curPos) {
        Vector2 targetPos = new Vector2(curPos.x, curPos.y + 1);
        Cell target = up(grid, targetPos);

        while (target != null) {
            targetPos = new Vector2(targetPos.x, targetPos.y - 1);
            target = target.up(grid, targetPos);

            if (target != null) {
                if (target.getType() != CellType.NONE && target.getType() != CellType.LIQUID) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean hasGrass(Grid grid, Vector2 curPos) {
        return growth >= 1.0f && hasSunlight(grid, curPos);
    }
}
