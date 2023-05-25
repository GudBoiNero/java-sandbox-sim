package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;
import com.gudboinero.sandbox.Grid;

public class SandCell extends Cell {
    public SandCell() {
        super(CellType.SAND, 0, 2, 0, new Color(0.6f, 0.6f, 0.9f, 1f));
    }

    @Override
    public Vector2 getMove(Grid grid, Vector2 curPos) {
        // Check for bottom cell plus bottom left and right cells
        Vector2 bPos = new Vector2(curPos.x, curPos.y + 1);
        Vector2 brPos = new Vector2(curPos.x + 1, curPos.y + 1);
        Vector2 blPos = new Vector2(curPos.x - 1, curPos.y + 1);

        Cell b = grid.getCell(bPos); // Below
        Cell br = grid.getCell(brPos); // Below Right
        Cell bl = grid.getCell(blPos); // Below Left

        if (b != null) {
            if (b.getDensity() < getDensity()) {
                return bPos;
            }
        }
        if (bl != null) {
            if (bl.getDensity() < getDensity()) {
                return blPos;
            }
        }
        if (br != null) {
            if (br.getDensity() < getDensity()) {
                return brPos;
            }
        }
        return super.getMove(grid, curPos);
    }
}
