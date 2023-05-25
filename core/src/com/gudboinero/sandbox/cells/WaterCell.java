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
        super(CellType.WATER, 1, 1, 0, new Color().fromHsv(180, 0.5f, 1f));
    }

    @Override
    public Vector2 getMove(Grid grid, Vector2 curPos) {
        // Check for bottom cell plus bottom left and right cells

        Vector2 posDown = new Vector2(curPos.x, curPos.y + 1);
        Cell cellDown = grid.getCell(posDown);
        if (canMove(grid, curPos, cellDown)) {
            return posDown;
        }

        Vector2 posDownLeft = new Vector2(curPos.x - 1, curPos.y + 1);
        Cell cellDownLeft = grid.getCell(posDownLeft);
        if (canMove(grid, curPos, cellDownLeft)) {
            return posDownLeft;
        }

        Vector2 posDownRight = new Vector2(curPos.x + 1, curPos.y + 1);
        Cell cellDownRight = grid.getCell(posDownRight);
        if (canMove(grid, curPos, cellDownRight)) {
            return posDownRight;
        }

        Vector2 posDir = new Vector2(curPos.x + direction, curPos.y);
        Cell cellDir = grid.getCell(posDir);
        if (canMove(grid, curPos, cellDir)) {
            return posDir;
        } else {
            direction = -direction;
        }

        posDir = new Vector2(curPos.x + direction, curPos.y);
        cellDir = grid.getCell(posDir);
        if (canMove(grid, curPos, cellDir)) {
            return posDir;
        } else {
            direction = -direction;
        }


        return super.getMove(grid, curPos);
    }
}
