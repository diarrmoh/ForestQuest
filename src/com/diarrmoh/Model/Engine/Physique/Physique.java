package com.diarrmoh.Model.Engine.Physique;


import com.diarrmoh.Model.Engine.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.InPut.InPut;
import com.diarrmoh.Model.Engine.Projectile;
import javafx.geometry.Point2D;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Physique implements Runnable {

    private volatile static List l = new LinkedList();

    private Point point;
    private Character character;
    private Projectile projectile;


    public Physique() {
        l.add(this);
        point = new Point(0,0);
    }




    public void update() {
        if (character != null){
            if (character.getAnimationEnum().equals(AnimationEnum.IDLE)){

            } else if (character.getAnimationEnum().equals(AnimationEnum.WALK)) walk();
            else if (character.getAnimationEnum().equals(AnimationEnum.JUMPING)){

            } else if (character.getAnimationEnum().equals(AnimationEnum.ATTACK1)){

            } else if (character.getAnimationEnum().equals(AnimationEnum.ATTACK2)){

            } else if (character.getAnimationEnum().equals(AnimationEnum.WALK_jUMP)){

            } else {

            }
        } else {
            if (projectile.getImageView() != null) {
                projectileattack();
            }
        }
    }

    private void projectileattack() {
        if (point.getX() + projectile.getCharacter().getAttackSpeed() < 1920 + projectile.getImageView().getFitWidth() && point.getX() - projectile.getCharacter().getAttackSpeed() + projectile.getImageView().getFitWidth() + 20 > 0){
            if (projectile.getProjectileOrientation().equals(Orientation.LEFT_TO_RIGHT)) point.setX(point.getX() + projectile.getCharacter().getAttackSpeed());
            else point.setX(point.getX() - projectile.getCharacter().getAttackSpeed());
            System.out.println(point.getX());
            if (projectile.getImageView() != null) projectile.getImageView().setX(point.getX());
        } else {
            projectile.destroy();
        }

    }


    private void walk() {
        if (character.getOrientation().equals(Orientation.LEFT_TO_RIGHT)) {
            point.setX(point.getX() + character.getSpeed());
        } else {
            point.setX(point.getX() - character.getSpeed());
        }
        if (character.getAnimation().getImageView() != null) character.getAnimation().getImageView().setX(point.getX());

    }



    public void jump() {

    }

    public static List getL() {
        return l;
    }

    @Override
    public void run() {
        while (true){
            if (!InPut.isPause()){
                try {
                    sleep(10);
                    for(int j = 0; j < l.size(); j++){
                        if (Physique.l.size() > j) ((Physique) l.get(j)).update();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.print("");
            }
        }
    }






    /////////////////////////////////////Getter and Setter//////////////////////////////


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }
}
