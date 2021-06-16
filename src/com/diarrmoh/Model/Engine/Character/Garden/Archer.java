package com.diarrmoh.Model.Engine.Character.Garden;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import com.diarrmoh.Model.Engine.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

public class Archer extends Garden{


    private static Image[] idle;
    private static Image[] walk;
    private static Image[] attack1;
    private static Image[] attack2;
    private static Image[] ultimeattack;
    private static Image[] jumping;
    private static Image[] inair;
    private static Image[] touchdown;
    private static Image[] death;




    public Archer(String name, int playerNumber, ImageView imageView) {
        super(name, playerNumber, imageView);
        element = Element.AIR;
        animation.setIdlePath(idle);
        animation.setAnimated(true);
        animation.setCurrentAnimation(animation.getIdlePath());
    }

    @Override
    public void specialUpdate() {

    }

    @Override
    public Image[] setAttack1() {
        return attack1;
    }

    @Override
    public void gardenUpdate() {

    }

    @Override
    public void setPath(){
        this.getAnimation().setWalkPath(walk);
        this.getAnimation().setDeathImage(death);
        Image[][] attackImage = new Image[3][];
        attackImage[0] = attack1;
        attackImage[1] = attack2;
        attackImage[2] = ultimeattack;
        this.getAnimation().setAttackPath(attackImage);
        Image[][] jumpImage = new Image[3][];
        jumpImage[0] = jumping;
        jumpImage[1] = inair;
        jumpImage[2] = touchdown;
        this.getAnimation().setJumpImage(jumpImage);
        projectileAttack = true;
    }


    public void attack(){
        for (int i = 0; i < projectileImageView.size(); i++){
            if (projectileImageView.get(i).getImage() == null){
                new Projectile(this,Projectile.arrowProjectile,projectileImageView.get(i));
                return;
            }
        }


    }

    static {
        System.out.println("Chargement");
        idle = new Image[6];
        for (int i = 0; i < idle.length; i++){
            idle[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/idle/Fichier_" + (i+1) + ".png")));
        }
    }


    public static void load() {
        System.out.println("Chargement");
        walk = new Image[14];
        for (int i = 0; i < walk.length; i++){
            walk[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/walk/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        attack1 = new Image[6];
        for (int i = 0; i < attack1.length; i++){
            attack1[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/attack1/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        attack2 = new Image[6];
        for (int i = 0; i < attack2.length; i++){
            attack2[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/attack2/Fichier_" + (i+1) + ".png")));
        }
        System.out.println("Chargement");
        ultimeattack = new Image[6];
        for (int i = 0; i < ultimeattack.length; i++){
            ultimeattack[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/ultimeattack/Fichier_" + (i+1) + ".png")));
        }
        System.out.println("Chargement");
        jumping = new Image[3];
        for (int i = 0; i < jumping.length; i++){
            jumping[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/jumping/Fichier_" + (i+1) + ".png")));
        }
        System.out.println("Chargement");
        inair = new Image[2];
        for (int i = 0; i < inair.length; i++){
            inair[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/inair/Fichier_" + (i+1) + ".png")));
        }
        System.out.println("Chargement");
        touchdown = new Image[3];
        for (int i = 0; i < touchdown.length; i++){
            touchdown[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/jump/touchdown/Fichier_" + (i+1) + ".png")));
        }
        System.out.println("Fin Chargement");
        death = new Image[6];
        for (int i = 0; i < death.length; i++){
            death[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/death/Fichier_" + (i+1) + ".png")));
        }

    }


}
