package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;
import com.gudboinero.sandbox.Grid;

public class SandCell extends Cell {
    public SandCell() {
        super(CellType.SOLID, 2, new Color(0.6f, 0.6f, 0.9f, 1f));
    }

    @Override
    public Vector2 getMove(Grid grid, Vector2 curPos) {
        // Check for bottom cell plus bottom left and right cells
        Vector2 bPos = new Vector2(curPos.x, curPos.y + 1);
        Vector2 blPos = new Vector2(curPos.x - 1, curPos.y + 1), brPos = new Vector2(curPos.x + 1, curPos.y + 1);
        Vector2 lPos = new Vector2(curPos.x - 1, curPos.y), rPos = new Vector2(curPos.x + 1, curPos.y);

        Cell b = grid.getCell(bPos); // Below
        Cell bl = grid.getCell(blPos), br = grid.getCell(brPos); // Below Right and Below Left
        Cell l = grid.getCell(lPos), r = grid.getCell(rPos); // Right and Left

        // Below
        if (canMove(grid, curPos, b)) {
            return bPos;
        }

        // Below Right or Right
        if (canMove(grid, curPos, r) && canMove(grid, curPos, br)) {
            return brPos;
        }

        // Below Left or Left
        if (canMove(grid, curPos, l) && canMove(grid, curPos, bl)) {
            return blPos;
        }

        return super.getMove(grid, curPos);
    }
}
