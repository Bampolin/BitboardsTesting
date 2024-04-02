package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BoardHistOneColor {
    private List<BoardStateOneColor> states;

    public BoardHistOneColor() {
        states = new ArrayList<>();
    }
}