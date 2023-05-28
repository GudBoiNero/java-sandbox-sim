package com.gudboinero.sandbox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.gudboinero.sandbox.cells.EmptyCell;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private final Vector2 GRID_SIZE;

    private final Cell[][] _grid;

    public Grid(int x, int y) {
        GRID_SIZE = new Vector2(x, y);

        Cell[][] grid = new Cell[y][x];
        for (int yi = 0; yi < y; yi++) {
            for (int xi = 0; xi < x; xi++) {
                grid[yi][xi] = new EmptyCell();
            }
        }
        
        _grid = grid;
    }

    public Vector2 getGridSize() {
        return GRID_SIZE;
    }

    public void physicsUpdate(float deltaTime) {
        //#region update cells
        ArrayList<Cell> updatedCells = new ArrayList<>();
        for (int yi = (int) this.GRID_SIZE.y - 1; yi >= 0; yi--) {
            for (int xi = 0; xi < this.GRID_SIZE.x; xi++) {
                Vector2 pos = new Vector2(xi, yi);
                Cell cell = getCell(pos);

                if (updatedCells.contains(cell) || cell == null) continue;

                updatedCells.add(cell);

                swapCell(cell.getMove(this, pos), pos);
            }
        }
        //#endregion
    }

    public Cell getCell(Vector2 pos) {
        if (pos.y < _grid.length && pos.y >= 0) {
            if (pos.x < _grid[(int) pos.y].length  && pos.x >= 0) {
                if (_grid[(int) pos.y][(int) pos.x] != null) {
                    return _grid[(int) pos.y][(int) pos.x];
                }
            }
        }
        return null;
    }

    public void putCell(Vector2 pos, Cell cell) {
        if (getCell(pos) != null) {
            if (getCell(pos).getType() == CellType.NONE) {
                setCell(pos, cell);
            }
        }
    }

    public void setCell(Vector2 pos, Cell cell) {
        if (getCell(pos) != null) {
            _grid[(int) pos.y][(int) pos.x] = cell;
        }
    }

    public void swapCell(Vector2 newPos, Vector2 curPos) {
        Cell currentCell = getCell(curPos);
        Cell newCell = getCell(newPos);
        setCell(newPos, currentCell);
        setCell(curPos, newCell);
    }
}
