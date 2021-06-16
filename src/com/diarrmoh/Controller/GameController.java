package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Engine.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Character.Garden.Garden;
import com.diarrmoh.Model.Engine.Physique.Point;
import com.diarrmoh.Model.GameMode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.*;

public class GameController implements Initializable {
    public ImageView player1;
    public Pane menuPane;
    public Pane gamePane;
    public Pane backgroundPane;
    public ImageView player2;
    public ImageView arrow1;
    public ImageView arrow2;
    public ImageView arrow3;
    public ImageView arrow4;
    public ImageView arrow5;
    public ImageView arrow6;
    public ImageView arrow7;
    public ImageView arrow8;
    public ImageView arrow9;
    public ImageView arrow10;
    public ImageView rock1;
    public ImageView rock2;
    public ImageView rock3;
    public ImageView rock4;
    public ImageView rock5;
    public ImageView rock6;
    public ImageView rock7;
    public ImageView rock8;
    public ImageView rock9;
    public ImageView rock10;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuPane.setVisible(false);
        menuPane.setDisable(true);

        gameMode = new GameMode();
        Archer garden = new Archer("momo",0,player1);
        player1.setY(garden.getPhysique().getPoint().getY());
        player1.setX(garden.getPhysique().getPoint().getX());
        garden.setPath();
        setArrowView(garden);



        RockGolem golem = new RockGolem("jojo",1,player2);
        golem.getPhysique().getPoint().setX(600);
        player2.setY(golem.getPhysique().getPoint().getY());
        player2.setX(golem.getPhysique().getPoint().getX());
        golem.setPath();
        setRockView(golem);


        playerOneThread = new Thread(garden);
        playerOneThread.start();

        playerTwoThread = new Thread(golem);
        playerTwoThread.start();

//
//
//        physiqueThread = new Thread(garden.getPhysique());
//        Launcher.physiqueThread.start();

        gameMode.setMenuRoot(menuPane);

    }

    private void setRockView(RockGolem golem) {
        rock1.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock1.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock1);

        rock2.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock2.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock2);

        rock3.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock3.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock3);

        rock4.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock4.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock4);

        rock5.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock5.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock5);

        rock6.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock6.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock6);

        rock7.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock7.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock7);

        rock8.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock8.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock8);

        rock9.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock9.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock9);

        rock10.setX(golem.getAnimation().getImageView().getX() + golem.getAnimation().getImageView().getFitWidth()/2);
        rock10.setY(golem.getAnimation().getImageView().getY() + golem.getAnimation().getImageView().getFitHeight()/2);
        golem.getProjectileImageView().add(rock10);
    }

    private void setArrowView(Archer garden) {
        arrow1.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow1.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow1);

        arrow2.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow2.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow2);

        arrow3.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow3.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow3);

        arrow4.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow4.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow4);

        arrow5.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow5.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow5);

        arrow6.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow6.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow6);

        arrow7.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow7.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow7);

        arrow8.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow8.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow8);

        arrow9.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow9.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow9);

        arrow10.setX(garden.getAnimation().getImageView().getX() + garden.getAnimation().getImageView().getFitWidth()/2);
        arrow10.setY(garden.getAnimation().getImageView().getY() + garden.getAnimation().getImageView().getFitHeight()/2);
        garden.getProjectileImageView().add(arrow10);

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        playerOneThread.stop();
        playerTwoThread.stop();
    }

    public void backToMenu(ActionEvent actionEvent) throws IOException {
        Launcher.root[0] = Launcher.setRoot("View/MenuView.fxml");
        Launcher.root[1] = Launcher.setRoot("View/SettingView.fxml");
        Launcher.root[2] = Launcher.setRoot("View/LobbyView.fxml");
        Launcher.setScene(Launcher.root[0]);
    }
}
