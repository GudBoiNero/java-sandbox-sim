package com.gudboinero.sandbox;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import org.omg.CORBA.Any;

import java.util.Dictionary;
import java.util.Enumeration;

public class Cell {
    private final CellType type;
    private final float weight;
    private final float density;
    private final Color color;
    private int age;

    public Cell(CellType type, float weight, float density, int age, Color color) {
        this.type = type;
        this.color = color;
        this.weight = weight;
        this.density = density;
        this.age = age;
    }

    public Cell(CellType type, Color color) {
        this.type = type;
        this.color = color;
        this.weight = 0;
        this.density = 0;
    }

    public Vector2 getMove(Grid grid, Vector2 curPos) {
        return curPos;
    }

    public boolean canMove(Grid grid, Vector2 curPos, Cell toCell) {
        Cell cell = grid.getCell(curPos);
        if (toCell != null) {
            if (toCell.getDensity() < cell.getDensity()) {
                return true;
            }
        }
        return false;
    }

    public CellType getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }

    public float getDensity() {
        return density;
    }

    public int getAge() {
        return age;
    }

    public Color getColor() {
        return this.color;
    }
}

