package com.example.owner.spacetraders.ViewModel;

import com.example.owner.spacetraders.Model.GameState;

public class Model {
    private GameState game;
    private static Model inst = new Model();

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