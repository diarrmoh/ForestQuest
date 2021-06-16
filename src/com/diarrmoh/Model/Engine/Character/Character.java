package com.diarrmoh.Model.Engine.Character;

import com.diarrmoh.Model.Engine.Animation;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.Enumeration.Element;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.Enumeration.Origin;
import com.diarrmoh.Model.Engine.InPut.InPut;
import com.diarrmoh.Model.Engine.Physique.Physique;
import com.diarrmoh.Model.Engine.Projectile;
import com.studiohartman.jamepad.ControllerState;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public abstract class Character implements Runnable {

    private static List l = new LinkedList();


    protected List<ImageView> projectileImageView = new LinkedList<ImageView>();
    protected Animation animation;
    //protected volatile InPut inPut;
    protected Physique physique;
    protected ControllerState state;
    protected double speed;
    protected String name;
    protected Element element;
    protected Origin origin;
    protected int playerNumber;
    protected Orientation orientation;
    protected AnimationEnum animationEnum;
    protected boolean inAttack;
    protected boolean projectileAttack;
    protected boolean inProjectileAttack;
    private double attackSpeed;


    public Character(String name, int playerNumber, ImageView imageView) {
        orientation = Orientation.LEFT_TO_RIGHT;


        //Animation
        animationEnum = AnimationEnum.IDLE;
        animation = new Animation();
        animation.setCharacter(this);
        animation.setImageView(imageView);

        //InPut
        //inPut = new InPut();
        //inPut.setCharacter(this);

        //Physique
        physique = new Physique();
        physique.setCharacter(this);

        this.name = name;
        this.playerNumber = playerNumber;
        this.speed = 10;
        this.attackSpeed = 10;

        inAttack = false;






        l.add(this);
    }


    private synchronized void update() {
        specialUpdate();

    }




    public void changeOrientation(int var) {
        if (animation.getImageView() != null){
            animation.getImageView().setRotationAxis(new Point3D(0, 1, 0));
            animation.getImageView().setRotate(var);
        }

    }

    public abstract void specialUpdate();


    public abstract void setPath();


    public abstract void attack();

















    @Override
    public void run() {
        while (true){
            if (!InPut.isPause()){
                try {
                    sleep(20);
                    if (animation != null && physique != null){
                        animation.animate();
                        physique.update();
                        //inPut.update();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            } else {
                System.out.print("");
            }
        }
    }








    ///////////////////////////Getter and Setter///////////////////////////////////


    public List<ImageView> getProjectileImageView() {
        return projectileImageView;
    }

    public void setProjectileImageView(List<ImageView> projectileImageView) {
        this.projectileImageView = projectileImageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

//    public InPut getInPut() {
//        return inPut;
//    }
//
//    public void setInPut(InPut inPut) {
//        this.inPut = inPut;
//    }

    public ControllerState getState() {
        return state;
    }

    public void setState(ControllerState state) {
        this.state = state;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public AnimationEnum getAnimationEnum() {
        return animationEnum;
    }

    public void setAnimationEnum(AnimationEnum animationEnum) {
        this.animationEnum = animationEnum;
    }

    public Physique getPhysique() {
        return physique;
    }

    public void setPhysique(Physique physique) {
        this.physique = physique;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public abstract Image[] setAttack1();

    public boolean isInAttack() {
        return inAttack;
    }

    public void setInAttack(boolean inAttack) {
        this.inAttack = inAttack;
    }

    public boolean isProjectileAttack() {
        return projectileAttack;
    }

    public void setProjectileAttack(boolean projectileAttack) {
        this.projectileAttack = projectileAttack;
    }

    public boolean isInProjectileAttack() {
        return inProjectileAttack;
    }

    public void setInProjectileAttack(boolean inProjectileAttack) {
        this.inProjectileAttack = inProjectileAttack;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}