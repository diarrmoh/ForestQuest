package com.diarrmoh.Model.Engine.InPut;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.InPutRunnable;
import com.studiohartman.jamepad.ControllerState;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class InPut implements Runnable{
    ControllerState state;

    private volatile static List l = new LinkedList();
    private volatile static boolean pause = false;

    private Character character;


    public InPut() {
        l.add(this);
    }


    public void update() {
        if (Launcher.controllerManager.getState(character.getPlayerNumber()).isConnected){
            state = Launcher.controllerManager.getState(character.getPlayerNumber());
            if (pause){
                if (state.startJustPressed) {
                    pause = !pause;
                    Launcher.gameMode.inPause(pause);
                }
            } else if (character.isInAttack()){
                if (state.startJustPressed) {
                    pause = !pause;
                    Launcher.gameMode.inPause(pause);
                }

            } else {
                if (state.leftStickX > 0.1) {
                    character.getAnimation().setCurrentAnimation(character.getAnimation().getWalkPath());
                    character.changeOrientation(0);
                    character.setOrientation(Orientation.LEFT_TO_RIGHT);
                    character.setAnimationEnum(AnimationEnum.WALK);
                } else if (state.leftStickX < -0.1) {
                    character.getAnimation().setCurrentAnimation(character.getAnimation().getWalkPath());
                    character.changeOrientation(180);
                    character.setOrientation(Orientation.RIGHT_TO_LEFT);
                    character.setAnimationEnum(AnimationEnum.WALK);
                } else if (state.startJustPressed) {
                    pause = !pause;
                    Launcher.gameMode.inPause(pause);
                } else {
                    character.setAnimationEnum(AnimationEnum.IDLE);
                    character.getAnimation().setCurrentAnimation(character.getAnimation().getIdlePath());
                }

                if (state.a){
                    System.out.println("A");;
                }
                else if (state.x){
                    character.setAnimationEnum(AnimationEnum.ATTACK1);
                    character.setInAttack(true);
                    character.getAnimation().setCurrentAnimation(character.setAttack1());
                }
            }
        }

    }

    public static boolean isPause() {
        return pause;
    }

    @Override
    public void run() {
        while (true) {
            long previous = System.currentTimeMillis();
            try {
                sleep(10);
                for (int j = 0; j < InPut.l.size(); j++) {
                   if (InPut.l.size() > j) ((InPut) l.get(j)).update();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }











    /////////////////////////////Getter and Setter//////////////////////////////

    public ControllerState getState() {
        return state;
    }

    public void setState(ControllerState state) {
        this.state = state;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }



}
