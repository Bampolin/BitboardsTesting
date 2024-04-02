package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitboardUtilTest {
    @Nested
    class FindBitTests {
        private long board1;
        private long board2;
        private long board3;

        @BeforeEach
        void setup() {
            board1 = 0b0000000000000000000000000000000000000000000000001111111100000000L;
            board2 = 0b0000000100000001000000010000000100000001000000010000000100000001L;
            board3 = board1 | board2;
        }

        @Test
        void board1() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (j == 1) {
                        System.out.println("file: " + i + "|row: " + j + ": " + BitboardUtil.findBit(board1, i, j));
                        assertEquals(true, BitboardUtil.findBit(board1, i, j));
                    } else {
                        assertEquals(false, BitboardUtil.findBit(board1, i, j));
                    }

                }
            }

            System.out.println();
        }

        @Test
        void board2() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (i == 7) {
                        System.out.println("file: " + i + "|row: " + j + ": " + BitboardUtil.findBit(board2, i, j));
                        assertEquals(true, BitboardUtil.findBit(board2, i, j));
                    } else {
                        assertEquals(false, BitboardUtil.findBit(board2, i, j));
                    }

                }
            }

            System.out.println();
        }

        @Test
        void board3() {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (i == 7 || j == 1) {
                        System.out.println("file: " + i + "|row: " + j + ": " + BitboardUtil.findBit(board3, i, j));
                        assertEquals(true, BitboardUtil.findBit(board3, i, j));
                    } else {
                        assertEquals(false, BitboardUtil.findBit(board3, i, j));
                    }

                }
            }

            System.out.println();
        }
    }



    @Nested
    class SetBitTests {
        private long board1;
        private long board2;
        private long board3;

        @BeforeEach
        void setup() {
            board1 = 0b0000000000000000000000000000000000000000000000000000000000000000L;
            board2 = 0b1111111111111111111111111111111111111111111111111111111111111111L;
            board3 = board1 | board2;
        }

        @Test
        void board1_1_at_0_0() {
            board1 = BitboardUtil.setBit(board1, 1, 0, 0);
            assertEquals(true, BitboardUtil.findBit(board1, 0, 0));
        }

        @Test
        void board2_0_at_7_7() {
            board1 = BitboardUtil.setBit(board1, 0, 7, 7);
            assertEquals(true, BitboardUtil.findBit(board2, 7, 7));
        }
    }

}