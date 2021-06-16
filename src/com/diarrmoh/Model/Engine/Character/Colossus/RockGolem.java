package com.diarrmoh.Model.Engine.Character.Colossus;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import com.diarrmoh.Model.Engine.Projectile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RockGolem extends Colossus{

    private static Image[] idle;
    private static Image[] walk;
    private static Image[] attack1;
    private static Image[] jumping;
    private static Image[] inair;
    private static Image[] touchdown;
    private static Image[] death;





    public RockGolem(String name, int playerNumber, ImageView imageView) {
        super(name, playerNumber, imageView);
        element =Element.EARTH;
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
    public void setPath(){
        this.getAnimation().setWalkPath(walk);
        this.getAnimation().setDeathImage(death);
        Image[][] attackImage = new Image[1][];
        attackImage[0] = attack1;
        this.getAnimation().setAttackPath(attackImage);
        Image[][] jumpImage = new Image[3][];
        jumpImage[0] = jumping;
        jumpImage[1] = inair;
        jumpImage[2] = touchdown;
        this.getAnimation().setJumpImage(jumpImage);
        projectileAttack = true;
    }

    @Override
    public void attack() {
        for (int i = 0; i < projectileImageView.size(); i++){
            if (projectileImageView.get(i).getImage() == null)new Projectile(this,Projectile.golemProjectile,projectileImageView.get(i));
        }
    }


    public static void load() {
        System.out.println("Chargement");
        walk = new Image[11];
        for (int i = 0; i < walk.length; i++){
            walk[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/walk/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        attack1 = new Image[7];
        for (int i = 0; i < attack1.length; i++){
            attack1[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/attack1/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Fin Chargement");
        death = new Image[6];
        for (int i = 0; i < death.length; i++){
            death[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/death/Fichier_" + (i+1) + ".png")));
        }

    }


    static {
        System.out.println("Chargement");
        idle = new Image[4];
        for (int i = 0; i < idle.length; i++){
            idle[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/idle/Fichier_" + (i+1) + ".png")));
        }
    }


}
