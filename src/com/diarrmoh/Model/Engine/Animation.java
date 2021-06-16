package com.diarrmoh.Model.Engine;


import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.AnimationEnum;
import com.diarrmoh.Model.Engine.InPut.InPut;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import static java.lang.Thread.sleep;

public class Animation  implements Runnable{

    private volatile static List l = new LinkedList();
    protected Image[] idlePath;
    protected Image[] walkPath;
    protected Image[][] attackPath;
    private Image[] deathImage;
    private Image[][] jumpImage;
    protected Image[] currentAnimation;
    protected boolean isAnimated;
    protected Image currentImage;
    protected ImageView imageView;
    private int attackRate;
    private long rate;
    private long jumpRate;
    private int otherRate;
    private Character character;
    private int projectileRate;
    private Projectile projectile;


    public Animation(){
        l.add(this);
        rate = 0;
        jumpRate = 0;
        otherRate = 0;
        attackRate = 0;
    }


    public void animate(){
        if (character != null){
            if (character.isInAttack()){
                if (getCurrentAnimation() != null){
                    //if (rate%(50/getCurrentAnimation().length) < 1)
                    setCurrentImage(getCurrentAnimation()[attackRate]);
                    if (imageView != null) {
                        getImageView().setImage(currentImage);
                        attackRate++;
                        if (getCurrentAnimation().length - 1 == attackRate) {
                            character.setInAttack(false);
                            attackRate = 0;
                            if (character.isProjectileAttack()){
                                character.attack();
                            }
                        }
                    }

                }

            }else {
                if (getCurrentAnimation() != null && imageView != null){
                    otherRate %= getCurrentAnimation().length;
                    setCurrentImage(getCurrentAnimation()[otherRate]);
                    getImageView().setImage(currentImage);
                    otherRate++;
                }

            }
        } else {
            if (projectile.getProjectileImage() != null){
                //if (rate%(50/getCurrentAnimation().length) < 1)
                if (projectile.getImageView() != null) {
                    projectileRate %= projectile.getProjectileImage().length;
                    projectile.getImageView().setImage(projectile.getProjectileImage()[projectileRate]);
                    projectileRate++;
                    if (projectile.isDestroyed()) {
                        projectileRate = 0;
                    }
                }
            }

        }




        rate++;


    }





    public static void reInitInstance(){
        l.clear();
    }




    @Override
    public void run() {
        while (true){
            if (!InPut.isPause()){
                try {
                    sleep(200);
                    for(int j = 0; j < l.size(); j++){
                        if (Animation.l.size() > j) ((Animation) l.get(j)).animate();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.print("");
            }
        }
    }

















   ///////////////////////////////Getter and Setter/////////////////////////////////


    public static List getL() {
        return l;
    }

    public Character getCharacter() {
        return character;
    }


    public Image[] getCurrentAnimation(){
        return currentAnimation;
    }

    public void setCurrentAnimation(Image[] currentAnimation){
        this.currentAnimation = currentAnimation;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public Image[] getIdlePath() {
        return idlePath;
    }

    public void setIdlePath(Image[] idlePath) {
        this.idlePath = idlePath;
    }

    public Image[] getWalkPath() {
        return walkPath;
    }

    public void setWalkPath(Image[] walkPath) {
        this.walkPath = walkPath;
    }

    public Image[][] getAttackPath() {
        return attackPath;
    }

    public void setAttackPath(Image[][] attackPath) {
        this.attackPath = attackPath;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public Image[] getDeathImage() {
        return deathImage;
    }

    public void setDeathImage(Image[] deathImage) {
        this.deathImage = deathImage;
    }

    public Image[][] getJumpImage() {
        return jumpImage;
    }

    public void setJumpImage(Image[][] jumpImage) {
        this.jumpImage = jumpImage;
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
