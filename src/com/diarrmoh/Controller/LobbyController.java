package com.diarrmoh.Controller;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Animation;
import com.diarrmoh.Model.Engine.Character.Colossus.RockGolem;
import com.diarrmoh.Model.Engine.Character.Garden.Archer;
import com.diarrmoh.Model.Engine.Enumeration.NumberOfPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.diarrmoh.Launcher.*;

public class LobbyController implements Initializable {
    public ImageView playerOne;
    public Text playerOneName;
    public Text playerOneElement;
    public Text playerOneOrigin;
    public Text playerTwoName;
    public ImageView playerTwo;
    public Text playerTwoElement;
    public Text playerTwoOrigin;
    public Text playerThreeName;
    public ImageView playerThree;
    public Text playerThreeElement;
    public Text playerThreeOrigin;
    public Text playerFourName;
    public ImageView playerFour;
    public Text playerFourElement;
    public Text playerFourOrigin;
    public Archer[] archers;
    public RockGolem[] rockGolems;
    public int playerOneCom;
    public int playerTwoCom;
    public int playerThreeCom;
    public int playerFourCom;
    public int playerNumberCom;
    public Text playerNumber;
    public String[] playerNumberSt;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menuSound.play();

    }

    private void load() throws IOException {
        loadCharacters();

        rockGolems[0].getAnimation().setImageView(playerOne);
        playerOneName.setText(rockGolems[0].getName());
        playerOneElement.setText(rockGolems[0].getElement().getName());
        playerOneOrigin.setText(rockGolems[0].getOrigin().getName());

        archers[1].getAnimation().setImageView(playerTwo);
        playerTwoName.setText(archers[1].getName());
        playerTwoElement.setText(archers[1].getElement().getName());
        playerTwoOrigin.setText(archers[1].getOrigin().getName());

        rockGolems[2].getAnimation().setImageView(playerThree);
        playerThreeName.setText(rockGolems[2].getName());
        playerThreeElement.setText(rockGolems[2].getElement().getName());
        playerThreeOrigin.setText(rockGolems[2].getOrigin().getName());

        archers[3].getAnimation().setImageView(playerFour);
        playerFourName.setText(archers[3].getName());
        playerFourElement.setText(archers[3].getElement().getName());
        playerFourOrigin.setText(archers[3].getOrigin().getName());

        playerNumberSt = new String[3];
        playerNumberSt[0] = NumberOfPlayer.OnePlayer.getName();
        playerNumberSt[1] = NumberOfPlayer.TwoPlayer.getName();
        playerNumberSt[2] = NumberOfPlayer.FourPlayer.getName();
        playerNumber.setText(playerNumberSt[0]);



        playerOneCom = 1;
        playerTwoCom = 0;
        playerThreeCom = 1;
        playerFourCom = 0;
        playerNumberCom = 0;
    }

    private void loadCharacters(){
        archers = new Archer[4];
        rockGolems = new RockGolem[4];

        for (int i = 0; i < 4; i++){
            archers[i] = new Archer("Archer",0,null);
            rockGolems[i] = new RockGolem("Golem",0,null);
        }

    }





    public void play(ActionEvent actionEvent) throws IOException {

        Launcher.menuAnimationThread.stop();
        for (int i = 0; i < Launcher.root.length; i++){
            Launcher.root[i] = null;
        }
        Animation.reInitInstance();
        gameRoot = Launcher.setRoot("View/GameView.fxml");
        setScene(gameRoot);
        menuSound.getMediaPlayer().stop();

    }

    public void backToMenu(ActionEvent actionEvent) {
        Launcher.setScene(root[0]);
    }

    public void playerOneScrollLeft(ActionEvent actionEvent) {
        playerOneCom += 2;
        playerOneCom--;
        playerOneScroll();
    }

    private void playerOneScroll() {
        playerOneCom %= 2;
        switch (playerOneCom) {
            case 0:
                rockGolems[0].getAnimation().setImageView(null);
                archers[0].getAnimation().setImageView(playerOne);
                playerOneName.setText(archers[0].getName());
                playerOneElement.setText(archers[0].getElement().getName());
                playerOneOrigin.setText(archers[0].getOrigin().getName());
                break;
            case 1:
                archers[0].getAnimation().setImageView(null);
                rockGolems[0].getAnimation().setImageView(playerOne);
                playerOneName.setText(rockGolems[0].getName());
                playerOneElement.setText(rockGolems[0].getElement().getName());
                playerOneOrigin.setText(rockGolems[0].getOrigin().getName());
                break;
        }
    }

    private void playerTwoScroll() {
        playerTwoCom %= 2;
        switch (playerTwoCom) {
            case 0:
                rockGolems[1].getAnimation().setImageView(null);
                archers[1].getAnimation().setImageView(playerTwo);
                playerTwoName.setText(archers[1].getName());
                playerTwoElement.setText(archers[1].getElement().getName());
                playerTwoOrigin.setText(archers[1].getOrigin().getName());
                break;
            case 1:
                archers[1].getAnimation().setImageView(null);
                rockGolems[1].getAnimation().setImageView(playerTwo);
                playerTwoName.setText(rockGolems[1].getName());
                playerTwoElement.setText(rockGolems[1].getElement().getName());
                playerTwoOrigin.setText(rockGolems[1].getOrigin().getName());
                break;
        }
    }

    private void playerThreeScroll() {
        playerThreeCom %= 2;
        switch (playerThreeCom) {
            case 0:
                rockGolems[2].getAnimation().setImageView(null);
                archers[2].getAnimation().setImageView(playerThree);
                playerThreeName.setText(archers[2].getName());
                playerThreeElement.setText(archers[2].getElement().getName());
                playerThreeOrigin.setText(archers[2].getOrigin().getName());
                break;
            case 1:
                archers[2].getAnimation().setImageView(null);
                rockGolems[2].getAnimation().setImageView(playerThree);
                playerThreeName.setText(rockGolems[2].getName());
                playerThreeElement.setText(rockGolems[2].getElement().getName());
                playerThreeOrigin.setText(rockGolems[2].getOrigin().getName());
                break;
        }
    }

    private void playerFourScroll() {
        playerFourCom %= 2;
        switch (playerFourCom) {
            case 0:
                rockGolems[3].getAnimation().setImageView(null);
                archers[3].getAnimation().setImageView(playerFour);
                playerFourName.setText(archers[3].getName());
                playerFourElement.setText(archers[3].getElement().getName());
                playerFourOrigin.setText(archers[3].getOrigin().getName());
                break;
            case 1:
                archers[3].getAnimation().setImageView(null);
                rockGolems[3].getAnimation().setImageView(playerFour);
                playerFourName.setText(rockGolems[3].getName());
                playerFourElement.setText(rockGolems[3].getElement().getName());
                playerFourOrigin.setText(rockGolems[3].getOrigin().getName());
                break;
        }
    }

    public void playerOneScrollRight(ActionEvent actionEvent) {
        playerOneCom++;
        playerOneScroll();
    }

    public void playerTwoScrollLeft(ActionEvent actionEvent) {
        playerTwoCom += 2;
        playerTwoCom--;
        playerTwoScroll();
    }

    public void playerTwoScrollRight(ActionEvent actionEvent) {
        playerTwoCom++;
        playerTwoScroll();
    }

    public void playerThreeScrollLeft(ActionEvent actionEvent) {
        playerThreeCom += 2;
        playerThreeCom--;
        playerThreeScroll();
    }

    public void playerThreeScrollRight(ActionEvent actionEvent) {
        playerThreeCom++;
        playerThreeScroll();
    }

    public void playerFourScrollLeft(ActionEvent actionEvent) {
        playerFourCom += 2;
        playerFourCom--;
        playerFourScroll();
    }

    public void playerFourScrollRight(ActionEvent actionEvent) {
        playerFourCom++;
        playerFourScroll();
    }

    public void playerNumberScrollRight(MouseEvent mouseEvent) {
        playerNumberCom++;
        playerNumberCom %= 3;
        playerNumber.setText(playerNumberSt[playerNumberCom]);
    }

    public void playerNumberScrollLeft(ActionEvent actionEvent) {
        playerNumberCom += 2;
        playerNumberCom %= 3;
        playerNumber.setText(playerNumberSt[playerNumberCom]);
    }
}
