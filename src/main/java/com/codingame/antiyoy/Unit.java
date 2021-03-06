package com.codingame.antiyoy;

import com.codingame.antiyoy.view.UnitView;


public class Unit extends Entity {
    private int id;
    private int level;
    private boolean alive;
    private boolean canMove;
    private static int unitIdCount = 1;

    private Cell cell;

    private UnitView viewer;

    public Unit(Cell cell, int ownerId, int level) {
        super(cell.getX(), cell.getY(), ownerId);
        this.alive = true;
        this.canMove = false;  // cannot play after TRAIN

        this.cell = cell;

        // Grant a unique id
        this.id = unitIdCount;
        unitIdCount++;

        this.level = level;
    }

    public int getId() { return this.id; }
    public int getLevel() { return this.level; }

    public boolean isAlive() { return this.alive; }
    public void die() { this.alive = false; }

    public void newTurn() { this.canMove = true; }
    public void moved() { this.canMove = false; }
    public boolean canPlay() { return this.canMove; }

    public void setCell(Cell cell) {this.cell = cell; }
    public Cell getCell() { return this.cell; }

    public void setViewer(UnitView viewer) { this.viewer = viewer; }
    public void doDispose() {
        this.cell.setUnit(null);
        this.alive = false;
        this.viewer.doDispose();
    }
}