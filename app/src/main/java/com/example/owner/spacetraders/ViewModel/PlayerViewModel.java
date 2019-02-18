package com.example.owner.spacetraders.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.graphics.ColorSpace;
import android.support.annotation.NonNull;

import com.example.owner.spacetraders.Model.Player;

public class PlayerViewModel extends AndroidViewModel {

    private Player player;

    public PlayerViewModel(@NonNull Application app) {
        super(app);

    }

    public void createPlayer(Player player) {

    }
}
