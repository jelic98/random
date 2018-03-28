package com.ecloga.flappy.snail.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.ecloga.flappy.snail.FlappySnail;

/**
 * Created by Lazar on 14.12.2015.
 */
public class Snail {
    private Vector3 position, velocity;
    private Texture texture;
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 90;
    private Rectangle bounds;
    private Sound flap;

    public Snail(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("snail.png");
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float dt) {
        if(position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        if(position.y < 0) {
            position.y = 0;
        }

        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getSnail() {
        return texture;
    }

    public void jump() {
        velocity.y = 300;
        flap.play(0.5f);
    }

    public void dispose() {
        texture.dispose();
        flap.dispose();
    }
}
