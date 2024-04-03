package org.example;

import java.util.ArrayList;
import java.util.List;

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

    public static long setBit(long board, int bit, int file, int row) {
        if (bit != 0 && bit != 1) {
            return 0;
        }

        boolean newBit;

        if (bit == 0) {
            newBit = false;
        } else {
            newBit = true;
        }

        file = 7 - file;
        return setBit(board, newBit, file + (row * 8));
    }

    public static List<Integer> findPositions(long bitboard) {
        List<Integer> positions = new ArrayList<>();
        while (bitboard != 0) {
            // Finde die Position des nächsten gesetzten Bits
            int position = Long.numberOfTrailingZeros(bitboard);
            positions.add(position);
            // Entferne das gefundene gesetzte Bit
            bitboard &= ~(1L << position);
        }
        return positions;
    }
}