package org.example;

public class ColumnMapper {
    public static char mapIntToColumn(int number) {
        char[] columns = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        return columns[number];
    }
}