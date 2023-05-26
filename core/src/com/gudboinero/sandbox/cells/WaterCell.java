package com.gudboinero.sandbox.cells;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.Cell;
import com.gudboinero.sandbox.CellType;
import com.gudboinero.sandbox.Grid;

import java.util.Random;

public class WaterCell extends Cell {
    private int direction = new Random().nextInt(2) == 0 ? -1 : 1; // Left or Right
    public WaterCell() {
        super(CellType.LIQUID, 1, new Color().fromHsv(180, 0.5f, 1f));
    }

    @Override
    public Vector2 getMove(Grid grid, Vector2 curPos) {
        // Check for bottom cell plus bottom dir and right cells

        Vector2 down = new Vector2(curPos.x, curPos.y + 1);
        Vector2 dir = new Vector2(curPos.x + direction, curPos.y);
        Vector2 downDir = new Vector2(curPos.x + direction, curPos.y + 1);

        Cell cellDown = grid.getCell(down);
        Cell cellDir = grid.getCell(dir);
        Cell cellDownDir = grid.getCell(downDir);

        if (canMove(grid, curPos, cellDown)) {
            return down;
        }

        // Check `direction` side
        if (canMove(grid, curPos, cellDir)) {
            if (canMove(grid, curPos, cellDownDir)) {
                return downDir;
            }
            return dir;
        }
        direction = -direction;

        // Check opposite side
        dir.x = curPos.x + direction;
        downDir.x = curPos.x + direction;
        cellDir = grid.getCell(dir);
        cellDownDir = grid.getCell(downDir);
        if (canMove(grid, curPos, cellDir)) {
            if (canMove(grid, curPos, cellDownDir)) {
                return downDir;
            }
            return dir;
        }

        return super.getMove(grid, curPos);
    }
}
