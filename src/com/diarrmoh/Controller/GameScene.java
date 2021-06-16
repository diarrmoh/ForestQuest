package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Garden.Archer;
import com.diarrmoh.Model.GameMode;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import static com.diarrmoh.Launcher.*;

public class GameScene {

    private Parent gameRoot;
    private Pane gamePane;

    public ImageView player1;
    public ImageView player2;
    public ImageView player3;
    public ImageView player4;

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


    public GameScene() {
        this.gamePane = new Pane();
        gamePane.setPrefSize(1920,1080);

        gamePane.setBackground(new Background(new BackgroundImage(
                new Image(String.valueOf(Launcher.class.getResource("Data/1080.png"))),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(100,100,true,true,true,true))));
        this.gameRoot = new Group(gamePane);

        initPlayerImageView();

        initArrowImageView();
        gameMode = new GameMode();
        Archer garden = new Archer("momo",0,player1);
        player1.setY(garden.getPhysique().getPoint().getY());
        player1.setX(garden.getPhysique().getPoint().getX());
        garden.setPath();
        setArrowView(garden);

        gameMode.setMenuRoot(gamePane);


        setScene(gameRoot);
    }

    private void initPlayerImageView() {
        player1 = new ImageView();
        player2 = new ImageView();
        player3 = new ImageView();
        player4 = new ImageView();
        gamePane.getChildren().addAll(player1,player2,player3,player4);
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

    private void initArrowImageView(){
        arrow1 = new ImageView();
        arrow2 = new ImageView();
        arrow3 = new ImageView();
        arrow4 = new ImageView();
        arrow5 = new ImageView();
        arrow6 = new ImageView();
        arrow7 = new ImageView();
        arrow8 = new ImageView();
        arrow9 = new ImageView();
        arrow10 = new ImageView();
        gamePane.getChildren().addAll(arrow1,arrow2,arrow3,arrow4,arrow5,arrow6,arrow7,arrow8,arrow9,arrow10);
    }

















    public Parent getGameRoot() {
        return gameRoot;
    }

    public void setGameRoot(Parent gameRoot) {
        this.gameRoot = gameRoot;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public void setGamePane(Pane gamePane) {
        this.gamePane = gamePane;
    }
}
