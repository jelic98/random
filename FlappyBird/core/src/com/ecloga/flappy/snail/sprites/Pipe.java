package com.ecloga.flappy.snail.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Lazar on 14.12.2015.
 */
public class Pipe {
    private Texture pipeUp, pipeDown, score;
    private Vector2 posPipeUp, posPipeDown, posScore;
    private Random random;
    private static final int FLUCTUATION = 130;
    public static final int PIPE_GAP = 85;
    private static final int LOWEST_OPENING = 120;
    public static final int PIPE_WIDTH = 52;
    private Rectangle boundsUp, boundsDown, boundsScore;

    public Pipe(float x) {
        pipeUp = new Texture("pipe_up.png");
        pipeDown = new Texture("pipe_down.png");
        score = new Texture("score.png");

        random = new Random();

        posPipeUp = new Vector2(x, random.nextInt(FLUCTUATION) + PIPE_GAP + LOWEST_OPENING);
        posPipeDown = new Vector2(x, posPipeUp.y - PIPE_GAP - pipeDown.getHeight());
        posScore = new Vector2(x, posPipeUp.y);

        boundsUp = new Rectangle(posPipeUp.x, posPipeUp.y, pipeUp.getWidth(), pipeUp.getHeight());
        boundsDown = new Rectangle(posPipeDown.x, posPipeDown.y, pipeDown.getWidth(), pipeDown.getHeight());
        boundsScore = new Rectangle(posScore.x, posScore.y, score.getWidth(), score.getHeight());
    }

    public Texture getPipeUp() {
        return pipeUp;
    }

    public Texture getPipeDown() {
        return pipeDown;
    }

    public Vector2 getPosPipeUp() {
        return posPipeUp;
    }

    public Vector2 getPosPipeDown() {
        return posPipeDown;
    }

    public Texture getScore() {
        return score;
    }

    public Vector2 getPosScore() {
        return posScore;
    }

    public void reposition(float x) {
        posPipeUp.set(x, random.nextInt(FLUCTUATION) + PIPE_GAP + LOWEST_OPENING);
        posPipeDown.set(x, posPipeUp.y - PIPE_GAP - pipeDown.getHeight());
        posScore.set(x, posPipeUp.y);

        boundsUp.setPosition(posPipeUp.x, posPipeUp.y);
        boundsDown.setPosition(posPipeDown.x, posPipeDown.y);
        boundsScore.setPosition(posScore.x, posScore.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsUp) || player.overlaps(boundsDown);
    }

    public boolean scores(Rectangle player) {
        return player.overlaps(boundsScore);
    }

    public void dispose() {
        pipeUp.dispose();
        pipeDown.dispose();
        score.dispose();
    }
}
