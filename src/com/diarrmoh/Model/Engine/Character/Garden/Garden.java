package com.diarrmoh.Model.Engine.Character.Garden;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Garden extends Character {






    public Garden(String name, int playerNumber, ImageView imageView) {
        super(name,playerNumber,imageView);
        origin = Origin.GARDEN;
    }



    public abstract void gardenUpdate();






}
