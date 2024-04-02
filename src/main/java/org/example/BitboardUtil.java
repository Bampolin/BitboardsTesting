package org.example;

public class BitboardUtil {
    private static boolean findBit(long board, int pos) {
        return (board & (1L << pos)) != 0;
    }


    public static boolean findBit(long board, int file, int row) {
        file = 7 - file;
        return findBit(board, file + (row * 8));
    }

    private static long setBit(long board, boolean bit, int pos) {
        if (bit) {
            return board | (1L << pos);
        } else {
            return board & ~(1L << pos);
        }
    }


    public static long setBit(long board, boolean bit, int file, int row) {
        file = 7 - file;
        return setBit(board, bit, file + (row * 8));
    }
}