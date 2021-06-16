package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Engine.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Character.Garden.Garden;
import com.diarrmoh.Model.Engine.Character.Colossus.Colossus;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {



    public ImageView image_G;
    public ImageView image_D;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void load() throws IOException {

        Archer garden = new Archer("jo",0,image_G);
        RockGolem colossus = new RockGolem("ga",1,image_D);
        image_D.setRotationAxis(new Point3D(0,1,0));
        image_D.setRotate(180);
        Launcher.menuAnimationThread = new Thread(garden.getAnimation());
        Launcher.menuAnimationThread.start();

    }


    public void setting(ActionEvent actionEvent) throws IOException {
        Launcher.setScene(Launcher.root[1]);
    }

    public void play(ActionEvent actionEvent) throws IOException {

        Launcher.setScene(Launcher.root[2]);

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        Launcher.menuAnimationThread.stop();
    }
}
