package org.example;

import lombok.Getter;

@Getter
public class Move {
    private final int fromFile;
    private final int fromRow;
    private final int toFile;
    private final int toRow;

    public Move(int fromFile, int fromRow, int toFile, int toRow) {
        this.fromFile = fromFile;
        this.toFile = toFile;
        this.fromRow = fromRow;
        this.toRow = toRow;
    }

    public Coordinates getFrom() {
        return new Coordinates(fromFile, fromRow);
    }

    public Coordinates getTo() {
        return new Coordinates(toFile, toRow);
    }
}