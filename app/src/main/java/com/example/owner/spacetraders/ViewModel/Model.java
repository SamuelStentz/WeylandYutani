package com.example.owner.spacetraders.ViewModel;

import com.example.owner.spacetraders.Model.GameState;

public final class Model {
    private final GameState game;
    private static final Model inst = new Model();

    public static Model getInst() {
        return inst;
    }

    private Model() {
        game = new GameState();
    }

    public GameState getGame() {
        return game;
    }
}