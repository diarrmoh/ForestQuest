package com.diarrmoh.Model;

import com.diarrmoh.Launcher;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class GameMode {

    Pane menuRoot;
    Pane gamePane;
    Pane backgroundPane;









    public void inPause(boolean b) {
        menuRoot.setVisible(b);
        menuRoot.setDisable(!b);
    }



    public Pane getMenuRoot() {
        return menuRoot;
    }

    public void setMenuRoot(Pane menuRoot) {
        this.menuRoot = menuRoot;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public void setGamePane(Pane gamePane) {
        this.gamePane = gamePane;
    }

    public Pane getBackgroundPane() {
        return backgroundPane;
    }

    public void setBackgroundPane(Pane backgroundPane) {
        this.backgroundPane = backgroundPane;
    }
}
