package com.diarrmoh.Model.Engine;

import com.diarrmoh.Launcher;
import com.diarrmoh.Model.Engine.Character.Character;
import com.diarrmoh.Model.Engine.Enumeration.Orientation;
import com.diarrmoh.Model.Engine.Physique.Physique;
import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Projectile {

    public static Image[] arrowProjectile;
    public static Image[] golemProjectile;

    private Image[] projectileImage;
    private Physique physique;
    private Animation animation;
    private ImageView imageView;
    public boolean destroyed;
    private boolean inAnimation;
    private Character character;
    private Orientation projectileOrientation;


    public Projectile() {
        physique = new Physique();
        physique.setProjectile(this);
        animation = new Animation();
        animation.setProjectile(this);
        destroyed = false;
    }

    public Projectile(Character character, Image[] images,ImageView imageView) {
        physique = new Physique();
        physique.setProjectile(this);
        animation = new Animation();
        animation.setProjectile(this);
        destroyed = false;
        this.character = character;
        this.projectileOrientation = character.getOrientation();

        this.imageView = imageView;
        getPhysique().getPoint().setX(character.getPhysique().getPoint().getX());
        getPhysique().getPoint().setY(character.getPhysique().getPoint().getY());
        setProjectileImage(images);
        setOrientation();
    }

    public void setOrientation() {
        if (projectileOrientation.equals(Orientation.RIGHT_TO_LEFT)){
            if (imageView != null){
                imageView.setRotationAxis(new Point3D(0, 1, 0));
                imageView.setRotate(180);
            }

        }
    }


    public void destroy() {
        character.setInAttack(false);
        imageView.setImage(null);
        setCharacter(null);

        Physique.getL().remove(physique);
        Animation.getL().remove(animation);

        setPhysique(null);
        setAnimation(null);

    }


    public Image[] getProjectileImage() {
        return projectileImage;
    }

    public void setProjectileImage(Image[] projectileImage) {
        this.projectileImage = projectileImage;
    }

    public Physique getPhysique() {
        return physique;
    }

    public void setPhysique(Physique physique) {
        this.physique = physique;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    static {
        System.out.println("Chargement");
        arrowProjectile = new Image[1];
        for (int i = 0; i < arrowProjectile.length; i++){
            arrowProjectile[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Archer/projectile/Fichier_" + (i+1) + ".png")));
        }

        System.out.println("Chargement");
        golemProjectile = new Image[7];
        for (int i = 0; i < golemProjectile.length; i++){
            golemProjectile[i] = new Image(String.valueOf(Launcher.class.getResource("Data/Golem/projectile/Fichier_" + (i+1) + ".png")));
        }
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setInAnimation(boolean b) {
        this.inAnimation = b;
    }

    public boolean isInAnimation() {
        return inAnimation;
    }

    public Character getCharacter() {
        return character;
    }


    public void setCharacter(Character character) {
        this.character = character;
    }


    public Orientation getProjectileOrientation() {
        return projectileOrientation;
    }

    public void setProjectileOrientation(Orientation projectileOrientation) {
        this.projectileOrientation = projectileOrientation;
    }
}
