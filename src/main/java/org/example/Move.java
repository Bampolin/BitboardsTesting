package org.example;

import lombok.Getter;

@Getter
public class Move {
    private final int fromFile;
    private final int fromRank;
    private final int toFile;
    private final int toRank;

    public Move(int fromFile, int fromrank, int toFile, int torank) {
        this.fromFile = fromFile;
        this.toFile = toFile;
        this.fromRank = fromrank;
        this.toRank = torank;
    }

    public Coordinates getFrom() {
        return new Coordinates(fromFile, fromRank);
    }

    public Coordinates getTo() {
        return new Coordinates(toFile, toRank);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(ColumnMapper.mapIntToColumn(fromFile));
        sb.append(fromRank + 1);
        sb.append("-");
        sb.append(ColumnMapper.mapIntToColumn(toFile));
        sb.append(toRank + 1);

        return sb.toString();
    }
}